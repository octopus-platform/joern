package main.FineFunctionParser;

import java.util.Stack;

import main.CommonCodeSensorListener;
import main.CommonParserContext;
import main.TokenSubStream;
import main.codeitems.CodeItemBuilder;
import main.codeitems.functionContent.FunctionContentBuilder;
import main.processors.CSVPrinter;
import main.processors.Processor;
import antlr.CodeSensorParser;

public class FineFunctionParseTreeListener extends CommonCodeSensorListener
{
	
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
		// builder.enterFuncCall(ctx);
	}
	
}
