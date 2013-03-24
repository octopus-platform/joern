package main.FineFunctionParser;

import main.CommonParser;
import main.codeitems.functionContent.FineFunctionContentBuilder;

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
		FineFunctionContentBuilder builder = new FineFunctionContentBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	}
	
	@Override
	public void exitStatements(FineFunctionGrammarParser.StatementsContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.pop();
		builder.exitStatements(ctx);
		p.processor.processItem(builder.getItem(), p.itemStack);
	}
	
	@Override public void enterStatement(FineFunctionGrammarParser.StatementContext ctx)
	{
		
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterStatement(ctx);
	}
	
	@Override public void exitStatement(FineFunctionGrammarParser.StatementContext ctx)
	{
		
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitStatement(ctx);
	}
	
	
	@Override public void enterElse_statement(FineFunctionGrammarParser.Else_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterElse(ctx);
	}
	
	@Override public void enterIf_statement(FineFunctionGrammarParser.If_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIf(ctx);
	}
	
	
	@Override
	public void enterBlock_starter(FineFunctionGrammarParser.Block_starterContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterBlockStarter(ctx);
	}
	
	@Override
	public void enterOpening_curly(FineFunctionGrammarParser.Opening_curlyContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterOpeningCurly(ctx);
	}
	
	@Override
	public void enterClosing_curly(FineFunctionGrammarParser.Closing_curlyContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterClosingCurly(ctx);
	}
	
}
