package main.codeitems.function;

import java.util.Stack;

import main.ParseTreeUtils;
import main.codeitems.CodeItemBuilder;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_idContext;

public class ParameterListBuilder extends CodeItemBuilder {

	ParameterList thisItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new ParameterList();
		thisItem = (ParameterList) item;
		thisItem.initializeFromContext(ctx);
	}
	
	public void addParameter(Parameter_declContext aCtx,
			Stack<CodeItemBuilder> itemStack)
	{
		Parameter_declContext ctx = (Parameter_declContext) aCtx;
		Parameter_idContext parameter_id = ctx.parameter_id();
		
		Parameter param = new Parameter();
		param.initializeFromContext(ctx);
		
		String baseType = ParseTreeUtils.childTokenString(ctx.param_decl_specifiers());
		String completeType = determineCompleteType(parameter_id, baseType);
		
		param.type.setBaseType(baseType);
		param.type.setCompleteType(completeType);
		
		thisItem.parameters.add(param);
	}
	
	public String determineCompleteType(Parameter_idContext parameter_id,
									  String baseType)
	{
		String retType = baseType;
		
		// TODO: use a string-builder here and clean this up.
		
		// iterate until nesting level is reached
		// where type is given.
		
		while(parameter_id.parameter_name() == null){
			
			String newCompleteType = "";
			
			newCompleteType += "(";
			
			if(parameter_id.ptrs() != null)
				newCompleteType += ParseTreeUtils.childTokenString(parameter_id.ptrs()) + " ";
			if(parameter_id.type_suffix() != null)
				newCompleteType += ParseTreeUtils.childTokenString(parameter_id.type_suffix()) + " ";
			
			newCompleteType += retType;
			newCompleteType += ")";
			retType = newCompleteType;
			parameter_id = parameter_id.parameter_id();
		}
		
		if(parameter_id.ptrs() != null)
			retType += " " + ParseTreeUtils.childTokenString(parameter_id.ptrs());
		if(parameter_id.type_suffix() != null)
			retType += " " + ParseTreeUtils.childTokenString(parameter_id.type_suffix());
		
		return retType;
	}
	
	
}
