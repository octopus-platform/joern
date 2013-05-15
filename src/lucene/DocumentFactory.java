package lucene;

import java.util.EnumMap;

import org.apache.lucene.document.Document;

public class DocumentFactory {
	
	public enum DocumentType { FILE, FUNCTION, EXPRESSION, TYPE, VARIABLE, ASSIGNMENT, CONDITION, ARGUMENT, CALL };
	
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
		typeToStringMap.put(DocumentType.ASSIGNMENT, "assignment");
		typeToStringMap.put(DocumentType.CONDITION, "condition");
		typeToStringMap.put(DocumentType.ARGUMENT, "argument");
		typeToStringMap.put(DocumentType.CALL, "call");
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

	public static boolean docHasType(Document doc, DocumentType type)
	{
		return doc.getFieldable("type").stringValue().equals(typeToStringMap.get(type));
	}
}
