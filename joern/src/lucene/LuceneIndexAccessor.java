package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;

public class LuceneIndexAccessor
{
	protected IndexReader indexReader;
	protected IndexSearcher searcher;
		
	public void initialize(String directoryName)
	{
		
		try {
			// Directory directory;
			// directory = FSDirectory.open(new File(directoryName));
			// indexReader = DirectoryReader.open(directory);
			
			indexReader = IndexReader.open(FSDirectory.open(new File(directoryName)));
			
			searcher = new IndexSearcher(indexReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
