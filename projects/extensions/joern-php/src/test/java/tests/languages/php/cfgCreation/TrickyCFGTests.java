package tests.languages.php.cfgCreation;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import cfg.CFG;
import cfg.CFGEdge;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;

public class TrickyCFGTests extends PHPCSVFunctionConverterBasedTest {

	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "cfgCreation");
	}
	

	/**
	 * try {
	 *   foo();
	 *   bar();
	 * }
	 * catch(FooException $f) {
	 *   buz();
	 * }
	 * catch(BarException $b) {
	 *   qux();
	 * }
	 * finally {
	 *   norf();
	 * }
	 */
	@Test
	public void testTrickyTry() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testTrickyTry");

		assertEquals( 8, cfg.getVertices().size());
		assertEquals( 11, cfg.getEdges().size());
		
		assertEquals( 5, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 8, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 8, 12, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 12, 38, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 8, cfg.getExceptionNode(), CFGEdge.EXCEPT_LABEL));
		assertTrue( edgeExists(cfg, 12, cfg.getExceptionNode(), CFGEdge.EXCEPT_LABEL));

		assertTrue( edgeExists(cfg, cfg.getExceptionNode(), 23, CFGEdge.HANDLED_EXCEPT_LABEL));
		assertTrue( edgeExists(cfg, cfg.getExceptionNode(), 33, CFGEdge.HANDLED_EXCEPT_LABEL));
		assertTrue( edgeExists(cfg, cfg.getExceptionNode(), cfg.getExitNode(), CFGEdge.UNHANDLED_EXCEPT_LABEL));

		assertTrue( edgeExists(cfg, 23, 38, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 33, 38, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 38, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * foo();
	 * while(true) {
	 *   while(true) {
	 *     break 2;
	 *   }
	 *   bar();
	 * }
	 * buz();
	 */
	@Test
	public void testTrickyBreak() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testTrickyBreak");

		assertEquals( 8, cfg.getVertices().size());
		assertEquals( 9, cfg.getEdges().size());
		
		assertEquals( 6, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 6, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 6, 11, CFGEdge.EMPTY_LABEL));
		
		assertTrue( edgeExists(cfg, 11, 16, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 11, 26, CFGEdge.FALSE_LABEL));
		
		assertTrue( edgeExists(cfg, 16, 20, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 16, 22, CFGEdge.FALSE_LABEL));

		// the really interesting one: break 2; -> buz();
		// TODO something is not working here: 'cfg.getBreakStatements()' is an empty list,
		// so we cannot test the following:
		//assertTrue( edgeExists(cfg, cfg.getBreakStatements().get(0), 26, CFGEdge.EMPTY_LABEL));
		// instead, we do this for now:
		assertTrue( edgeExists(cfg, 20, 26, CFGEdge.EMPTY_LABEL));

		assertTrue( edgeExists(cfg, 22, 11, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 26, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * foo();
	 * while(true) {
	 *   while(true) {
	 *     while(true) {
	 *       continue 3;
	 *     }
	 *     bar();
	 *   }
	 *   buz();
	 * }
	 * qux();
	 */
	@Test
	public void testTrickyContinue() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testTrickyContinue");

		assertEquals( 10, cfg.getVertices().size());
		assertEquals( 12, cfg.getEdges().size());
		
		assertEquals( 8, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 6, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 6, 11, CFGEdge.EMPTY_LABEL));
		
		assertTrue( edgeExists(cfg, 11, 16, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 11, 35, CFGEdge.FALSE_LABEL));
		
		assertTrue( edgeExists(cfg, 16, 21, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 16, 31, CFGEdge.FALSE_LABEL));

		assertTrue( edgeExists(cfg, 21, 25, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 21, 27, CFGEdge.FALSE_LABEL));
		
		// the really interesting one: continue 3; -> true
		// TODO something is not working here: 'cfg.getContinueStatements()' is an empty list,
		// so we cannot test the following:
		//assertTrue( edgeExists(cfg, cfg.getContinueStatements().get(0), 11, CFGEdge.EMPTY_LABEL));
		// instead, we do this for now:
		assertTrue( edgeExists(cfg, 25, 11, CFGEdge.EMPTY_LABEL));

		assertTrue( edgeExists(cfg, 27, 16, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 31, 11, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 35, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * true ? "foo" : "bar";
	 */
	@Test
	public void testTrickyConditional() throws IOException, InvalidCSVFile
	{
		@SuppressWarnings("unused")
		CFG cfg = getTopCFGForCSVFiles( "testTrickyConditional");

		// TODO
		// still treated as a normal statement;
		// instead of a CFG node for 6,
		// there should be three CFG nodes for nodes 7, 10 and 11,
		// with a [true] edge from 7 to 10 and a [false] edge from 7 to 11.
	}

	/**
	 * foo();
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case "bar":
	 *     bar();
	 *   case 1.42:
	 *   case 2:
	 *     buz();
	 *     break;
	 *   default:
	 *     qux();
	 * }
	 * norf();
	 */
	@Test
	public void testTrickySwitch() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testTrickySwitch");

		assertEquals( 10, cfg.getVertices().size());
		assertEquals( 13, cfg.getEdges().size());
		
		assertEquals( 8, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		// from entry node to first call and from first call to switch condition
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 6, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 6, 11, CFGEdge.EMPTY_LABEL));
		
		// from switch condition to cases
		assertTrue( edgeExists(cfg, 11, 17, "foo"));
		assertTrue( edgeExists(cfg, 11, 22, "bar"));
		assertTrue( edgeExists(cfg, 11, 32, "1.42"));
		assertTrue( edgeExists(cfg, 11, 32, "2"));
		assertTrue( edgeExists(cfg, 11, 41, "default"));

		// within the switch statement
		assertTrue( edgeExists(cfg, 22, 32, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 32, 36, CFGEdge.EMPTY_LABEL));

		// from break statements and last statement to call after switch statement
		assertTrue( edgeExists(cfg, 17, 45, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 36, 45, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 41, 45, CFGEdge.EMPTY_LABEL));
		
		// from last statement to exit node
		assertTrue( edgeExists(cfg, 45, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * "foo" ?? "bar";
	 */
	@Test
	public void testTrickyCoalesce() throws IOException, InvalidCSVFile
	{
		@SuppressWarnings("unused")
		CFG cfg = getTopCFGForCSVFiles( "testTrickyCoalesce");

		// TODO
		// treated as a normal statement; can we do better?
	}

	/**
	 * foo();
	 * foreach( $x as $y) { buz(); }
	 * bar();
	 */
	@Test
	public void testTrickyForEach() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testTrickyForEach");

		// TODO
		// we should consider the entire guard of the foreach-statement, i.e.,
		// the ForEachCondition, as integral part of the AST and a distinguished
		// CFG node. Currently, we only consider the iterated object as condition
		// and ignore the defined key/value pair.
		assertEquals( 6, cfg.getVertices().size());
		assertEquals( 6, cfg.getEdges().size());
		
		assertEquals( 4, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 6, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 6, 11, CFGEdge.EMPTY_LABEL));
		
		assertTrue( edgeExists(cfg, 11, 17, CFGEdge.NEXT_LABEL));
		assertTrue( edgeExists(cfg, 11, 21, CFGEdge.COMPLETE_LABEL));
		assertTrue( edgeExists(cfg, 17, 11, CFGEdge.EMPTY_LABEL));
		
		assertTrue( edgeExists(cfg, 21, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * function foo() {
	 *   yield 42;
	 *   yield $somekey => bar();
	 *   buz();
	 * }
	 *
	 * foo();
	 */
	@Test
	public void testTrickyYield() throws IOException, InvalidCSVFile
	{
		HashMap<String,CFG> cfgs = getAllCFGsForCSVFiles( "testTrickyYield");

		@SuppressWarnings("unused")
		CFG cfg = cfgs.get( "foo");

		// TODO
		// epsilon edges from 12 to 15 and from 15 to 22 are there which is correct in a sense,
		// but should there perhaps be edges from 12 to [EXIT] and from 15 to [EXIT] too?
	}

	/**
	 * function foo() {
	 *   bar();
	 *   yield from norf();
	 *   buz();
	 * }
	 *
	 * foo();
	 */
	@Test
	public void testTrickyYieldFrom() throws IOException, InvalidCSVFile
	{
		HashMap<String,CFG> cfgs = getAllCFGsForCSVFiles( "testTrickyYieldFrom");

		@SuppressWarnings("unused")
		CFG cfg = cfgs.get( "foo");

		// TODO
		// epsilon edge from 16 to 21 which is correct in a sense,
		// but should there perhaps be an edge from 16 to [EXIT] too?
	}


}
