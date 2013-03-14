package main.processors;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Processor
{
	public abstract void startOfUnit(ParserRuleContext ctx, String filename);
	public abstract void endOfUnit(ParserRuleContext ctx, String filename);
	public abstract void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack);
}
