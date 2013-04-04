package main.codeitems.functionContent;

import java.util.LinkedList;
import java.util.List;
import main.codeitems.CodeItem;

public class CompoundItem extends CodeItem
{

	LinkedList<CodeItem> statements = new LinkedList<CodeItem>();
	
	public void addChild(CodeItem stmt){ addStatement(stmt); }
	public int getChildCount() { return statements.size(); }
	public CodeItem getChild(int i){ return statements.get(i); }
	
	
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
