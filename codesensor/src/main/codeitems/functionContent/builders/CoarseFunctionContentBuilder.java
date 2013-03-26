package main.codeitems.functionContent.builders;


import main.codeitems.expressions.ExpressionItem;
import main.codeitems.expressions.FieldOnlyWrapper;
import main.codeitems.expressions.builders.CallBuilder;
import main.codeitems.expressions.builders.ExpressionBuilder;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;
import main.codeitems.functionContent.StatementItem;
import antlr.CoarseFunctionGrammarParser.FieldOnlyContext;
import antlr.CoarseFunctionGrammarParser.FuncCallContext;

public class CoarseFunctionContentBuilder extends FunctionContentBuilder
{

	public void addFunctionCall(FuncCallContext ctx)
	{
		CallBuilder builder = new CallBuilder();
		builder.createNew(ctx);
		builder.setCallee(ctx.field().getText());
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
