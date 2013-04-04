package lucene;

import java.util.Iterator;
import java.util.LinkedList;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.expressions.CallItem;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

public class LuceneCodeItemVisitor implements CodeItemVisitor
{
	
	String filename = "";
	Document currentDocument;
	int currentDocumentId = 0;
	
	LinkedList<Document> documents = new LinkedList<Document>();
	
	public void reset()
	{
		filename = "";
		currentDocument = null;
	}
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	@Override
	public void visit(FunctionDef item)
	{
		createNewDocument();
		FunctionDefToDocumentConverter.convert(item, filename, currentDocument);
	}
	
	@Override
	public void visit(ClassDef item)
	{
		createNewDocument();
		ClassDefToDocumentConverter.convert(item, filename, currentDocument);
	}
	
	public Document getDocument()
	{
		markDocumentWithId();
		return currentDocument;
	}
	
	public static void addContent(CompoundItem item, Document d)
	{
		StatementInfoExtractor infoExtractor = new StatementInfoExtractor();
		infoExtractor.setDocument(d);
		
		LinkedList<CodeItem> statements = item.statements;
		Iterator<CodeItem> it = statements.iterator();
		while(it.hasNext()){
			CodeItem statement = it.next();
			statement.accept(infoExtractor);
		}
		
	}

	@Override public void visit(CodeItem item) {}
	@Override public void visit(CallItem statementItem) {}
	@Override public void visit(IdentifierDeclStatement statementItem) {}
	@Override public void visit(ExprStatementItem statementItem) {}

	private void createNewDocument()
	{
		currentDocument = new Document();
		currentDocumentId++;
	}
	
	private void markDocumentWithId()
	{
		if(currentDocument.getField("id") != null)
			return;
		currentDocument.add(new NumericField("id", Field.Store.YES, true).setIntValue(currentDocumentId));
	}
	
	
	
}
