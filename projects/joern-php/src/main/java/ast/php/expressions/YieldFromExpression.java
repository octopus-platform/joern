package ast.php.expressions;

import ast.expressions.Expression;

public class YieldFromExpression extends Expression
{
	private Expression fromExpression = null;

	public Expression getFromExpression()
	{
		return this.fromExpression;
	}

	public void setFromExpression(Expression fromExpression)
	{
		this.fromExpression = fromExpression;
		super.addChild(fromExpression);
	}
}
