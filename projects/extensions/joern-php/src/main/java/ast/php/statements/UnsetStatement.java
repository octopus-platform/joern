package ast.php.statements;

import ast.expressions.Expression;
import ast.logical.statements.Statement;

public class UnsetStatement extends Statement
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
