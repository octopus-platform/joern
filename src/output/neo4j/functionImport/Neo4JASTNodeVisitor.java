package output.neo4j.functionImport;

import output.neo4j.nodes.FileDatabaseNode;
import astnodes.functionDef.FunctionDef;
import astwalking.ASTNodeVisitor;

// Stays alive during the lifetime of the program

public class Neo4JASTNodeVisitor extends ASTNodeVisitor
{
	FunctionImporter functionImporter;
	FileDatabaseNode currentFileNode;
	
	public void handleStartOfUnit(FileDatabaseNode aCurrentFileNode)
	{
		currentFileNode = aCurrentFileNode;
	}
	
	public void visit(FunctionDef node)
	{
		createNewFunctionImporterForFunction();
		functionImporter.addFunctionToDatabaseSafe(node, currentFileNode);
		functionImporter = null;
	}

	private void createNewFunctionImporterForFunction()
	{
		functionImporter = new FunctionImporter();
	}
	
}
