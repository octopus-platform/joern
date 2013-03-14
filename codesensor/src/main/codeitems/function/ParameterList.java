package main.codeitems.function;

import java.util.LinkedList;

import main.ParseTreeUtils;
import main.codeitems.CodeItem;

public class ParameterList extends CodeItem
{
	public LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	public ParameterList()
	{
		nodeTypeName = "PARAMETER_LIST";
	}
	
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		codeStr = ParseTreeUtils.childTokenString(rootRule);
		return codeStr;
	}

}
