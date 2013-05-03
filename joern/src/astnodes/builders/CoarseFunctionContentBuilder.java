package astnodes.builders;

import antlr.CoarseFunctionGrammarParser.Coarse_content_elemContext;
import antlr.CoarseFunctionGrammarParser.FuncCallContext;
import antlr.CoarseFunctionGrammarParser.Function_argument_listContext;
import astnodes.expressions.ArgumentList;
import astnodes.expressions.CallExpression;
import astnodes.statements.ExpressionStatement;


public class CoarseFunctionContentBuilder extends FunctionContentBuilder
{
	
	public void enterCoarseContentElem(Coarse_content_elemContext ctx)
	{
		ExpressionStatement expr = new ExpressionStatement();
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
