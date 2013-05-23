package output.neo4j;

import java.util.Map;

public class GraphNodeStore
{
	
	public long addNeo4jNode(Map<String, Object> properties)
	{
		long nodeId = Neo4JDatabase.addNode(properties);
		return nodeId;
	}
	
	public void indexNode(long nodeId, Map<String, Object> properties)
	{
		Neo4JDatabase.indexNode(nodeId, properties);
	}
	
}
