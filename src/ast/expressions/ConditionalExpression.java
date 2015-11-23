package ast.expressions;

import ast.ASTNode;

public class ConditionalExpression extends Expression
{
	protected ASTNode condition = null; // TODO change type to Expression once mapping is finished
	protected ASTNode trueExpression = null; // TODO change type to Expression once mapping is finished
	protected ASTNode falseExpression = null; // TODO change type to Expression once mapping is finished

	public ASTNode getCondition()
	{
		return this.condition;
	}

	public void setCondition(ASTNode expression)
	{
		this.condition = expression;
		super.addChild(expression);
	}
	
	public ASTNode getTrueExpression()
	{
		return this.trueExpression;
	}

	public void setTrueExpression(ASTNode trueExpression)
	{
		this.trueExpression = trueExpression;
		super.addChild(trueExpression);
	}
	
	public ASTNode getFalseExpression()
	{
		return this.falseExpression;
	}

	public void setFalseExpression(ASTNode falseExpression)
	{
		this.falseExpression = falseExpression;
		super.addChild(falseExpression);
	}
}
