package ast.expressions;

public class InstanceofExpression extends Expression
{
	Expression instanceExpression = null;
	Identifier classIdentifier = null;

	public Expression getInstanceExpression()
	{
		return this.instanceExpression;
	}

	public void setInstanceExpression(Expression instanceExpression)
	{
		this.instanceExpression = instanceExpression;
		super.addChild(instanceExpression);
	}
	
	public Identifier getClassIdentifier()
	{
		return this.classIdentifier;
	}

	public void setClassIdentifier(Identifier classIdentifier)
	{
		this.classIdentifier = classIdentifier;
		super.addChild(classIdentifier);
	}
}
