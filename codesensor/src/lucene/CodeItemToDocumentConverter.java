package lucene;

import java.util.Iterator;
import java.util.LinkedList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import main.codeitems.CodeItem;
import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;
import main.codeitems.functionContent.StatementItem;

public class CodeItemToDocumentConverter
{
		
	public static Document convert(FunctionDef item, String filename)
	{	
		Document d = new Document();
		addLocationFields(d, item, filename);
		addTypeField(d, "function");
		addCodeString(item, d);
		
		d.add(new TextField("name", item.name.getCodeStr(), Field.Store.YES));
		d.add(new TextField("returnType", item.returnType.getCodeStr(), Field.Store.YES));
		
		addParameters(item, d);
		addFunctionContent(item, d);
		
		return d;
	}

	private static void addFunctionContent(FunctionDef item, Document d)
	{
		StatementInfoExtractor infoExtractor = new StatementInfoExtractor();
		infoExtractor.setDocument(d);
		
		LinkedList<StatementItem> statements = item.content.statements;
		Iterator<StatementItem> it = statements.iterator();
		while(it.hasNext()){
			StatementItem statement = it.next();
			statement.accept(infoExtractor);
		}
		
	}

	private static void addCodeString(CodeItem item, Document d)
	{
		d.add(new TextField("code", item.getCodeStr(), Field.Store.YES));
	}

	private static void addParameters(FunctionDef item, Document d)
	{
		Iterator<Parameter> it = item.parameterList.parameters.iterator();
		while(it.hasNext()){
			Parameter param = it.next();
			String paramName = param.name.getCodeStr();
			String paramType = param.type.getCodeStr();
			d.add(new TextField("parameterName", paramName, Field.Store.YES));
			d.add(new TextField("parameterType", paramType, Field.Store.YES));
		}
	}
	
	private static void addTypeField(Document d, String typeName)
	{
		d.add(new TextField("type", typeName, Field.Store.YES));
	}

	private static void addLocationFields(Document d, CodeItem item, String filename)
	{
		d.add(new TextField("filename", filename, Field.Store.NO));
		d.add(new TextField("location", item.location.toString(), Field.Store.NO));
	}

}
