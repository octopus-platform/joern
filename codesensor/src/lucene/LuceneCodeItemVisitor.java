package lucene;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

import lucene.DocumentFactory.DocumentType;
import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.CallExpression;
import main.codeitems.expressions.MemberAccess;
import main.codeitems.expressions.PrimaryExpression;
import main.codeitems.expressions.UnaryExpression;
import main.codeitems.functionDef.FunctionDef;
import main.codeitems.statements.Condition;
import main.codeitems.statements.ExprStatementItem;
import main.codeitems.statements.IdentifierDeclStatement;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.util.Version;

public class LuceneCodeItemVisitor extends CodeItemVisitor
{
	
	String filename = "";
	
	Stack<Document> documents = new Stack<Document>();
	// Analyzer analyzer = new KeywordAnalyzer();
	Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
	IDocumentWriter writer = new LuceneIndexWriter(analyzer);
	
	public void setDocumentWriter(IDocumentWriter aWriter)
	{
		writer = aWriter;
	}
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	public void setIndexDirectoryName(String dirName)
	{
		writer.setIndexDirectoryName(dirName);
		writer.initialize();
	}
	
	public void visit(FunctionDef item)
	{
		Document d = DocumentFactory.createNewDocument(DocumentType.FUNCTION);
		FunctionDefToDocumentConverter.convert(item, filename, d);
		visitChildrenAndWrite(item, d);
	}
	
	public void visit(ClassDef item)
	{
		Document d = DocumentFactory.createNewDocument(DocumentType.TYPE);
		ClassDefToDocumentConverter.convert(item, filename, d);
		visitChildrenAndWrite(item, d);
	}
	
	public void visit(IdentifierDeclStatement statementItem)
	{
		Document parentDoc;
		
		try{
			parentDoc = documents.peek();
		}catch(EmptyStackException ex)
		{
			visitChildren(statementItem);
			return;
		}
			
		Iterator<CodeItem> it = statementItem.getIdentifierDeclList().iterator();
		while(it.hasNext()){
			IdentifierDecl idDecl = (IdentifierDecl) it.next();
			String name = idDecl.name.getCodeStr();
			String completeType = idDecl.type.completeType;
			parentDoc.add(LuceneUtils.createField("localName", name));
			parentDoc.add(LuceneUtils.createField("localType", completeType));
		}
		
		visitChildren(statementItem);
	}
	
	@Override
	public void visit(Condition expression)
	{
		Document d = DocumentFactory.createNewDocument(DocumentType.CONDITION);
		addFieldToParentsAndLink(d, "condition", expression.getCodeStr());
		visitChildrenAndWrite(expression, d);
	}
	
	@Override
	public void visit(CallExpression expression)
	{
		Document d = DocumentFactory.createNewDocument(DocumentType.EXPRESSION);
		
		String callExprString = expression.getCodeStr();
		String callTarget = "";
		if(expression.getTarget() != null)
			callTarget = expression.getTarget().getCodeStr();
		
		// add fields to this document
		d.add(LuceneUtils.createField("exprType", "call"));
		d.add(LuceneUtils.createField("code", callExprString));
		d.add(LuceneUtils.createField("target", callTarget));
		
		addFieldToParentsAndLink(d, "callTarget", callTarget);
		visitChildrenAndWrite(expression, d);
	}
	
	public void visit(PrimaryExpression expression)
	{
		addFieldToParentsAndLink(null, "primary", expression.getCodeStr());
		visitChildren(expression);
	}
	
	public void visit(MemberAccess expression)
	{
		addFieldToParentsAndLink(null, "access", expression.getCodeStr());
		visitChildren(expression);
	}
	
	public void visit(UnaryExpression expression)
	{
		addFieldToParentsAndLink(null, "unary", expression.getCodeStr());
		visitChildren(expression);
	}
	
	private void addFieldToParentsAndLink(Document thisDocument, String key, String value)
	{
		Document parentDoc;
		Iterator<Document> it = documents.iterator();
		while(it.hasNext())
		{
			parentDoc = it.next();
			parentDoc.add(LuceneUtils.createField(key, value));
		}
	
		parentDoc = getParentDocument();
		if(parentDoc != null && thisDocument != null){
			String parentId = "<unset>";
			parentId = parentDoc.getFieldable("id").stringValue();
			thisDocument.add(LuceneUtils.createIDField("parentid",Integer.parseInt(parentId)));
		}
	}

	public void visit(AssignmentExpr expression)
	{ 
		Document d = DocumentFactory.createNewDocument(DocumentType.EXPRESSION);
		
		d.add(LuceneUtils.createField("lval", expression.getLeft().getCodeStr()));
		d.add(LuceneUtils.createField("rval", expression.getRight().getCodeStr()));
		
		addFieldToParentsAndLink(d, "assignment", expression.getCodeStr());
		
		visitChildrenAndWrite(expression, d);
	}
	
	private Document getParentDocument()
	{
		try{
			return documents.peek();
		}catch(EmptyStackException ex)
		{
			return null;
		}
	}
	
	private void visitChildrenAndWrite(CodeItem expression, Document d)
	{
		documents.push(d);
		visitChildren(expression);
		documents.pop();
		writer.addDocumentToIndex(d);
	}
	
	@Override
	public void visit(ExprStatementItem statementItem)
	{
		// TODO: implement me
		visitChildren(statementItem);
	}
	
	public void shutdown()
	{
		writer.shutdown();
	}

}
