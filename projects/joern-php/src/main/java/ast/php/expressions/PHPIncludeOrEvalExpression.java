package ast.php.expressions;

import ast.expressions.Expression;
import ast.expressions.UnaryExpression;

public class PHPIncludeOrEvalExpression extends UnaryExpression
{
	public Expression getIncludeOrEvalExpression() {
		return super.getExpression();
	}
	
	public void setIncludeOrEvalExpression(Expression variable) {
		super.setExpression(variable);
	}
}
