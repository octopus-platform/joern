package ast.expressions;

public class StaticPropertyExpression extends MemberAccess
{
	private Expression classExpression = null;
	private Expression propertyExpression = null;

	public Expression getClassExpression()
	{
		return this.classExpression;
	}

	public void setClassExpression(Expression classExpression)
	{
		this.classExpression = classExpression;
		super.addChild(classExpression);
	}
	
	public Expression getPropertyExpression()
	{
		return this.propertyExpression;
	}

	public void setPropertyExpression(Expression propertyExpression)
	{
		this.propertyExpression = propertyExpression;
		super.addChild(propertyExpression);
	}
}
