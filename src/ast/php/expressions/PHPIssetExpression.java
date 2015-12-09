package ast.php.expressions;

import ast.expressions.Expression;
import ast.expressions.UnaryExpression;

public class PHPIssetExpression extends UnaryExpression
{
	public Expression getVariableExpression() {
		return super.getExpression();
	}
	
	public void setVariableExpression(Expression variable) {
		super.setExpression(variable);
	}
}
