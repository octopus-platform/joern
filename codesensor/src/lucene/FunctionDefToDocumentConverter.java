package lucene;

import java.util.Iterator;
import java.util.LinkedList;

import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;
import main.codeitems.functionContent.StatementItem;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

public class FunctionDefToDocumentConverter
{
	public static void convert(FunctionDef item, String filename, Document d)
	{	
		d = new Document();
		CodeItemToDocumentConverter.addStandardFields(item, filename, d);
		
		d.add(new TextField("name", item.name.getCodeStr(), Field.Store.YES));
		d.add(new TextField("returnType", item.returnType.getCodeStr(), Field.Store.YES));
		
		addParameters(item, d);
		addFunctionContent(item, d);		
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

}
