package ast.php.expressions;

import ast.expressions.CallExpression;
import ast.expressions.Expression;

public class MethodCallExpression extends CallExpression
{
	private Expression targetObject = null;
	
	public Expression getTargetObject()
	{
		return this.targetObject;
	}
	
	public void setTargetObject(Expression targetObject)
	{
		this.targetObject = targetObject;
		super.addChild(targetObject);
	}
}
