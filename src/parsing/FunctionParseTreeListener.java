package parsing;

import antlr.FunctionBaseListener;
import antlr.FunctionParser;
import astnodes.builders.FineFunctionContentBuilder;

public class FunctionParseTreeListener extends FunctionBaseListener
{
	CommonParserDriver p;
	
	FunctionParseTreeListener(CommonParserDriver aP)
	{
		p = aP;
	}
	
	@Override
	public void enterStatements(FunctionParser.StatementsContext ctx)
	{
		FineFunctionContentBuilder builder = new FineFunctionContentBuilder();
		builder.createNew(ctx);
		p.itemStack.push(builder);
	}
	
	@Override
	public void exitStatements(FunctionParser.StatementsContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitStatements(ctx);
	}
	
	@Override public void enterStatement(FunctionParser.StatementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterStatement(ctx);
	}
	
	@Override public void exitStatement(FunctionParser.StatementContext ctx)
	{	
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitStatement(ctx);
	}
	
	@Override public void enterElse_statement(FunctionParser.Else_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterElse(ctx);
	}
	
	@Override public void enterIf_statement(FunctionParser.If_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIf(ctx);
	}
	
	@Override public void enterFor_statement(FunctionParser.For_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterFor(ctx);
	}
	
	@Override public void enterFor_init_statement(FunctionParser.For_init_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitFor(ctx);
	}
	
	@Override public void exitFor_init_statement(FunctionParser.For_init_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitFor(ctx);
	}
	
	@Override public void enterWhile_statement(FunctionParser.While_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterWhile(ctx);
	}
	
	@Override public void enterDo_statement(FunctionParser.Do_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterDo(ctx);
	}
	
	@Override public void enterSwitch_statement(FunctionParser.Switch_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterSwitchStatement(ctx);
	}
	
	@Override public void enterLabel(FunctionParser.LabelContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterLabel(ctx);
	}
	
	@Override
	public void enterBlock_starter(FunctionParser.Block_starterContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterBlockStarter(ctx);
	}
	
	@Override
	public void enterOpening_curly(FunctionParser.Opening_curlyContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterOpeningCurly(ctx);
	}
	
	@Override
	public void enterClosing_curly(FunctionParser.Closing_curlyContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterClosingCurly(ctx);
	}
	
	@Override public void enterExpr_statement(FunctionParser.Expr_statementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterExprStatement(ctx);
	}
	
	@Override public void enterReturnStatement(FunctionParser.ReturnStatementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterReturnStatement(ctx);
	}
	
	@Override public void enterBreakStatement(FunctionParser.BreakStatementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterBreakStatement(ctx);
	}
	
	@Override public void enterContinueStatement(FunctionParser.ContinueStatementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterContinueStatement(ctx);
	}
	
	@Override public void enterGotoStatement(FunctionParser.GotoStatementContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterGotoStatement(ctx);
	}
	
	@Override
	public void enterDeclByType(FunctionParser.DeclByTypeContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterDeclByType(ctx, ctx.type_name());
	}
	
	@Override
	public void exitDeclByType(FunctionParser.DeclByTypeContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitDeclByType();
	}
	
	@Override public void enterDeclByClass(FunctionParser.DeclByClassContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterDeclByClass(ctx);
	}
	
	@Override public void exitDeclByClass(FunctionParser.DeclByClassContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitDeclByClass();
	}
	
	@Override public void enterInitDeclSimple(FunctionParser.InitDeclSimpleContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitDeclSimple(ctx);
	}
	
	@Override public void exitInitDeclSimple(FunctionParser.InitDeclSimpleContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitDeclSimple();
	}
	
	@Override public void enterInitDeclWithAssign(FunctionParser.InitDeclWithAssignContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitDeclWithAssign(ctx);
	}
	
	@Override public void exitInitDeclWithAssign(FunctionParser.InitDeclWithAssignContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitDeclWithAssign(ctx);
	}
	
	@Override public void enterInitDeclWithCall(FunctionParser.InitDeclWithCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitDeclWithCall(ctx);
	}	
	@Override public void exitInitDeclWithCall(FunctionParser.InitDeclWithCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitDeclWithCall();
	}
	
	@Override public void enterCondition(FunctionParser.ConditionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterCondition(ctx);
	}
	
	@Override public void exitCondition(FunctionParser.ConditionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitCondition(ctx);
	}
	
	
	@Override public void enterExpr(FunctionParser.ExprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterExpression(ctx);
	}
	
	@Override public void exitExpr(FunctionParser.ExprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitExpression(ctx);
	}
	
	@Override public void enterAssign_expr(FunctionParser.Assign_exprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterAssignment(ctx);
	}
	
	@Override public void exitAssign_expr(FunctionParser.Assign_exprContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitAssignment(ctx);
	}
	
	@Override public void enterConditional_expression(FunctionParser.Conditional_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterConditionalExpr(ctx);
	}
	
	@Override public void exitConditional_expression(FunctionParser.Conditional_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitConditionalExpr(ctx);
	}
	
	@Override public void enterOr_expression(FunctionParser.Or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterOrExpression(ctx);
	}
	
	@Override public void exitOr_expression(FunctionParser.Or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitrOrExpression(ctx);
	}
	
	@Override public void enterAnd_expression(FunctionParser.And_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterAndExpression(ctx);
	}
	
	@Override public void exitAnd_expression(FunctionParser.And_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitAndExpression(ctx);
	}
	

