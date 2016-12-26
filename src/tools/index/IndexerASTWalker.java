package tools.index;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.ASTNodeBuilder;
import ast.walking.ASTNodeVisitor;
import ast.walking.ASTWalker;
import databaseNodes.FileDatabaseNode;

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
	
}
