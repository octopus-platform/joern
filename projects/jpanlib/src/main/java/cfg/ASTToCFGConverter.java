package cfg;

import ast.functionDef.FunctionDef;

public class ASTToCFGConverter
{

	private CFGFactory factory;

	public void setFactory(CFGFactory factory)
	{
		// prior to converting a function node,
		// this method should be used to set the
		// CFG factory for a particular language,
		// such as a C CFG factory or a PHP CFG factory.
		
		this.factory = factory;
	}


	public CFG convert(FunctionDef node)
	{
		return factory.newInstance(node);
	}
}
