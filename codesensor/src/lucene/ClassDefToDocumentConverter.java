package lucene;

import main.codeitems.declarations.ClassDef;
import org.apache.lucene.document.Document;

public class ClassDefToDocumentConverter
{

	public static void convert(ClassDef item, String filename, Document d)
	{
		CommonCodeItemToDocument.addStandardFields(item, filename, d);	
	
		String className = "";
		if(item.name != null)
			className = item.getName().getCodeStr();
		
		d.add(LuceneUtils.createField("name", className));
	}
	
}
