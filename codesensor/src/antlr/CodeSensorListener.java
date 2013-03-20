// Generated from ./CodeSensor.g4 by ANTLR 4.0

	package antlr;
    import java.util.Stack;


  import java.util.Stack;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface CodeSensorListener extends ParseTreeListener {
	void enterOperator_function_id(CodeSensorParser.Operator_function_idContext ctx);
	void exitOperator_function_id(CodeSensorParser.Operator_function_idContext ctx);

	void enterPre_else(CodeSensorParser.Pre_elseContext ctx);
	void exitPre_else(CodeSensorParser.Pre_elseContext ctx);

	void enterTemplate_decl_start(CodeSensorParser.Template_decl_startContext ctx);
	void exitTemplate_decl_start(CodeSensorParser.Template_decl_startContext ctx);

	void enterFunction_argument_list(CodeSensorParser.Function_argument_listContext ctx);
	void exitFunction_argument_list(CodeSensorParser.Function_argument_listContext ctx);

	void enterType_suffix(CodeSensorParser.Type_suffixContext ctx);
	void exitType_suffix(CodeSensorParser.Type_suffixContext ctx);

	void enterCompound_statement(CodeSensorParser.Compound_statementContext ctx);
	void exitCompound_statement(CodeSensorParser.Compound_statementContext ctx);

	void enterNo_squares_or_semicolon(CodeSensorParser.No_squares_or_semicolonContext ctx);
	void exitNo_squares_or_semicolon(CodeSensorParser.No_squares_or_semicolonContext ctx);

	void enterCast_expression(CodeSensorParser.Cast_expressionContext ctx);
	void exitCast_expression(CodeSensorParser.Cast_expressionContext ctx);

	void enterNo_angle_brackets_or_brackets(CodeSensorParser.No_angle_brackets_or_bracketsContext ctx);
	void exitNo_angle_brackets_or_brackets(CodeSensorParser.No_angle_brackets_or_bracketsContext ctx);

	void enterEquality_expression(CodeSensorParser.Equality_expressionContext ctx);
	void exitEquality_expression(CodeSensorParser.Equality_expressionContext ctx);

	void enterParameter_decl_clause(CodeSensorParser.Parameter_decl_clauseContext ctx);
	void exitParameter_decl_clause(CodeSensorParser.Parameter_decl_clauseContext ctx);

	void enterNo_comma_or_semicolon(CodeSensorParser.No_comma_or_semicolonContext ctx);
	void exitNo_comma_or_semicolon(CodeSensorParser.No_comma_or_semicolonContext ctx);

	void enterFor_statement(CodeSensorParser.For_statementContext ctx);
	void exitFor_statement(CodeSensorParser.For_statementContext ctx);

	void enterGoto_statement(CodeSensorParser.Goto_statementContext ctx);
	void exitGoto_statement(CodeSensorParser.Goto_statementContext ctx);

	void enterCtor_expr(CodeSensorParser.Ctor_exprContext ctx);
	void exitCtor_expr(CodeSensorParser.Ctor_exprContext ctx);

	void enterStatement_water(CodeSensorParser.Statement_waterContext ctx);
	void exitStatement_water(CodeSensorParser.Statement_waterContext ctx);

	void enterNumber(CodeSensorParser.NumberContext ctx);
	void exitNumber(CodeSensorParser.NumberContext ctx);

	void enterBase_type(CodeSensorParser.Base_typeContext ctx);
	void exitBase_type(CodeSensorParser.Base_typeContext ctx);

	void enterReturn_type(CodeSensorParser.Return_typeContext ctx);
	void exitReturn_type(CodeSensorParser.Return_typeContext ctx);

	void enterPre_opener(CodeSensorParser.Pre_openerContext ctx);
	void exitPre_opener(CodeSensorParser.Pre_openerContext ctx);

	void enterNo_squares(CodeSensorParser.No_squaresContext ctx);
	void exitNo_squares(CodeSensorParser.No_squaresContext ctx);

	void enterShift_expression(CodeSensorParser.Shift_expressionContext ctx);
	void exitShift_expression(CodeSensorParser.Shift_expressionContext ctx);

	void enterDeclByClass(CodeSensorParser.DeclByClassContext ctx);
	void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx);

	void enterType_name(CodeSensorParser.Type_nameContext ctx);
	void exitType_name(CodeSensorParser.Type_nameContext ctx);

	void enterFuncCall(CodeSensorParser.FuncCallContext ctx);
	void exitFuncCall(CodeSensorParser.FuncCallContext ctx);

	void enterInclusive_or_expression(CodeSensorParser.Inclusive_or_expressionContext ctx);
	void exitInclusive_or_expression(CodeSensorParser.Inclusive_or_expressionContext ctx);

	void enterBase_classes(CodeSensorParser.Base_classesContext ctx);
	void exitBase_classes(CodeSensorParser.Base_classesContext ctx);

	void enterElse_statement(CodeSensorParser.Else_statementContext ctx);
	void exitElse_statement(CodeSensorParser.Else_statementContext ctx);

	void enterPre_closer(CodeSensorParser.Pre_closerContext ctx);
	void exitPre_closer(CodeSensorParser.Pre_closerContext ctx);

	void enterIf_statement(CodeSensorParser.If_statementContext ctx);
	void exitIf_statement(CodeSensorParser.If_statementContext ctx);

	void enterRelational_expression(CodeSensorParser.Relational_expressionContext ctx);
	void exitRelational_expression(CodeSensorParser.Relational_expressionContext ctx);

	void enterClass_name(CodeSensorParser.Class_nameContext ctx);
	void exitClass_name(CodeSensorParser.Class_nameContext ctx);

	void enterParam_decl_specifiers(CodeSensorParser.Param_decl_specifiersContext ctx);
	void exitParam_decl_specifiers(CodeSensorParser.Param_decl_specifiersContext ctx);

	void enterParam_type(CodeSensorParser.Param_typeContext ctx);
	void exitParam_type(CodeSensorParser.Param_typeContext ctx);

	void enterFunction_argument(CodeSensorParser.Function_argumentContext ctx);
	void exitFunction_argument(CodeSensorParser.Function_argumentContext ctx);

	void enterNon_expr_statement(CodeSensorParser.Non_expr_statementContext ctx);
	void exitNon_expr_statement(CodeSensorParser.Non_expr_statementContext ctx);

	void enterNon_block_starter(CodeSensorParser.Non_block_starterContext ctx);
	void exitNon_block_starter(CodeSensorParser.Non_block_starterContext ctx);

	void enterConstant_expr_w_(CodeSensorParser.Constant_expr_w_Context ctx);
	void exitConstant_expr_w_(CodeSensorParser.Constant_expr_w_Context ctx);

	void enterWater(CodeSensorParser.WaterContext ctx);
	void exitWater(CodeSensorParser.WaterContext ctx);

	void enterReturn_statement(CodeSensorParser.Return_statementContext ctx);
	void exitReturn_statement(CodeSensorParser.Return_statementContext ctx);

	void enterClosing_curly(CodeSensorParser.Closing_curlyContext ctx);
	void exitClosing_curly(CodeSensorParser.Closing_curlyContext ctx);

	void enterOr_expression(CodeSensorParser.Or_expressionContext ctx);
	void exitOr_expression(CodeSensorParser.Or_expressionContext ctx);

	void enterFor_init_statement(CodeSensorParser.For_init_statementContext ctx);
	void exitFor_init_statement(CodeSensorParser.For_init_statementContext ctx);

	void enterSelection_statement(CodeSensorParser.Selection_statementContext ctx);
	void exitSelection_statement(CodeSensorParser.Selection_statementContext ctx);

	void enterFunction_def(CodeSensorParser.Function_defContext ctx);
	void exitFunction_def(CodeSensorParser.Function_defContext ctx);

	void enterRelational_operator(CodeSensorParser.Relational_operatorContext ctx);
	void exitRelational_operator(CodeSensorParser.Relational_operatorContext ctx);

	void enterUsing_directive(CodeSensorParser.Using_directiveContext ctx);
	void exitUsing_directive(CodeSensorParser.Using_directiveContext ctx);

	void enterDo_statement1(CodeSensorParser.Do_statement1Context ctx);
	void exitDo_statement1(CodeSensorParser.Do_statement1Context ctx);

	void enterTry_block(CodeSensorParser.Try_blockContext ctx);
	void exitTry_block(CodeSensorParser.Try_blockContext ctx);

	void enterOperator(CodeSensorParser.OperatorContext ctx);
	void exitOperator(CodeSensorParser.OperatorContext ctx);

	void enterField(CodeSensorParser.FieldContext ctx);
	void exitField(CodeSensorParser.FieldContext ctx);

	void enterConditional_expression(CodeSensorParser.Conditional_expressionContext ctx);
	void exitConditional_expression(CodeSensorParser.Conditional_expressionContext ctx);

	void enterPrimary_expression(CodeSensorParser.Primary_expressionContext ctx);
	void exitPrimary_expression(CodeSensorParser.Primary_expressionContext ctx);

	void enterOpening_curly(CodeSensorParser.Opening_curlyContext ctx);
	void exitOpening_curly(CodeSensorParser.Opening_curlyContext ctx);

	void enterFieldOnly(CodeSensorParser.FieldOnlyContext ctx);
	void exitFieldOnly(CodeSensorParser.FieldOnlyContext ctx);

	void enterPart(CodeSensorParser.PartContext ctx);
	void exitPart(CodeSensorParser.PartContext ctx);

	void enterNo_brackets(CodeSensorParser.No_bracketsContext ctx);
	void exitNo_brackets(CodeSensorParser.No_bracketsContext ctx);

	void enterBit_and_expression(CodeSensorParser.Bit_and_expressionContext ctx);
	void exitBit_and_expression(CodeSensorParser.Bit_and_expressionContext ctx);

	void enterAssign_water(CodeSensorParser.Assign_waterContext ctx);
	void exitAssign_water(CodeSensorParser.Assign_waterContext ctx);

	void enterFunction_decl_specifiers(CodeSensorParser.Function_decl_specifiersContext ctx);
	void exitFunction_decl_specifiers(CodeSensorParser.Function_decl_specifiersContext ctx);

	void enterMultiplicative_expression(CodeSensorParser.Multiplicative_expressionContext ctx);
	void exitMultiplicative_expression(CodeSensorParser.Multiplicative_expressionContext ctx);

	void enterJump_statement(CodeSensorParser.Jump_statementContext ctx);
	void exitJump_statement(CodeSensorParser.Jump_statementContext ctx);

	void enterAssign_expr(CodeSensorParser.Assign_exprContext ctx);
	void exitAssign_expr(CodeSensorParser.Assign_exprContext ctx);

	void enterParam_type2(CodeSensorParser.Param_type2Context ctx);
	void exitParam_type2(CodeSensorParser.Param_type2Context ctx);

	void enterCall_template_list(CodeSensorParser.Call_template_listContext ctx);
	void exitCall_template_list(CodeSensorParser.Call_template_listContext ctx);

	void enterFunction_call_tail(CodeSensorParser.Function_call_tailContext ctx);
	void exitFunction_call_tail(CodeSensorParser.Function_call_tailContext ctx);

	void enterExpr_statement(CodeSensorParser.Expr_statementContext ctx);
	void exitExpr_statement(CodeSensorParser.Expr_statementContext ctx);

	void enterBase_class(CodeSensorParser.Base_classContext ctx);
	void exitBase_class(CodeSensorParser.Base_classContext ctx);

	void enterFunction_name(CodeSensorParser.Function_nameContext ctx);
	void exitFunction_name(CodeSensorParser.Function_nameContext ctx);

	void enterParameter_name(CodeSensorParser.Parameter_nameContext ctx);
	void exitParameter_name(CodeSensorParser.Parameter_nameContext ctx);

	void enterAccess_specifier(CodeSensorParser.Access_specifierContext ctx);
	void exitAccess_specifier(CodeSensorParser.Access_specifierContext ctx);

	void enterCtor_list(CodeSensorParser.Ctor_listContext ctx);
	void exitCtor_list(CodeSensorParser.Ctor_listContext ctx);

	void enterType_name2(CodeSensorParser.Type_name2Context ctx);
	void exitType_name2(CodeSensorParser.Type_name2Context ctx);

	void enterDeclaration(CodeSensorParser.DeclarationContext ctx);
	void exitDeclaration(CodeSensorParser.DeclarationContext ctx);

	void enterInit_declarator_list(CodeSensorParser.Init_declarator_listContext ctx);
	void exitInit_declarator_list(CodeSensorParser.Init_declarator_listContext ctx);

	void enterAssign_water_l2(CodeSensorParser.Assign_water_l2Context ctx);
	void exitAssign_water_l2(CodeSensorParser.Assign_water_l2Context ctx);

	void enterCondition(CodeSensorParser.ConditionContext ctx);
	void exitCondition(CodeSensorParser.ConditionContext ctx);

	void enterInit_declarator(CodeSensorParser.Init_declaratorContext ctx);
	void exitInit_declarator(CodeSensorParser.Init_declaratorContext ctx);

	void enterParameter_decl(CodeSensorParser.Parameter_declContext ctx);
	void exitParameter_decl(CodeSensorParser.Parameter_declContext ctx);

	void enterLabel(CodeSensorParser.LabelContext ctx);
	void exitLabel(CodeSensorParser.LabelContext ctx);

	void enterCode(CodeSensorParser.CodeContext ctx);
	void exitCode(CodeSensorParser.CodeContext ctx);

	void enterCtor_initializer(CodeSensorParser.Ctor_initializerContext ctx);
	void exitCtor_initializer(CodeSensorParser.Ctor_initializerContext ctx);

	void enterDo_statement(CodeSensorParser.Do_statementContext ctx);
	void exitDo_statement(CodeSensorParser.Do_statementContext ctx);

	void enterExclusive_or_expression(CodeSensorParser.Exclusive_or_expressionContext ctx);
	void exitExclusive_or_expression(CodeSensorParser.Exclusive_or_expressionContext ctx);

	void enterAssign_expr_w_(CodeSensorParser.Assign_expr_w_Context ctx);
	void exitAssign_expr_w_(CodeSensorParser.Assign_expr_w_Context ctx);

	void enterStatement(CodeSensorParser.StatementContext ctx);
	void exitStatement(CodeSensorParser.StatementContext ctx);

	void enterParam_type_id(CodeSensorParser.Param_type_idContext ctx);
	void exitParam_type_id(CodeSensorParser.Param_type_idContext ctx);

	void enterAdditive_expression(CodeSensorParser.Additive_expressionContext ctx);
	void exitAdditive_expression(CodeSensorParser.Additive_expressionContext ctx);

	void enterUnary_operator(CodeSensorParser.Unary_operatorContext ctx);
	void exitUnary_operator(CodeSensorParser.Unary_operatorContext ctx);

	void enterIteration_statement(CodeSensorParser.Iteration_statementContext ctx);
	void exitIteration_statement(CodeSensorParser.Iteration_statementContext ctx);

	void enterNo_brackets_curlies_or_squares(CodeSensorParser.No_brackets_curlies_or_squaresContext ctx);
	void exitNo_brackets_curlies_or_squares(CodeSensorParser.No_brackets_curlies_or_squaresContext ctx);

	void enterIdentifier(CodeSensorParser.IdentifierContext ctx);
	void exitIdentifier(CodeSensorParser.IdentifierContext ctx);

	void enterFunction_param_list(CodeSensorParser.Function_param_listContext ctx);
	void exitFunction_param_list(CodeSensorParser.Function_param_listContext ctx);

	void enterNo_brackets_or_semicolon(CodeSensorParser.No_brackets_or_semicolonContext ctx);
	void exitNo_brackets_or_semicolon(CodeSensorParser.No_brackets_or_semicolonContext ctx);

	void enterEquality_operator(CodeSensorParser.Equality_operatorContext ctx);
	void exitEquality_operator(CodeSensorParser.Equality_operatorContext ctx);

	void enterNo_curlies(CodeSensorParser.No_curliesContext ctx);
	void exitNo_curlies(CodeSensorParser.No_curliesContext ctx);

	void enterExpr(CodeSensorParser.ExprContext ctx);
	void exitExpr(CodeSensorParser.ExprContext ctx);

	void enterParam_type_list(CodeSensorParser.Param_type_listContext ctx);
	void exitParam_type_list(CodeSensorParser.Param_type_listContext ctx);

	void enterWhile_statement(CodeSensorParser.While_statementContext ctx);
	void exitWhile_statement(CodeSensorParser.While_statementContext ctx);

	void enterSimple_decl(CodeSensorParser.Simple_declContext ctx);
	void exitSimple_decl(CodeSensorParser.Simple_declContext ctx);

	void enterBlock_starter(CodeSensorParser.Block_starterContext ctx);
	void exitBlock_starter(CodeSensorParser.Block_starterContext ctx);

	void enterBreak_or_continue(CodeSensorParser.Break_or_continueContext ctx);
	void exitBreak_or_continue(CodeSensorParser.Break_or_continueContext ctx);

	void enterAssignment_operator(CodeSensorParser.Assignment_operatorContext ctx);
	void exitAssignment_operator(CodeSensorParser.Assignment_operatorContext ctx);

	void enterCatch_block(CodeSensorParser.Catch_blockContext ctx);
	void exitCatch_block(CodeSensorParser.Catch_blockContext ctx);

	void enterType_id_list(CodeSensorParser.Type_id_listContext ctx);
	void exitType_id_list(CodeSensorParser.Type_id_listContext ctx);

	void enterUnary_expression(CodeSensorParser.Unary_expressionContext ctx);
	void exitUnary_expression(CodeSensorParser.Unary_expressionContext ctx);

	void enterStatements(CodeSensorParser.StatementsContext ctx);
	void exitStatements(CodeSensorParser.StatementsContext ctx);

	void enterClass_key(CodeSensorParser.Class_keyContext ctx);
	void exitClass_key(CodeSensorParser.Class_keyContext ctx);

	void enterPtrs(CodeSensorParser.PtrsContext ctx);
	void exitPtrs(CodeSensorParser.PtrsContext ctx);

	void enterSwitch_statement(CodeSensorParser.Switch_statementContext ctx);
	void exitSwitch_statement(CodeSensorParser.Switch_statementContext ctx);

	void enterConstant(CodeSensorParser.ConstantContext ctx);
	void exitConstant(CodeSensorParser.ConstantContext ctx);

	void enterAssign_expr_w__l2(CodeSensorParser.Assign_expr_w__l2Context ctx);
	void exitAssign_expr_w__l2(CodeSensorParser.Assign_expr_w__l2Context ctx);

	void enterPtr_operator(CodeSensorParser.Ptr_operatorContext ctx);
	void exitPtr_operator(CodeSensorParser.Ptr_operatorContext ctx);

	void enterPostfix(CodeSensorParser.PostfixContext ctx);
	void exitPostfix(CodeSensorParser.PostfixContext ctx);

	void enterParam_decl_specifiers2(CodeSensorParser.Param_decl_specifiers2Context ctx);
	void exitParam_decl_specifiers2(CodeSensorParser.Param_decl_specifiers2Context ctx);

	void enterClass_def(CodeSensorParser.Class_defContext ctx);
	void exitClass_def(CodeSensorParser.Class_defContext ctx);

	void enterInitializer_id(CodeSensorParser.Initializer_idContext ctx);
	void exitInitializer_id(CodeSensorParser.Initializer_idContext ctx);

	void enterAnd_expression(CodeSensorParser.And_expressionContext ctx);
	void exitAnd_expression(CodeSensorParser.And_expressionContext ctx);

	void enterException_specification(CodeSensorParser.Exception_specificationContext ctx);
	void exitException_specification(CodeSensorParser.Exception_specificationContext ctx);

	void enterTemplate_param_list(CodeSensorParser.Template_param_listContext ctx);
	void exitTemplate_param_list(CodeSensorParser.Template_param_listContext ctx);

	void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx);
	void exitDeclByType(CodeSensorParser.DeclByTypeContext ctx);

	void enterParameter_id(CodeSensorParser.Parameter_idContext ctx);
	void exitParameter_id(CodeSensorParser.Parameter_idContext ctx);
}