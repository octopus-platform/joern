package main.codeitems;

import java.util.LinkedList;

import antlr.CodeSensorParser.Parameter_declContext;
import antlr.CodeSensorParser.Parameter_decl_clauseContext;

public class ParameterList extends CodeItem
{
	public LinkedList<Parameter> parameters = new LinkedList<Parameter>();

	public void create(Parameter_decl_clauseContext ctx)
	{
		nodeTypeName = "PARAMETER_LIST";
		super.create(ctx);
	}
	
	public void addParameter(Parameter_declContext ctx)
	{
		Parameter param = new Parameter();
		param.create(ctx);
		parameters.add(param);
	}

}
