package lucene;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.processors.Processor;

import org.antlr.v4.runtime.ParserRuleContext;

public class LuceneIndexCreatorMain extends Processor
{
	
	
	String filename = "";
	LuceneCodeItemVisitor converter = new LuceneCodeItemVisitor();
	
	@Override public void begin(){}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String aFilename)
	{
		filename = aFilename;
	}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		converter.setFilename(filename);
		item.accept(converter);
	}

	@Override public void endOfUnit(ParserRuleContext ctx, String filename){}
	
	public void setIndexDirectoryName(String dirName)
	{
		converter.setIndexDirectoryName(dirName);
	}
	
	@Override
	public void end()
	{
		converter.shutdown();
	}
	
	
}
