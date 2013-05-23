package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.ASTNode;

public class ASTDatabaseNode extends DatabaseNode {

	ASTNode astNode;
	
	@Override
	public void initialize(Object node)
	{
		astNode = (ASTNode) node;
	}

	@Override
	public Map<String, Object> createProperties() {
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("type", astNode.getTypeAsString());
		properties.put("code", astNode.getEscapedCodeStr());
		return properties;
	}

}
