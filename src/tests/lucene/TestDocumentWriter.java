package tests.lucene;

import java.util.LinkedList;
import java.util.List;

import lucene.IDocumentWriter;

import org.apache.lucene.document.Document;

public class TestDocumentWriter implements IDocumentWriter {

	LinkedList<Document> savedDocuments = new LinkedList<Document>();
	
	public List<Document> getDocuments()
	{
		return savedDocuments;
	}
	
	@Override
	public void addDocumentsToIndex(List<Document> documents)
	{
		savedDocuments.addAll(documents);
	}

	@Override
	public void addDocumentToIndex(Document doc)
	{
		savedDocuments.add(doc);
	}

	@Override public void shutdown() {}
	@Override public void setIndexDirectoryName(String aName){}
	@Override public void initialize() {}
}
