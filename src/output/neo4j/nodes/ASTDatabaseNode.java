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

		boolean isStatement = isStatement();
		
		// Only calculate and store code strings for
		// leave-nodes and statements
		
		// if(astNode.getChildCount() == 0 || isStatement)
			properties.put("code", astNode.getEscapedCodeStr());
		
		
		if(astNode instanceof BinaryExpression)
			properties.put("operator", ((BinaryExpression) astNode).getOperator()); 
	
		if(isStatement)
			properties.put("isStatement", "True");
		
		return properties;
	}

	// TODO
	// When creating properties for the database node of an AST node,
	// we decide if it is a statement. Arguably, the parser should
	// already do this.
	
	private boolean isStatement()
	{
		if(Statement.class.isAssignableFrom(astNode.getClass()))
			return true;
		
		if(Condition.class.isAssignableFrom(astNode.getClass()))
			return true;
		
		if(Parameter.class.isAssignableFrom(astNode.getClass()))
			return true;
	
		return false;
	}
	
}
