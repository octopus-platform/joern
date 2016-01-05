package languages.php.cfg;

import ast.statements.blockstarters.IfStatement;
import cfg.CFG;
import cfg.CFGFactory;

public class PHPCFGFactory extends CFGFactory
{
	static{
		structuredFlowVisitior = new PHPStructuredFlowVisitor();
	}

	public static CFG newInstance(IfStatement ifStatement)
	{
		try
		{
			CFG block = new CFG();
			

			return block;
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			return newErrorInstance();
		}
	}

}
