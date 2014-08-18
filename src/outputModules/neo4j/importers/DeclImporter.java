package outputModules.neo4j.importers;

import ast.ASTNode;
import databaseNodes.DeclDatabaseNode;

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
