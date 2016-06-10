package ast.c.statements.blockstarters;

import ast.ASTNode;
import ast.statements.blockstarters.IfStatement;
import ast.walking.ASTNodeVisitor;

public class CIfStatement extends IfStatement
{
	private CElseStatement elseNode = null;

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

	public CElseStatement getElseNode()
	{
		return elseNode;
	}

	public void setElseNode(CElseStatement elseNode)
	{
		this.elseNode = elseNode;
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
