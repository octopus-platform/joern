package output.neo4j.functionImport;

import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;

// Stays alive during the lifetime of the program

public class Neo4JASTVisitor extends ASTNodeVisitor
{
	FunctionImporter functionImporter;
	String currentFilename;
	
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
	
}
