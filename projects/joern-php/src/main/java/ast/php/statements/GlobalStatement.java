package ast.php.statements;

import ast.expressions.Variable;
import ast.logical.statements.Statement;

public class GlobalStatement extends Statement
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
