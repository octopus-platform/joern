package parsing;

import antlr.FineFunctionGrammarBaseListener;
import antlr.FineFunctionGrammarParser;
import astnodes.builders.FineFunctionContentBuilder;

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
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitStatements(ctx);
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
	
	@Override public void enterFor_statement(FineFunctionGrammarParser.For_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterFor(ctx);
	}
	
	@Override public void enterWhile_statement(FineFunctionGrammarParser.While_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterWhile(ctx);
	}
	
	@Override public void enterDo_statement(FineFunctionGrammarParser.Do_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterDo(ctx);
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
	
	@Override public void enterExpr_statement(FineFunctionGrammarParser.Expr_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterExprStatement(ctx);
	}
	
	
	@Override
	public void enterDeclByType(FineFunctionGrammarParser.DeclByTypeContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterDeclByType(ctx.type_name());
	}
	
	@Override
	public void exitDeclByType(FineFunctionGrammarParser.DeclByTypeContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitDeclByType();
	}
	
	@Override public void enterDeclByClass(FineFunctionGrammarParser.DeclByClassContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterDeclByClass(ctx);
	}
	
	@Override public void exitDeclByClass(FineFunctionGrammarParser.DeclByClassContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitDeclByClass();
	}
	
	@Override public void enterInitDeclSimple(FineFunctionGrammarParser.InitDeclSimpleContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitDeclSimple(ctx);
	}
	
	@Override public void exitInitDeclSimple(FineFunctionGrammarParser.InitDeclSimpleContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitDeclSimple();
	}
	
	@Override public void enterInitDeclWithAssign(FineFunctionGrammarParser.InitDeclWithAssignContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitDeclWithAssign(ctx);
	}
	
	@Override public void exitInitDeclWithAssign(FineFunctionGrammarParser.InitDeclWithAssignContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitDeclWithAssign(ctx);
	}
	
	@Override public void enterInitDeclWithCall(FineFunctionGrammarParser.InitDeclWithCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitDeclWithCall(ctx);
	}	
	@Override public void exitInitDeclWithCall(FineFunctionGrammarParser.InitDeclWithCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitDeclWithCall();
	}
	
	@Override public void enterCondition(FineFunctionGrammarParser.ConditionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterCondition(ctx);
	}
	
	@Override public void exitCondition(FineFunctionGrammarParser.ConditionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitCondition(ctx);
	}
	
	
	@Override public void enterExpr(FineFunctionGrammarParser.ExprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterExpression(ctx);
	}
	
	@Override public void exitExpr(FineFunctionGrammarParser.ExprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitExpression(ctx);
	}
	
	@Override public void enterAssign_expr(FineFunctionGrammarParser.Assign_exprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterAssignment(ctx);
	}
	
	@Override public void exitAssign_expr(FineFunctionGrammarParser.Assign_exprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitAssignment(ctx);
	}
	
	@Override public void enterConditional_expression(FineFunctionGrammarParser.Conditional_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterConditionalExpr(ctx);
	}
	
	@Override public void exitConditional_expression(FineFunctionGrammarParser.Conditional_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitConditionalExpr(ctx);
	}
	
	@Override public void enterOr_expression(FineFunctionGrammarParser.Or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterOrExpression(ctx);
	}
	
	@Override public void exitOr_expression(FineFunctionGrammarParser.Or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitrOrExpression(ctx);
	}
	
	@Override public void enterAnd_expression(FineFunctionGrammarParser.And_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterAndExpression(ctx);
	}
	
	@Override public void exitAnd_expression(FineFunctionGrammarParser.And_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitAndExpression(ctx);
	}
	

	@Override public void enterInclusive_or_expression(FineFunctionGrammarParser.Inclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInclusiveOrExpression(ctx);
	}
	
	@Override public void exitInclusive_or_expression(FineFunctionGrammarParser.Inclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInclusiveOrExpression(ctx);
	}

	@Override public void enterExclusive_or_expression(FineFunctionGrammarParser.Exclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterExclusiveOrExpression(ctx);
	}
	
	@Override public void exitExclusive_or_expression(FineFunctionGrammarParser.Exclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitExclusiveOrExpression(ctx);
	}

	@Override public void enterBit_and_expression(FineFunctionGrammarParser.Bit_and_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterBitAndExpression(ctx);
	}
	
	@Override public void exitBit_and_expression(FineFunctionGrammarParser.Bit_and_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitBitAndExpression(ctx);
	}
	
	@Override public void enterEquality_expression(FineFunctionGrammarParser.Equality_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterEqualityExpression(ctx);
	}
	
	@Override public void exitEquality_expression(FineFunctionGrammarParser.Equality_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitEqualityExpression(ctx);
	}
	
	
	@Override public void enterRelational_expression(FineFunctionGrammarParser.Relational_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterRelationalExpression(ctx);
	}
	
	@Override public void exitRelational_expression(FineFunctionGrammarParser.Relational_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitRelationalExpression(ctx);
	}
	
	@Override public void enterShift_expression(FineFunctionGrammarParser.Shift_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterShiftExpression(ctx);
	}
	
	@Override public void exitShift_expression(FineFunctionGrammarParser.Shift_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitShiftExpression(ctx);
	}
	
	@Override public void enterAdditive_expression(FineFunctionGrammarParser.Additive_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterAdditiveExpression(ctx);
	}
	
	@Override public void exitAdditive_expression(FineFunctionGrammarParser.Additive_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitAdditiveExpression(ctx);
	}
	
	@Override public void enterMultiplicative_expression(FineFunctionGrammarParser.Multiplicative_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterMultiplicativeExpression(ctx);
	}
	
	@Override public void exitMultiplicative_expression(FineFunctionGrammarParser.Multiplicative_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitMultiplicativeExpression(ctx);
	}
	
	@Override public void enterCast_expression(FineFunctionGrammarParser.Cast_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterCastExpression(ctx);
	}
	
	@Override public void exitCast_expression(FineFunctionGrammarParser.Cast_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitCastExpression(ctx);
	}
	
	@Override public void enterCast_target(FineFunctionGrammarParser.Cast_targetContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterCast_target(ctx);
	}
	
	@Override public void exitCast_target(FineFunctionGrammarParser.Cast_targetContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitCast_target(ctx);
	}
	
	@Override public void enterFuncCall(FineFunctionGrammarParser.FuncCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterFuncCall(ctx);
	}
	
	@Override public void exitFuncCall(FineFunctionGrammarParser.FuncCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitFuncCall(ctx);
	}

	@Override public void enterFunction_argument_list(FineFunctionGrammarParser.Function_argument_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterArgumentList(ctx);
	}
	
	@Override public void exitFunction_argument_list(FineFunctionGrammarParser.Function_argument_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitArgumentList(ctx);	
	}
	
	@Override
	public void enterInc_dec(FineFunctionGrammarParser.Inc_decContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIncDec(ctx);
	}
	
	@Override public void exitInc_dec(FineFunctionGrammarParser.Inc_decContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitIncDec(ctx);
	}
	
	@Override
	public void enterArrayIndexing(FineFunctionGrammarParser.ArrayIndexingContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterArrayIndexing(ctx);
	}
	
	@Override
	public void exitArrayIndexing(FineFunctionGrammarParser.ArrayIndexingContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitArrayIndexing(ctx);
	}
	
	@Override
	public void enterMemberAccess(FineFunctionGrammarParser.MemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterMemberAccess(ctx);
	}
	
	@Override
	public void exitMemberAccess(FineFunctionGrammarParser.MemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitMemberAccess(ctx);
	}
	
	@Override
	public void enterPtrMemberAccess(FineFunctionGrammarParser.PtrMemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterPtrMemberAccess(ctx);
	}
	
	@Override
	public void exitPtrMemberAccess(FineFunctionGrammarParser.PtrMemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitPtrMemberAccess(ctx);
	}
	
	
	@Override
	public void enterIncDecOp(FineFunctionGrammarParser.IncDecOpContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIncDecOp(ctx);
	}
	
	@Override
	public void exitIncDecOp(FineFunctionGrammarParser.IncDecOpContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitIncDecOp(ctx);
	}
	
	@Override
	public void enterPrimary_expression(FineFunctionGrammarParser.Primary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterPrimary(ctx);
	}
	
	@Override
	public void exitPrimary_expression(FineFunctionGrammarParser.Primary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitPrimary(ctx);
	}
	
	@Override
	public void enterUnary_expression(FineFunctionGrammarParser.Unary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterUnaryExpression(ctx);
	}
	
	@Override
	public void exitUnary_expression(FineFunctionGrammarParser.Unary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitUnaryExpression(ctx);
	}
	
	@Override
	public void enterIdentifier(FineFunctionGrammarParser.IdentifierContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIdentifier(ctx);
	}
	
	@Override
	public void exitIdentifier(FineFunctionGrammarParser.IdentifierContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitIdentifier(ctx);
	}

	@Override
	public void enterFunction_argument(FineFunctionGrammarParser.Function_argumentContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterArgument(ctx);
	}
	
	@Override
	public void exitFunction_argument(FineFunctionGrammarParser.Function_argumentContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitArgument(ctx);
	}
	
	@Override public void enterInitializer_list(FineFunctionGrammarParser.Initializer_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitializerList(ctx);
	}
	
	@Override public void exitInitializer_list(FineFunctionGrammarParser.Initializer_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitializerList(ctx);
	}
	
}
