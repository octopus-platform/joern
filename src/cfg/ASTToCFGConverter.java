package cfg;

import ast.functionDef.FunctionDef;

public class ASTToCFGConverter
{

	public CFG convert(FunctionDef node)
	{
		return CFG.newInstance(node);
	}
}
