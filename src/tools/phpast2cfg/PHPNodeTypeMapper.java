package tools.phpast2cfg;

import ast.functionDef.FunctionDef;
import inputModules.csv.csv2ast.NodeTypeMapper;

public class PHPNodeTypeMapper extends NodeTypeMapper
{

	@Override
	protected void initMap()
	{
		stringMap.put("AST_METHOD", new FunctionDef().getTypeAsString());
		// TODO: add more types
	}

}
