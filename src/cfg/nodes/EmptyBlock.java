package cfg.nodes;

import java.util.Map;

import databaseNodes.NodeKeys;

public class EmptyBlock extends AbstractCFGNode
{
	@Override
	public String toString()
	{
		return "[EMPTY BLOCK]";
	}

	@Override
	public Map<String, Object> getProperties()
	{
		Map<String, Object> properties = super.getProperties();
		properties.put(NodeKeys.CODE, "EMPTY BLOCK");
		return properties;
	}
}
