package languages.c.cfg;

import cfg.CFGFactory;

public class CCFGFactory extends CFGFactory
{

	static{
		structuredFlowVisitior = new CStructuredFlowVisitor();
	}
	
}
