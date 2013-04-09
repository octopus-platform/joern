package lucene;

import java.util.EnumMap;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

public class DocumentFactory {
	
	public enum DocumentType { FILE, FUNCTION, EXPRESSION, TYPE, VARIABLE, ASSIGNMENT, CONDITION };
	
	static int currentDocumentId = 0;
	static EnumMap<DocumentType, String> typeToStringMap;
	  
	static
	{
		initializeTypeToStringMap();
	}


	private static void initializeTypeToStringMap()
	{
		typeToStringMap = new EnumMap<DocumentType, String>(DocumentType.class);
		typeToStringMap.put(DocumentType.FILE, "file");
		typeToStringMap.put(DocumentType.FUNCTION, "function");
		typeToStringMap.put(DocumentType.EXPRESSION, "expression");
		typeToStringMap.put(DocumentType.TYPE, "type");
		typeToStringMap.put(DocumentType.VARIABLE, "variable");
		typeToStringMap.put(DocumentType.VARIABLE, "assignment");
		typeToStringMap.put(DocumentType.CONDITION, "condition");
	}
			 
	public static Document createNewDocument(DocumentType docType)
	{
		Document newDocument = new Document();
		markDocumentWithType(newDocument, docType);
		markDocumentWithId(newDocument);
		currentDocumentId++;
		return newDocument;
	}
	
	private static void markDocumentWithType(Document doc, DocumentType docType)
	{
		doc.add(LuceneUtils.createField("type", typeToStringMap.get(docType)));
	}

	private static void markDocumentWithId(Document doc)
	{
		if(doc.getFieldable("id") != null)
			return;
		
		doc.add(LuceneUtils.createIDField("id", currentDocumentId));
	}
}
