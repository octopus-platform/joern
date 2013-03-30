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
		
		String[] names = item.parameterList.getNameStrings();
		for(String paramName : names){
			d.add(LuceneUtils.createField("parameterName", paramName));
		}
		
		String[] types = item.parameterList.getTypeStrings();
		for(String paramType : types){
			d.add(LuceneUtils.createField("parameterType", paramType));
		}	
	}	


}
