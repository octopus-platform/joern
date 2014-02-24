package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import cfg.CFGNode;

public class EmptyCFGDatabaseNode extends DatabaseNode {
	
	@Override
	public void initialize(Object obj)
	{
		
	}

	@Override
	public Map<String, Object> createProperties()
	{	
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("code", "");
		properties.put("type", "Statement");
		properties.put("isStatement", "True");
		return properties;
	}

}
