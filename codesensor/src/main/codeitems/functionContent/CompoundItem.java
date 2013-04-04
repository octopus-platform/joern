package main.codeitems.functionContent;

import java.util.List;
import main.codeitems.CodeItem;

public class CompoundItem extends CodeItem
{
	
	public CompoundItem()
	{
		setNodeTypeName("STATEMENTS");	
	}
	
	public void addStatement(CodeItem stmt)
	{
		addChild(stmt);
	}
	
	public List<CodeItem> getStatements()
	{
		return getChildren();
	}
	
}
