package ast.statements;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class TryStatement extends BlockStarter
{

	private CatchStatement catchNode = null;

	public void setCatchNode(CatchStatement catchNode)
	{
		this.catchNode = catchNode;
	}

	public CatchStatement getCatchNode()
	{
		return this.catchNode;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	public int getChildCount()
	{
		int childCount = super.getChildCount();

		if (getCatchNode() != null)
			childCount++;
		return childCount;
	}

	public ASTNode getChild(int i)
	{
		if (i == 0)
			return getStatement();
		else if (i == 1)
			return getCatchNode();
		throw new RuntimeException("Invalid IfItem");
	}

}
