package main.codeitems.functionContent;


import main.codeitems.expressions.CallBuilder;
import main.codeitems.expressions.ExpressionBuilder;
import main.codeitems.expressions.ExpressionItem;
import main.codeitems.expressions.FieldOnlyWrapper;
import antlr.CoarseFunctionGrammarParser.FieldOnlyContext;
import antlr.CoarseFunctionGrammarParser.FuncCallContext;

public class CoarseFunctionContentBuilder extends FunctionContentBuilder
{

	public void addFunctionCall(FuncCallContext ctx)
	{
		CallBuilder builder = new CallBuilder();
		builder.createNew(ctx);
		rootItem.addStatement((StatementItem) builder.getItem());
	}

	public void addFieldOnly(FieldOnlyContext ctx)
	{
		ExpressionBuilder builder = new ExpressionBuilder();
		builder.createUnaryExpression(new FieldOnlyWrapper(ctx));
		ExprStatementItem stmt = new ExprStatementItem();
		stmt.expr =  (ExpressionItem) builder.getItem();
		rootItem.addStatement(stmt);
	}

	public void addDeclStatement(IdentifierDeclStatement statement)
	{
		rootItem.addStatement(statement);
	}
	
}
