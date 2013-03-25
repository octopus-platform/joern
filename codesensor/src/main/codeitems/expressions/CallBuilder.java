package main.codeitems.expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import main.codeitems.CodeItemBuilder;


public class CallBuilder extends CodeItemBuilder {

	CallItem thisItem;
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CallItem();
		thisItem = (CallItem) item;
		item.initializeFromContext(ctx);
	}
	
	public void setCallee(String aCallee)
	{
		thisItem.setCallee(aCallee);
	}
	
}
