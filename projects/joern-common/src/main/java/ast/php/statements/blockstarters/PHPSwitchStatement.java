package ast.php.statements.blockstarters;

import ast.expressions.Expression;
import ast.statements.blockstarters.SwitchStatement;

public class PHPSwitchStatement extends SwitchStatement
{
	private Expression expression = null;
	protected PHPSwitchList switchList = null;

	public Expression getExpression()
	{
		return this.expression;
	}

	public void setExpression(Expression expression)
	{
		this.expression = expression;
		super.addChild(expression);
	}
	
	public PHPSwitchList getSwitchList()
	{
		return this.switchList;
	}
	
	public void setSwitchList(PHPSwitchList switchList)
	{
		this.switchList = switchList;
		super.addChild(switchList);
	}
}
