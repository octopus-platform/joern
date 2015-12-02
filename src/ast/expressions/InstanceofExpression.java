package ast.expressions;

import ast.ASTNode;

public class InstanceofExpression extends Expression
{
	ASTNode instanceExpression = null; // TODO make this an Expression once PHP mapping is finished
	Identifier classIdentifier = null;

	public ASTNode getInstanceExpression() // TODO return Expression
	{
		return this.instanceExpression;
	}

	public void setInstanceExpression(ASTNode instanceExpression) // TODO take Expression
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
