package ast.php.statements;

import ast.expressions.Expression;
import ast.expressions.Variable;
import ast.logical.statements.Statement;

public class StaticVariableDeclaration extends Statement
{
	private Variable name = null;
	private Expression defaultvalue = null;

	public Variable getNameChild()
	{
		return this.name;
	}
	
	public void setNameChild(Variable name)
	{
		this.name = name;
		super.addChild(name);
	}
	
	public Expression getDefault()
	{
		return this.defaultvalue;
	}
	
	public void setDefault(Expression defaultvalue)
	{
		this.defaultvalue = defaultvalue;
		super.addChild(defaultvalue);
	}
}
