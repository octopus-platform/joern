package output.neo4j;

import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;


public class Neo4JASTVisitor extends ASTNodeVisitor
{
	FunctionImporter functionImporter = new FunctionImporter();
	
	public void setIndexDirectoryName(String dirName)
	{
		Neo4JDatabase.setIndexDirectoryName(dirName);
	}

	public void setFilename(String aFilename)
	{
		functionImporter.setFilename(aFilename);
	}
	
	public void visit(FunctionDef node)
	{
		functionImporter.addFunctionToDatabaseSafe(node);
	}

	public void begin()
	{
		Neo4JDatabase.start();
	}

	public void end()
	{
		Neo4JDatabase.shutdown();
	}

}
