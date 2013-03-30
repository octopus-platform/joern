package main.codeitems.functionContent;

import main.codeitems.CodeItem;
import main.codeitems.expressions.Expression;


public class BlockStarterItem extends CodeItem
{
	CodeItem statement = null;
	Expression condition = null;

	public Expression getCondition()
	{
		return condition;
	}
	
	public void setStatement(CodeItem aStatement)
	{
		statement = aStatement;
	}

	public void setCondition(Expression expression)
	{
		condition = expression;
	}
}
