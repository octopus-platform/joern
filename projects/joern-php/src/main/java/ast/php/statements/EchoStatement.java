package ast.php.statements;

import ast.expressions.Expression;
import ast.logical.statements.Statement;

public class EchoStatement extends Statement
{
	private Expression echoExpression = null;

	public Expression getEchoExpression()
	{
		return this.echoExpression;
	}

	public void setEchoExpression(Expression echoExpression)
	{
		this.echoExpression = echoExpression;
		super.addChild(echoExpression);
	}
}
