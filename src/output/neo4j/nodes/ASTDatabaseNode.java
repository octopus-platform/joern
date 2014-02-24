package output.neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.ASTNode;
import astnodes.expressions.BinaryExpression;
import astnodes.functionDef.Parameter;
import astnodes.statements.Condition;
import astnodes.statements.Statement;


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
		
//		if(astNode.getChildCount() == 0)
			properties.put("code", astNode.getEscapedCodeStr());
		
		if(astNode instanceof BinaryExpression)
			properties.put("operator", ((BinaryExpression) astNode).getOperator()); 
	
		
		if(Statement.class.isAssignableFrom(astNode.getClass())){
			properties.put("isStatement", "True");
		}
		
		if(Condition.class.isAssignableFrom(astNode.getClass())){
			properties.put("isStatement", "True");
		}
		
		if(Parameter.class.isAssignableFrom(astNode.getClass())){
			properties.put("isStatement", "True");
		}
		
		return properties;
	}

}
