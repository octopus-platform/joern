package main.codeitems.builders;

import main.codeitems.expressions.ArgumentList;
import main.codeitems.expressions.CallExpression;
import main.codeitems.statements.ExprStatementItem;
import antlr.CoarseFunctionGrammarParser.Coarse_content_elemContext;
import antlr.CoarseFunctionGrammarParser.FuncCallContext;
import antlr.CoarseFunctionGrammarParser.Function_argument_listContext;


public class CoarseFunctionContentBuilder extends FunctionContentBuilder
{
	
	public void enterCoarseContentElem(Coarse_content_elemContext ctx)
	{
		ExprStatementItem expr = new ExprStatementItem();
		itemStack.push(expr);
	}

	public void exitCoarseContentElem(Coarse_content_elemContext ctx)
	{
		rootItem.addStatement(itemStack.pop());
	}
	
	
	public void enterFuncCall(FuncCallContext ctx)
	{
		CallExpression expr = new CallExpression();
		itemStack.push(expr);
	}

	public void exitFuncCall(FuncCallContext ctx)
	{
		consolidateSubExpression(ctx);
	}

	public void enterArgumentList(Function_argument_listContext ctx)
	{
		ArgumentList list = new ArgumentList();
		itemStack.push(list);
	}

	public void exitArgumentList(Function_argument_listContext ctx)
	{
		consolidateSubExpression(ctx);
	}


}
