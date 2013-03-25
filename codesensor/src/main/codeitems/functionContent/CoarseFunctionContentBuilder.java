package main.codeitems.functionContent;

import antlr.CoarseFunctionGrammarParser.FuncCallContext;

public class CoarseFunctionContentBuilder extends FunctionContentBuilder
{

	public void enterFunctionCall(FuncCallContext ctx)
	{
		CallBuilder builder = new CallBuilder();
		builder.createNew(ctx);
		replaceTopOfStack(builder.getItem());
	}
	
}
