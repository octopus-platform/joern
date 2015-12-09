package ast.php.statements;

import ast.expressions.Expression;
import ast.expressions.StringExpression;
import ast.logical.statements.Statement;

public class StaticVariableDeclaration extends Statement
{
	private StringExpression name = null;
	private Expression defaultvalue = null;

	public StringExpression getNameChild()
	{
		return this.name;
	}
	
	public void setNameChild(StringExpression name)
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
