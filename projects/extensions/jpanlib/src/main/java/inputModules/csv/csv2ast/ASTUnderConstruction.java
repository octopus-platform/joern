package inputModules.csv.csv2ast;

import java.util.Arrays;
import java.util.HashMap;

import ast.ASTNode;
import ast.functionDef.FunctionDefBase;

public class ASTUnderConstruction
{
	HashMap<Long, ASTNode> idToNode = new HashMap<Long, ASTNode>();
	FunctionDefBase rootNode;

	/**
	 * @return The AST's root node, or null if none is set.
	 * @see setRootNode(FunctionDef)
	 */
	public FunctionDefBase getRootNode()
	{
		return rootNode;
	}

	/**
	 * For ASTUnderConstruction instances representing single functions,
	 * the function's root node may be explicitly set.
	 *
	 * @param node The node to be considered as the AST's root node.
	 */
	public void setRootNode(FunctionDefBase node)
	{
		rootNode = node;
	}

	// TODO:
	// - Make ASTUnderConstruction implement Map.
	// - Accordingly, rename addNodeWithId() to put() and getNodeById() to get();
	//    this makes the class more familiar to use for Java programmers anyhow.
	// - Throw an exception if trying to put() a Node that already exists
	//    in the map but with a different id.
	// - The previous point makes the map bijective. Implement a method getIdForNode()
	//    that gives us the unique id of a given node, or -1 if it is not contained.
	public void addNodeWithId(ASTNode newNode, Long id)
	{
		idToNode.put(id, newNode);
	}

	public ASTNode getNodeById(Long id)
	{
		return idToNode.get(id);
	}

	public ASTNode getNodeWithLowestId()
	{
		Object[] array = idToNode.keySet().toArray();
		Arrays.sort(array);
		return idToNode.get(array[0]);
	}

	public boolean containsValue(ASTNode node) {
		return idToNode.containsValue(node);
	}
}
