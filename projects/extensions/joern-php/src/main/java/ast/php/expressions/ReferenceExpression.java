package ast.php.expressions;

import ast.expressions.Expression;
import ast.expressions.Variable;

public class ReferenceExpression extends Variable
{
	private Expression variable = null;

	public Expression getVariableExpression()
	{
		return this.variable;
	}

	public void setVariableExpression(Expression variable)
	{
		this.variable = variable;
		super.addChild(variable);
	}
}
