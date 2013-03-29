package lucene;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;

import org.apache.lucene.queryParser.core.QueryNodeException;
import org.apache.lucene.queryParser.standard.StandardQueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class Finder extends LuceneIndexAccessor
{
	
	Analyzer analyzer = new KeywordAnalyzer();
	// Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_36);
	StandardQueryParser parser = new StandardQueryParser(analyzer);
		
	// Probably want this to be content.
	private static final String defaultField = "name";
	private static final int maxHits = 10000;
	
	public Finder(String directoryName)
	{
		initialize(directoryName);
	}
		
	public ScoreDoc[] find(String queryString) throws QueryNodeException, IOException
	{
		Query query = parser.parse(queryString, defaultField);
		TopDocs topDocs = searcher.search(query, maxHits);
		return topDocs.scoreDocs;
	}

	public Document getDocumentById(int docID) throws IOException
	{
		return searcher.doc(docID);
	}
	
}
