package main.FineFunctionParser;

import java.util.Stack;

import main.CommonParser;
import main.CommonParserContext;
import main.TokenSubStream;
import main.codeitems.CodeItemBuilder;
import main.codeitems.functionContent.FunctionContentBuilder;
import main.processors.CSVPrinter;
import antlr.FineFunctionGrammarParser;
import antlr.FineFunctionGrammarBaseListener;

public class FineFunctionParseTreeListener extends FineFunctionGrammarBaseListener
{
	CommonParser p;
	
	FineFunctionParseTreeListener(CommonParser aP)
	{
		p = aP;
	}
	
	@Override
	public void enterStatements(FineFunctionGrammarParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = new FunctionContentBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	}
	
	@Override
	public void exitStatements(FineFunctionGrammarParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.pop();
		builder.exitStatements(ctx);
		p.processor.processItem(builder.getItem(), p.itemStack);
	}
	
	@Override public void enterStatement(FineFunctionGrammarParser.StatementContext ctx)
	{
		
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterStatement(ctx);
	}
	
	@Override public void exitStatement(FineFunctionGrammarParser.StatementContext ctx)
	{
		
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.exitStatement(ctx);
	}
	
	
	@Override public void enterElse_statement(FineFunctionGrammarParser.Else_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterElse(ctx);
	}
	
	@Override public void enterIf_statement(FineFunctionGrammarParser.If_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterIf(ctx);
	}
	
	
	@Override
	public void enterBlock_starter(FineFunctionGrammarParser.Block_starterContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterBlockStarter(ctx);
	}
	
	@Override
	public void enterOpening_curly(FineFunctionGrammarParser.Opening_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterOpeningCurly(ctx);
	}
	
	@Override
	public void enterClosing_curly(FineFunctionGrammarParser.Closing_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterClosingCurly(ctx);
	}
	
}
