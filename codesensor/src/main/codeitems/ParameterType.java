package main.codeitems;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;
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
		
		nodeTypeName = "PARAMETER_TYPE";		
		// We want to include the type_suffix in the type-node,
		// e.g., the type of "char buf[256]" should be "char [256]".

		baseType = ctx.param_decl_specifiers().getText();
			
		String typeName = baseType;
		Type_suffixContext type_suffix = ctx.type_suffix();
		PtrsContext ptrs = ctx.ptrs();
			
		if(ptrs != null)
			typeName += " " + ptrs.getText();
		if(type_suffix != null)
			typeName += " " + type_suffix.getText();
		completeType = typeName;
		
	
		// use entire parameter as location. It's the best
		// we can do right now.
		super.create(ctx, itemStack);
		codeStr = typeName;
	}
}
