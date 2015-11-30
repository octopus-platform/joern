package ast.expressions;

import ast.ASTNode;

public class StaticPropertyExpression extends Expression
{
	private ASTNode classExpression = null; // TODO make this an Expression
	private ASTNode propertyName = null;

	public ASTNode getClassExpression() // TODO return an Expression
	{
		return this.classExpression;
	}

	public void setClassExpression(ASTNode classExpression) // TODO take an Expression
	{
		this.classExpression = classExpression;
		super.addChild(classExpression);
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
