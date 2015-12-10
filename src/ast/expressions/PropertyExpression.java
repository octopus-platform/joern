package ast.expressions;

public class PropertyExpression extends MemberAccess
{
	private Expression objectExpression = null;
	private StringExpression propertyName = null;

	public Expression getObjectExpression()
	{
		return this.objectExpression;
	}

	public void setObjectExpression(Expression objectExpression)
	{
		this.objectExpression = objectExpression;
		super.addChild(objectExpression);
	}
	
	public StringExpression getPropertyName()
	{
		return this.propertyName;
	}

	public void setPropertyName(StringExpression propertyName)
	{
		this.propertyName = propertyName;
		super.addChild(propertyName);
	}
}
