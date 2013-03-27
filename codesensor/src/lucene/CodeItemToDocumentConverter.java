package lucene;

import java.util.Iterator;
import java.util.LinkedList;

import org.apache.lucene.document.Document;

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
		d = new Document();
		FunctionDefToDocumentConverter.convert(item, filename, d);
	}
	
	@Override
	public void visit(ClassDef item)
	{
		d = new Document();
		ClassDefToDocumentConverter.convert(item, filename, d);
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
		d.add(LuceneUtils.createField("location", item.location.toString()));
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
