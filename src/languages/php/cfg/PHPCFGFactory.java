package languages.php.cfg;

import cfg.CFGFactory;

public class PHPCFGFactory extends CFGFactory
{

	public PHPCFGFactory()
	{
		structuredFlowVisitor = new PHPStructuredFlowVisitor();
	}

}
