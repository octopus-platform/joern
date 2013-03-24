package main.CoarseFunctionParser;

import main.CommonParser;
import antlr.CoarseFunctionGrammarBaseListener;
import antlr.CoarseFunctionGrammarParser;


public class CoarseParseTreeListener extends CoarseFunctionGrammarBaseListener
{
	CommonParser p;
	
	public CoarseParseTreeListener(CoarseFunctionParser aP)
	{
		p = aP;
	}
	
	@Override
	public void enterFuncCall(CoarseFunctionGrammarParser.FuncCallContext ctx)
	{
		
	}
	
	@Override
	public void enterFunction_argument_list(CoarseFunctionGrammarParser.Function_argument_listContext ctx)
	{
		
	}
	
	@Override
	public void enterFunction_argument(CoarseFunctionGrammarParser.Function_argumentContext ctx)
	{
		
	}

	@Override
	public void enterField(CoarseFunctionGrammarParser.FieldContext ctx)
	{
		
	}
	
}
