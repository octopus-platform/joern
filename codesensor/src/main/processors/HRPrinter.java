package main.processors;

import java.util.LinkedList;
import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;

import org.antlr.v4.runtime.ParserRuleContext;

public class HRPrinter extends Processor{

	String filename = null;
	LinkedList<String> functionDefs = new LinkedList<String>();
	
	@Override
	public void startOfUnit(ParserRuleContext ctx, String aFilename)
	{
		filename = aFilename;
		reset();
	}

	private void reset()
	{
		functionDefs.clear();
	}
	
	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void processItem(CodeItem line, Stack<CodeItemBuilder> itemStack)
	{
		// TODO Auto-generated method stub		
	}

}
