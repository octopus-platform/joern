package languages.c.parsing.Functions.builder;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import ast.ASTNodeBuilder;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.functionDef.ParameterType;
import languages.c.antlr.ModuleParser.Parameter_declContext;
import languages.c.antlr.ModuleParser.Parameter_idContext;
import languages.c.parsing.ASTNodeFactory;
import parsing.ParseTreeUtils;

public class ParameterListBuilder extends ASTNodeBuilder
{

	ParameterList thisItem;

	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new ParameterList();
		thisItem = (ParameterList) item;
		ASTNodeFactory.initializeFromContext(thisItem, ctx);
	}

	public void addParameter(Parameter_declContext aCtx,
			Stack<ASTNodeBuilder> itemStack)
	{
		Parameter_declContext ctx = (Parameter_declContext) aCtx;
		Parameter_idContext parameter_id = ctx.parameter_id();
		Parameter param = ASTNodeFactory.create(ctx);

		String baseType = ParseTreeUtils
				.childTokenString(ctx.param_decl_specifiers());
		String completeType = determineCompleteType(parameter_id, baseType);

		((ParameterType)param.getType()).setBaseType(baseType);
		((ParameterType)param.getType()).setCompleteType(completeType);

		thisItem.addChild(param);
	}

	public String determineCompleteType(Parameter_idContext parameter_id,
			String baseType)
	{
		String retType = baseType;

		// TODO: use a string-builder here and clean this up.

		// iterate until nesting level is reached
		// where type is given.

		while (parameter_id.parameter_name() == null)
		{

			String newCompleteType = "";

			newCompleteType += "(";

			if (parameter_id.ptrs() != null)
				newCompleteType += ParseTreeUtils
						.childTokenString(parameter_id.ptrs()) + " ";
			if (parameter_id.type_suffix() != null)
				newCompleteType += ParseTreeUtils
						.childTokenString(parameter_id.type_suffix()) + " ";

			newCompleteType += retType;
			newCompleteType += ")";
			retType = newCompleteType;
			parameter_id = parameter_id.parameter_id();
		}

		if (parameter_id.ptrs() != null)
			retType += " "
					+ ParseTreeUtils.childTokenString(parameter_id.ptrs());
		if (parameter_id.type_suffix() != null)
			retType += " " + ParseTreeUtils
					.childTokenString(parameter_id.type_suffix());

		return retType;
	}

}
