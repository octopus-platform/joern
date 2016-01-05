package languages.c.cfg;

import cfg.CFGFactory;

public class CCFGFactory extends CFGFactory
{
	public CCFGFactory()
	{
		structuredFlowVisitor =  new CStructuredFlowVisitor();
	}
}
