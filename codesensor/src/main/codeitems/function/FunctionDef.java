package main.codeitems.function;

import main.codeitems.CodeItem;
import main.codeitems.Name;
import main.codeitems.functionContent.CompoundItem;


public class FunctionDef extends CodeItem{

	public Name name;
	public ParameterList parameterList = new ParameterList();
	public ReturnType returnType = null;
	public CompoundItem content;
	
	public FunctionDef()
	{
		nodeTypeName = "FUNCTION_DEF";
	}
	
	@Override
	public String getCodeStr()
	{
		// check if codeStr has already been generated
		if(codeStr != null)
			return codeStr;
		codeStr = getFunctionSignature();
		return codeStr;
	}
	
	public String getFunctionSignature()
	{
		String retval = name.getCodeStr();
		if(parameterList != null)
			retval += " (" + parameterList.getCodeStr() + ")";
		else
			retval += " ()";
		return retval;
	}

	public void setContent(CompoundItem functionContent)
	{
		content = functionContent;
	}
	
}
