package main.codeitems;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;

public class Parameter extends CodeItem
{
	public ParameterType type;
	public ParameterName name;

	public class ParameterName extends CodeItem
	{
		public void create(ParserRuleContext ctx){
			nodeTypeName = "PARAMETER_NAME"; super.create(ctx);
			}
	}
	
	@Override
	public void create(ParserRuleContext ctx)
	{
		Parameter_declContext param_ctx = (Parameter_declContext) ctx;
		nodeTypeName = "PARAMETER";
		type = new ParameterType();
		type.create(param_ctx);
		name = new ParameterName();
		name.create(param_ctx.parameter_name());
		super.create(ctx);
	}
	
}
