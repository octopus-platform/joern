package neo4j.nodes;

import java.util.HashMap;
import java.util.Map;

import astnodes.ASTNode;
import astnodes.expressions.BinaryExpression;

public class ASTDatabaseNode extends DatabaseNode
{

	ASTNode astNode;

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

		if (astNode.isInCFG())
			properties.put(NodeKeys.IS_CFG_NODE, "True");

		if (astNode instanceof BinaryExpression)
			properties.put(NodeKeys.OPERATOR,
					((BinaryExpression) astNode).getOperator());

		// if(astNode.getChildCount() > 1){
		String childNumStr = Integer.toString(astNode.getChildNumber());
		properties.put(NodeKeys.CHILD_NUMBER, childNumStr);
		// }

		return properties;
	}

}
