package output.neo4j;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astwalking.ASTWalker;

public class Neo4JDatabaseCreatorMain extends ASTWalker
{

	Neo4ASTVisitor converter = new Neo4ASTVisitor();
	
	public void setIndexDirectoryName(String dirName)
	{
		converter.setIndexDirectoryName(dirName);
	}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		converter.setFilename(filename);
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void processItem(ASTNode node, Stack<ASTNodeBuilder> nodeStack)
	{
		node.accept(converter);
	}

	@Override
	public void begin()
	{
		converter.begin();
	}

	@Override
	public void end()
	{
		converter.end();
	}


}
