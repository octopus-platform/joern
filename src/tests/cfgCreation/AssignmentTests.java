package tests.cfgCreation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import astnodes.ASTNode;
import cfg.BasicBlock;
import cfg.CFG;

public class AssignmentTests extends CFGCreatorTest
{
	@Test
	public void testSingleAssignmentBlockNumber()
	{
		String input = "x = y;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 1);
	}

	
	@Test
	public void testAssignmentASTLink()
	{
		String input = "x = 10;";
		CFG cfg = getCFGForCode(input);
		BasicBlock basicBlock = cfg.getBasicBlocks().get(0);
		ASTNode astNode = basicBlock.getASTNode();
		assertTrue(astNode != null);
		System.out.println(astNode.getClass().getSimpleName());
	}
	
	
	@Test
	public void testAssignmentInDecl()
	{
		String input = "int x = 10;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.getBasicBlocks().size() == 1);
	}
	
	
}
