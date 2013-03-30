package main.codeitems.expressions;

import java.util.LinkedList;

import main.codeitems.CodeItem;

public class ExpressionItem extends CodeItem
{
	protected LinkedList<ExpressionItem>
		subExpressions = new LinkedList<ExpressionItem>();

	public void addSubExpression(ExpressionItem expression)
	{
		subExpressions.add(expression);
	}
	
}
