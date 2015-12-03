package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.UnaryExpression;

public class PHPIssetExpression extends UnaryExpression
{
	public ASTNode getVariableExpression() { // TODO return an expression
		return super.getExpression();
	}
	
	public void setVariableExpression(ASTNode variable) { // TODO take an expression
		super.setExpression(variable);
	}
}
