package neo4j;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import databaseNodes.FileDatabaseNode;
import tools.index.IndexerASTWalker;
import tools.index.IndexerState;
import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;

public class Neo4JASTWalker extends IndexerASTWalker
{

	Neo4JASTNodeVisitor neo4jASTVisitor = new Neo4JASTNodeVisitor();
	IndexerState state;

	public void setIndexerState(IndexerState aState)
	{
		state = aState;
	}

	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		FileDatabaseNode currentFileNode = state.getCurrentFileNode();
		neo4jASTVisitor.handleStartOfUnit(currentFileNode);
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
	}

	@Override
	public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
	{
		node.accept(neo4jASTVisitor);
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
