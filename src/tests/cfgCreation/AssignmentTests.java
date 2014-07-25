package tests.cfgCreation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cfg.CFG;

public class AssignmentTests extends CFGCreatorTest
{
	@Test
	public void testSingleAssignmentBlockNumber()
	{
		String input = "x = y;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 3);
	}

	@Test
	public void testAssignmentASTLink()
	{
		String input = "x = 10;";
		CFG cfg = getCFGForCode(input);
		assertTrue(getNodeByCode(cfg, "x = 10") != null);
	}

	@Test
	public void testAssignmentInDecl()
	{
		String input = "int x = 10;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 3);
	}

}
