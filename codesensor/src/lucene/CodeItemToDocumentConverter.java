package lucene;

import java.util.Iterator;
import java.util.LinkedList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.function.FunctionDef;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.StatementItem;

public class CodeItemToDocumentConverter implements CodeItemVisitor
{
	
	String filename = "";
	Document d;
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	public Document getDocument()
	{
		return d;
	}
	
	@Override public void visit(CodeItem item) {}
	
	@Override
	public void visit(FunctionDef item)
	{
		FunctionDefToDocumentConverter.convert(item, filename, d);
	}
	
	@Override
	public void visit(ClassDef item)
	{
		ClassDefToDocumentConverter.convert(item, filename, d);
	}
	
	public static void addStandardFields(CodeItem item, String filename,
										 Document d)
	{
		addLocationFields(d, item, filename);
		addTypeField(d, "function");
		addCodeString(item, d);
	}
	
	static void addCodeString(CodeItem item, Document d)
	{
		d.add(new TextField("code", item.getCodeStr(), Field.Store.YES));
	}
	
	static void addTypeField(Document d, String typeName)
	{
		d.add(new TextField("type", typeName, Field.Store.YES));
	}

	static void addLocationFields(Document d, CodeItem item, String filename)
	{
		d.add(new TextField("filename", filename, Field.Store.YES));
		d.add(new TextField("location", item.location.toString(), Field.Store.YES));
	}

	public static void addContent(CompoundItem item, Document d)
	{
		StatementInfoExtractor infoExtractor = new StatementInfoExtractor();
		infoExtractor.setDocument(d);
		
		LinkedList<StatementItem> statements = item.statements;
		Iterator<StatementItem> it = statements.iterator();
		while(it.hasNext()){
			StatementItem statement = it.next();
			statement.accept(infoExtractor);
		}
		
	}
	
}
