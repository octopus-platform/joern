package main.processors;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;

import org.antlr.v4.runtime.ParserRuleContext;

public class TestProcessor extends Processor {

	public List<CodeItem> codeItems;

	public TestProcessor()
	{
		codeItems = new LinkedList<CodeItem>();
	}
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String filename) 
	{
	
	}

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		
	}

	@Override
	public void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack)
	{
		codeItems.add(item);
	}

	@Override
	public void begin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
