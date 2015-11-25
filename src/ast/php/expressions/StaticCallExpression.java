package ast.php.expressions;

import ast.expressions.CallExpression;
import ast.expressions.Identifier;

public class StaticCallExpression extends CallExpression
{
	private Identifier targetClass = null;
	
	public Identifier getTargetClass()
	{
		return this.targetClass;
	}
	
	public void setTargetClass(Identifier targetClass)
	{
		this.targetClass = targetClass;
		super.addChild(targetClass);
	}
}
