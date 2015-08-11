package outputModules.csv.exporters;

import ast.ASTNode;
import databaseNodes.DeclDatabaseNode;

public class CSVDeclExporter extends CSVASTNodeExporter
{

	@Override
	public void addToDatabaseSafe(ASTNode node)
	{
		DeclDatabaseNode dbNode = new DeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);

	}

}
