package lucene;

import java.util.Iterator;

import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;

import org.apache.lucene.document.Document;

public class FunctionDefToDocumentConverter
{
	public static void convert(FunctionDef item, String filename, Document d)
	{	
		CodeItemToDocumentConverter.addStandardFields(item, filename, d);
		
		d.add(LuceneUtils.createField("name", item.name.getCodeStr()));
		d.add(LuceneUtils.createField("returnType", item.returnType.getCodeStr()));
		
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
			d.add(LuceneUtils.createField("parameterName", paramName));
			d.add(LuceneUtils.createField("parameterType", paramType));
		}
	}	


}
