package lucene;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.processors.Processor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.document.Document;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneIndexCreator extends Processor
{
	
	Analyzer analyzer = new KeywordAnalyzer();
	IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_36, analyzer);
	
	IndexWriter indexWriter;
	String filename = "";
	String directoryName = null;
	
	public void setDirectoryName(String aName)
	{
		directoryName = aName;
	}
	
	@Override
	public void begin()
	{
		if(directoryName == null)
			throw new RuntimeException("Directory name for index not set");
		
		try {
			createIndexWriter(directoryName);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to: " + directoryName);
		}
	}
	
	private void createIndexWriter(String directoryName) throws IOException
	{
		Directory directory = FSDirectory.open(new File(directoryName));
		indexWriter = new IndexWriter(directory, iwc);
	}
	
	@Override
	public void end()
	{
		try {
			closeIndexWriter();
		} catch (IOException e) {
			throw new RuntimeException("Error when closing handle to: " + directoryName);
		}
	}
	
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String aFilename)
	{
		filename = aFilename;
	}

	private void closeIndexWriter() throws IOException
	{
		indexWriter.close();
	}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		
		CodeItemToDocumentConverter converter = new CodeItemToDocumentConverter();
		converter.setFilename(filename);
		item.accept(converter);
		
		// TODO: Converter should not return NULL by raise an error instead
		Document doc = converter.getDocument();
		
		if(doc == null)
			return;
		
		try {
			indexWriter.addDocument(doc);
		} catch (IOException e) {
			throw new RuntimeException("Error writing to: " + directoryName);
		}
		
	}

	@Override public void endOfUnit(ParserRuleContext ctx, String filename){}
}
