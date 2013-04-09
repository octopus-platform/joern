package lucene;


import main.codeitems.CodeItem;

import org.apache.lucene.document.Document;

public class CommonCodeItemToDocument
{
	public static void addStandardFields(CodeItem item, String filename,
			 Document d)
	{
		addLocationFields(d, item, filename);
		addCodeString(item, d);
	}

	private static void addCodeString(CodeItem item, Document d)
	{
		d.add(LuceneUtils.createField("code", item.getCodeStr()));
	}

	private static void addLocationFields(Document d, CodeItem item, String filename)
	{
		d.add(LuceneUtils.createField("filename", filename));
		d.add(LuceneUtils.createField("location", item.getLocationString()));
	}
	
}
