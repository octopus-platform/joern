package cfg.nodes;

import java.util.Map;

import neo4j.nodes.NodeKeys;

public class CFGExitNode extends AbstractCFGNode
{

	@Override
	public String toString()
	{
		return "[EXIT]";
	}

	@Override
	public Map<String, Object> getProperties()
	{
		Map<String, Object> properties = super.getProperties();
		properties.put(NodeKeys.CODE, "EXIT");
		return properties;
	}

}
