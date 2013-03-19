package main.FunctionParser;

import java.util.Stack;

import main.TokenSubStream;
import main.ShallowParser.ShallowParserContext;
import main.codeitems.CodeItemBuilder;
import main.codeitems.functionContent.FunctionContentBuilder;
import main.processors.CSVPrinter;
import main.processors.Processor;
import antlr.CodeSensorBaseListener;
import antlr.CodeSensorParser;

public class FunctionParseTreeListener extends CodeSensorBaseListener
{
	// Warning: code duplication! The same code is in ShallowParseTreeListener
	
	Stack<CodeItemBuilder> itemStack = new Stack<CodeItemBuilder>();
	
	Processor processor = new CSVPrinter();
	String filename;
	TokenSubStream stream;
		
	void initializeContext(ShallowParserContext context)
	{
		filename = context.filename;
		stream = context.stream;
	}
	void setStack(Stack<CodeItemBuilder> aStack)
	{
		itemStack = aStack;
	}
	
	void setProcessor(Processor aProcessor)
	{
		processor = aProcessor;
	}

	public Processor getProcessor() 
	{
		return processor;
	}
	
	// duplication end
	
	@Override
	public void enterStatements(CodeSensorParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = new FunctionContentBuilder();
		builder.createNew(ctx);
		itemStack.push(builder);
	}
	
	@Override
	public void exitStatements(CodeSensorParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.pop();
		builder.exitStatements(ctx);
		processor.processItem(builder.getItem(), itemStack);
	}
	
	@Override public void enterStatement(CodeSensorParser.StatementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterStatement(ctx);
	}
	
	@Override public void exitStatement(CodeSensorParser.StatementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.exitStatement(ctx);
	}
	
	@Override public void enterElse_statement(CodeSensorParser.Else_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterElse(ctx);
	}
	
	@Override public void enterIf_statement(CodeSensorParser.If_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterIf(ctx);
	}
	
	@Override
	public void enterBlock_starter(CodeSensorParser.Block_starterContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterBlockStarter(ctx);
	}
	
	@Override
	public void enterOpening_curly(CodeSensorParser.Opening_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterOpeningCurly(ctx);
	}
	
	@Override
	public void enterClosing_curly(CodeSensorParser.Closing_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterClosingCurly(ctx);
	}
	
	@Override public void enterFuncCall(CodeSensorParser.FuncCallContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterFuncCall(ctx);
	}
	
}
