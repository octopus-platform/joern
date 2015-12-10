package ast.expressions;

public class NewExpression extends CallExpression
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
