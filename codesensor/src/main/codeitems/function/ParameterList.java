package main.codeitems.function;

import java.util.Iterator;
import java.util.LinkedList;

import main.codeitems.CodeItem;

public class ParameterList extends CodeItem
{
	public LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	public ParameterList()
	{
		nodeTypeName = "PARAMETER_LIST";
	}
	
	@Override
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		if(parameters.size() == 0){
			codeStr = "";
			return codeStr;
		}
		
		Iterator<Parameter> i = parameters.iterator();
		StringBuilder s = new StringBuilder();
		for(; i.hasNext();){
			Parameter param = i.next();
			s.append(param.getCodeStr() + " , ");
		}
		
		codeStr = s.toString();
		codeStr = codeStr.substring(0, s.length() - 3);
		
		return codeStr;
	}

}
