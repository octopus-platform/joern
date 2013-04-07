package main.codeitems.statements;

import main.codeitems.CodeItem;
import main.codeitems.DummyItem;

public class ForItem extends BlockStarterItem
{
	private CodeItem forInitStatement = new DummyItem();
	private CodeItem expression = new DummyItem();
	
	public CodeItem getForInitStatement()
	{
		return forInitStatement;
	}

	public void setForInitStatement(CodeItem forInitStatement)
	{
		this.forInitStatement = forInitStatement;
	}

	public CodeItem getExpression()
	{
		return expression;
	}

	public void setExpression(CodeItem expression)
	{
		this.expression = expression;
	}
	
	@Override
	public void addChild(CodeItem item)
	{	
		if(forInitStatement instanceof DummyItem)
			forInitStatement = item;
		else if(expression instanceof DummyItem)
			expression = item;
		super.addChild(item);
	}

}
