package ast.expressions;

public class PreIncDecOperationExpression extends PrefixExpression
{
	private Expression variableExpression = null;

	public Expression getVariableExpression()
	{
		return this.variableExpression;
	}

	public void setVariableExpression(Expression variableExpression)
	{
		this.variableExpression = variableExpression;
		super.addChild(variableExpression);
	}
}
