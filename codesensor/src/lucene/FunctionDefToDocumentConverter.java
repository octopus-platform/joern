package lucene;

import java.util.Iterator;

import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;

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
		CodeItemToDocumentConverter.addContent(item.content, d);		
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


}
