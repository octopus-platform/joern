package ast.php.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;

public class PHPEchoStatement extends Statement
{
	private ASTNode echoExpression = null; // TODO make into Expression once mapping is finished

	public ASTNode getEchoExpression() // TODO return Expression
	{
		return this.echoExpression;
	}

	public void setEchoExpression(ASTNode echoExpression) // TODO take Expression
	{
		this.echoExpression = echoExpression;
		super.addChild(echoExpression);
	}
}
