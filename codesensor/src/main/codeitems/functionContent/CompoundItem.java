package main.codeitems.functionContent;

import java.util.LinkedList;
import java.util.List;
import main.codeitems.CodeItem;

public class CompoundItem extends CodeItem
{

	LinkedList<CodeItem> statements = new LinkedList<CodeItem>();
	
	public CompoundItem()
	{
		setNodeTypeName("STATEMENTS");	
	}
	
	public void addStatement(CodeItem stmt)
	{
		statements.add(stmt);
	}
	
	public List<CodeItem> getStatements()
	{
		return statements;
	}
	
}
