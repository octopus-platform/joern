package ast.expressions;

import ast.ASTNode;

public class ClassConstantExpression extends Expression
{
	private ASTNode classExpression = null; // TODO make this an Expression
	private ASTNode constantName = null;

	public ASTNode getClassExpression() // TODO return an Expression
	{
		return this.classExpression;
	}

	public void setClassExpression(ASTNode classExpression) // TODO take an Expression
	{
		this.classExpression = classExpression;
		super.addChild(classExpression);
	}
	
	public ASTNode getConstantName()
	{
		return this.constantName;
	}

	public void setConstantName(ASTNode constantName)
	{
		this.constantName = constantName;
		super.addChild(constantName);
	}
}
