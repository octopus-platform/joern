package outputModules.neo4j.importers;

import ast.ASTNode;
import databaseNodes.DeclDatabaseNode;

public class DeclImporter extends Neo4JASTNodeImporter
{

	@Override
	public void addToDatabaseSafe(ASTNode node)
	{
		DeclDatabaseNode dbNode = new DeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);
	}

}
