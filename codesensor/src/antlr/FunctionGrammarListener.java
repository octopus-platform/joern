// Generated from ./FunctionGrammar.g4 by ANTLR 4.0

	package antlr;


  import java.util.Stack;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface FunctionGrammarListener extends ParseTreeListener {
	void enterOperator_function_id(FunctionGrammarParser.Operator_function_idContext ctx);
	void exitOperator_function_id(FunctionGrammarParser.Operator_function_idContext ctx);

	void enterPre_else(FunctionGrammarParser.Pre_elseContext ctx);
	void exitPre_else(FunctionGrammarParser.Pre_elseContext ctx);

	void enterTemplate_decl_start(FunctionGrammarParser.Template_decl_startContext ctx);
	void exitTemplate_decl_start(FunctionGrammarParser.Template_decl_startContext ctx);

	void enterFunction_argument_list(FunctionGrammarParser.Function_argument_listContext ctx);
	void exitFunction_argument_list(FunctionGrammarParser.Function_argument_listContext ctx);

	void enterType_suffix(FunctionGrammarParser.Type_suffixContext ctx);
	void exitType_suffix(FunctionGrammarParser.Type_suffixContext ctx);

	void enterNo_squares_or_semicolon(FunctionGrammarParser.No_squares_or_semicolonContext ctx);
	void exitNo_squares_or_semicolon(FunctionGrammarParser.No_squares_or_semicolonContext ctx);

	void enterCast_expression(FunctionGrammarParser.Cast_expressionContext ctx);
	void exitCast_expression(FunctionGrammarParser.Cast_expressionContext ctx);

	void enterNo_angle_brackets_or_brackets(FunctionGrammarParser.No_angle_brackets_or_bracketsContext ctx);
	void exitNo_angle_brackets_or_brackets(FunctionGrammarParser.No_angle_brackets_or_bracketsContext ctx);

	void enterEquality_expression(FunctionGrammarParser.Equality_expressionContext ctx);
	void exitEquality_expression(FunctionGrammarParser.Equality_expressionContext ctx);

	void enterNo_comma_or_semicolon(FunctionGrammarParser.No_comma_or_semicolonContext ctx);
	void exitNo_comma_or_semicolon(FunctionGrammarParser.No_comma_or_semicolonContext ctx);

	void enterGoto_statement(FunctionGrammarParser.Goto_statementContext ctx);
	void exitGoto_statement(FunctionGrammarParser.Goto_statementContext ctx);

	void enterFor_statement(FunctionGrammarParser.For_statementContext ctx);
	void exitFor_statement(FunctionGrammarParser.For_statementContext ctx);

	void enterStatement_water(FunctionGrammarParser.Statement_waterContext ctx);
	void exitStatement_water(FunctionGrammarParser.Statement_waterContext ctx);

	void enterNumber(FunctionGrammarParser.NumberContext ctx);
	void exitNumber(FunctionGrammarParser.NumberContext ctx);

	void enterBase_type(FunctionGrammarParser.Base_typeContext ctx);
	void exitBase_type(FunctionGrammarParser.Base_typeContext ctx);

	void enterPre_opener(FunctionGrammarParser.Pre_openerContext ctx);
	void exitPre_opener(FunctionGrammarParser.Pre_openerContext ctx);

	void enterNo_squares(FunctionGrammarParser.No_squaresContext ctx);
	void exitNo_squares(FunctionGrammarParser.No_squaresContext ctx);

	void enterShift_expression(FunctionGrammarParser.Shift_expressionContext ctx);
	void exitShift_expression(FunctionGrammarParser.Shift_expressionContext ctx);

	void enterDeclByClass(FunctionGrammarParser.DeclByClassContext ctx);
	void exitDeclByClass(FunctionGrammarParser.DeclByClassContext ctx);

	void enterType_name(FunctionGrammarParser.Type_nameContext ctx);
	void exitType_name(FunctionGrammarParser.Type_nameContext ctx);

	void enterFuncCall(FunctionGrammarParser.FuncCallContext ctx);
	void exitFuncCall(FunctionGrammarParser.FuncCallContext ctx);

	void enterInclusive_or_expression(FunctionGrammarParser.Inclusive_or_expressionContext ctx);
	void exitInclusive_or_expression(FunctionGrammarParser.Inclusive_or_expressionContext ctx);

	void enterBase_classes(FunctionGrammarParser.Base_classesContext ctx);
	void exitBase_classes(FunctionGrammarParser.Base_classesContext ctx);

	void enterElse_statement(FunctionGrammarParser.Else_statementContext ctx);
	void exitElse_statement(FunctionGrammarParser.Else_statementContext ctx);

	void enterPre_closer(FunctionGrammarParser.Pre_closerContext ctx);
	void exitPre_closer(FunctionGrammarParser.Pre_closerContext ctx);

	void enterIf_statement(FunctionGrammarParser.If_statementContext ctx);
	void exitIf_statement(FunctionGrammarParser.If_statementContext ctx);

	void enterRelational_expression(FunctionGrammarParser.Relational_expressionContext ctx);
	void exitRelational_expression(FunctionGrammarParser.Relational_expressionContext ctx);

	void enterClass_name(FunctionGrammarParser.Class_nameContext ctx);
	void exitClass_name(FunctionGrammarParser.Class_nameContext ctx);

	void enterParam_decl_specifiers(FunctionGrammarParser.Param_decl_specifiersContext ctx);
	void exitParam_decl_specifiers(FunctionGrammarParser.Param_decl_specifiersContext ctx);

	void enterParam_type(FunctionGrammarParser.Param_typeContext ctx);
	void exitParam_type(FunctionGrammarParser.Param_typeContext ctx);

	void enterFunction_argument(FunctionGrammarParser.Function_argumentContext ctx);
	void exitFunction_argument(FunctionGrammarParser.Function_argumentContext ctx);

	void enterNon_expr_statement(FunctionGrammarParser.Non_expr_statementContext ctx);
	void exitNon_expr_statement(FunctionGrammarParser.Non_expr_statementContext ctx);

	void enterNon_block_starter(FunctionGrammarParser.Non_block_starterContext ctx);
	void exitNon_block_starter(FunctionGrammarParser.Non_block_starterContext ctx);

	void enterConstant_expr_w_(FunctionGrammarParser.Constant_expr_w_Context ctx);
	void exitConstant_expr_w_(FunctionGrammarParser.Constant_expr_w_Context ctx);

	void enterReturn_statement(FunctionGrammarParser.Return_statementContext ctx);
	void exitReturn_statement(FunctionGrammarParser.Return_statementContext ctx);

	void enterWater(FunctionGrammarParser.WaterContext ctx);
	void exitWater(FunctionGrammarParser.WaterContext ctx);

	void enterClosing_curly(FunctionGrammarParser.Closing_curlyContext ctx);
	void exitClosing_curly(FunctionGrammarParser.Closing_curlyContext ctx);

	void enterFor_init_statement(FunctionGrammarParser.For_init_statementContext ctx);
	void exitFor_init_statement(FunctionGrammarParser.For_init_statementContext ctx);

	void enterOr_expression(FunctionGrammarParser.Or_expressionContext ctx);
	void exitOr_expression(FunctionGrammarParser.Or_expressionContext ctx);

	void enterSelection_statement(FunctionGrammarParser.Selection_statementContext ctx);
	void exitSelection_statement(FunctionGrammarParser.Selection_statementContext ctx);

	void enterRelational_operator(FunctionGrammarParser.Relational_operatorContext ctx);
	void exitRelational_operator(FunctionGrammarParser.Relational_operatorContext ctx);

	void enterTry_block(FunctionGrammarParser.Try_blockContext ctx);
	void exitTry_block(FunctionGrammarParser.Try_blockContext ctx);

	void enterDo_statement1(FunctionGrammarParser.Do_statement1Context ctx);
	void exitDo_statement1(FunctionGrammarParser.Do_statement1Context ctx);

	void enterOperator(FunctionGrammarParser.OperatorContext ctx);
	void exitOperator(FunctionGrammarParser.OperatorContext ctx);

	void enterField(FunctionGrammarParser.FieldContext ctx);
	void exitField(FunctionGrammarParser.FieldContext ctx);

	void enterConditional_expression(FunctionGrammarParser.Conditional_expressionContext ctx);
	void exitConditional_expression(FunctionGrammarParser.Conditional_expressionContext ctx);

	void enterOpening_curly(FunctionGrammarParser.Opening_curlyContext ctx);
	void exitOpening_curly(FunctionGrammarParser.Opening_curlyContext ctx);

	void enterPrimary_expression(FunctionGrammarParser.Primary_expressionContext ctx);
	void exitPrimary_expression(FunctionGrammarParser.Primary_expressionContext ctx);

	void enterFieldOnly(FunctionGrammarParser.FieldOnlyContext ctx);
	void exitFieldOnly(FunctionGrammarParser.FieldOnlyContext ctx);

	void enterNo_brackets(FunctionGrammarParser.No_bracketsContext ctx);
	void exitNo_brackets(FunctionGrammarParser.No_bracketsContext ctx);

	void enterBit_and_expression(FunctionGrammarParser.Bit_and_expressionContext ctx);
	void exitBit_and_expression(FunctionGrammarParser.Bit_and_expressionContext ctx);

	void enterAssign_water(FunctionGrammarParser.Assign_waterContext ctx);
	void exitAssign_water(FunctionGrammarParser.Assign_waterContext ctx);

	void enterFunction_decl_specifiers(FunctionGrammarParser.Function_decl_specifiersContext ctx);
	void exitFunction_decl_specifiers(FunctionGrammarParser.Function_decl_specifiersContext ctx);

	void enterMultiplicative_expression(FunctionGrammarParser.Multiplicative_expressionContext ctx);
	void exitMultiplicative_expression(FunctionGrammarParser.Multiplicative_expressionContext ctx);

	void enterJump_statement(FunctionGrammarParser.Jump_statementContext ctx);
	void exitJump_statement(FunctionGrammarParser.Jump_statementContext ctx);

	void enterAssign_expr(FunctionGrammarParser.Assign_exprContext ctx);
	void exitAssign_expr(FunctionGrammarParser.Assign_exprContext ctx);

	void enterParam_type2(FunctionGrammarParser.Param_type2Context ctx);
	void exitParam_type2(FunctionGrammarParser.Param_type2Context ctx);

	void enterExpr_statement(FunctionGrammarParser.Expr_statementContext ctx);
	void exitExpr_statement(FunctionGrammarParser.Expr_statementContext ctx);

	void enterFunction_call_tail(FunctionGrammarParser.Function_call_tailContext ctx);
	void exitFunction_call_tail(FunctionGrammarParser.Function_call_tailContext ctx);

	void enterCall_template_list(FunctionGrammarParser.Call_template_listContext ctx);
	void exitCall_template_list(FunctionGrammarParser.Call_template_listContext ctx);

	void enterBase_class(FunctionGrammarParser.Base_classContext ctx);
	void exitBase_class(FunctionGrammarParser.Base_classContext ctx);

	void enterParameter_name(FunctionGrammarParser.Parameter_nameContext ctx);
	void exitParameter_name(FunctionGrammarParser.Parameter_nameContext ctx);

	void enterAccess_specifier(FunctionGrammarParser.Access_specifierContext ctx);
	void exitAccess_specifier(FunctionGrammarParser.Access_specifierContext ctx);

	void enterType_name2(FunctionGrammarParser.Type_name2Context ctx);
	void exitType_name2(FunctionGrammarParser.Type_name2Context ctx);

	void enterAssign_water_l2(FunctionGrammarParser.Assign_water_l2Context ctx);
	void exitAssign_water_l2(FunctionGrammarParser.Assign_water_l2Context ctx);

	void enterInit_declarator_list(FunctionGrammarParser.Init_declarator_listContext ctx);
	void exitInit_declarator_list(FunctionGrammarParser.Init_declarator_listContext ctx);

	void enterCondition(FunctionGrammarParser.ConditionContext ctx);
	void exitCondition(FunctionGrammarParser.ConditionContext ctx);

	void enterInit_declarator(FunctionGrammarParser.Init_declaratorContext ctx);
	void exitInit_declarator(FunctionGrammarParser.Init_declaratorContext ctx);

	void enterLabel(FunctionGrammarParser.LabelContext ctx);
	void exitLabel(FunctionGrammarParser.LabelContext ctx);

	void enterDo_statement(FunctionGrammarParser.Do_statementContext ctx);
	void exitDo_statement(FunctionGrammarParser.Do_statementContext ctx);

	void enterExclusive_or_expression(FunctionGrammarParser.Exclusive_or_expressionContext ctx);
	void exitExclusive_or_expression(FunctionGrammarParser.Exclusive_or_expressionContext ctx);

	void enterAssign_expr_w_(FunctionGrammarParser.Assign_expr_w_Context ctx);
	void exitAssign_expr_w_(FunctionGrammarParser.Assign_expr_w_Context ctx);

	void enterStatement(FunctionGrammarParser.StatementContext ctx);
	void exitStatement(FunctionGrammarParser.StatementContext ctx);

	void enterParam_type_id(FunctionGrammarParser.Param_type_idContext ctx);
	void exitParam_type_id(FunctionGrammarParser.Param_type_idContext ctx);

	void enterAdditive_expression(FunctionGrammarParser.Additive_expressionContext ctx);
	void exitAdditive_expression(FunctionGrammarParser.Additive_expressionContext ctx);

	void enterUnary_operator(FunctionGrammarParser.Unary_operatorContext ctx);
	void exitUnary_operator(FunctionGrammarParser.Unary_operatorContext ctx);

	void enterIteration_statement(FunctionGrammarParser.Iteration_statementContext ctx);
	void exitIteration_statement(FunctionGrammarParser.Iteration_statementContext ctx);

	void enterNo_brackets_curlies_or_squares(FunctionGrammarParser.No_brackets_curlies_or_squaresContext ctx);
	void exitNo_brackets_curlies_or_squares(FunctionGrammarParser.No_brackets_curlies_or_squaresContext ctx);

	void enterIdentifier(FunctionGrammarParser.IdentifierContext ctx);
	void exitIdentifier(FunctionGrammarParser.IdentifierContext ctx);

	void enterNo_brackets_or_semicolon(FunctionGrammarParser.No_brackets_or_semicolonContext ctx);
	void exitNo_brackets_or_semicolon(FunctionGrammarParser.No_brackets_or_semicolonContext ctx);

	void enterEquality_operator(FunctionGrammarParser.Equality_operatorContext ctx);
	void exitEquality_operator(FunctionGrammarParser.Equality_operatorContext ctx);

	void enterNo_curlies(FunctionGrammarParser.No_curliesContext ctx);
	void exitNo_curlies(FunctionGrammarParser.No_curliesContext ctx);

	void enterParam_type_list(FunctionGrammarParser.Param_type_listContext ctx);
	void exitParam_type_list(FunctionGrammarParser.Param_type_listContext ctx);

	void enterWhile_statement(FunctionGrammarParser.While_statementContext ctx);
	void exitWhile_statement(FunctionGrammarParser.While_statementContext ctx);

	void enterExpr(FunctionGrammarParser.ExprContext ctx);
	void exitExpr(FunctionGrammarParser.ExprContext ctx);

	void enterSimple_decl(FunctionGrammarParser.Simple_declContext ctx);
	void exitSimple_decl(FunctionGrammarParser.Simple_declContext ctx);

	void enterBlock_starter(FunctionGrammarParser.Block_starterContext ctx);
	void exitBlock_starter(FunctionGrammarParser.Block_starterContext ctx);

	void enterBreak_or_continue(FunctionGrammarParser.Break_or_continueContext ctx);
	void exitBreak_or_continue(FunctionGrammarParser.Break_or_continueContext ctx);

	void enterAssignment_operator(FunctionGrammarParser.Assignment_operatorContext ctx);
	void exitAssignment_operator(FunctionGrammarParser.Assignment_operatorContext ctx);

	void enterCatch_block(FunctionGrammarParser.Catch_blockContext ctx);
	void exitCatch_block(FunctionGrammarParser.Catch_blockContext ctx);

	void enterStatements(FunctionGrammarParser.StatementsContext ctx);
	void exitStatements(FunctionGrammarParser.StatementsContext ctx);

	void enterUnary_expression(FunctionGrammarParser.Unary_expressionContext ctx);
	void exitUnary_expression(FunctionGrammarParser.Unary_expressionContext ctx);

	void enterClass_key(FunctionGrammarParser.Class_keyContext ctx);
	void exitClass_key(FunctionGrammarParser.Class_keyContext ctx);

	void enterPtrs(FunctionGrammarParser.PtrsContext ctx);
	void exitPtrs(FunctionGrammarParser.PtrsContext ctx);

	void enterSwitch_statement(FunctionGrammarParser.Switch_statementContext ctx);
	void exitSwitch_statement(FunctionGrammarParser.Switch_statementContext ctx);

	void enterConstant(FunctionGrammarParser.ConstantContext ctx);
	void exitConstant(FunctionGrammarParser.ConstantContext ctx);

	void enterAssign_expr_w__l2(FunctionGrammarParser.Assign_expr_w__l2Context ctx);
	void exitAssign_expr_w__l2(FunctionGrammarParser.Assign_expr_w__l2Context ctx);

	void enterPtr_operator(FunctionGrammarParser.Ptr_operatorContext ctx);
	void exitPtr_operator(FunctionGrammarParser.Ptr_operatorContext ctx);

	void enterParam_decl_specifiers2(FunctionGrammarParser.Param_decl_specifiers2Context ctx);
	void exitParam_decl_specifiers2(FunctionGrammarParser.Param_decl_specifiers2Context ctx);

	void enterPostfix(FunctionGrammarParser.PostfixContext ctx);
	void exitPostfix(FunctionGrammarParser.PostfixContext ctx);

	void enterClass_def(FunctionGrammarParser.Class_defContext ctx);
	void exitClass_def(FunctionGrammarParser.Class_defContext ctx);

	void enterAnd_expression(FunctionGrammarParser.And_expressionContext ctx);
	void exitAnd_expression(FunctionGrammarParser.And_expressionContext ctx);

	void enterTemplate_param_list(FunctionGrammarParser.Template_param_listContext ctx);
	void exitTemplate_param_list(FunctionGrammarParser.Template_param_listContext ctx);

	void enterDeclByType(FunctionGrammarParser.DeclByTypeContext ctx);
	void exitDeclByType(FunctionGrammarParser.DeclByTypeContext ctx);
}