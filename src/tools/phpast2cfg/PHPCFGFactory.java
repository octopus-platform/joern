package tools.phpast2cfg;

import ast.functionDef.FunctionDef;
import cfg.CFG;
import cfg.CFGFactory;

public class PHPCFGFactory extends CFGFactory
{
	@Override
	public CFG newInstance(FunctionDef functionDefinition)
	{
		return null;
	}
}
