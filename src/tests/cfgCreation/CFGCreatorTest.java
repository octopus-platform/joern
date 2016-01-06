package tests.cfgCreation;

import cfg.CFG;
import cfg.nodes.CFGNode;

public class CFGCreatorTest {

	protected CFGNode getNodeByCode(CFG cfg, String code)
	{
		for (CFGNode node : cfg.getVertices())
		{
			if (node.toString().equals("[" + code + "]"))
			{
				return node;
			}
		}
		return null;
	}

	protected boolean contains(CFG cfg, String code)
	{
		return getNodeByCode(cfg, code) != null;
	}

	protected boolean isConnected(CFG cfg, String srcCode, String dstCode)
	{
		return cfg.isConnected(getNodeByCode(cfg, srcCode),
				getNodeByCode(cfg, dstCode));
	}

}
