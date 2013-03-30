package main.codeitems.expressions;

import java.util.LinkedList;

public class UnaryExpression extends Expression
{	
	
	Expression incDec;
	Expression unaryOperators;
	Expression field;
	Expression functionArgumentList;
	
	LinkedList<Expression> children = new LinkedList<Expression>();
	
	@Override
	public void addChildExpression(Expression expression)
	{
		if(expression instanceof IncDec){
			incDec = expression;
		}else if(expression instanceof UnaryOperator){
			unaryOperators = expression;
		}else if(expression instanceof FieldExpression){
			field = expression;
		}else{
			functionArgumentList = expression;
		}
		children.add(expression);
	}

	@Override
	public int getChildCount()
	{
		int childCount = 0;
		if(incDec != null) childCount++;
		if(unaryOperators != null) childCount++;
		if(field != null) childCount++;
		if(functionArgumentList != null) childCount++;
		return childCount;
	}

	@Override
	public Expression getChild(int i)
	{
		return children.get(i);
	}
}
