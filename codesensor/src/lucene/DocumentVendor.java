package lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

public class DocumentVendor {
	
	static int currentDocumentId = 0;
	
	public static Document createNewDocument()
	{
		Document newDocument = new Document();
		markDocumentWithId(newDocument);
		currentDocumentId++;
		return newDocument;
	}
	
	private static void markDocumentWithId(Document doc)
	{
		if(doc.getField("id") != null)
			return;
		doc.add(new NumericField("id", Field.Store.YES, true).setIntValue(currentDocumentId));
	}
}
