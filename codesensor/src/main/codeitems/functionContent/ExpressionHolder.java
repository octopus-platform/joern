package main.codeitems.functionContent;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.expressions.Expression;


public class ExpressionHolder extends CodeItem
{
	public Expression expr;

	public Expression getExpression()
	{
		return expr;
	}
	
	public void addChild(CodeItem expression){ }
	
	public int getChildCount()
	{
		if(expr == null)
			throw new RuntimeException("Invalid Expression Statement");
		return 1;
	}
	public CodeItem getChild(int i)
	{
		return expr;
	}
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
}
