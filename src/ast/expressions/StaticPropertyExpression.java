package ast.expressions;

public class StaticPropertyExpression extends MemberAccess
{
	private Expression classExpression = null;
	private StringExpression propertyName = null;

	public Expression getClassExpression()
	{
		return this.classExpression;
	}

	public void setClassExpression(Expression classExpression)
	{
		this.classExpression = classExpression;
		super.addChild(classExpression);
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
