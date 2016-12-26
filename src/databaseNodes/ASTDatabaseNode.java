package databaseNodes;

import java.util.HashMap;
import java.util.Map;

import ast.ASTNode;
import ast.CodeLocation;
import ast.expressions.BinaryExpression;
import ast.expressions.Expression;
import ast.functionDef.Parameter;
import ast.functionDef.ReturnType;
import ast.statements.CompoundStatement;

public class ASTDatabaseNode extends DatabaseNode
{

	ASTNode astNode;
	private FunctionDatabaseNode currentFunction;
	
	@Override
	public void initialize(Object node)
	{
		astNode = (ASTNode) node;
	}

	@Override
	public Map<String, Object> createProperties()
	{

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.TYPE, astNode.getTypeAsString());

		// Only calculate and store code strings for
		// leave-nodes and statements
		// if(astNode.getChildCount() == 0)
		properties.put(NodeKeys.CODE, astNode.getEscapedCodeStr());

		if (astNode.isInCFG()){
			properties.put(NodeKeys.IS_CFG_NODE, "True");			
			properties.put(NodeKeys.LOCATION, getCorrectedLocationString());
		}
			
		if (astNode instanceof CompoundStatement ){
			properties.put(NodeKeys.LOCATION, astNode.getLocationString());
		}
		
		if (astNode instanceof Expression){
			String operator = ((Expression) astNode).getOperator();
			if(operator != "")
				properties.put(NodeKeys.OPERATOR, operator);
		}
			
		// if(astNode.getChildCount() > 1){
		String childNumStr = Integer.toString(astNode.getChildNumber());
		properties.put(NodeKeys.CHILD_NUMBER, childNumStr);
		// }

		return properties;
	}

	private String getCorrectedLocationString()
	{

		CodeLocation funcLocation = currentFunction.getContentLocation();
		CodeLocation location = astNode.getLocation();
		
		if(!(astNode instanceof Parameter) || (astNode instanceof ReturnType)){
			location.startIndex += funcLocation.startIndex + 1;
			location.startLine += funcLocation.startLine - 1;
			location.stopIndex += funcLocation.startIndex + 1;
		}
			
		return location.toString();
	}

	public FunctionDatabaseNode getCurrentFunction()
	{
		return currentFunction;
	}

	public void setCurrentFunction(FunctionDatabaseNode currentFunction)
	{
		this.currentFunction = currentFunction;
	}

}
