package astnodes.expressions;

import astnodes.ASTNode;
import astnodes.statements.Condition;

public class ConditionalExpression extends Expression
{
	Expression expressions [] = new Expression[3];

	Condition condition;
	Expression trueExpr;
	Expression falseExpr;
	
	@Override
	public void addChild(ASTNode expression)
	{
		if(getCondition() == null)
			setCondition((Expression) expression);
		else if(getTrueExpr() == null)
			setTrueExpr((Expression) expression);
		else
			setFalseExpression((Expression) expression);
	}

	private void setCondition(Expression expression)
	{
		expressions[0] = expression;
	}
	
	private void setTrueExpr(Expression expression)
	{
		expressions[1] = expression;
	}
	
	private void setFalseExpression(Expression expression)
	{
		expressions[2] = expression;
	}

	public Expression getCondition()
	{
		return expressions[0];
	}

	public Object getTrueExpr()
	{
		return expressions[1];
	}
	
	public Object getFalseExpr()
	{
		return expressions[2];
	}
	
	@Override
	public int getChildCount()
	{
		int childCount = 0;
		if(getCondition() != null) childCount++;
		if(getTrueExpr() != null) childCount++;
		if(getFalseExpr() != null) childCount++;
		return childCount;
	}

	@Override
	public ASTNode getChild(int i)
	{
		return expressions[i];
	}

}
