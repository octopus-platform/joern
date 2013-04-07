package main.codeitems.statements;

import main.codeitems.CodeItem;
import main.codeitems.expressions.Expression;


public class BlockStarterItem extends Statement
{
	CodeItem statement = null;
	Condition condition = null;
	
	public BlockStarterItem()
	{
		super();
		condition = new Condition();
		condition.addChild(new Expression());
	}
	
	public Condition getCondition()
	{
		return condition;
	}
	
	private void setStatement(CodeItem aStatement)
	{
		statement = aStatement;
	}

	public void setCondition(Condition expression)
	{
		condition = expression;
	}

	@Override
	public void addChild(CodeItem expression)
	{
		if(expression instanceof Condition)
			setCondition((Condition) expression);
		if(expression instanceof Statement)
			setStatement(expression);
		super.addChild(expression);			
	}
	
	@Override
	public int getChildCount()
	{
		if(condition == null || statement == null)
			throw new RuntimeException("Invalid Blockstarter");
		
		return 2;
	}
	
	@Override
	public CodeItem getChild(int i)
	{
		if(i == 0) return condition;
		if(i == 1) return statement;
		throw new RuntimeException("Invalid Blockstarter");
	}
	
}
