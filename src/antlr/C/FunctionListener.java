// Generated from src/antlr/C/Function.g4 by ANTLR 4.2.1-SNAPSHOT

	package antlr.C;


  import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FunctionParser}.
 */
public interface FunctionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FunctionParser#pre_else}.
	 * @param ctx the parse tree
	 */
	void enterPre_else(@NotNull FunctionParser.Pre_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#pre_else}.
	 * @param ctx the parse tree
	 */
	void exitPre_else(@NotNull FunctionParser.Pre_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(@NotNull FunctionParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(@NotNull FunctionParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#template_decl_start}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_decl_start(@NotNull FunctionParser.Template_decl_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#template_decl_start}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_decl_start(@NotNull FunctionParser.Template_decl_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#function_argument_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_argument_list(@NotNull FunctionParser.Function_argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#function_argument_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_argument_list(@NotNull FunctionParser.Function_argument_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#type_suffix}.
	 * @param ctx the parse tree
	 */
	void enterType_suffix(@NotNull FunctionParser.Type_suffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#type_suffix}.
	 * @param ctx the parse tree
	 */
	void exitType_suffix(@NotNull FunctionParser.Type_suffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#cndExpr}.
	 * @param ctx the parse tree
	 */
	void enterCndExpr(@NotNull FunctionParser.CndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#cndExpr}.
	 * @param ctx the parse tree
	 */
	void exitCndExpr(@NotNull FunctionParser.CndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_squares_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterNo_squares_or_semicolon(@NotNull FunctionParser.No_squares_or_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_squares_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitNo_squares_or_semicolon(@NotNull FunctionParser.No_squares_or_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#For_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(@NotNull FunctionParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#For_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(@NotNull FunctionParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void enterCast_expression(@NotNull FunctionParser.Cast_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void exitCast_expression(@NotNull FunctionParser.Cast_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_angle_brackets_or_brackets}.
	 * @param ctx the parse tree
	 */
	void enterNo_angle_brackets_or_brackets(@NotNull FunctionParser.No_angle_brackets_or_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_angle_brackets_or_brackets}.
	 * @param ctx the parse tree
	 */
	void exitNo_angle_brackets_or_brackets(@NotNull FunctionParser.No_angle_brackets_or_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(@NotNull FunctionParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(@NotNull FunctionParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_comma_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterNo_comma_or_semicolon(@NotNull FunctionParser.No_comma_or_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_comma_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitNo_comma_or_semicolon(@NotNull FunctionParser.No_comma_or_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#Try_statement}.
	 * @param ctx the parse tree
	 */
	void enterTry_statement(@NotNull FunctionParser.Try_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#Try_statement}.
	 * @param ctx the parse tree
	 */
	void exitTry_statement(@NotNull FunctionParser.Try_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull FunctionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull FunctionParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBase_type(@NotNull FunctionParser.Base_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBase_type(@NotNull FunctionParser.Base_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#ptrMemberAccess}.
	 * @param ctx the parse tree
	 */
	void enterPtrMemberAccess(@NotNull FunctionParser.PtrMemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#ptrMemberAccess}.
	 * @param ctx the parse tree
	 */
	void exitPtrMemberAccess(@NotNull FunctionParser.PtrMemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#pre_opener}.
	 * @param ctx the parse tree
	 */
	void enterPre_opener(@NotNull FunctionParser.Pre_openerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#pre_opener}.
	 * @param ctx the parse tree
	 */
	void exitPre_opener(@NotNull FunctionParser.Pre_openerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_squares}.
	 * @param ctx the parse tree
	 */
	void enterNo_squares(@NotNull FunctionParser.No_squaresContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_squares}.
	 * @param ctx the parse tree
	 */
	void exitNo_squares(@NotNull FunctionParser.No_squaresContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShift_expression(@NotNull FunctionParser.Shift_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShift_expression(@NotNull FunctionParser.Shift_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#declByClass}.
	 * @param ctx the parse tree
	 */
	void enterDeclByClass(@NotNull FunctionParser.DeclByClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#declByClass}.
	 * @param ctx the parse tree
	 */
	void exitDeclByClass(@NotNull FunctionParser.DeclByClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(@NotNull FunctionParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(@NotNull FunctionParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(@NotNull FunctionParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(@NotNull FunctionParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#sizeof_expression}.
	 * @param ctx the parse tree
	 */
	void enterSizeof_expression(@NotNull FunctionParser.Sizeof_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#sizeof_expression}.
	 * @param ctx the parse tree
	 */
	void exitSizeof_expression(@NotNull FunctionParser.Sizeof_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#unary_op_and_cast_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op_and_cast_expr(@NotNull FunctionParser.Unary_op_and_cast_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#unary_op_and_cast_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op_and_cast_expr(@NotNull FunctionParser.Unary_op_and_cast_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(@NotNull FunctionParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(@NotNull FunctionParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterInclusive_or_expression(@NotNull FunctionParser.Inclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitInclusive_or_expression(@NotNull FunctionParser.Inclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#base_classes}.
	 * @param ctx the parse tree
	 */
	void enterBase_classes(@NotNull FunctionParser.Base_classesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#base_classes}.
	 * @param ctx the parse tree
	 */
	void exitBase_classes(@NotNull FunctionParser.Base_classesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#incDecOp}.
	 * @param ctx the parse tree
	 */
	void enterIncDecOp(@NotNull FunctionParser.IncDecOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#incDecOp}.
	 * @param ctx the parse tree
	 */
	void exitIncDecOp(@NotNull FunctionParser.IncDecOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#pre_closer}.
	 * @param ctx the parse tree
	 */
	void enterPre_closer(@NotNull FunctionParser.Pre_closerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#pre_closer}.
	 * @param ctx the parse tree
	 */
	void exitPre_closer(@NotNull FunctionParser.Pre_closerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(@NotNull FunctionParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(@NotNull FunctionParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#class_name}.
	 * @param ctx the parse tree
	 */
	void enterClass_name(@NotNull FunctionParser.Class_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#class_name}.
	 * @param ctx the parse tree
	 */
	void exitClass_name(@NotNull FunctionParser.Class_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#param_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_specifiers(@NotNull FunctionParser.Param_decl_specifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#param_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_specifiers(@NotNull FunctionParser.Param_decl_specifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#param_type}.
	 * @param ctx the parse tree
	 */
	void enterParam_type(@NotNull FunctionParser.Param_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#param_type}.
	 * @param ctx the parse tree
	 */
	void exitParam_type(@NotNull FunctionParser.Param_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void enterFunction_argument(@NotNull FunctionParser.Function_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void exitFunction_argument(@NotNull FunctionParser.Function_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#If_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull FunctionParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#If_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull FunctionParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#water}.
	 * @param ctx the parse tree
	 */
	void enterWater(@NotNull FunctionParser.WaterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#water}.
	 * @param ctx the parse tree
	 */
	void exitWater(@NotNull FunctionParser.WaterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#closing_curly}.
	 * @param ctx the parse tree
	 */
	void enterClosing_curly(@NotNull FunctionParser.Closing_curlyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#closing_curly}.
	 * @param ctx the parse tree
	 */
	void exitClosing_curly(@NotNull FunctionParser.Closing_curlyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#for_init_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_init_statement(@NotNull FunctionParser.For_init_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#for_init_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_init_statement(@NotNull FunctionParser.For_init_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(@NotNull FunctionParser.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(@NotNull FunctionParser.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(@NotNull FunctionParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(@NotNull FunctionParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#do_statement1}.
	 * @param ctx the parse tree
	 */
	void enterDo_statement1(@NotNull FunctionParser.Do_statement1Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#do_statement1}.
	 * @param ctx the parse tree
	 */
	void exitDo_statement1(@NotNull FunctionParser.Do_statement1Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(@NotNull FunctionParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(@NotNull FunctionParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void enterInc_dec(@NotNull FunctionParser.Inc_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void exitInc_dec(@NotNull FunctionParser.Inc_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#initDeclSimple}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclSimple(@NotNull FunctionParser.InitDeclSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#initDeclSimple}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclSimple(@NotNull FunctionParser.InitDeclSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#opening_curly}.
	 * @param ctx the parse tree
	 */
	void enterOpening_curly(@NotNull FunctionParser.Opening_curlyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#opening_curly}.
	 * @param ctx the parse tree
	 */
	void exitOpening_curly(@NotNull FunctionParser.Opening_curlyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(@NotNull FunctionParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(@NotNull FunctionParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void enterGotoStatement(@NotNull FunctionParser.GotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void exitGotoStatement(@NotNull FunctionParser.GotoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_brackets}.
	 * @param ctx the parse tree
	 */
	void enterNo_brackets(@NotNull FunctionParser.No_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_brackets}.
	 * @param ctx the parse tree
	 */
	void exitNo_brackets(@NotNull FunctionParser.No_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#bit_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterBit_and_expression(@NotNull FunctionParser.Bit_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#bit_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitBit_and_expression(@NotNull FunctionParser.Bit_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#assign_water}.
	 * @param ctx the parse tree
	 */
	void enterAssign_water(@NotNull FunctionParser.Assign_waterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#assign_water}.
	 * @param ctx the parse tree
	 */
	void exitAssign_water(@NotNull FunctionParser.Assign_waterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#cast_target}.
	 * @param ctx the parse tree
	 */
	void enterCast_target(@NotNull FunctionParser.Cast_targetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#cast_target}.
	 * @param ctx the parse tree
	 */
	void exitCast_target(@NotNull FunctionParser.Cast_targetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(@NotNull FunctionParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(@NotNull FunctionParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#function_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void enterFunction_decl_specifiers(@NotNull FunctionParser.Function_decl_specifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#function_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void exitFunction_decl_specifiers(@NotNull FunctionParser.Function_decl_specifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(@NotNull FunctionParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(@NotNull FunctionParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(@NotNull FunctionParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(@NotNull FunctionParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(@NotNull FunctionParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(@NotNull FunctionParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression(@NotNull FunctionParser.New_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression(@NotNull FunctionParser.New_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#expr_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpr_statement(@NotNull FunctionParser.Expr_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#expr_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpr_statement(@NotNull FunctionParser.Expr_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(@NotNull FunctionParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(@NotNull FunctionParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#base_class}.
	 * @param ctx the parse tree
	 */
	void enterBase_class(@NotNull FunctionParser.Base_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#base_class}.
	 * @param ctx the parse tree
	 */
	void exitBase_class(@NotNull FunctionParser.Base_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#parameter_name}.
	 * @param ctx the parse tree
	 */
	void enterParameter_name(@NotNull FunctionParser.Parameter_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#parameter_name}.
	 * @param ctx the parse tree
	 */
	void exitParameter_name(@NotNull FunctionParser.Parameter_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#access_specifier}.
	 * @param ctx the parse tree
	 */
	void enterAccess_specifier(@NotNull FunctionParser.Access_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#access_specifier}.
	 * @param ctx the parse tree
	 */
	void exitAccess_specifier(@NotNull FunctionParser.Access_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#assign_water_l2}.
	 * @param ctx the parse tree
	 */
	void enterAssign_water_l2(@NotNull FunctionParser.Assign_water_l2Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#assign_water_l2}.
	 * @param ctx the parse tree
	 */
	void exitAssign_water_l2(@NotNull FunctionParser.Assign_water_l2Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#init_declarator_list}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator_list(@NotNull FunctionParser.Init_declarator_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#init_declarator_list}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator_list(@NotNull FunctionParser.Init_declarator_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull FunctionParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull FunctionParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexing(@NotNull FunctionParser.ArrayIndexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexing(@NotNull FunctionParser.ArrayIndexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#Catch_statement}.
	 * @param ctx the parse tree
	 */
	void enterCatch_statement(@NotNull FunctionParser.Catch_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#Catch_statement}.
	 * @param ctx the parse tree
	 */
	void exitCatch_statement(@NotNull FunctionParser.Catch_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull FunctionParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull FunctionParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterExclusive_or_expression(@NotNull FunctionParser.Exclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitExclusive_or_expression(@NotNull FunctionParser.Exclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull FunctionParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull FunctionParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#param_type_id}.
	 * @param ctx the parse tree
	 */
	void enterParam_type_id(@NotNull FunctionParser.Param_type_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#param_type_id}.
	 * @param ctx the parse tree
	 */
	void exitParam_type_id(@NotNull FunctionParser.Param_type_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#initDeclWithCall}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclWithCall(@NotNull FunctionParser.InitDeclWithCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#initDeclWithCall}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclWithCall(@NotNull FunctionParser.InitDeclWithCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(@NotNull FunctionParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(@NotNull FunctionParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#initializer_list}.
	 * @param ctx the parse tree
	 */
	void enterInitializer_list(@NotNull FunctionParser.Initializer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#initializer_list}.
	 * @param ctx the parse tree
	 */
	void exitInitializer_list(@NotNull FunctionParser.Initializer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(@NotNull FunctionParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(@NotNull FunctionParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#normOr}.
	 * @param ctx the parse tree
	 */
	void enterNormOr(@NotNull FunctionParser.NormOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#normOr}.
	 * @param ctx the parse tree
	 */
	void exitNormOr(@NotNull FunctionParser.NormOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#Else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(@NotNull FunctionParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#Else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(@NotNull FunctionParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#sizeof}.
	 * @param ctx the parse tree
	 */
	void enterSizeof(@NotNull FunctionParser.SizeofContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#sizeof}.
	 * @param ctx the parse tree
	 */
	void exitSizeof(@NotNull FunctionParser.SizeofContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#Switch_statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_statement(@NotNull FunctionParser.Switch_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#Switch_statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_statement(@NotNull FunctionParser.Switch_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#Do_statement}.
	 * @param ctx the parse tree
	 */
	void enterDo_statement(@NotNull FunctionParser.Do_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#Do_statement}.
	 * @param ctx the parse tree
	 */
	void exitDo_statement(@NotNull FunctionParser.Do_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_brackets_curlies_or_squares}.
	 * @param ctx the parse tree
	 */
	void enterNo_brackets_curlies_or_squares(@NotNull FunctionParser.No_brackets_curlies_or_squaresContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_brackets_curlies_or_squares}.
	 * @param ctx the parse tree
	 */
	void exitNo_brackets_curlies_or_squares(@NotNull FunctionParser.No_brackets_curlies_or_squaresContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#While_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(@NotNull FunctionParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#While_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(@NotNull FunctionParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull FunctionParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull FunctionParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#primaryOnly}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryOnly(@NotNull FunctionParser.PrimaryOnlyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#primaryOnly}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryOnly(@NotNull FunctionParser.PrimaryOnlyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#sizeof_operand2}.
	 * @param ctx the parse tree
	 */
	void enterSizeof_operand2(@NotNull FunctionParser.Sizeof_operand2Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#sizeof_operand2}.
	 * @param ctx the parse tree
	 */
	void exitSizeof_operand2(@NotNull FunctionParser.Sizeof_operand2Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_brackets_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterNo_brackets_or_semicolon(@NotNull FunctionParser.No_brackets_or_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_brackets_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitNo_brackets_or_semicolon(@NotNull FunctionParser.No_brackets_or_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#no_curlies}.
	 * @param ctx the parse tree
	 */
	void enterNo_curlies(@NotNull FunctionParser.No_curliesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#no_curlies}.
	 * @param ctx the parse tree
	 */
	void exitNo_curlies(@NotNull FunctionParser.No_curliesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquality_operator(@NotNull FunctionParser.Equality_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquality_operator(@NotNull FunctionParser.Equality_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#param_type_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_type_list(@NotNull FunctionParser.Param_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#param_type_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_type_list(@NotNull FunctionParser.Param_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull FunctionParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull FunctionParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#simple_decl}.
	 * @param ctx the parse tree
	 */
	void enterSimple_decl(@NotNull FunctionParser.Simple_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#simple_decl}.
	 * @param ctx the parse tree
	 */
	void exitSimple_decl(@NotNull FunctionParser.Simple_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#block_starter}.
	 * @param ctx the parse tree
	 */
	void enterBlock_starter(@NotNull FunctionParser.Block_starterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#block_starter}.
	 * @param ctx the parse tree
	 */
	void exitBlock_starter(@NotNull FunctionParser.Block_starterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_operator(@NotNull FunctionParser.Assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_operator(@NotNull FunctionParser.Assignment_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(@NotNull FunctionParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(@NotNull FunctionParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(@NotNull FunctionParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(@NotNull FunctionParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#ptrs}.
	 * @param ctx the parse tree
	 */
	void enterPtrs(@NotNull FunctionParser.PtrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#ptrs}.
	 * @param ctx the parse tree
	 */
	void exitPtrs(@NotNull FunctionParser.PtrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#initDeclWithAssign}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclWithAssign(@NotNull FunctionParser.InitDeclWithAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#initDeclWithAssign}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclWithAssign(@NotNull FunctionParser.InitDeclWithAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull FunctionParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull FunctionParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(@NotNull FunctionParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(@NotNull FunctionParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#ptr_operator}.
	 * @param ctx the parse tree
	 */
	void enterPtr_operator(@NotNull FunctionParser.Ptr_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#ptr_operator}.
	 * @param ctx the parse tree
	 */
	void exitPtr_operator(@NotNull FunctionParser.Ptr_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(@NotNull FunctionParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(@NotNull FunctionParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(@NotNull FunctionParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(@NotNull FunctionParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#template_param_list}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_param_list(@NotNull FunctionParser.Template_param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#template_param_list}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_param_list(@NotNull FunctionParser.Template_param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#declByType}.
	 * @param ctx the parse tree
	 */
	void enterDeclByType(@NotNull FunctionParser.DeclByTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#declByType}.
	 * @param ctx the parse tree
	 */
	void exitDeclByType(@NotNull FunctionParser.DeclByTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#sizeof_operand}.
	 * @param ctx the parse tree
	 */
	void enterSizeof_operand(@NotNull FunctionParser.Sizeof_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#sizeof_operand}.
	 * @param ctx the parse tree
	 */
	void exitSizeof_operand(@NotNull FunctionParser.Sizeof_operandContext ctx);
}