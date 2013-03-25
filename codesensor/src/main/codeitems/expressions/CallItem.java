package main.codeitems.expressions;

import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.StatementVisitor;

public class CallItem extends ExprStatementItem
{
	public String callee;
	public FunctionArgumentList arguments;

	public void setCallee(String aCallee)
	{
		callee = aCallee;
	}

	public void accept(StatementVisitor visitor){ visitor.visit(this); }

}
