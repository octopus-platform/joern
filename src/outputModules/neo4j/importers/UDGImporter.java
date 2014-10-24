package outputModules.neo4j.importers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import misc.MultiHashMap;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;
import databaseNodes.EdgeTypes;
import databaseNodes.FunctionDatabaseNode;
import databaseNodes.NodeKeys;

public class UDGImporter
{

	GraphNodeStore nodeStore;
	private FunctionDatabaseNode currentFunction;

	public UDGImporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	public void setCurrentFunction(FunctionDatabaseNode function)
	{
		currentFunction = function;
	}

	public void addUDGToDatabase(UseDefGraph graph)
	{
		MultiHashMap<String, UseOrDefRecord> useDefDict = graph.getUseDefDict();

		Iterator<String> it = useDefDict.getKeySetIterator();

		while (it.hasNext())
		{
			String identifier = it.next();
			long symbolNodeId = createSymbolNode(identifier);
			addUseDefEdges(useDefDict, identifier, symbolNodeId);
		}

	}

	private void addUseDefEdges(
			MultiHashMap<String, UseOrDefRecord> useDefDict, String identifier,
			long symbolNodeId)
	{

		List<UseOrDefRecord> destinations = useDefDict.get(identifier);

		for (UseOrDefRecord item : destinations)
		{
			addUseOrDefRecordToDatabase(symbolNodeId, item);
		}
	}

	private void addUseOrDefRecordToDatabase(long symbolNodeId,
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

	private long createSymbolNode(String identifier)
	{
		long functionId = nodeStore.getIdForObject(currentFunction);

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.TYPE, "Symbol");
		properties.put(NodeKeys.CODE, identifier);
		properties.put(NodeKeys.FUNCTION_ID, functionId);

		long newNodeId = Neo4JBatchInserter.addNode(properties);
		Neo4JBatchInserter.indexNode(newNodeId, properties);
		return newNodeId;
	}

}
