package main.codeitems.function;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.DummyName;
import main.codeitems.Name;
import main.codeitems.functionContent.CompoundItem;


public class FunctionDef extends CodeItem
{

	public Name name = new DummyName();
	public ParameterList parameterList = new ParameterList();
	public ReturnType returnType = new DummyReturnType();
	public CompoundItem content = new CompoundItem();
	
	public FunctionDef()
	{
		nodeTypeName = "function";
	}
	
	public void addParameter(Parameter aParameter)
	{
		parameterList.addParameter(aParameter);
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
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
	
}
