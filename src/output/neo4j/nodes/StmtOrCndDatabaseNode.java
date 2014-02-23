package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import cfg.StatementOrCondition;

public class StmtOrCndDatabaseNode extends DatabaseNode {

	StatementOrCondition block;
	
	@Override
	public void initialize(Object obj)
	{
		block = (StatementOrCondition) obj;
	}

	@Override
	public Map<String, Object> createProperties()
	{	
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("code", block.getEscapedCodeStr());
		properties.put("type", block.getType());		
		if(block.getASTNode() != null)
			properties.put("location", block.getASTNode().getLocationString());
		return properties;
	}

}
