package lucene;

import java.util.LinkedList;
import java.util.List;

import main.codeitems.CodeItemVisitor;
import main.codeitems.declarations.ClassDef;
import main.codeitems.function.FunctionDef;

import org.apache.lucene.document.Document;

public class LuceneCodeItemVisitor extends CodeItemVisitor
{
	
	String filename = "";
	LinkedList<Document> documents = new LinkedList<Document>();
	
	
	public void setFilename(String aFilename)
	{
		filename = aFilename;
	}
	
	
	public void visit(FunctionDef item)
	{
		Document newDocument = DocumentVendor.createNewDocument();
		documents.add(newDocument);
		FunctionDefToDocumentConverter.convert(item, filename, documents);
	}
	
	
	public void visit(ClassDef item)
	{
		Document newDocument = DocumentVendor.createNewDocument();
		documents.add(newDocument);
		ClassDefToDocumentConverter.convert(item, filename, documents);
	}
		
	public List<Document> getDocuments()
	{
		return documents;
	}
	
}
