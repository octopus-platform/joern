package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.UnaryExpression;

public class PHPShellExecExpression extends UnaryExpression
{
	public ASTNode getShellCommand() { // TODO return an expression
		return super.getExpression();
	}
	
	public void setShellCommand(ASTNode variable) { // TODO take an expression
		super.setExpression(variable);
	}
}
