package lucene;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneIndexWriter
{
	
	IndexWriterConfig iwc;
	IndexWriter indexWriter;
	String indexDirectoryName = null;

	public LuceneIndexWriter(Analyzer analyzer)
	{
		iwc = new IndexWriterConfig(Version.LUCENE_36, analyzer);
	}
	
	public void setIndexDirectoryName(String aName)
	{
		indexDirectoryName = aName;
	}
	
	public void initialize(){
		if(indexDirectoryName == null)
			throw new RuntimeException("Directory name for index not set");
	
		try {
			createIndexWriter(indexDirectoryName);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to: " + indexDirectoryName);
		}
	}
	
	public void addDocumentsToIndex(List<Document> documents)
	{
		Iterator<Document> it = documents.iterator();
		while(it.hasNext()){
			Document doc = it.next();
			addDocumentToIndex(doc);
		}
	}
	
	public void addDocumentToIndex(Document doc)
	{
		try {
			indexWriter.addDocument(doc);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to: " + indexDirectoryName);
		}
	}
	
	public void shutdown()
	{
		try {
			closeIndexWriter();
		} catch (IOException e) {
			throw new RuntimeException("Error when closing handle to: " + indexDirectoryName);
		}
	}
	
	private void createIndexWriter(String directoryName) throws IOException
	{
		Directory directory = FSDirectory.open(new File(directoryName));
		indexWriter = new IndexWriter(directory, iwc);
	}
	
	private void closeIndexWriter() throws IOException
	{
		indexWriter.close();
	}
	
}
