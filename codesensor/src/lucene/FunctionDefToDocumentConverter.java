package lucene;


import java.util.LinkedList;

import main.codeitems.function.FunctionDef;

import org.apache.lucene.document.Document;

public class FunctionDefToDocumentConverter
{
	public static void convert(FunctionDef item, String filename, LinkedList<Document> documents)
	{	
		Document functionDoc = documents.peekLast();
		
		CommonCodeItemToDocument.addStandardFields(item, filename, functionDoc);
		functionDoc.add(LuceneUtils.createField("name", item.name.getCodeStr()));
		functionDoc.add(LuceneUtils.createField("returnType", item.returnType.getCodeStr()));
		
		addParameters(item, functionDoc);
		CommonCodeItemToDocument.addCompound(item.content, functionDoc);		
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
