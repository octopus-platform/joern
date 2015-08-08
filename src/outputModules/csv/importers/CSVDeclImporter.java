package outputModules.csv.importers;

import ast.ASTNode;
import databaseNodes.DeclDatabaseNode;

public class CSVDeclImporter extends CSVASTNodeImporter
{

	@Override
	public void addToDatabaseSafe(ASTNode node)
	{
		DeclDatabaseNode dbNode = new DeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);

	}

}
