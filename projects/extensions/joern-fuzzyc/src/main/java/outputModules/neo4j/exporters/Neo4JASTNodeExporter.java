package outputModules.neo4j.exporters;

import java.util.Map;

import ast.ASTNode;
import databaseNodes.DatabaseNode;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.GraphNodeStore;
import outputModules.common.ASTNodeExporter;

public abstract class Neo4JASTNodeExporter extends ASTNodeExporter
{

	public abstract void addToDatabaseSafe(ASTNode node);

	protected GraphNodeStore nodeStore = new GraphNodeStore();

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
		properties.remove(NodeKeys.LOCATION);
		nodeStore.indexNode(dbNode, properties);

	}

}
