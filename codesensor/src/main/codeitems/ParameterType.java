package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_idContext;
import antlr.CodeSensorParser.PtrsContext;
import antlr.CodeSensorParser.Type_suffixContext;

public class ParameterType extends CodeItem
{
	String completeType;
	String baseType;

	@Override
	public void create(ParserRuleContext aCtx, Stack<CodeItem> itemStack)
	{
		Parameter_declContext ctx = (Parameter_declContext) aCtx;
		Parameter_idContext parameter_id = ctx.parameter_id();
		
		nodeTypeName = "PARAMETER_TYPE";		
		
		baseType = childTokenString(ctx.param_decl_specifiers());
		String typeName = baseType;
		setCompleteType(parameter_id, baseType);
		
		// use entire parameter as location. It's the best
		// we can do right now.
		super.create(ctx, itemStack);
		codeStr = typeName;
	}

	private void setCompleteType(Parameter_idContext parameter_id, String baseType)
	{
		completeType = baseType;
		
		while(parameter_id.parameter_name() == null){
			// we are not yet at the nesting level
			// where name is given
			
			String newCompleteType = "";
			
			newCompleteType += "(";
			if(parameter_id.ptrs() != null)
				newCompleteType += childTokenString(parameter_id.ptrs()) + " ";
			if(parameter_id.type_suffix() != null)
				newCompleteType += childTokenString(parameter_id.type_suffix()) + " ";
			newCompleteType += completeType;
			newCompleteType += ")";
			completeType = newCompleteType;
			parameter_id = parameter_id.parameter_id();
		}
		
	}

	

}
