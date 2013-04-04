package main.codeitems.expressions;

import java.util.LinkedList;

import main.codeitems.CodeItem;

public class Expression extends CodeItem
{
	LinkedList<CodeItem> children;
	
	public void addChild(CodeItem expression)
	{
		if(children == null)
			children = new LinkedList<CodeItem>();
		children.add(expression);
	}
	public int getChildCount()
	{
		if(children == null) return 0;
		return children.size();
	}
	
	public CodeItem getChild(int i)
	{
		if(children == null) return null;
		return children.get(i);
	}
}
