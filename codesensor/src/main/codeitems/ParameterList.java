package main.codeitems;

import java.util.LinkedList;
import java.util.Stack;

import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_decl_clauseContext;

public class ParameterList extends CodeItem
{
	public LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	public void create(Parameter_decl_clauseContext ctx, Stack<CodeItem> itemStack)
	{
		nodeTypeName = "PARAMETER_LIST";
		super.create(ctx, itemStack);
	}
	
	public void addParameter(Parameter_declContext ctx, Stack<CodeItem> itemStack)
	{
		Parameter param = new Parameter();
		param.create(ctx, itemStack);
		parameters.add(param);
	}

}
