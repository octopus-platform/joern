package main.codeitems.expressions;

import java.util.LinkedList;

import main.codeitems.CodeItem;

public class Expression extends CodeItem
{
	LinkedList<CodeItem> children = new LinkedList<CodeItem>();
	
	// Child classes must implement this
	public void addChildExpression(Expression expression)
	{
		children.add(expression);
	}
	public int getChildCount() { return children.size(); }
	public Expression getChild(int i){ return (Expression) children.get(i); }
	
}
