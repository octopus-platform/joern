package inputModules.csv.csv2ast;

import java.util.HashMap;

import ast.ASTNode;
import ast.functionDef.FunctionDef;

public class ASTUnderConstruction
{
	HashMap<Long, ASTNode> idToNode = new HashMap<Long, ASTNode>();
	FunctionDef rootNode;

	public FunctionDef getRootNode()
	{
		return rootNode;
	}

	public void addNodeWithId(ASTNode newNode, Long id)
	{
		idToNode.put(id, newNode);
	}

	public void setRootNode(FunctionDef node)
	{
		rootNode = node;
	}

	public ASTNode getNodeById(Long id)
	{
		return idToNode.get(id);
	}
}
