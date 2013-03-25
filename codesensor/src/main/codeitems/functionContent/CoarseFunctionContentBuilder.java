package main.codeitems.functionContent;

import main.codeitems.expressions.CallBuilder;
import main.codeitems.expressions.ExpressionBuilder;
import main.codeitems.expressions.FieldOnlyWrapper;
import antlr.CoarseFunctionGrammarParser.FieldOnlyContext;
import antlr.CoarseFunctionGrammarParser.FuncCallContext;

public class CoarseFunctionContentBuilder extends FunctionContentBuilder
{

	public void enterFunctionCall(FuncCallContext ctx)
	{
		CallBuilder builder = new CallBuilder();
		builder.createNew(ctx);
		replaceTopOfStack(builder.getItem());
	}

	public void enterFieldOnly(FieldOnlyContext ctx)
	{
		ExpressionBuilder builder = new ExpressionBuilder();
		builder.createUnaryExpression(new FieldOnlyWrapper(ctx));
		replaceTopOfStack(builder.getItem());
	}
	
}
