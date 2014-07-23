package tests.cfgCreation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cfg.CFG;
import cfg.nodes.CFGNode;

public class IfBlockTests extends CFGCreatorTest
{

	@Test
	public void testIfStatementNumberOfBlocks()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 4);
	}

	@Test
	public void testElseIfNumberOfBlocks()
	{
		String input = "if(foo) bar(); else if(foo2) bar(2);";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 6);
	}

	@Test
	public void testElseIfElseIfNumberOfBlocks()
	{
		String input = "if(foo1) bar1(); else if(foo2) bar2(); else if(foo3) bar3();";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 8);
	}

	@Test
	public void testIfStatementNumberOfEdges()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.numberOfEdges() == 4);
	}

	@Test
	public void testIfStatementCondition()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);
		CFGNode condition = getNodeByCode(cfg, "foo");
		assertTrue(condition != null);
	}

	@Test
	public void testIfStatementBody()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);

		assertTrue(isConnected(cfg, "foo", "bar ( )"));
	}

	@Test
	public void testIfEdges()
	{
		String input = "if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);

		assertTrue(cfg.numberOfEdges() == 4);
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "foo")) == 2);
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "bar ( )")) == 1);

		assertTrue(isConnected(cfg, "foo", "bar ( )"));
		assertTrue(isConnected(cfg, "foo", "EXIT"));
		assertTrue(isConnected(cfg, "bar ( )", "EXIT"));
	}

	@Test
	public void testIfJoinWithPrevCode()
	{
		String input = "x = 10; if(foo){ bar(); }";
		CFG cfg = getCFGForCode(input);

		assertTrue(cfg.numberOfEdges() == 5);
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "foo")) == 2);
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "bar ( )")) == 1);

		assertTrue(isConnected(cfg, "x = 10", "foo"));
		assertTrue(isConnected(cfg, "foo", "bar ( )"));
		assertTrue(isConnected(cfg, "foo", "EXIT"));
		assertTrue(isConnected(cfg, "bar ( )", "EXIT"));
	}

	@Test
	public void testIfJoinWithNextCode()
	{
		String input = "if(foo){ bar(); } x = 10; ";
		CFG cfg = getCFGForCode(input);

		assertTrue(cfg.numberOfEdges() == 5);
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "foo")) == 2);
		assertTrue(cfg.outDegree(getNodeByCode(cfg, "bar ( )")) == 1);

		assertTrue(isConnected(cfg, "foo", "x = 10"));
		assertTrue(isConnected(cfg, "bar ( )", "x = 10"));
		assertTrue(isConnected(cfg, "foo", "bar ( )"));
		assertTrue(isConnected(cfg, "x = 10", "EXIT"));
	}

	@Test
	public void testEmptyElse()
	{
		// String input = "if(foo) bar(); else {}";
		// CFG cfg = getCFGForCode(input);
	}

	@Test
	public void testEmptyIf()
	{
		// String input = "if(foo){}else bar(); ";
		// CFG cfg = getCFGForCode(input);
	}

	@Test
	public void testIfElseNumberOfBlocks()
	{
		String input = "if(foo){ bar(); }else{ woo(); }";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 5);
	}

}
