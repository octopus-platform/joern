package main.codeitems.statements;

import main.codeitems.CodeItem;
import main.codeitems.expressions.Expression;

public class ExpressionHolder extends CodeItem
{

	Expression expr;
	
	public Expression getExpression()
	{
		return expr;
	}
	
	@Override
	public void addChild(CodeItem expression)
	{ 
		expr = (Expression) expression;
		super.addChild(expression);
	}
}
