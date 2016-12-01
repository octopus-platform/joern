package ast.expressions;

public class PropertyExpression extends MemberAccess
{
	private Expression objectExpression = null;
	private Expression propertyExpression = null;

	public Expression getObjectExpression()
	{
		return this.objectExpression;
	}

	public void setObjectExpression(Expression objectExpression)
	{
		this.objectExpression = objectExpression;
		super.addChild(objectExpression);
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
