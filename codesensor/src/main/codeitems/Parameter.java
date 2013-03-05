package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_idContext;
import antlr.CodeSensorParser.Parameter_nameContext;

public class Parameter extends NamedCodeItem
{
	public ParameterType type;

	@Override
	public void create(ParserRuleContext ctx, Stack<CodeItem> itemStack)
	{
		Parameter_declContext param_ctx = (Parameter_declContext) ctx;
		nodeTypeName = "PARAMETER";
		type = new ParameterType();
		type.create(param_ctx, itemStack);
		
		Parameter_nameContext paramName = getNameOfParameter(param_ctx);
		
		setName(paramName, itemStack);
		super.create(ctx, itemStack);
	}

	private Parameter_nameContext getNameOfParameter
	(Parameter_declContext param_ctx)
	{
		Parameter_idContext parameter_id = param_ctx.parameter_id();
		
		while(parameter_id.parameter_name() == null){
			parameter_id = parameter_id.parameter_id();
		}
		return parameter_id.parameter_name();
	}

	
}
