package languages.php.cfg;

import ast.functionDef.FunctionDef;
import cfg.CFG;
import cfg.CFGFactory;

public class PHPCFGFactory extends CFGFactory
{

	public PHPCFGFactory()
	{
		structuredFlowVisitor = new PHPStructuredFlowVisitor();
	}

	@Override
	public CFG newInstance(FunctionDef functionDefinition)
	{
		try
		{
			CFG function = newInstance();
			CFG parameterBlock = convert(
					functionDefinition.getParameterList());
			CFG functionBody = convert(functionDefinition.getContent());
			parameterBlock.appendCFG(functionBody);
			function.appendCFG(parameterBlock);

			return function;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}
}
