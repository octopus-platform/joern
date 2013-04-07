package lucene;

import java.util.Iterator;
import java.util.Stack;

import lucene.DocumentFactory.DocumentType;
import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.CallExpression;
import main.codeitems.functionDef.FunctionDef;
import main.codeitems.statements.ExprStatementItem;
import main.codeitems.statements.IdentifierDeclStatement;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.document.Document;

public class LuceneCodeItemVisitor extends CodeItemVisitor
{
	
	String filename = "";
	
	Stack<Document> documents = new Stack<Document>();
	Analyzer analyzer = new KeywordAnalyzer();
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
		
		// TODO: execute this only when there is a function on the stack
		/*
		Document d = documents.peek();
		
		Iterator<CodeItem> it = statementItem.getIdentifierDeclList().iterator();
		while(it.hasNext()){
			IdentifierDecl idDecl = (IdentifierDecl) it.next();
			String name = idDecl.name.getCodeStr();
			String completeType = idDecl.type.completeType;
			d.add(LuceneUtils.createField("localName", name));
			d.add(LuceneUtils.createField("localType", completeType));
		}
		*/
		visitChildren(statementItem);
	}
	
	@Override
	public void visit(CallExpression expression)
	{
		Document d = DocumentFactory.createNewDocument(DocumentType.EXPRESSION);
		String callExprString = expression.getCodeStr();
		d.add(LuceneUtils.createField("exprType", callExprString));
		visitChildrenAndWrite(expression, d);
	}

	private void visitChildrenAndWrite(CodeItem expression, Document d)
	{
		documents.push(d);
		visitChildren(expression);
		documents.pop();
		writer.addDocumentToIndex(d);
	}
	
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
