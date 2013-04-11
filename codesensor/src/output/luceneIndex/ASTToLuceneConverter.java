package output.luceneIndex;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

import lucene.DocumentFactory;
import lucene.DocumentFactory.DocumentType;
import lucene.IDocumentWriter;
import lucene.LuceneIndexWriter;
import lucene.LuceneUtils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.util.Version;

import astnodes.ASTNode;
import astnodes.declarations.ClassDef;
import astnodes.declarations.IdentifierDecl;
import astnodes.expressions.Argument;
import astnodes.expressions.AssignmentExpr;
import astnodes.expressions.CallExpression;
import astnodes.expressions.Identifier;
import astnodes.expressions.MemberAccess;
import astnodes.expressions.PrimaryExpression;
import astnodes.expressions.UnaryExpression;
import astnodes.functionDef.FunctionDef;
import astnodes.statements.Condition;
import astnodes.statements.ExpressionStatement;
import astnodes.statements.IdentifierDeclStatement;
import astwalking.ASTNodeVisitor;

public class ASTToLuceneConverter extends ASTNodeVisitor
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
			
		Iterator<ASTNode> it = statementItem.getIdentifierDeclList().iterator();
		while(it.hasNext()){
			IdentifierDecl idDecl = (IdentifierDecl) it.next();
			String name = idDecl.getName().getCodeStr();
			String completeType = idDecl.getType().completeType;
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
		Document d = DocumentFactory.createNewDocument(DocumentType.CALL);
		
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
	
	public void visit(Identifier expression)
	{
		addFieldToParentsAndLink(null, "identifier", expression.getCodeStr());
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
		LinkedList<String> parentIds = new LinkedList<String>();
		
		Document parentDoc;
		Iterator<Document> it = documents.iterator();
		while(it.hasNext())
		{
			parentDoc = it.next();
			parentDoc.add(LuceneUtils.createField(key, value));
			String parentId = parentDoc.getFieldable("id").stringValue();
			parentIds.add(parentId);
		}
	
		if(thisDocument != null)
		{
			for(String parentId : parentIds)
				thisDocument.add(LuceneUtils.createIDField("parentid",Integer.parseInt(parentId)));
		}
		
	}

	public void visit(AssignmentExpr expression)
	{ 
		Document d = DocumentFactory.createNewDocument(DocumentType.ASSIGNMENT);
		
		d.add(LuceneUtils.createField("lval", expression.getLeft().getCodeStr()));
		d.add(LuceneUtils.createField("rval", expression.getRight().getCodeStr()));
		
		addFieldToParentsAndLink(d, "assignment", expression.getCodeStr());
		visitChildrenAndWrite(expression, d);
	}
	
	public void visit(Argument expression)
	{ 
		Document d = DocumentFactory.createNewDocument(DocumentType.ARGUMENT);
		
		Document callDoc = getFirstParentWithType(DocumentFactory.DocumentType.CALL);
		
		if(callDoc != null){
			String callTarget = callDoc.getFieldable("target").stringValue();
			d.add(LuceneUtils.createField("target", callTarget));
		}
		
		int childNumber = expression.getChildNumber();
		
		d.add(LuceneUtils.createField("number", String.valueOf(childNumber)));
		d.add(LuceneUtils.createField("code", expression.getCodeStr()));
		
		addFieldToParentsAndLink(d, "argument", expression.getCodeStr());
		visitChildrenAndWrite(expression, d);
	}
	
	private Document getFirstParentWithType(DocumentFactory.DocumentType type)
	{
		ListIterator<Document> it = documents.listIterator(documents.size());
				
		while(it.hasPrevious())
		{
			Document parentDoc = it.previous();
			if(DocumentFactory.docHasType(parentDoc, type))
				return parentDoc;
		}
		return null;
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
	
	private void visitChildrenAndWrite(ASTNode expression, Document d)
	{
		documents.push(d);
		visitChildren(expression);
		documents.pop();
		writer.addDocumentToIndex(d);
	}
	
	@Override
	public void visit(ExpressionStatement statementItem)
	{
		// TODO: implement me
		visitChildren(statementItem);
	}
	
	public void shutdown()
	{
		writer.shutdown();
	}

}
