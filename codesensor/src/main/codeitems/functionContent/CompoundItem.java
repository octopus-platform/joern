package main.codeitems.functionContent;

import java.util.LinkedList;

import main.codeitems.CodeItem;

public class CompoundItem extends CodeItem
{
	public LinkedList<CodeItem> statements = new LinkedList<CodeItem>();
	
	public CompoundItem()
	{
		setNodeTypeName("STATEMENTS");	
	}
	
	public void addStatement(CodeItem stmt)
	{
		statements.add(stmt);
	}
	
}
