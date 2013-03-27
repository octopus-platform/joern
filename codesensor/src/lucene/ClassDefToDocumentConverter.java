package lucene;


import main.codeitems.declarations.ClassDef;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

public class ClassDefToDocumentConverter
{

	public static void convert(ClassDef item, String filename, Document d)
	{
		CodeItemToDocumentConverter.addStandardFields(item, filename, d);	
	
		String className = "";
		if(item.name != null)
			className = item.getName().getCodeStr();
			d.add(new TextField("name", className, Field.Store.YES));
		
		CodeItemToDocumentConverter.addContent(item.content, d);
	}
	
}
