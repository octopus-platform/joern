package main.codeitems.statements;

import main.codeitems.CodeItem;



public class IfItem extends BlockStarterItem {
	
	public ElseItem elseItem = null;

	public int getChildCount()
	{
		int childCount = super.getChildCount();
		
		if(elseItem != null) childCount++;
		return childCount;
	}
	
	public CodeItem getChild(int i)
	{
		if(i == 0)
			return condition;
		else if (i == 1)
			return statement;
		else if(i == 2)
			return elseItem;
		throw new RuntimeException("Invalid IfItem");
	}
}
