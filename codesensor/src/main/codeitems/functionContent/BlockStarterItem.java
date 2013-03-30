package main.codeitems.functionContent;

import main.codeitems.CodeItem;
import main.codeitems.expressions.ExpressionItem;


public class BlockStarterItem extends CodeItem
{
	CodeItem statement = null;
	ExpressionItem condition = null;

	public ExpressionItem getCondition()
	{
		return condition;
	}
	
	public void setStatement(CodeItem aStatement)
	{
		statement = aStatement;
	}

	public void setCondition(ExpressionItem expression)
	{
		condition = expression;
	}
}
