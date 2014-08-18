package outputModules.neo4j.importers;

import databaseNodes.DeclDatabaseNode;
import ast.ASTNode;

public class DeclImporter extends ASTNodeImporter
{

	@Override
	public void addToDatabaseSafe(ASTNode node)
	{
		DeclDatabaseNode dbNode = new DeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);
	}

}
