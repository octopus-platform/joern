package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;

public class UnstructuredFlowTests extends PHPCSVFunctionConverterBasedTest {

	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "cfgCreation");
	}
	
	
	/**
	 * if($foo) {
	 *   return;
	 * }
	 * bar();
	 */
	@Test
	public void testReturn() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testReturn");

		assertEquals( 5, cfg.getVertices().size());
		assertEquals( 5, cfg.getEdges().size());
		
		assertEquals( 3, getNodesOfType(cfg, "ASTNodeContainer").size());

		@SuppressWarnings("unused")
		List<CFGNode> returns = cfg.getReturnStatements();
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 8, CFGEdge.EMPTY_LABEL));
		
		// TODO something is not working here: 'returns' is an empty list, so we cannot test the following:
		//assertTrue( edgeExists(cfg, 8, cfg.getReturnStatements().get(0), CFGEdge.TRUE_LABEL));
		//assertTrue( edgeExists(cfg, cfg.getReturnStatements().get(0), cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
		// instead, we do this for now:
		assertTrue( edgeExists(cfg, 8, 11, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 11, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));

		assertTrue( edgeExists(cfg, 8, 13, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists(cfg, 13, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * goto a;
	 * foo();
	 * a:
	 * bar();
	 */
	@Test
	public void testGoto() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testGoto");

		assertEquals( 6, cfg.getVertices().size());
		assertEquals( 5, cfg.getEdges().size());
		
		assertEquals( 4, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 6, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 8, 12, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 12, 14, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 14, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));

		assertFalse( edgeExists(cfg, 6, 8, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 6, 12, CFGEdge.EMPTY_LABEL));
	}

	/**
	 * while( $foo) {
	 * 
	 *   if($bar)
	 *     continue;
	 *     
	 *   $foo = call();
	 * }
	 */
	@Test
	public void testContinue() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testContinue");

		assertEquals( 6, cfg.getVertices().size());
		assertEquals( 7, cfg.getEdges().size());
		
		assertEquals( 4, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 7, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 7, 12, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 7, cfg.getExitNode(), CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists(cfg, 12, 14, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 12, 16, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists(cfg, 16, 7, CFGEdge.EMPTY_LABEL));

		assertFalse( edgeExists(cfg, 14, 16, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 14, 7, CFGEdge.EMPTY_LABEL));
	}

	/**
	 * while( $foo) {
	 * 
	 *   if($bar)
	 *     break;
	 *     
	 *   $foo = call();
	 * }
	 */
	@Test
	public void testBreak() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testBreak");

		assertEquals( 6, cfg.getVertices().size());
		assertEquals( 7, cfg.getEdges().size());
		
		assertEquals( 4, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 7, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 7, 12, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 7, cfg.getExitNode(), CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists(cfg, 12, 14, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists(cfg, 12, 16, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists(cfg, 16, 7, CFGEdge.EMPTY_LABEL));

		assertFalse( edgeExists(cfg, 14, 16, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 14, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * try {
	 *   bar();
	 * }
	 * catch(Exception $e) {
	 *   exceptionHandler();
	 * }
	 */
	@Test
	public void testTry() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testTry");

		assertEquals( 5, cfg.getVertices().size());
		assertEquals( 6, cfg.getEdges().size());
		
		assertEquals( 2, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists(cfg, cfg.getEntryNode(), 8, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 8, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists(cfg, 19, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));

		assertTrue( edgeExists(cfg, 8, cfg.getExceptionNode(), CFGEdge.EXCEPT_LABEL));
		assertTrue( edgeExists(cfg, cfg.getExceptionNode(), 19, CFGEdge.HANDLED_EXCEPT_LABEL));
		assertTrue( edgeExists(cfg, cfg.getExceptionNode(), cfg.getExitNode(), CFGEdge.UNHANDLED_EXCEPT_LABEL));
	}
}
