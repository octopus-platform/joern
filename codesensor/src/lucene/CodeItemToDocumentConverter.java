package lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import main.codeitems.function.FunctionDef;

public class CodeItemToDocumentConverter
{
	public Document convert(FunctionDef item, String filename)
	{
		Document d = new Document();
		d.add(new TextField("filename", filename, Field.Store.NO));
		d.add(new TextField("name", item.name.getCodeStr(), Field.Store.YES));
		return d;
	}
}
