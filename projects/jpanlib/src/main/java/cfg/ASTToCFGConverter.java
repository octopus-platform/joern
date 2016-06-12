package cfg;

import ast.functionDef.FunctionDef;

public class ASTToCFGConverter
{

	CFGFactory factory;

	public void setFactory(CFGFactory factory)
	{
		this.factory = factory;
	}


	public CFG convert(FunctionDef node)
	{
		// currently, we just use the C-CFG-factory.
		// In the future, this is where we can choose
		// the factory based on the language.

		return factory.newInstance(node);
	}
}
