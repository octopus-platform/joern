package main.FunctionParser;

import java.util.Stack;

import main.TokenSubStream;
import main.ShallowParser.ShallowParserContext;
import main.codeitems.CodeItemBuilder;
import main.codeitems.functionContent.FunctionContentBuilder;
import main.processors.CSVPrinter;
import main.processors.Processor;
import antlr.FunctionGrammarBaseListener;
import antlr.FunctionGrammarParser;

public class FunctionParseTreeListener extends FunctionGrammarBaseListener
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
	public void enterStatements(FunctionGrammarParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = new FunctionContentBuilder();
		builder.createNew(ctx);
		itemStack.push(builder);
	}
	
	@Override
	public void exitStatements(FunctionGrammarParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.pop();
		builder.exitStatements(ctx);
		processor.processItem(builder.getItem(), itemStack);
	}
	
	@Override public void enterStatement(FunctionGrammarParser.StatementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterStatement(ctx);
	}
	
	@Override public void exitStatement(FunctionGrammarParser.StatementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.exitStatement(ctx);
	}
	
	@Override public void enterElse_statement(FunctionGrammarParser.Else_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterElse(ctx);
	}
	
	@Override public void enterIf_statement(FunctionGrammarParser.If_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterIf(ctx);
	}
	
	@Override
	public void enterBlock_starter(FunctionGrammarParser.Block_starterContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterBlockStarter(ctx);
	}
	
	@Override
	public void enterOpening_curly(FunctionGrammarParser.Opening_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterOpeningCurly(ctx);
	}
	
	@Override
	public void enterClosing_curly(FunctionGrammarParser.Closing_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterClosingCurly(ctx);
	}
	
	@Override public void enterFuncCall(FunctionGrammarParser.FuncCallContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) itemStack.peek();
		builder.enterFuncCall(ctx);
	}
	
}
