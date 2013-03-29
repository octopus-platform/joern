package main.codeitems.functionContent;

import main.codeitems.CodeItem;


public class BlockStarterItem extends CodeItem
{
	CodeItem statement = null;
	ConditionItem condition = null;

	public void setStatement(CodeItem aStatement)
	{
		statement = aStatement;
	}
}
