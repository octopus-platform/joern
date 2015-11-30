package ast.expressions;

import ast.ASTNode;

public class PropertyExpression extends Expression
{
	private ASTNode objectExpression = null; // TODO make this an Expression
	private ASTNode propertyName = null;

	public ASTNode getObjectExpression() // TODO return an Expression
	{
		return this.objectExpression;
	}

	public void setObjectExpression(ASTNode objectExpression) // TODO take an Expression
	{
		this.objectExpression = objectExpression;
		super.addChild(objectExpression);
	}
	
	public ASTNode getPropertyName()
	{
		return this.propertyName;
	}

	public void setPropertyName(ASTNode propertyName)
	{
		this.propertyName = propertyName;
		super.addChild(propertyName);
	}
}
