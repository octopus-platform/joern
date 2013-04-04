package lucene;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.processors.Processor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.document.Document;

public class LuceneIndexCreator extends Processor
{
	
	CodeItemToDocumentConverter converter = new CodeItemToDocumentConverter();
	Analyzer analyzer = new KeywordAnalyzer();
	String filename = "";
	LuceneIndexWriter writer = new LuceneIndexWriter(analyzer); 
	@Override
	public void begin()
	{
		writer.initialize();
	}
	
	public void setIndexDirectoryName(String dirName)
	{
		writer.setIndexDirectoryName(dirName);
	}
	
	@Override
	public void end()
	{
		writer.shutdown();
	}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String aFilename)
	{
		filename = aFilename;
	}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		
		converter.reset();
		converter.setFilename(filename);
		item.accept(converter);
		
		// TODO: Converter should not return NULL but raise an error instead
		// TODO: change to getDocuments and then write all documents
		Document doc = converter.getDocument();
		
		if(doc == null)
			return;
		
		writer.addDocumentToIndex(doc);
		
	}

	@Override public void endOfUnit(ParserRuleContext ctx, String filename){}
}
