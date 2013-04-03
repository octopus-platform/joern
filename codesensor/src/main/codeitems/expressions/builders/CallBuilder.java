package main.codeitems.expressions.builders;

import main.codeitems.CodeItemBuilder;
import main.codeitems.expressions.CallItem;

import org.antlr.v4.runtime.ParserRuleContext;


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
