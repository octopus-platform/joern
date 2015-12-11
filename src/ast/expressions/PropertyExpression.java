package ast.expressions;

public class PropertyExpression extends MemberAccess
{
	private Expression objectExpression = null;
	private Expression propertyName = null;

	public Expression getObjectExpression()
	{
		return this.objectExpression;
	}

	public void setObjectExpression(Expression objectExpression)
	{
		this.objectExpression = objectExpression;
		super.addChild(objectExpression);
	}
	
	public Expression getPropertyName()
	{
		return this.propertyName;
	}

	public void setPropertyName(Expression propertyName)
	{
		this.propertyName = propertyName;
		super.addChild(propertyName);
	}
}
