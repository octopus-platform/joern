package ast.php.expressions;

import ast.expressions.Variable;

public class PHPReferenceExpression extends Variable
{
	private Variable variable = null;

	public Variable getVariable()
	{
		return this.variable;
	}

	public void setVariable(Variable variable)
	{
		this.variable = variable;
		super.addChild(variable);
	}
}
