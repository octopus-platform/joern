package output.luceneIndex;



import lucene.LuceneUtils;

import org.apache.lucene.document.Document;

import astnodes.ASTNode;

public class CommonCodeItemToDocument
{
	public static void addStandardFields(ASTNode item, String filename,
			 Document d)
	{
		addLocationFields(d, item, filename);
		addCodeString(item, d);
	}

	private static void addCodeString(ASTNode item, Document d)
	{
		d.add(LuceneUtils.createField("code", item.getCodeStr()));
	}

	private static void addLocationFields(Document d, ASTNode item, String filename)
	{
		d.add(LuceneUtils.createField("filename", filename));
		d.add(LuceneUtils.createField("location", item.getLocationString()));
	}
	
}
