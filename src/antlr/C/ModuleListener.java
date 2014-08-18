// Generated from src/antlr/C/Module.g4 by ANTLR 4.2.1-SNAPSHOT

	package antlr.C;


  import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ModuleParser}.
 */
public interface ModuleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ModuleParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(@NotNull ModuleParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(@NotNull ModuleParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#template_decl_start}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_decl_start(@NotNull ModuleParser.Template_decl_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#template_decl_start}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_decl_start(@NotNull ModuleParser.Template_decl_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#function_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void enterFunction_decl_specifiers(@NotNull ModuleParser.Function_decl_specifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#function_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void exitFunction_decl_specifiers(@NotNull ModuleParser.Function_decl_specifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#type_suffix}.
	 * @param ctx the parse tree
	 */
	void enterType_suffix(@NotNull ModuleParser.Type_suffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#type_suffix}.
	 * @param ctx the parse tree
	 */
	void exitType_suffix(@NotNull ModuleParser.Type_suffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#function_argument_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_argument_list(@NotNull ModuleParser.Function_argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#function_argument_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_argument_list(@NotNull ModuleParser.Function_argument_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#cndExpr}.
	 * @param ctx the parse tree
	 */
	void enterCndExpr(@NotNull ModuleParser.CndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#cndExpr}.
	 * @param ctx the parse tree
	 */
	void exitCndExpr(@NotNull ModuleParser.CndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(@NotNull ModuleParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(@NotNull ModuleParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(@NotNull ModuleParser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(@NotNull ModuleParser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_squares_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterNo_squares_or_semicolon(@NotNull ModuleParser.No_squares_or_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_squares_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitNo_squares_or_semicolon(@NotNull ModuleParser.No_squares_or_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(@NotNull ModuleParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(@NotNull ModuleParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void enterCast_expression(@NotNull ModuleParser.Cast_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void exitCast_expression(@NotNull ModuleParser.Cast_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_angle_brackets_or_brackets}.
	 * @param ctx the parse tree
	 */
	void enterNo_angle_brackets_or_brackets(@NotNull ModuleParser.No_angle_brackets_or_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_angle_brackets_or_brackets}.
	 * @param ctx the parse tree
	 */
	void exitNo_angle_brackets_or_brackets(@NotNull ModuleParser.No_angle_brackets_or_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(@NotNull ModuleParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(@NotNull ModuleParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#parameter_decl_clause}.
	 * @param ctx the parse tree
	 */
	void enterParameter_decl_clause(@NotNull ModuleParser.Parameter_decl_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#parameter_decl_clause}.
	 * @param ctx the parse tree
	 */
	void exitParameter_decl_clause(@NotNull ModuleParser.Parameter_decl_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_comma_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterNo_comma_or_semicolon(@NotNull ModuleParser.No_comma_or_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_comma_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitNo_comma_or_semicolon(@NotNull ModuleParser.No_comma_or_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression(@NotNull ModuleParser.New_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression(@NotNull ModuleParser.New_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(@NotNull ModuleParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(@NotNull ModuleParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#base_class}.
	 * @param ctx the parse tree
	 */
	void enterBase_class(@NotNull ModuleParser.Base_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#base_class}.
	 * @param ctx the parse tree
	 */
	void exitBase_class(@NotNull ModuleParser.Base_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(@NotNull ModuleParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(@NotNull ModuleParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#parameter_name}.
	 * @param ctx the parse tree
	 */
	void enterParameter_name(@NotNull ModuleParser.Parameter_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#parameter_name}.
	 * @param ctx the parse tree
	 */
	void exitParameter_name(@NotNull ModuleParser.Parameter_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#ctor_list}.
	 * @param ctx the parse tree
	 */
	void enterCtor_list(@NotNull ModuleParser.Ctor_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#ctor_list}.
	 * @param ctx the parse tree
	 */
	void exitCtor_list(@NotNull ModuleParser.Ctor_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#access_specifier}.
	 * @param ctx the parse tree
	 */
	void enterAccess_specifier(@NotNull ModuleParser.Access_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#access_specifier}.
	 * @param ctx the parse tree
	 */
	void exitAccess_specifier(@NotNull ModuleParser.Access_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#ctor_expr}.
	 * @param ctx the parse tree
	 */
	void enterCtor_expr(@NotNull ModuleParser.Ctor_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#ctor_expr}.
	 * @param ctx the parse tree
	 */
	void exitCtor_expr(@NotNull ModuleParser.Ctor_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#init_declarator_list}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator_list(@NotNull ModuleParser.Init_declarator_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#init_declarator_list}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator_list(@NotNull ModuleParser.Init_declarator_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#assign_water_l2}.
	 * @param ctx the parse tree
	 */
	void enterAssign_water_l2(@NotNull ModuleParser.Assign_water_l2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#assign_water_l2}.
	 * @param ctx the parse tree
	 */
	void exitAssign_water_l2(@NotNull ModuleParser.Assign_water_l2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator(@NotNull ModuleParser.Init_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator(@NotNull ModuleParser.Init_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexing(@NotNull ModuleParser.ArrayIndexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexing(@NotNull ModuleParser.ArrayIndexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#parameter_decl}.
	 * @param ctx the parse tree
	 */
	void enterParameter_decl(@NotNull ModuleParser.Parameter_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#parameter_decl}.
	 * @param ctx the parse tree
	 */
	void exitParameter_decl(@NotNull ModuleParser.Parameter_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull ModuleParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull ModuleParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBase_type(@NotNull ModuleParser.Base_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBase_type(@NotNull ModuleParser.Base_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(@NotNull ModuleParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(@NotNull ModuleParser.Return_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(@NotNull ModuleParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(@NotNull ModuleParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#ctor_initializer}.
	 * @param ctx the parse tree
	 */
	void enterCtor_initializer(@NotNull ModuleParser.Ctor_initializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#ctor_initializer}.
	 * @param ctx the parse tree
	 */
	void exitCtor_initializer(@NotNull ModuleParser.Ctor_initializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterExclusive_or_expression(@NotNull ModuleParser.Exclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitExclusive_or_expression(@NotNull ModuleParser.Exclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#assign_expr_w_}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr_w_(@NotNull ModuleParser.Assign_expr_w_Context ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#assign_expr_w_}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr_w_(@NotNull ModuleParser.Assign_expr_w_Context ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#param_type_id}.
	 * @param ctx the parse tree
	 */
	void enterParam_type_id(@NotNull ModuleParser.Param_type_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#param_type_id}.
	 * @param ctx the parse tree
	 */
	void exitParam_type_id(@NotNull ModuleParser.Param_type_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#ptrMemberAccess}.
	 * @param ctx the parse tree
	 */
	void enterPtrMemberAccess(@NotNull ModuleParser.PtrMemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#ptrMemberAccess}.
	 * @param ctx the parse tree
	 */
	void exitPtrMemberAccess(@NotNull ModuleParser.PtrMemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#initializer_list}.
	 * @param ctx the parse tree
	 */
	void enterInitializer_list(@NotNull ModuleParser.Initializer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#initializer_list}.
	 * @param ctx the parse tree
	 */
	void exitInitializer_list(@NotNull ModuleParser.Initializer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(@NotNull ModuleParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(@NotNull ModuleParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_squares}.
	 * @param ctx the parse tree
	 */
	void enterNo_squares(@NotNull ModuleParser.No_squaresContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_squares}.
	 * @param ctx the parse tree
	 */
	void exitNo_squares(@NotNull ModuleParser.No_squaresContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(@NotNull ModuleParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(@NotNull ModuleParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#declByClass}.
	 * @param ctx the parse tree
	 */
	void enterDeclByClass(@NotNull ModuleParser.DeclByClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#declByClass}.
	 * @param ctx the parse tree
	 */
	void exitDeclByClass(@NotNull ModuleParser.DeclByClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShift_expression(@NotNull ModuleParser.Shift_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShift_expression(@NotNull ModuleParser.Shift_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#normOr}.
	 * @param ctx the parse tree
	 */
	void enterNormOr(@NotNull ModuleParser.NormOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#normOr}.
	 * @param ctx the parse tree
	 */
	void exitNormOr(@NotNull ModuleParser.NormOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#sizeof}.
	 * @param ctx the parse tree
	 */
	void enterSizeof(@NotNull ModuleParser.SizeofContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#sizeof}.
	 * @param ctx the parse tree
	 */
	void exitSizeof(@NotNull ModuleParser.SizeofContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(@NotNull ModuleParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(@NotNull ModuleParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_brackets_curlies_or_squares}.
	 * @param ctx the parse tree
	 */
	void enterNo_brackets_curlies_or_squares(@NotNull ModuleParser.No_brackets_curlies_or_squaresContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_brackets_curlies_or_squares}.
	 * @param ctx the parse tree
	 */
	void exitNo_brackets_curlies_or_squares(@NotNull ModuleParser.No_brackets_curlies_or_squaresContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#sizeof_expression}.
	 * @param ctx the parse tree
	 */
	void enterSizeof_expression(@NotNull ModuleParser.Sizeof_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#sizeof_expression}.
	 * @param ctx the parse tree
	 */
	void exitSizeof_expression(@NotNull ModuleParser.Sizeof_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull ModuleParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull ModuleParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#unary_op_and_cast_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op_and_cast_expr(@NotNull ModuleParser.Unary_op_and_cast_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#unary_op_and_cast_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op_and_cast_expr(@NotNull ModuleParser.Unary_op_and_cast_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(@NotNull ModuleParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(@NotNull ModuleParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#primaryOnly}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryOnly(@NotNull ModuleParser.PrimaryOnlyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#primaryOnly}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryOnly(@NotNull ModuleParser.PrimaryOnlyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterInclusive_or_expression(@NotNull ModuleParser.Inclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitInclusive_or_expression(@NotNull ModuleParser.Inclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#sizeof_operand2}.
	 * @param ctx the parse tree
	 */
	void enterSizeof_operand2(@NotNull ModuleParser.Sizeof_operand2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#sizeof_operand2}.
	 * @param ctx the parse tree
	 */
	void exitSizeof_operand2(@NotNull ModuleParser.Sizeof_operand2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#function_param_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_param_list(@NotNull ModuleParser.Function_param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#function_param_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_param_list(@NotNull ModuleParser.Function_param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_brackets_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterNo_brackets_or_semicolon(@NotNull ModuleParser.No_brackets_or_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_brackets_or_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitNo_brackets_or_semicolon(@NotNull ModuleParser.No_brackets_or_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#base_classes}.
	 * @param ctx the parse tree
	 */
	void enterBase_classes(@NotNull ModuleParser.Base_classesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#base_classes}.
	 * @param ctx the parse tree
	 */
	void exitBase_classes(@NotNull ModuleParser.Base_classesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#incDecOp}.
	 * @param ctx the parse tree
	 */
	void enterIncDecOp(@NotNull ModuleParser.IncDecOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#incDecOp}.
	 * @param ctx the parse tree
	 */
	void exitIncDecOp(@NotNull ModuleParser.IncDecOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_curlies}.
	 * @param ctx the parse tree
	 */
	void enterNo_curlies(@NotNull ModuleParser.No_curliesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_curlies}.
	 * @param ctx the parse tree
	 */
	void exitNo_curlies(@NotNull ModuleParser.No_curliesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquality_operator(@NotNull ModuleParser.Equality_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquality_operator(@NotNull ModuleParser.Equality_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#param_type_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_type_list(@NotNull ModuleParser.Param_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#param_type_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_type_list(@NotNull ModuleParser.Param_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull ModuleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull ModuleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#class_name}.
	 * @param ctx the parse tree
	 */
	void enterClass_name(@NotNull ModuleParser.Class_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#class_name}.
	 * @param ctx the parse tree
	 */
	void exitClass_name(@NotNull ModuleParser.Class_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(@NotNull ModuleParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(@NotNull ModuleParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#simple_decl}.
	 * @param ctx the parse tree
	 */
	void enterSimple_decl(@NotNull ModuleParser.Simple_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#simple_decl}.
	 * @param ctx the parse tree
	 */
	void exitSimple_decl(@NotNull ModuleParser.Simple_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#param_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_specifiers(@NotNull ModuleParser.Param_decl_specifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#param_decl_specifiers}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_specifiers(@NotNull ModuleParser.Param_decl_specifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_operator(@NotNull ModuleParser.Assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_operator(@NotNull ModuleParser.Assignment_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#param_type}.
	 * @param ctx the parse tree
	 */
	void enterParam_type(@NotNull ModuleParser.Param_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#param_type}.
	 * @param ctx the parse tree
	 */
	void exitParam_type(@NotNull ModuleParser.Param_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#type_id_list}.
	 * @param ctx the parse tree
	 */
	void enterType_id_list(@NotNull ModuleParser.Type_id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#type_id_list}.
	 * @param ctx the parse tree
	 */
	void exitType_id_list(@NotNull ModuleParser.Type_id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void enterFunction_argument(@NotNull ModuleParser.Function_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void exitFunction_argument(@NotNull ModuleParser.Function_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(@NotNull ModuleParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(@NotNull ModuleParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#ptrs}.
	 * @param ctx the parse tree
	 */
	void enterPtrs(@NotNull ModuleParser.PtrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#ptrs}.
	 * @param ctx the parse tree
	 */
	void exitPtrs(@NotNull ModuleParser.PtrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#constant_expr_w_}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expr_w_(@NotNull ModuleParser.Constant_expr_w_Context ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#constant_expr_w_}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expr_w_(@NotNull ModuleParser.Constant_expr_w_Context ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#water}.
	 * @param ctx the parse tree
	 */
	void enterWater(@NotNull ModuleParser.WaterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#water}.
	 * @param ctx the parse tree
	 */
	void exitWater(@NotNull ModuleParser.WaterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(@NotNull ModuleParser.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(@NotNull ModuleParser.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull ModuleParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull ModuleParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#assign_expr_w__l2}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr_w__l2(@NotNull ModuleParser.Assign_expr_w__l2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#assign_expr_w__l2}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr_w__l2(@NotNull ModuleParser.Assign_expr_w__l2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#function_def}.
	 * @param ctx the parse tree
	 */
	void enterFunction_def(@NotNull ModuleParser.Function_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#function_def}.
	 * @param ctx the parse tree
	 */
	void exitFunction_def(@NotNull ModuleParser.Function_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#using_directive}.
	 * @param ctx the parse tree
	 */
	void enterUsing_directive(@NotNull ModuleParser.Using_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#using_directive}.
	 * @param ctx the parse tree
	 */
	void exitUsing_directive(@NotNull ModuleParser.Using_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(@NotNull ModuleParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(@NotNull ModuleParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#ptr_operator}.
	 * @param ctx the parse tree
	 */
	void enterPtr_operator(@NotNull ModuleParser.Ptr_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#ptr_operator}.
	 * @param ctx the parse tree
	 */
	void exitPtr_operator(@NotNull ModuleParser.Ptr_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(@NotNull ModuleParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(@NotNull ModuleParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(@NotNull ModuleParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(@NotNull ModuleParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#initializer_id}.
	 * @param ctx the parse tree
	 */
	void enterInitializer_id(@NotNull ModuleParser.Initializer_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#initializer_id}.
	 * @param ctx the parse tree
	 */
	void exitInitializer_id(@NotNull ModuleParser.Initializer_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void enterInc_dec(@NotNull ModuleParser.Inc_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void exitInc_dec(@NotNull ModuleParser.Inc_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(@NotNull ModuleParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(@NotNull ModuleParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(@NotNull ModuleParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(@NotNull ModuleParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#exception_specification}.
	 * @param ctx the parse tree
	 */
	void enterException_specification(@NotNull ModuleParser.Exception_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#exception_specification}.
	 * @param ctx the parse tree
	 */
	void exitException_specification(@NotNull ModuleParser.Exception_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#template_param_list}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_param_list(@NotNull ModuleParser.Template_param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#template_param_list}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_param_list(@NotNull ModuleParser.Template_param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#declByType}.
	 * @param ctx the parse tree
	 */
	void enterDeclByType(@NotNull ModuleParser.DeclByTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#declByType}.
	 * @param ctx the parse tree
	 */
	void exitDeclByType(@NotNull ModuleParser.DeclByTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#parameter_id}.
	 * @param ctx the parse tree
	 */
	void enterParameter_id(@NotNull ModuleParser.Parameter_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#parameter_id}.
	 * @param ctx the parse tree
	 */
	void exitParameter_id(@NotNull ModuleParser.Parameter_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#sizeof_operand}.
	 * @param ctx the parse tree
	 */
	void enterSizeof_operand(@NotNull ModuleParser.Sizeof_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#sizeof_operand}.
	 * @param ctx the parse tree
	 */
	void exitSizeof_operand(@NotNull ModuleParser.Sizeof_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#no_brackets}.
	 * @param ctx the parse tree
	 */
	void enterNo_brackets(@NotNull ModuleParser.No_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#no_brackets}.
	 * @param ctx the parse tree
	 */
	void exitNo_brackets(@NotNull ModuleParser.No_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#bit_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterBit_and_expression(@NotNull ModuleParser.Bit_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#bit_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitBit_and_expression(@NotNull ModuleParser.Bit_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(@NotNull ModuleParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(@NotNull ModuleParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#assign_water}.
	 * @param ctx the parse tree
	 */
	void enterAssign_water(@NotNull ModuleParser.Assign_waterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#assign_water}.
	 * @param ctx the parse tree
	 */
	void exitAssign_water(@NotNull ModuleParser.Assign_waterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModuleParser#cast_target}.
	 * @param ctx the parse tree
	 */
	void enterCast_target(@NotNull ModuleParser.Cast_targetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModuleParser#cast_target}.
	 * @param ctx the parse tree
	 */
	void exitCast_target(@NotNull ModuleParser.Cast_targetContext ctx);
}