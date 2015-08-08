package outputModules.neo4j.importers;

import ast.ASTNode;
import databaseNodes.DeclDatabaseNode;

public class Neo4JDeclImporter extends Neo4JASTNodeImporter
{

	@Override
	public void addToDatabaseSafe(ASTNode node)
	{
		DeclDatabaseNode dbNode = new DeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);
	}

}
