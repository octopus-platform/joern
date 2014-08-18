package ast.statements;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class IfStatement extends BlockStarter
{

	private ElseStatement elseNode = null;

	public int getChildCount()
	{
		int childCount = super.getChildCount();

		if (getElseNode() != null)
			childCount++;
		return childCount;
	}

	public ASTNode getChild(int i)
	{
		if (i == 0)
			return condition;
		else if (i == 1)
			return statement;
		else if (i == 2)
			return getElseNode();
		throw new RuntimeException("Invalid IfItem");
	}

	public ElseStatement getElseNode()
	{
		return elseNode;
	}

	public void setElseNode(ElseStatement elseNode)
	{
		this.elseNode = elseNode;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
