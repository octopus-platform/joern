package main.codeitems.functionContent;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;

public class FunctionContentBuilder extends CodeItemBuilder
{
	Stack<CodeItem> itemStack = new Stack<CodeItem>();
	CompoundItem rootItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundItem();
		rootItem = (CompoundItem) item;
		item.initializeFromContext(ctx);
		itemStack.push(rootItem);
	}

}
