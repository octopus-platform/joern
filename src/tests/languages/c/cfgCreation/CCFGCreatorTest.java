package tests.languages.c.cfgCreation;

import ast.ASTNode;
import cfg.CFG;
import languages.c.cfg.CCFGFactory;
import tests.CFGCreatorTest;
import tests.languages.c.parseTreeToAST.FunctionContentTestUtil;

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
