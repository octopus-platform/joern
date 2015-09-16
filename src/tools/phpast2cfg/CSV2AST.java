package tools.phpast2cfg;

import java.util.HashMap;

import ast.ASTNode;
import ast.functionDef.FunctionDef;

public class CSV2AST
{
	HashMap<Long, ASTNode> idToNode = new HashMap<Long, ASTNode>();

	public FunctionDef convert(String nodeFilename, String edgeFilename)
	{
		FunctionDef rootNode = handleNodes(nodeFilename);
		handleEdges(nodeFilename);
		return rootNode;
	}

	private void handleEdges(String nodeFilename)
	{
		// TODO Auto-generated method stub

	}

	private FunctionDef handleNodes(String nodeFilename)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
