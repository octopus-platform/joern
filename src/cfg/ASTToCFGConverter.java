package cfg;

import astnodes.functionDef.FunctionDef;

public class ASTToCFGConverter
{

	public CFG convert(FunctionDef node)
	{
		return CFG.newInstance(node);
	}
}
