package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

public class ClassDef extends NamedCodeItem{
	
	@Override
	public void create(ParserRuleContext ctx, Stack<CodeItem> itemStack)
	{	
		nodeTypeName = "CLASS_DEF";
		codeStr = "";
		setLocation(ctx);
	}
	
	
}
