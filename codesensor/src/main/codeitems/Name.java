package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

public class Name extends CodeItem
{
	public void create(ParserRuleContext ctx, Stack<CodeItem> itemStack)
	{
		nodeTypeName = "NAME";
		super.create(ctx, itemStack);
	}

}
