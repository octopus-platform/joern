package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.ASTNode;
import astnodes.expressions.BinaryExpression;

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

		// Only calculate and store code strings for
		// leave-nodes and statements
		
		// if(astNode.getChildCount() == 0)
			properties.put("code", astNode.getEscapedCodeStr());
		
		if(astNode.isInCFG())
			properties.put("isCFGNode", "True");
			
		if(astNode instanceof BinaryExpression)
			properties.put("operator", ((BinaryExpression) astNode).getOperator()); 
		
		return properties;
	}
	
}
