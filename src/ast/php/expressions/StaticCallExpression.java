package ast.php.expressions;

import ast.expressions.CallExpression;
import ast.expressions.Expression;
import ast.expressions.StringExpression;

public class StaticCallExpression extends CallExpression
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
	
	@Override
	public StringExpression getTargetFunc()
	{
		return (StringExpression)super.getTargetFunc();
	}
}
