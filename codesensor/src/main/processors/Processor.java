package main.processors;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Processor implements Observer
{
	
	public void update(Observable obj, Object arg)
	{
		ParserEvent event = (ParserEvent) arg;
		switch(event.id){
			case BEGIN: begin(); break;
			case START_OF_UNIT: startOfUnit(event.ctx, event.filename); break;
			case END_OF_UNIT: endOfUnit(event.ctx, event.filename); break;
			case PROCESS_ITEM: processItem(event.item, event.itemStack); break;
			case END: end(); break;
		};
	}
	
	public abstract void startOfUnit(ParserRuleContext ctx, String filename);
	public abstract void endOfUnit(ParserRuleContext ctx, String filename);
	public abstract void processItem(CodeItem item, Stack<CodeItemBuilder> itemStack);
	public abstract void begin();
	public abstract void end();

}
