package main.processors;

import java.util.Stack;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemBuilder;

import org.antlr.v4.runtime.ParserRuleContext;


public class ParserEvent {
	
	public enum eventID{
		BEGIN,
		START_OF_UNIT,
		END_OF_UNIT,
		PROCESS_ITEM,
		END
	};
	
	public ParserEvent(eventID aId)
	{
		id = aId;
	}
	
	public eventID id;
	public ParserRuleContext ctx;
	public String filename;
	public Stack<CodeItemBuilder> itemStack;
	public CodeItem item;
}
