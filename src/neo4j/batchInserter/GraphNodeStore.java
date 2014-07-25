package neo4j.batchInserter;

import java.util.HashMap;
import java.util.Map;

public class GraphNodeStore
{

	Map<Object, Long> objectToId = new HashMap<Object, Long>();

	public long getIdForObject(Object o)
	{
		return objectToId.get(o);
	}

	public void addNeo4jNode(Object o, Map<String, Object> properties)
	{
		long nodeId = Neo4JBatchInserter.addNode(properties);
		objectToId.put(o, nodeId);
	}

	public void indexNode(Object o, Map<String, Object> properties)
	{
		long nodeId = getIdForObject(o);
		Neo4JBatchInserter.indexNode(nodeId, properties);
	}

	public void setNodeProperty(Object o, String key, String val)
	{
		long nodeId = getIdForObject(o);
		Neo4JBatchInserter.setNodeProperty(nodeId, key, val);
	}

}
