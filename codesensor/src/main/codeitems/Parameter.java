package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;

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
		
		setName(param_ctx.parameter_name(), itemStack);
		super.create(ctx, itemStack);
	}
	
}
