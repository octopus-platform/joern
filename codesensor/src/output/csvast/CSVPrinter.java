package output.csvast;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTNodeVisitor;
import astwalking.ASTWalker;

public class CSVPrinter extends ASTWalker
{
    
    private ASTToCSVConverter converter = new ASTToCSVConverter();
    
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		
	}

	@Override
	public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
	{
		node.accept(converter);
	}

	@Override
	public void begin()
	{
		
	}

	@Override
	public void end()
	{
		
	}
    
}
