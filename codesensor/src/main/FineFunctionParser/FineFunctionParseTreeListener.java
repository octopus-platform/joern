package main.FineFunctionParser;

import java.util.Stack;

import main.CommonParser;
import main.CommonParserContext;
import main.TokenSubStream;
import main.codeitems.CodeItemBuilder;
import main.codeitems.functionContent.FunctionContentBuilder;
import main.processors.CSVPrinter;
import antlr.FunctionGrammarParser;
import antlr.FunctionGrammarBaseListener;

public class FineFunctionParseTreeListener extends FunctionGrammarBaseListener
{
	CommonParser p;
	
	FineFunctionParseTreeListener(CommonParser aP)
	{
		p = aP;
	}
	
	@Override
	public void enterStatements(FunctionGrammarParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = new FunctionContentBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	}
	
	@Override
	public void exitStatements(FunctionGrammarParser.StatementsContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.pop();
		builder.exitStatements(ctx);
		p.processor.processItem(builder.getItem(), p.itemStack);
	}
	
	@Override public void enterStatement(FunctionGrammarParser.StatementContext ctx)
	{
		if(ctx.water() != null || ctx.PRE_ELSE() != null) return;
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterStatement(ctx);
	}
	
	@Override public void exitStatement(FunctionGrammarParser.StatementContext ctx)
	{
		if(ctx.water() != null || ctx.PRE_ELSE() != null) return;
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.exitStatement(ctx);
	}
	
	@Override public void enterElse_statement(FunctionGrammarParser.Else_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterElse(ctx);
	}
	
	@Override public void enterIf_statement(FunctionGrammarParser.If_statementContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterIf(ctx);
	}
	
	@Override
	public void enterBlock_starter(FunctionGrammarParser.Block_starterContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterBlockStarter(ctx);
	}
	
	@Override
	public void enterOpening_curly(FunctionGrammarParser.Opening_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterOpeningCurly(ctx);
	}
	
	@Override
	public void enterClosing_curly(FunctionGrammarParser.Closing_curlyContext ctx)
	{
		FunctionContentBuilder builder = (FunctionContentBuilder) p.itemStack.peek();
		builder.enterClosingCurly(ctx);
	}
	
}