	@Override public void enterInclusive_or_expression(FunctionParser.Inclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInclusiveOrExpression(ctx);
	}
	
	@Override public void exitInclusive_or_expression(FunctionParser.Inclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInclusiveOrExpression(ctx);
	}

	@Override public void enterExclusive_or_expression(FunctionParser.Exclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterExclusiveOrExpression(ctx);
	}
	
	@Override public void exitExclusive_or_expression(FunctionParser.Exclusive_or_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitExclusiveOrExpression(ctx);
	}

	@Override public void enterBit_and_expression(FunctionParser.Bit_and_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterBitAndExpression(ctx);
	}
	
	@Override public void exitBit_and_expression(FunctionParser.Bit_and_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitBitAndExpression(ctx);
	}
	
	@Override public void enterEquality_expression(FunctionParser.Equality_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterEqualityExpression(ctx);
	}
	
	@Override public void exitEquality_expression(FunctionParser.Equality_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitEqualityExpression(ctx);
	}
	
	
	@Override public void enterRelational_expression(FunctionParser.Relational_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterRelationalExpression(ctx);
	}
	
	@Override public void exitRelational_expression(FunctionParser.Relational_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitRelationalExpression(ctx);
	}
	
	@Override public void enterShift_expression(FunctionParser.Shift_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterShiftExpression(ctx);
	}
	
	@Override public void exitShift_expression(FunctionParser.Shift_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitShiftExpression(ctx);
	}
	
	@Override public void enterAdditive_expression(FunctionParser.Additive_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterAdditiveExpression(ctx);
	}
	
	@Override public void exitAdditive_expression(FunctionParser.Additive_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitAdditiveExpression(ctx);
	}
	
	@Override public void enterMultiplicative_expression(FunctionParser.Multiplicative_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterMultiplicativeExpression(ctx);
	}
	
	@Override public void exitMultiplicative_expression(FunctionParser.Multiplicative_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitMultiplicativeExpression(ctx);
	}
	
	@Override public void enterCast_expression(FunctionParser.Cast_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterCastExpression(ctx);
	}
	
	@Override public void exitCast_expression(FunctionParser.Cast_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitCastExpression(ctx);
	}
	
	@Override public void enterCast_target(FunctionParser.Cast_targetContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterCast_target(ctx);
	}
	
	@Override public void exitCast_target(FunctionParser.Cast_targetContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitCast_target(ctx);
	}
	
	@Override public void enterFuncCall(FunctionParser.FuncCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterFuncCall(ctx);
	}
	
	@Override public void exitFuncCall(FunctionParser.FuncCallContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitFuncCall(ctx);
	}

	@Override public void enterFunction_argument_list(FunctionParser.Function_argument_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterArgumentList(ctx);
	}
	
	@Override public void exitFunction_argument_list(FunctionParser.Function_argument_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitArgumentList(ctx);	
	}
	
	@Override
	public void enterInc_dec(FunctionParser.Inc_decContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIncDec(ctx);
	}
	
	@Override public void exitInc_dec(FunctionParser.Inc_decContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitIncDec(ctx);
	}
	
	@Override
	public void enterArrayIndexing(FunctionParser.ArrayIndexingContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterArrayIndexing(ctx);
	}
	
	@Override
	public void exitArrayIndexing(FunctionParser.ArrayIndexingContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitArrayIndexing(ctx);
	}
	
	@Override
	public void enterMemberAccess(FunctionParser.MemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterMemberAccess(ctx);
	}
	
	@Override
	public void exitMemberAccess(FunctionParser.MemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitMemberAccess(ctx);
	}
	
	@Override
	public void enterPtrMemberAccess(FunctionParser.PtrMemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterPtrMemberAccess(ctx);
	}
	
	@Override
	public void exitPtrMemberAccess(FunctionParser.PtrMemberAccessContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitPtrMemberAccess(ctx);
	}
	
	
	@Override
	public void enterIncDecOp(FunctionParser.IncDecOpContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIncDecOp(ctx);
	}
	
	@Override
	public void exitIncDecOp(FunctionParser.IncDecOpContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitIncDecOp(ctx);
	}
	
	@Override
	public void enterPrimary_expression(FunctionParser.Primary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterPrimary(ctx);
	}
	
	@Override
	public void exitPrimary_expression(FunctionParser.Primary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitPrimary(ctx);
	}
	
	@Override
	public void enterUnary_expression(FunctionParser.Unary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterUnaryExpression(ctx);
	}
	
	@Override
	public void exitUnary_expression(FunctionParser.Unary_expressionContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitUnaryExpression(ctx);
	}
	
	@Override
	public void enterIdentifier(FunctionParser.IdentifierContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterIdentifier(ctx);
	}
	
	@Override
	public void exitIdentifier(FunctionParser.IdentifierContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitIdentifier(ctx);
	}

	@Override
	public void enterFunction_argument(FunctionParser.Function_argumentContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterArgument(ctx);
	}
	
	@Override
	public void exitFunction_argument(FunctionParser.Function_argumentContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitArgument(ctx);
	}
	
	@Override public void enterInitializer_list(FunctionParser.Initializer_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.enterInitializerList(ctx);
	}
	
	@Override public void exitInitializer_list(FunctionParser.Initializer_listContext ctx)
	{
		FineFunctionContentBuilder builder = (FineFunctionContentBuilder) p.itemStack.peek();
		builder.exitInitializerList(ctx);
	}
	
}
