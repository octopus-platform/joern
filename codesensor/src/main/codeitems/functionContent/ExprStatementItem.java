package main.codeitems.functionContent;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.expressions.ExpressionItem;

public class ExprStatementItem extends CodeItem
{
	public ExpressionItem expr = new ExpressionItem();

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
