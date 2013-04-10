package astnodes.expressions;

import java.util.LinkedList;

import astnodes.ASTNode;


public class Expression extends ASTNode
{
	protected LinkedList<ASTNode> children;
	
	public void addChild(ASTNode expression)
	{
		if(children == null)
			children = new LinkedList<ASTNode>();
		children.add(expression);
	}
	public int getChildCount()
	{
		if(children == null) return 0;
		return children.size();
	}
	
	public ASTNode getChild(int i)
	{
		if(children == null) return null;
		return children.get(i);
	}
}
