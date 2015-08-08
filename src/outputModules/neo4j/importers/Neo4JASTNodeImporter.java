package outputModules.neo4j.importers;

import java.util.Map;

import neo4j.batchInserter.GraphNodeStore;
import outputModules.ASTNodeImporter;
import ast.ASTNode;
import databaseNodes.DatabaseNode;

public abstract class Neo4JASTNodeImporter extends ASTNodeImporter
{

	protected GraphNodeStore nodeStore = new GraphNodeStore();

	public abstract void addToDatabaseSafe(ASTNode node);

	@Override
	protected void addMainNode(DatabaseNode dbNode)
	{
		Map<String, Object> properties = dbNode.createProperties();
		nodeStore.addNeo4jNode(dbNode, properties);

		mainNodeId = nodeStore.getIdForObject(dbNode);

		// We are currently not adding 'functionId' to the function node
		// as that requires us to perform a lookup on the node just created
		// and thus requires us to flush.

		// nodeStore.setNodeProperty(dbNode, "functionId", String.format("%d",
		// mainNodeId));

		// index, but do not index location
		properties.remove("location");
		nodeStore.indexNode(dbNode, properties);

	}

}
