package tests.cfgCreation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cfg.CFG;
import cfg.nodes.CFGNode;
import cfg.nodes.InfiniteForNode;

public class OtherTests extends CFGCreatorTest
{

	@Test
	public void testSingleCallBlockNumber()
	{
		String input = "foo();";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 3);
	}

	@Test
	public void testWhileNumberOfBlocks()
	{
		String input = "while(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 4);
	}

	@Test
	public void testDoNumberOfBlocks()
	{
		String input = "do{ bar(); }while(foo);";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 4);
	}

	@Test
	public void testForNumberOfBlocks()
	{
		String input = "for(i = 0; i < 10; i ++){ foo(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 6);
	}

	@Test
	public void testEmptyFor()
	{
		String input = "for(;;){}";
		CFG cfg = getCFGForCode(input);
		CFGNode node = getNodeByCode(cfg, "INFINITE FOR");
		assertTrue(node instanceof InfiniteForNode);
		assertTrue(cfg.size() == 3);
	}
	
	@Test
	public void testSwitchNumberOfEdges()
	{
		String input = "switch(foo){ case 1: case2: case 3: }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.numberOfEdges() == 8);
	}

	@Test
	public void testSwitchWithBreakNumberOfEdges()
	{
		String input = "switch(foo){ case 1: break; case2: break; case 3: }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.numberOfEdges() == 10);
	}

	@Test
	public void testSwitchWithDefaultLabelNumberOfEdges()
	{
		String input = "switch(foo){ case 1: case2: default: }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.numberOfEdges() == 7);
	}

	@Test
	public void testTwoInstructions()
	{
		String input = "x = 10; y = 20;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 4);
	}

	@Test
	public void testLinkBetweenBlocks()
	{
		String input = "x = 10; y = 20;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.numberOfEdges() == 3);
	}

	@Test
	public void testReturnExitBlock()
	{
		// this needs to be parsed as a function
		
		// String input = "int foo() { if(!x) return 1; y = x; return 0; }";
		//
		// CFG cfg = getCFGForCode(input);
		//
		// assertFalse(isConnected(cfg, "return 1 ;", "y = x"));
		// assertTrue(cfg.outDegree(getNodeByCode(cfg, "return 1 ;")) == 1);
		// assertTrue(cfg.outDegree(getNodeByCode(cfg, "return 0 ;")) == 1);
		// assertTrue(isConnected(cfg, "return 1 ;", "EXIT"));
		// assertTrue(isConnected(cfg, "return 0 ;", "EXIT"));
	}

	@Test
	public void testReturnOneExitBlock()
	{
		String input = "if(!x) return 1; y = x;";
		CFG cfg = getCFGForCode(input);

		assertTrue(isConnected(cfg, "y = x", "EXIT"));
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "y = x")) == 1);
	}

	@Test
	public void testGoto()
	{
		// this needs to be parsed as a function

		// String input =
		// "void foo() { x = 0; foo: x++; if(x < 10) goto foo; }";
		// CFG cfg = getCFGForCode(input);
		//
		// assertFalse(isConnected(cfg, "goto foo ;", "EXIT"));
		// assertFalse(isConnected(cfg, "goto foo ;", "foo :"));
		// assertFalse(cfg.outDegree(getNodeByCode(cfg, "goto foo ;")) == 1);
	}

}
