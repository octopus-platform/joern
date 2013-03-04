package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

public class NamedCodeItem extends CodeItem
{
	public Name name;

	public void setName(ParserRuleContext ctx, Stack<CodeItem> itemStack)
	{
		name = new Name();
		name.create(ctx, itemStack);
		if(name.codeStr.equals(""))
			name = null;
	}
	
}
