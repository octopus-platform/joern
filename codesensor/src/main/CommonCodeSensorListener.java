package main;

import java.util.Stack;

import main.ShallowParser.ShallowParserContext;
import main.codeitems.CodeItemBuilder;
import main.processors.CSVPrinter;
import main.processors.Processor;
import antlr.CodeSensorBaseListener;

public class CommonCodeSensorListener extends CodeSensorBaseListener
{

	protected Stack<CodeItemBuilder> itemStack = new Stack<CodeItemBuilder>();
	protected Processor processor = new CSVPrinter();
	protected String filename;
	protected TokenSubStream stream;
		
	public void initializeContext(ShallowParserContext context)
	{
		filename = context.filename;
		stream = context.stream;
	}
	
	public void setStack(Stack<CodeItemBuilder> aStack)
	{
		itemStack = aStack;
	}
	
	public void setProcessor(Processor aProcessor)
	{
		processor = aProcessor;
	}

	public Processor getProcessor() 
	{
		return processor;
	}
	
	
	public CommonCodeSensorListener() {
		super();
	}
	
}