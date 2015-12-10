package ast.php.expressions;

import ast.expressions.Expression;
import ast.expressions.UnaryExpression;

public class PHPShellExecExpression extends UnaryExpression
{
	public Expression getShellCommand() {
		return super.getExpression();
	}
	
	public void setShellCommand(Expression variable) {
		super.setExpression(variable);
	}
}
