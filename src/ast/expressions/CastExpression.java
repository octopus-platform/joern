package ast.expressions;

import ast.ASTNode;

public class CastExpression extends Expression
{

	Expression castTarget = null;
	Expression castExpression = null;

	@Override
	public void addChild(ASTNode expression)
	{
		if (castTarget == null)
		{
			castTarget = (Expression) expression;
		}
		else
		{
			castExpression = (Expression) expression;
		}
	}

	@Override
	public int getChildCount()
	{
		int childCount = 0;
		if (castTarget != null)
			childCount++;
		if (castExpression != null)
			childCount++;
		return childCount;
	}

	@Override
	public ASTNode getChild(int i)
	{
		if (i == 0)
			return castTarget;
		return castExpression;
	}

	public ASTNode getCastTarget()
	{
		return castTarget;
	}

}
