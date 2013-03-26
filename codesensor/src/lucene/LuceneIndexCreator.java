package lucene;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.codeitems.function.FunctionDef;
import main.processors.Processor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneIndexCreator extends Processor {

	Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_42);
	IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_42, analyzer);
	IndexWriter indexWriter;
	
	@Override
	public void begin()
	{
		String directoryName = "/home/fabs/tmp/lucene/";
		createIndexWriter(directoryName);
	}
	

	private void createIndexWriter(String directoryName)
	{
		Directory directory;
		try {
			directory = FSDirectory.open(new File(directoryName));
			indexWriter = new IndexWriter(directory, iwc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void end()
	{
		closeIndexWriter();
	}
	
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		
	}
	
	private void closeIndexWriter()
	{
		try {
			indexWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		
		CodeItemToDocumentConverter converter = new CodeItemToDocumentConverter();
		converter.setFilename("");
		
		item.accept(converter);
		Document doc = converter.getDocument();
		if(doc == null) return;
		
		try {
			indexWriter.addDocument(doc);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
