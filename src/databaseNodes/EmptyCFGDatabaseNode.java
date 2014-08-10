package databaseNodes;

import java.util.HashMap;
import java.util.Map;

public class EmptyCFGDatabaseNode extends DatabaseNode
{

	@Override
	public void initialize(Object obj)
	{

	}

	@Override
	public Map<String, Object> createProperties()
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.TYPE, "EmptyStatement");
		properties.put(NodeKeys.IS_CFG_NODE, "True");
		return properties;
	}

}
