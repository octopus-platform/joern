package main.codeitems;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Function_defContext;
import antlr.CodeSensorParser.Function_nameContext;
import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_decl_clauseContext;
import antlr.CodeSensorParser.Return_typeContext;

public class FunctionDef extends CodeItem{

	public class FunctionName extends CodeItem
	{
		public void create(ParserRuleContext ctx){
			nodeTypeName = "FUNCTION_NAME"; super.create(ctx);
			}
	}

	public ParameterList parameterList;
	public ReturnType returnType = null;
	public FunctionName name;
		
	@Override
	public void create(ParserRuleContext ctx)
	{	
		nodeTypeName = "FUNCTION_DEF";
		super.create(ctx);
	}

	public void setName(Function_nameContext ctx)
	{
		name = new FunctionName();
		name.create(ctx);
	}

	public void setReturnType(Return_typeContext ctx)
	{
		returnType = new ReturnType();
		returnType.create(ctx);
	}


	public void setParameterList(Parameter_decl_clauseContext ctx)
	{
		parameterList = new ParameterList();
		parameterList.create(ctx);
	}

	public void addParameter(Parameter_declContext ctx)
	{
		parameterList.addParameter(ctx);
		
	}

	public String getFunctionSignature()
	{
		String retval = name.codeStr;
		if(parameterList != null)
			retval += " (" + parameterList.codeStr + ")";
		else
			retval += " ()";
		return retval;
	}

	public void complete(Function_defContext ctx)
	{
		codeStr = getFunctionSignature();
	}
	
}
