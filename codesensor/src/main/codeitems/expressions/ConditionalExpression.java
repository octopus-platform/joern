package main.codeitems.expressions;

public class ConditionalExpression extends Expression
{
	Expression expressions [] = new Expression[3];

	Expression condition;
	Expression trueExpr;
	Expression falseExpr;
	
	@Override
	public void addChildExpression(Expression expression)
	{
		if(getCondition() == null)
			setCondition(expression);
		else if(getTrueExpr() == null)
			setTrueExpr(expression);
		else
			setFalseExpression(expression);;
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
	public Expression getChild(int i)
	{
		return expressions[i];
	}

}
