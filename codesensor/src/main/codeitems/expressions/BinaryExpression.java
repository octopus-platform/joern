package main.codeitems.expressions;


public class BinaryExpression extends Expression
{
	Expression subExpressions [] = new Expression[2];
		
	protected String operator = "";
	
	public Expression getLeft() { return subExpressions[0]; }
	public Expression getRight() { return subExpressions[1];}
	public void setLeft(Expression aLeft) { subExpressions[0] = aLeft; }
	public void setRight(Expression aRight) {subExpressions[1] = aRight; }
	
	public String getOperator(){ return operator; }
	
	public void addChildExpression(Expression expression)
	{
		if(getLeft() == null)
			setLeft(expression);
		else
			setRight(expression);
	}
	
	@Override
	public int getChildCount()
	{
		int childCount = 0;
		if(getLeft() != null) childCount++;
		if(getRight() != null) childCount++;
		return childCount;
	}
	@Override
	public Expression getChild(int i)
	{
		return subExpressions[i];
	}
	
}
