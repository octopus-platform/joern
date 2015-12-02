package ast.expressions;

import ast.ASTNode;

public class BinaryOperationExpression extends BinaryExpression
{
	// for binary operation expressions, change visibility of setLeft() and setRight()

	@Override
	public void setLeft(ASTNode leftExpression) // TODO take Expression
	{
		super.setLeft(leftExpression);
	}

	@Override
	public void setRight(ASTNode rightExpression) // TODO take Expression
	{
		super.setRight(rightExpression);
	}
}
