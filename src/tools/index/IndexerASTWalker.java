package tools.index;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import databaseNodes.FileDatabaseNode;
import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTNodeVisitor;
import astwalking.ASTWalker;

public abstract class IndexerASTWalker extends ASTWalker
{

	protected IndexerState state;
	protected ASTNodeVisitor astVisitor;
	
	public void setIndexerState(IndexerState aState)
	{
		state = aState;
	}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		FileDatabaseNode currentFileNode = state.getCurrentFileNode();
		astVisitor.handleStartOfUnit(currentFileNode);
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
	}

	@Override
	public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
	{
		node.accept(astVisitor);
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
