package outputModules.parser;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNode;
import ast.ASTNodeBuilder;
import ast.walking.ASTNodeVisitor;
import ast.walking.ASTWalker;
import databaseNodes.FileDatabaseNode;

public abstract class ParserASTWalker extends ASTWalker
{

	protected ParserState state;
	protected ASTNodeVisitor astVisitor;

	public void setIndexerState(ParserState aState)
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
