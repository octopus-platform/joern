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

public class CodeItemToDocumentConverter implements CodeItemVisitor
{
	
	String filename = "";
	Document currentDocument;
	int currentDocumentId = 0;
	
	public void reset()
	{
		filename = "";
		currentDocument = null;
	}
	
	private void createNewDocument()
	{
		currentDocument = new Document();
		currentDocumentId++;
	}
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	public Document getDocument()
	{
		markDocumentWithId();
		return currentDocument;
	}

	private void markDocumentWithId()
	{
		if(currentDocument.getField("id") != null)
			return;
		currentDocument.add(new NumericField("id", Field.Store.YES, true).setIntValue(currentDocumentId));
	}
	
	@Override public void visit(CodeItem item) {}
	
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
	
	public static void addStandardFields(CodeItem item, String filename,
										 Document d)
	{
		addLocationFields(d, item, filename);
		addTypeField(d, item.nodeTypeName);
		addCodeString(item, d);
	}
	
	static void addCodeString(CodeItem item, Document d)
	{
		d.add(LuceneUtils.createField("code", item.getCodeStr()));
	}
	
	static void addTypeField(Document d, String typeName)
	{
		d.add(LuceneUtils.createField("type", typeName));
	}

	static void addLocationFields(Document d, CodeItem item, String filename)
	{
		d.add(LuceneUtils.createField("filename", filename));
		d.add(LuceneUtils.createField("location", item.getLocationString()));
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

	@Override
	public void visit(CallItem statementItem) {}

	@Override
	public void visit(IdentifierDeclStatement statementItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExprStatementItem statementItem) {
		// TODO Auto-generated method stub
		
	}
	
}
