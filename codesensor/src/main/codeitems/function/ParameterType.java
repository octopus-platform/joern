package main.codeitems.function;

import java.util.Stack;

import main.codeitems.CodeItem;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_idContext;
import antlr.CodeSensorParser.PtrsContext;
import antlr.CodeSensorParser.Type_suffixContext;

public class ParameterType extends CodeItem
{
	String completeType;
	String baseType;

	public void setCompleteType(String aCompleteType)
	{
		completeType = aCompleteType;
	}

	public void setBaseType(String aBaseType)
	{
		baseType = aBaseType;
	}
		
	public ParameterType()
	{
		nodeTypeName = "PARAMETER_TYPE";
	}
	
	public void initializeFromContext(ParserRuleContext aCtx)
	{
		
		// use entire parameter as location. It's the best
		// we can do right now.
		super.initializeFromContext(aCtx);
	}	

}
