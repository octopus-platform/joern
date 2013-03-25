package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.flexible.core.QueryNodeException;
import org.apache.lucene.queryparser.flexible.standard.StandardQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Finder
{
	IndexReader indexReader;
	Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_42);
	StandardQueryParser parser = new StandardQueryParser(analyzer);
	IndexSearcher searcher;
	
	// Probably want this to be content.
	private static final String defaultField = "name";
	private static final int maxHits = 100;
	
	
	Finder(String directoryName)
	{
		createIndexReader(directoryName);
	}
	
	private void createIndexReader(String directoryName)
	{
		Directory directory;
		try {
			directory = FSDirectory.open(new File(directoryName));
			indexReader = DirectoryReader.open(directory);
			searcher = new IndexSearcher(indexReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ScoreDoc[] find(String queryString)
	{
		try {
			Query query = parser.parse(queryString, defaultField);
			TopDocs topDocs = searcher.search(query, maxHits);
			

			for(ScoreDoc doc : topDocs.scoreDocs){
				
				Document document = searcher.doc(doc.doc);
				String codeStr = document.getField("code").stringValue();				
				System.out.println(codeStr);
			}
			
			
			
		} catch (QueryNodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
