package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Return_typeContext;

public class ReturnType extends CodeItem
{
	String completeType;
	String baseType;
	
	public void create(ParserRuleContext aCtx, Stack<CodeItem> itemStack)
	{
		Return_typeContext ctx = (Return_typeContext) aCtx;
		nodeTypeName = "RETURN_TYPE";
		baseType =  childTokenString(ctx.type_name());
		completeType = childTokenString(ctx);
		super.create(ctx, itemStack);
	}
}
