package output.neo4j.importers;

import output.neo4j.nodes.IdentifierDeclDatabaseNode;
import astnodes.ASTNode;

public class IdentifierDeclImporter extends Importer {

	public void addToDatabaseSafe(ASTNode node)
	{
		IdentifierDeclDatabaseNode dbNode = new IdentifierDeclDatabaseNode();
		dbNode.initialize(node);
		addMainNode(dbNode);
	}
	
}
