package tests.cfgCreation.c;

import ast.ASTNode;
import cfg.CFG;
import languages.c.cfg.CCFGFactory;
import tests.cfgCreation.CFGCreatorTest;
import tests.parseTreeToAST.FunctionContentTestUtil;

public class CCFGCreatorTest extends CFGCreatorTest
{
	protected ASTNode getASTForCode(String input)
	{
		return FunctionContentTestUtil.parseAndWalk(input);
	}

	protected CFG getCFGForCode(String input)
	{
		return CCFGFactory.convert(getASTForCode(input));
	}

}
