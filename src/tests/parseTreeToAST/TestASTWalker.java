package tests.parseTreeToAST;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTWalker;

public class TestASTWalker extends ASTWalker
{

	public List<ASTNode> codeItems;

	public TestASTWalker()
	{
		codeItems = new LinkedList<ASTNode>();
	}

	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{

	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{

	}

	@Override
	public void processItem(ASTNode item, Stack<ASTNodeBuilder> itemStack)
	{
		codeItems.add(item);
	}

	@Override
	public void begin()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void end()
	{
		// TODO Auto-generated method stub

	}

}
