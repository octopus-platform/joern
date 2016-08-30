package outputModules.neo4j.exporters;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import databaseNodes.EdgeTypes;
import databaseNodes.NodeKeys;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import outputModules.common.UDGExporter;
import udg.useDefGraph.UseOrDefRecord;

public class Neo4JUDGExporter extends UDGExporter
{

	GraphNodeStore nodeStore;

	public Neo4JUDGExporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	@Override
	protected void addUseOrDefRecordToDatabase(long symbolNodeId,
			UseOrDefRecord item)
	{
		RelationshipType rel;
		if (item.isDef())
			rel = DynamicRelationshipType.withName(EdgeTypes.DEF);
		else
			rel = DynamicRelationshipType.withName(EdgeTypes.USE);

		long nodeId = nodeStore.getIdForObject(item.getAstNode());

		Neo4JBatchInserter.addRelationship(nodeId, symbolNodeId, rel, null);
	}

	@Override
	protected long createSymbolNode(String identifier)
	{
		long functionId = nodeStore.getIdForObject(currentFunction);

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.NODE_TYPE, "Symbol");
		properties.put(NodeKeys.CODE, identifier);
		properties.put(NodeKeys.FUNCTION_ID, functionId);

		long newNodeId = Neo4JBatchInserter.addNode(properties);
		Neo4JBatchInserter.indexNode(newNodeId, properties);
		return newNodeId;
	}

}
