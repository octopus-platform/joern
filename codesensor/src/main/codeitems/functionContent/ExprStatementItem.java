package main.codeitems.functionContent;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.expressions.Expression;

public class ExprStatementItem extends CodeItem
{
	public Expression expr;

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
