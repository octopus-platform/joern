package main.processors;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;
import main.codeitems.statements.CompoundItem;

import org.antlr.v4.runtime.ParserRuleContext;

public class CompoundItemGenerator extends Processor {

	private CompoundItem compoundItem;
	
	public CompoundItem getCompoundItem(){ return compoundItem; }
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename)
	{
		compoundItem = new CompoundItem();
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename) {}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		compoundItem.addStatement(item);
	}

	@Override public void begin(){}
	@Override public void end(){}

}
