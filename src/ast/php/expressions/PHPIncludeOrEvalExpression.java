package ast.php.expressions;

import ast.ASTNode;
import ast.expressions.UnaryExpression;

public class PHPIncludeOrEvalExpression extends UnaryExpression
{
	public ASTNode getIncludeOrEvalExpression() { // TODO return an expression
		return super.getExpression();
	}
	
	public void setIncludeOrEvalExpression(ASTNode variable) { // TODO take an expression
		super.setExpression(variable);
	}
}
