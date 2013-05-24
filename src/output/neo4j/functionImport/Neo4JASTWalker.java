package output.neo4j.functionImport;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import output.neo4j.Neo4JImportListener;
import output.neo4j.nodes.FileDatabaseNode;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTWalker;

public class Neo4JASTWalker extends ASTWalker
{

	Neo4JASTNodeVisitor neo4jASTVisitor = new Neo4JASTNodeVisitor();
	Neo4JImportListener importListener;
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		FileDatabaseNode currentFileNode = importListener.getCurrentFileNode();
		neo4jASTVisitor.handleStartOfUnit(currentFileNode);
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename){}

	@Override
	public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
	{
		node.accept(neo4jASTVisitor);
	}

	@Override public void begin(){}
	@Override public void end(){}

	public void setImportListener(Neo4JImportListener anImportListener)
	{
		importListener = anImportListener;
	}

}
