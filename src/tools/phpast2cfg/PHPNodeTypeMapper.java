package tools.phpast2cfg;

import ast.functionDef.FunctionDef;
import tools.phpast2cfg.csv2ast.NodeTypeMapper;

public class PHPNodeTypeMapper extends NodeTypeMapper
{

	@Override
	protected void initMap()
	{
		stringMap.put("AST_METHOD", new FunctionDef().getSimpleName());
		// TODO: add more types
	}

}
