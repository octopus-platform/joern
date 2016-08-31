package ast.statements.blockstarters;

import ast.expressions.Expression;

// dummy container for the three elements of a PHP foreach "condition"
public class ForEachCondition extends Expression
{
	private Expression iteratedObject = null;
	private Expression key = null;
	private Expression value = null;

	public Expression getIteratedObject()
	{
		return this.iteratedObject;
	}

	public void setIteratedObject(Expression expression)
	{
		this.iteratedObject = expression;
	}

	public Expression getValueExpression()
	{
		return this.value;
	}

	public void setValueExpression(Expression value)
	{
		this.value = value;
	}

	public Expression getKeyExpression()
	{
		return this.key;
	}

	public void setKeyExpression(Expression key)
	{
		this.key = key;
	}
}
