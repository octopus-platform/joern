package main.codeitems.expressions.builders;

import org.antlr.v4.runtime.ParserRuleContext;

import main.codeitems.CodeItemBuilder;
import main.codeitems.expressions.Expression;
import main.codeitems.expressions.FieldOnlyWrapper;
import main.codeitems.expressions.UnaryExpression;

public class ExpressionBuilder extends CodeItemBuilder {

	Expression thisItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		
	}

	public void createUnaryExpression(FieldOnlyWrapper ctx)
	{
		item = new UnaryExpression();
		thisItem = (Expression) item;
		UnaryExpression unaryExpr = (UnaryExpression) thisItem;
		
		unaryExpr.field = ctx.getFieldString();
		unaryExpr.incrementDecrement = ctx.getIncDecString();
		unaryExpr.unaryOperators = ctx.getUnaryOperatorString();
		
	}
	
}
