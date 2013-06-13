package output.neo4j.importers;

import output.neo4j.nodes.DeclDatabaseNode;
import astnodes.ASTNode;

public class DeclImporter extends Importer {

	@Override
	public void addToDatabaseSafe(ASTNode node)
	{
		DeclDatabaseNode dbNode = new DeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);
	}

}
