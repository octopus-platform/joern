package main.codeitems.expressions.builders;

import org.antlr.v4.runtime.ParserRuleContext;

import main.codeitems.CodeItemBuilder;
import main.codeitems.expressions.ExpressionItem;
import main.codeitems.expressions.FieldOnlyWrapper;
import main.codeitems.expressions.UnaryExpression;

public class ExpressionBuilder extends CodeItemBuilder {

	ExpressionItem thisItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new ExpressionItem();
		thisItem = (ExpressionItem) item;
	}

	public void createUnaryExpression(FieldOnlyWrapper ctx)
	{
		item = new UnaryExpression();
		thisItem = (ExpressionItem) item;
		UnaryExpression unaryExpr = (UnaryExpression) thisItem;
		
		unaryExpr.field = ctx.getFieldString();
		unaryExpr.incrementDecrement = ctx.getIncDecString();
		unaryExpr.unaryOperators = ctx.getUnaryOperatorString();
		
	}
	
}
