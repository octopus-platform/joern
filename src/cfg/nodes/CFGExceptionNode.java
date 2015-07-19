package cfg.nodes;

import java.util.Map;

import databaseNodes.NodeKeys;

public class CFGExceptionNode extends AbstractCFGNode
{
	@Override
	public String toString()
	{
		return "[EXCEPTION]";
	}

	@Override
	public Map<String, Object> getProperties()
	{
		Map<String, Object> properties = super.getProperties();
		properties.put(NodeKeys.CODE, "EXCEPTION");
		return properties;
	}
}
