package tests.cfgCreation;

import tests.parseTreeToAST.FunctionContentTestUtil;
import ast.ASTNode;
import cfg.CFG;
import cfg.C.CCFGFactory;
import cfg.nodes.CFGNode;

public class CFGCreatorTest
{
	protected ASTNode getASTForCode(String input)
	{
		return FunctionContentTestUtil.parseAndWalk(input);
	}

	protected CFG getCFGForCode(String input)
	{
		return CCFGFactory.convert(getASTForCode(input));
	}

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
