package output.neo4j;

import java.util.Map;

public class GraphNodeStore
{
	
	public long addNeo4jNode(Object o, Map<String, Object> properties)
	{
		long nodeId = Neo4JDatabase.addNode(properties);
		return nodeId;
	}
	
}
