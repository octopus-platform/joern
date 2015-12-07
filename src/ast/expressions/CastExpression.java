package ast.expressions;

import ast.ASTNode;

public class CastExpression extends Expression
{

	Expression castTarget = null;
	ASTNode castExpression = null; // TODO make this an expression

	@Override
	public void addChild(ASTNode expression)
	{
		if (castTarget == null)
			setCastTarget( (Expression)expression);
		else
			setCastExpression( (Expression)expression);
	}
	
	public Expression getCastTarget()
	{
		return this.castTarget;
	}
	
	public void setCastTarget(Expression castTarget)
	{
		this.castTarget = castTarget;
		super.addChild(castTarget);
	}
	
	public ASTNode getCastExpression()  // TODO return an expression
	{
		return this.castExpression;
	}

	public void setCastExpression(ASTNode castExpression) // TODO take an expression
	{
		this.castExpression = castExpression;
		super.addChild(castExpression);
	}
}
