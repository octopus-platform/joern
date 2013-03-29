package main.codeitems.expressions;

import main.codeitems.CodeItemVisitor;
import main.codeitems.functionContent.ExprStatementItem;


public class CallItem extends ExprStatementItem
{
	public String callee;
	public FunctionArgumentList arguments;

	public void setCallee(String aCallee)
	{
		callee = aCallee;
	}

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }

}
