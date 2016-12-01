package cfg.nodes;

import java.util.Map;

import databaseNodes.NodeKeys;

public class InfiniteForNode extends AbstractCFGNode
{
	@Override
	public String toString()
	{
		return "[INFINITE FOR]";
	}

	@Override
	public Map<String, Object> getProperties()
	{
		Map<String, Object> properties = super.getProperties();
		properties.put(NodeKeys.CODE, "true");
		return properties;
	}
}
