package output.luceneIndex;

import java.util.Stack;



import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTWalker;

public class LuceneIndexCreatorMain extends ASTWalker
{
	String filename = "";
	ASTToLuceneConverter converter = new ASTToLuceneConverter();
	
	@Override public void begin(){}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String aFilename)
	{
		filename = aFilename;
	}

	@Override
	public void processItem(ASTNode item, Stack<ASTNodeBuilder> itemStack)
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
