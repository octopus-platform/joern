package ast.expressions;

import ast.ASTNode;

public class BinaryExpression extends Expression
{
	Expression leftExpression = null;
	Expression rightExpression = null;
	
	public Expression getLeft()
	{
		return this.leftExpression;
	}

	public void setLeft(Expression leftExpression)
	{
		this.leftExpression = leftExpression;
		super.addChild(leftExpression);
	}
	
	public Expression getRight()
	{
		return this.rightExpression;
	}

	public void setRight(Expression rightExpression)
	{
		this.rightExpression = rightExpression;
		super.addChild(rightExpression);
	}

	@Override
	public void addChild(ASTNode item)
	{
		if (getLeft() == null)
			setLeft((Expression)item);
		else if (getRight() == null)
			setRight((Expression)item);
		else
			throw new RuntimeException(
					"Error: attempting to add third child to binary expression");
	}
}
