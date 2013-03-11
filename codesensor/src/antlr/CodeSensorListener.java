// Generated from ./CodeSensor.g4 by ANTLR 4.0

	package antlr;
    import java.util.Stack;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface CodeSensorListener extends ParseTreeListener {
	void enterAssign_expr_l2(CodeSensorParser.Assign_expr_l2Context ctx);
	void exitAssign_expr_l2(CodeSensorParser.Assign_expr_l2Context ctx);

	void enterOperator_function_id(CodeSensorParser.Operator_function_idContext ctx);
	void exitOperator_function_id(CodeSensorParser.Operator_function_idContext ctx);

	void enterTemplate_decl_start(CodeSensorParser.Template_decl_startContext ctx);
	void exitTemplate_decl_start(CodeSensorParser.Template_decl_startContext ctx);

	void enterFunction_decl_specifiers(CodeSensorParser.Function_decl_specifiersContext ctx);
	void exitFunction_decl_specifiers(CodeSensorParser.Function_decl_specifiersContext ctx);

	void enterType_suffix(CodeSensorParser.Type_suffixContext ctx);
	void exitType_suffix(CodeSensorParser.Type_suffixContext ctx);

	void enterNo_squares_or_semicolon(CodeSensorParser.No_squares_or_semicolonContext ctx);
	void exitNo_squares_or_semicolon(CodeSensorParser.No_squares_or_semicolonContext ctx);

	void enterCompound_statement(CodeSensorParser.Compound_statementContext ctx);
	void exitCompound_statement(CodeSensorParser.Compound_statementContext ctx);

	void enterAssign_expr(CodeSensorParser.Assign_exprContext ctx);
	void exitAssign_expr(CodeSensorParser.Assign_exprContext ctx);

	void enterNo_angle_brackets_or_brackets(CodeSensorParser.No_angle_brackets_or_bracketsContext ctx);
	void exitNo_angle_brackets_or_brackets(CodeSensorParser.No_angle_brackets_or_bracketsContext ctx);

	void enterNo_comma_or_semicolon(CodeSensorParser.No_comma_or_semicolonContext ctx);
	void exitNo_comma_or_semicolon(CodeSensorParser.No_comma_or_semicolonContext ctx);

	void enterParameter_decl_clause(CodeSensorParser.Parameter_decl_clauseContext ctx);
	void exitParameter_decl_clause(CodeSensorParser.Parameter_decl_clauseContext ctx);

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

	void enterCtor_expr(CodeSensorParser.Ctor_exprContext ctx);
	void exitCtor_expr(CodeSensorParser.Ctor_exprContext ctx);

	void enterDeclaration(CodeSensorParser.DeclarationContext ctx);
	void exitDeclaration(CodeSensorParser.DeclarationContext ctx);

	void enterAssign_water_l2(CodeSensorParser.Assign_water_l2Context ctx);
	void exitAssign_water_l2(CodeSensorParser.Assign_water_l2Context ctx);

	void enterInit_declarator_list(CodeSensorParser.Init_declarator_listContext ctx);
	void exitInit_declarator_list(CodeSensorParser.Init_declarator_listContext ctx);

	void enterInit_declarator(CodeSensorParser.Init_declaratorContext ctx);
	void exitInit_declarator(CodeSensorParser.Init_declaratorContext ctx);

	void enterParameter_decl(CodeSensorParser.Parameter_declContext ctx);
	void exitParameter_decl(CodeSensorParser.Parameter_declContext ctx);

	void enterNumber(CodeSensorParser.NumberContext ctx);
	void exitNumber(CodeSensorParser.NumberContext ctx);

	void enterBase_type(CodeSensorParser.Base_typeContext ctx);
	void exitBase_type(CodeSensorParser.Base_typeContext ctx);

	void enterReturn_type(CodeSensorParser.Return_typeContext ctx);
	void exitReturn_type(CodeSensorParser.Return_typeContext ctx);

	void enterCode(CodeSensorParser.CodeContext ctx);
	void exitCode(CodeSensorParser.CodeContext ctx);

	void enterCtor_initializer(CodeSensorParser.Ctor_initializerContext ctx);
	void exitCtor_initializer(CodeSensorParser.Ctor_initializerContext ctx);

	void enterParam_type_id(CodeSensorParser.Param_type_idContext ctx);
	void exitParam_type_id(CodeSensorParser.Param_type_idContext ctx);

	void enterNo_squares(CodeSensorParser.No_squaresContext ctx);
	void exitNo_squares(CodeSensorParser.No_squaresContext ctx);

	void enterUnary_operator(CodeSensorParser.Unary_operatorContext ctx);
	void exitUnary_operator(CodeSensorParser.Unary_operatorContext ctx);

	void enterCv_qualifier(CodeSensorParser.Cv_qualifierContext ctx);
	void exitCv_qualifier(CodeSensorParser.Cv_qualifierContext ctx);

	void enterDeclByClass(CodeSensorParser.DeclByClassContext ctx);
	void exitDeclByClass(CodeSensorParser.DeclByClassContext ctx);

	void enterType_name(CodeSensorParser.Type_nameContext ctx);
	void exitType_name(CodeSensorParser.Type_nameContext ctx);

	void enterNo_brackets_curlies_or_squares(CodeSensorParser.No_brackets_curlies_or_squaresContext ctx);
	void exitNo_brackets_curlies_or_squares(CodeSensorParser.No_brackets_curlies_or_squaresContext ctx);

	void enterConstant_expr(CodeSensorParser.Constant_exprContext ctx);
	void exitConstant_expr(CodeSensorParser.Constant_exprContext ctx);

	void enterIdentifier(CodeSensorParser.IdentifierContext ctx);
	void exitIdentifier(CodeSensorParser.IdentifierContext ctx);

	void enterFunction_param_list(CodeSensorParser.Function_param_listContext ctx);
	void exitFunction_param_list(CodeSensorParser.Function_param_listContext ctx);

	void enterNo_brackets_or_semicolon(CodeSensorParser.No_brackets_or_semicolonContext ctx);
	void exitNo_brackets_or_semicolon(CodeSensorParser.No_brackets_or_semicolonContext ctx);

	void enterBase_classes(CodeSensorParser.Base_classesContext ctx);
	void exitBase_classes(CodeSensorParser.Base_classesContext ctx);

	void enterNo_curlies(CodeSensorParser.No_curliesContext ctx);
	void exitNo_curlies(CodeSensorParser.No_curliesContext ctx);

	void enterParam_type_list(CodeSensorParser.Param_type_listContext ctx);
	void exitParam_type_list(CodeSensorParser.Param_type_listContext ctx);

	void enterExpr(CodeSensorParser.ExprContext ctx);
	void exitExpr(CodeSensorParser.ExprContext ctx);

	void enterClass_name(CodeSensorParser.Class_nameContext ctx);
	void exitClass_name(CodeSensorParser.Class_nameContext ctx);

	void enterSimple_decl(CodeSensorParser.Simple_declContext ctx);
	void exitSimple_decl(CodeSensorParser.Simple_declContext ctx);

	void enterParam_decl_specifiers(CodeSensorParser.Param_decl_specifiersContext ctx);
	void exitParam_decl_specifiers(CodeSensorParser.Param_decl_specifiersContext ctx);

	void enterAssignment_operator(CodeSensorParser.Assignment_operatorContext ctx);
	void exitAssignment_operator(CodeSensorParser.Assignment_operatorContext ctx);

	void enterParam_type(CodeSensorParser.Param_typeContext ctx);
	void exitParam_type(CodeSensorParser.Param_typeContext ctx);

	void enterType_id_list(CodeSensorParser.Type_id_listContext ctx);
	void exitType_id_list(CodeSensorParser.Type_id_listContext ctx);

	void enterClass_key(CodeSensorParser.Class_keyContext ctx);
	void exitClass_key(CodeSensorParser.Class_keyContext ctx);

	void enterPtrs(CodeSensorParser.PtrsContext ctx);
	void exitPtrs(CodeSensorParser.PtrsContext ctx);

	void enterWater(CodeSensorParser.WaterContext ctx);
	void exitWater(CodeSensorParser.WaterContext ctx);

	void enterConstant(CodeSensorParser.ConstantContext ctx);
	void exitConstant(CodeSensorParser.ConstantContext ctx);

	void enterFunction_def(CodeSensorParser.Function_defContext ctx);
	void exitFunction_def(CodeSensorParser.Function_defContext ctx);

	void enterUsing_directive(CodeSensorParser.Using_directiveContext ctx);
	void exitUsing_directive(CodeSensorParser.Using_directiveContext ctx);

	void enterOperator(CodeSensorParser.OperatorContext ctx);
	void exitOperator(CodeSensorParser.OperatorContext ctx);

	void enterPtr_operator(CodeSensorParser.Ptr_operatorContext ctx);
	void exitPtr_operator(CodeSensorParser.Ptr_operatorContext ctx);

	void enterClass_def(CodeSensorParser.Class_defContext ctx);
	void exitClass_def(CodeSensorParser.Class_defContext ctx);

	void enterInitializer_id(CodeSensorParser.Initializer_idContext ctx);
	void exitInitializer_id(CodeSensorParser.Initializer_idContext ctx);

	void enterTemplate_param_list(CodeSensorParser.Template_param_listContext ctx);
	void exitTemplate_param_list(CodeSensorParser.Template_param_listContext ctx);

	void enterException_specification(CodeSensorParser.Exception_specificationContext ctx);
	void exitException_specification(CodeSensorParser.Exception_specificationContext ctx);

	void enterDeclByType(CodeSensorParser.DeclByTypeContext ctx);
	void exitDeclByType(CodeSensorParser.DeclByTypeContext ctx);

	void enterParameter_id(CodeSensorParser.Parameter_idContext ctx);
	void exitParameter_id(CodeSensorParser.Parameter_idContext ctx);

	void enterPart(CodeSensorParser.PartContext ctx);
	void exitPart(CodeSensorParser.PartContext ctx);

	void enterNo_brackets(CodeSensorParser.No_bracketsContext ctx);
	void exitNo_brackets(CodeSensorParser.No_bracketsContext ctx);

	void enterAssign_water(CodeSensorParser.Assign_waterContext ctx);
	void exitAssign_water(CodeSensorParser.Assign_waterContext ctx);
}