package lucene;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.processors.Processor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.document.Document;

public class LuceneIndexCreatorMain extends Processor
{
	
	Analyzer analyzer = new KeywordAnalyzer();
	String filename = "";
	LuceneIndexWriter writer = new LuceneIndexWriter(analyzer); 
	
	@Override
	public void begin()
	{
		writer.initialize();
	}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String aFilename)
	{
		filename = aFilename;
	}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		LuceneCodeItemVisitor converter = new LuceneCodeItemVisitor();
		converter.setFilename(filename);
		item.accept(converter);
		
		List<Document> documents = converter.getDocuments();
		writer.addDocumentsToIndex(documents);
		
	}

	@Override public void endOfUnit(ParserRuleContext ctx, String filename){}
	
	public void setIndexDirectoryName(String dirName)
	{
		writer.setIndexDirectoryName(dirName);
	}
	
	@Override
	public void end()
	{
		writer.shutdown();
	}
	
}
