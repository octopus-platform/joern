package main.codeitems.function;

import main.codeitems.CodeItem;

import org.antlr.v4.runtime.ParserRuleContext;

public class ParameterType extends CodeItem
{
	String completeType;
	String baseType;

	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		codeStr = completeType;
		return codeStr;
	}
	
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
