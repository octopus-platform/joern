package main;

import java.util.Stack;

import main.codeitems.CodeItem;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Printer
{
	public abstract void startOfUnit(String nodeTypeName, ParserRuleContext ctx, String codeStr);
	public abstract void endOfUnit(String nodeTypeName, ParserRuleContext ctx, String codeStr);
	public abstract void printItem(CodeItem line, Stack<CodeItem> itemStack);

}
