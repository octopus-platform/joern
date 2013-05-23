package output.neo4j;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTWalker;

public class Neo4JDatabaseCreatorMain extends ASTWalker
{

	Neo4JASTVisitor neo4jASTVisitor = new Neo4JASTVisitor();
	
	public void setIndexDirectoryName(String dirName)
	{
		neo4jASTVisitor.setIndexDirectoryName(dirName);
	}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		neo4jASTVisitor.handleStartOfUnit(filename);
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
	{
		node.accept(neo4jASTVisitor);
	}

	@Override
	public void begin()
	{
		neo4jASTVisitor.begin();
	}

	@Override
	public void end()
	{
		neo4jASTVisitor.end();
	}


}
