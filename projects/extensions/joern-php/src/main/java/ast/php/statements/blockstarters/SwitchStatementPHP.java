package ast.php.statements.blockstarters;

import ast.expressions.Expression;
import ast.statements.blockstarters.SwitchStatement;

public class SwitchStatementPHP extends SwitchStatement
{
	private Expression expression = null;
	protected SwitchList switchList = null;

	public Expression getExpression()
	{
		return this.expression;
	}

	public void setExpression(Expression expression)
	{
		this.expression = expression;
		super.addChild(expression);
	}
	
	public SwitchList getSwitchList()
	{
		return this.switchList;
	}
	
	public void setSwitchList(SwitchList switchList)
	{
		this.switchList = switchList;
		super.addChild(switchList);
	}
}
