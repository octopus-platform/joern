package lucene;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.queryParser.core.QueryNodeException;
import org.apache.lucene.queryParser.standard.StandardQueryParser;
import org.apache.lucene.queryParser.standard.config.NumericConfig;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;

public class Finder extends LuceneIndexAccessor
{
	
	// Analyzer analyzer = new KeywordAnalyzer();
	Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
	// Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_36);
	StandardQueryParser parser = new StandardQueryParser(analyzer);
		
	// Probably want this to be content.
	private static final String defaultField = "name";
	private static final int maxHits = 10000;
	
	public Finder(String directoryName)
	{
		initialize(directoryName);
		configureQueryParser();
	}

	private void configureQueryParser()
	{
		// register 'id' and 'parentid' as numeric fields
		// I'm not sure this is 100% correct since I couldn't find any
		// documentation on this API, but it seems to work
		
		parser.setAllowLeadingWildcard(true);
		Map<String, NumericConfig> numericConfigMap = new HashMap<String, NumericConfig>();
		NumericConfig numericConfig = new NumericConfig(1, NumberFormat.getIntegerInstance(), NumericField.DataType.INT);
		numericConfigMap.put("id", numericConfig);
		numericConfigMap.put("parentid", numericConfig);
		parser.setNumericConfigMap(numericConfigMap);
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
