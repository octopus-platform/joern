package output.neo4j;

import java.util.HashMap;
import java.util.Map;

import output.neo4j.dbinterfaces.Neo4JInterface;

public class GraphNodeStore
{
	
	Map<Object, Long> objectToId = new HashMap<Object, Long>();
	
	public long getIdForObject(Object o)
	{
		return objectToId.get(o);
	}
	
	public void addNeo4jNode(Object o, Map<String, Object> properties)
	{
		long nodeId = Neo4JInterface.addNode(properties);
		objectToId.put(o, nodeId);
	}
	
	public void indexNode(Object o, Map<String, Object> properties)
	{
		long nodeId = getIdForObject(o);
		Neo4JInterface.indexNode(nodeId, properties);
	}
	
}
