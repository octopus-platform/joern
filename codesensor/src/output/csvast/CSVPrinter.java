package output.csvast;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;


import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTWalker;
import astwalking.FunctionNodeVisitor;

public class CSVPrinter extends ASTWalker
{
    
	private ASTToCSVConverter converter = new ASTToCSVConverter();
    FunctionNodeVisitor visitor = new FunctionNodeVisitor();
	
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
		visitor.setFunctionNodeVisitor(converter);
		node.accept(visitor);
		
		String result = converter.getResult();
		converter.reset();
		
		System.out.println(result);
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
