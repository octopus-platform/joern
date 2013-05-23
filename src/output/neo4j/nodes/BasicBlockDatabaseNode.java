package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import cfg.BasicBlock;

public class BasicBlockDatabaseNode extends DatabaseNode {

	BasicBlock block;
	
	@Override
	public void initialize(Object obj)
	{
		block = (BasicBlock) obj;
	}

	@Override
	public Map<String, Object> createProperties()
	{	
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("code", block.getEscapedCodeStr());
		properties.put("type", block.getType());
		return properties;	
	}

}
