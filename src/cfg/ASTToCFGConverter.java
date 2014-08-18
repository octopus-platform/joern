package cfg;

import ast.functionDef.FunctionDef;
import cfg.C.CCFGFactory;

public class ASTToCFGConverter
{

	public CFG convert(FunctionDef node)
	{
		// currently, we just use the C-CFG-factory.
		// In the future, this is where we can choose
		// the factory based on the language.
		
		CCFGFactory factory = new CCFGFactory();
		return factory.newInstance(node);
	}
}
