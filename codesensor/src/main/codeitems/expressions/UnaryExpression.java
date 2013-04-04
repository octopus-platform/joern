package main.codeitems.expressions;

import java.util.LinkedList;

import main.codeitems.CodeItem;

public class UnaryExpression extends Expression
{	
	
	Expression incDec;
	Expression unaryOperators;
	Expression field;
	Expression functionArgumentList;
	
	LinkedList<Expression> children = new LinkedList<Expression>();
	
	@Override
	public void addChild(CodeItem expression)
	{
		if(expression instanceof IncDec){
			incDec = (Expression) expression;
		}else if(expression instanceof UnaryOperator){
			unaryOperators = (Expression) expression;
		}else if(expression instanceof FieldExpression){
			field = (Expression) expression;
		}else{
			functionArgumentList = (Expression) expression;
		}
		children.add((Expression) expression);
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
	public CodeItem getChild(int i)
	{
		return children.get(i);
	}
}
