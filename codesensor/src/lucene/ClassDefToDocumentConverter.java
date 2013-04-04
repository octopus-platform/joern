package lucene;


import java.util.LinkedList;

import main.codeitems.declarations.ClassDef;

import org.apache.lucene.document.Document;

public class ClassDefToDocumentConverter
{

	public static void convert(ClassDef item, String filename, LinkedList<Document> documents)
	{
		Document document = documents.peekLast();
		CommonCodeItemToDocument.addStandardFields(item, filename, document);	
	
		String className = "";
		if(item.name != null)
			className = item.getName().getCodeStr();
		
		
		document.add(LuceneUtils.createField("name", className));
	}
	
}
