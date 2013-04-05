package lucene;

import java.util.List;

import org.apache.lucene.document.Document;

public interface IDocumentWriter {

	public abstract void setIndexDirectoryName(String aName);

	public abstract void initialize();

	public abstract void addDocumentsToIndex(List<Document> documents);

	public abstract void addDocumentToIndex(Document doc);

	public abstract void shutdown();

}