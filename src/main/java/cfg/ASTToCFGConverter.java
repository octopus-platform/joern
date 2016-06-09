package cfg;

import ast.functionDef.FunctionDef;
import languages.c.cfg.CCFGFactory;
import languages.php.cfg.PHPCFGFactory;

public class ASTToCFGConverter
{

	CFGFactory factory = new CCFGFactory();

	public void setLanguage(String language)
	{
		if(language.equals("PHP"))
			factory = new PHPCFGFactory();
	}

	public CFG convert(FunctionDef node)
	{
		// currently, we just use the C-CFG-factory.
		// In the future, this is where we can choose
		// the factory based on the language.

		return factory.newInstance(node);
	}
}
