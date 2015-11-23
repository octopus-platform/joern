package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.Expression;

public class PHPCoalesceExpression extends Expression
{
	protected ASTNode leftExpression = null;
	protected ASTNode rightExpression = null;

	public ASTNode getLeftExpression()
	{
		return this.leftExpression;
	}

	public void setLeftExpression(ASTNode leftExpression)
	{
		this.leftExpression = leftExpression;
		super.addChild(leftExpression);
	}

	public ASTNode getRightExpression()
	{
		return this.rightExpression;
	}

	public void setRightExpression(ASTNode rightExpression)
	{
		this.rightExpression = rightExpression;
		super.addChild(rightExpression);
	}
}
