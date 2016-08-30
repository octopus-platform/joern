package ast.php.expressions;

import ast.expressions.CallExpressionBase;
import ast.expressions.Expression;

public class StaticCallExpression extends CallExpressionBase
{
	private Expression targetClass = null;
	
	public Expression getTargetClass()
	{
		return this.targetClass;
	}
	
	public void setTargetClass(Expression targetClass)
	{
		this.targetClass = targetClass;
		super.addChild(targetClass);
	}
}
