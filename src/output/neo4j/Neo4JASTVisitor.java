package output.neo4j;

import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;

// Stays alive during the lifetime of the program

public class Neo4JASTVisitor extends ASTNodeVisitor
{
	FunctionImporter functionImporter;
	String currentFilename;
	
	public void setIndexDirectoryName(String dirName)
	{
		Neo4JDatabase.setIndexDirectoryName(dirName);
	}

	public void handleStartOfUnit(String aFilename)
	{
		currentFilename = aFilename;
	}
	
	public void visit(FunctionDef node)
	{
		createNewFunctionImporterForFunction();
		functionImporter.addFunctionToDatabaseSafe(node);
		functionImporter = null;
	}

	private void createNewFunctionImporterForFunction()
	{
		functionImporter = new FunctionImporter();
		functionImporter.setFilename(currentFilename);
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
