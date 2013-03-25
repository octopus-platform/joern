package main.codeitems.functionContent;

import main.codeitems.expressions.ExpressionItem;

public class ExprStatementItem extends StatementItem
{
	ExpressionItem expr;

	public void accept(StatementVisitor visitor){ visitor.visit(this); }

}
