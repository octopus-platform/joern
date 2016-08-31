package outputModules.neo4j.exporters;

import java.util.Map;

import databaseNodes.NodeKeys;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import databaseNodes.DatabaseNode;
import databaseNodes.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.DeclStmtExporter;

public class Neo4JDeclStmtExporter extends DeclStmtExporter
{

	public Neo4JDeclStmtExporter()
	{
		declImporter = new Neo4JDeclExporter();

	}

	@Override
	protected void addLinkFromStmtToDecl(long mainNodeId, long declId)
	{
		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.DECLARES);
		Neo4JBatchInserter.addRelationship(mainNodeId, declId, rel, null);
	}

	// ///

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
