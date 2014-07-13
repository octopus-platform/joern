package astnodes.functionDef;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.ModuleParser.Parameter_declContext;
import antlr.ModuleParser.Parameter_idContext;
import antlr.ModuleParser.Parameter_nameContext;
import astnodes.ASTNode;
import astnodes.expressions.Identifier;

public class Parameter extends ASTNode
{
	public ParameterType type = new ParameterType();
	public Identifier name = new Identifier();

	@Override
	public void initializeFromContext(ParserRuleContext ctx)
	{
		Parameter_declContext paramCtx = (Parameter_declContext) ctx;
		Parameter_nameContext paramName = getNameOfParameter(paramCtx);

		type.initializeFromContext(ctx);
		name.initializeFromContext(paramName);
		super.initializeFromContext(ctx);

		super.addChild(type);
		super.addChild(name);
	}

	private Parameter_nameContext getNameOfParameter(
			Parameter_declContext param_ctx)
	{
		Parameter_idContext parameter_id = param_ctx.parameter_id();

		while (parameter_id.parameter_name() == null)
		{
			parameter_id = parameter_id.parameter_id();
		}
		return parameter_id.parameter_name();
	}

}
