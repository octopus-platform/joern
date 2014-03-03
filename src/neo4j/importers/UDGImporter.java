package neo4j.importers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;
import misc.MultiHashMap;
import neo4j.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import neo4j.nodes.FunctionDatabaseNode;
import neo4j.nodes.NodeKeys;

public class UDGImporter {

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
		MultiHashMap useDefDict = graph.getUseDefDict();
				
		Iterator<Object> it = useDefDict.getKeySetIterator();
			
		while(it.hasNext()){
			String identifier = (String) it.next();							
			long symbolNodeId = createSymbolNode(identifier);			
			addUseDefEdges(useDefDict, identifier, symbolNodeId);	
		}
	
	}

	private void addUseDefEdges(MultiHashMap useDefDict, String identifier,
			long symbolNodeId)
	{
		
		List<Object> destinations = useDefDict.getListForKey(identifier);			
		
		for(Object d : destinations){
			UseOrDefRecord item = (UseOrDefRecord) d;
			addUseOrDefRecordToDatabase(symbolNodeId, item);			
		}
	}

	private void addUseOrDefRecordToDatabase(long symbolNodeId, UseOrDefRecord item)
	{
		RelationshipType rel;				
		if(item.isDef)
			rel = DynamicRelationshipType.withName(EdgeTypes.DEF);				          
		else
			rel = DynamicRelationshipType.withName(EdgeTypes.USE);
		
		long nodeId = nodeStore.getIdForObject(item.astNode);
		
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
