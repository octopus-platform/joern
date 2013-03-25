package lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import main.codeitems.CodeItem;
import main.codeitems.function.FunctionDef;

public class CodeItemToDocumentConverter
{
	public static Document convert(FunctionDef item, String filename)
	{
		Document d = new Document();
		addLocationFields(d, item, filename);
		
		d.add(new TextField("name", item.name.getCodeStr(), Field.Store.YES));
		d.add(new TextField("returnType", item.returnType.getCodeStr(), Field.Store.YES));
		
		return d;
	}

	private static void addLocationFields(Document d, CodeItem item, String filename)
	{
		d.add(new TextField("filename", filename, Field.Store.NO));
		d.add(new TextField("location", item.location.toString(), Field.Store.NO));
	}

}
