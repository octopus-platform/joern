package main.codeitems.expressions;

import main.codeitems.functionContent.ExprStatementItem;

public class CallItem extends ExprStatementItem
{
	String callee;
	FunctionArgumentList arguments;

	public void setCallee(String aCallee)
	{
		callee = aCallee;
	}

}
