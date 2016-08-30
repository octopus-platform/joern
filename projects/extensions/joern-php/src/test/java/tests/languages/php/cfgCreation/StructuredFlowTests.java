package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cfg.CFG;
import cfg.CFGEdge;
import cfg.nodes.CFGNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;

public class StructuredFlowTests extends PHPCSVFunctionConverterBasedTest {

	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "cfgCreation");
	}
	
	
	/**
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */
	@Test
	public void testIfAndElseIf() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testIf");
		
		assertEquals( 5, cfg.getVertices().size());
		assertEquals( 7, cfg.getEdges().size());
		
		// Make sure there is exactly one condition node for each predicate
		assertEquals( 3, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), 8, CFGEdge.EMPTY_LABEL));;
		assertTrue( edgeExists( cfg, 8, cfg.getExitNode(), CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 8, 12, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 12, cfg.getExitNode(), CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 12, 16, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 16, cfg.getExitNode(), CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 16, cfg.getExitNode(), CFGEdge.FALSE_LABEL));
	}

	/**
	 * while($foo) {}
	 * while(true) {}
	 * while(somecall()) {}
	 * while($var === 1) {}
	 */
	@Test
	public void testWhile() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testWhile");

		assertEquals( 6, cfg.getVertices().size());
		assertEquals( 9, cfg.getEdges().size());
		
		// Make sure there is exactly one condition node for each predicate
		assertEquals( 4, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), 7, CFGEdge.EMPTY_LABEL));;
		assertTrue( edgeExists( cfg, 7, 7, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 7, 11, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 11, 11, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 11, 16, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 16, 16, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 16, 22, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 22, 22, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 22, cfg.getExitNode(), CFGEdge.FALSE_LABEL));
	}

	/**
	 * do {} while($foo);
	 * do {} while(true);
	 * do {} while(somecall());
	 * do {} while($var === 1);
	 */
	@Test
	public void testDo() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testDo");

		assertEquals( 6, cfg.getVertices().size());
		assertEquals( 9, cfg.getEdges().size());
		
		// Make sure there is exactly one condition node for each predicate
		assertEquals( 4, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), 8, CFGEdge.EMPTY_LABEL));;
		assertTrue( edgeExists( cfg, 8, 8, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 8, 12, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 12, 12, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 12, 17, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 17, 17, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 17, 23, CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 23, 23, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 23, cfg.getExitNode(), CFGEdge.FALSE_LABEL));
	}


	/**
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */
	@Test
	public void testFor() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testFor");

		assertEquals( 5, cfg.getVertices().size());
		assertEquals( 5, cfg.getEdges().size());
		
		// TODO actually, there should be an ASTNodeContainer for each expression in an expression list
		assertEquals( 3, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), 7, CFGEdge.EMPTY_LABEL));;
		assertTrue( edgeExists( cfg, 7, 16, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists( cfg, 16, 21, CFGEdge.TRUE_LABEL));
		assertTrue( edgeExists( cfg, 16, cfg.getExitNode(), CFGEdge.FALSE_LABEL));
		assertTrue( edgeExists( cfg, 21, 16, CFGEdge.EMPTY_LABEL));
	}

	/**
	 * function foo(int $bar = 3, string $buz = "yabadabadoo") {}
	 */
	@Test
	public void testParams() throws IOException, InvalidCSVFile
	{
		HashMap<String,CFG> cfgs = getAllCFGsForCSVFiles( "testParameterList");

		CFG cfg = cfgs.get( "foo");
		
		assertEquals( 4, cfg.getVertices().size());
		assertEquals( 3, cfg.getEdges().size());
		
		assertEquals( 2, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		List<CFGNode> parameters = cfg.getParameters();
		
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), parameters.get(0), CFGEdge.EMPTY_LABEL));;
		assertTrue( edgeExists( cfg, parameters.get(0), parameters.get(1), CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists( cfg, parameters.get(1), cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

	/**
	 * function foo( $x) {
	 *   return $x + 1;
	 * }
	 */
	@Test
	public void testFuncWithParams() throws IOException, InvalidCSVFile
	{
		HashMap<String,CFG> cfgs = getAllCFGsForCSVFiles( "testFuncWithParams");

		CFG cfg = cfgs.get( "foo");

		assertEquals( 4, cfg.getVertices().size());
		assertEquals( 3, cfg.getEdges().size());
		
		assertEquals( 2, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		List<CFGNode> parameters = cfg.getParameters();
		@SuppressWarnings("unused")
		List<CFGNode> returns = cfg.getReturnStatements();
		
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), parameters.get(0), CFGEdge.EMPTY_LABEL));;
		
		// TODO something is not working here: 'returns' is an empty list, so we cannot test the following:
		//assertTrue( edgeExists( cfg, parameters.get(0), returns.get(0), CFGEdge.EMPTY_LABEL));
		//assertTrue( edgeExists( cfg, returns.get(0), cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
		
		// instead, we do this for now:
		assertTrue( edgeExists( cfg, parameters.get(0), 16, CFGEdge.EMPTY_LABEL));
		assertTrue( edgeExists( cfg, 16, cfg.getExitNode(), CFGEdge.EMPTY_LABEL));
	}

    /**
     * foreach ($somearray as $foo) {}
     * foreach (somecall() as $bar => $buz) {}
     * foreach ($someobj->qux as $someobj->norf => $someobj->nicknack) {}
     */
	@Test
	public void testForEach() throws IOException, InvalidCSVFile
	{
		CFG cfg = getTopCFGForCSVFiles( "testForEach");
		
		assertEquals( 5, cfg.getVertices().size());
		assertEquals( 7, cfg.getEdges().size());
		
		assertEquals( 3, getNodesOfType(cfg, "ASTNodeContainer").size());
		
		// TODO currently, we regard the iterated object as the condition and
		// completely ignore the defined key/value pair. This should be improved
		// by explicitly considering a ForEachCondition as the condition. For this,
		// we have to
		// (1) modify the parser to actually generate a ForEachCondition AST node,
		//     so that this condition has an explicit node id
		// (2) modify the def/use analysis to cope with ForEachConditions (which "use"
		//     the iterated object and "define" the key and the value)
		assertTrue( edgeExists( cfg, cfg.getEntryNode(), 7, CFGEdge.EMPTY_LABEL));;
		assertTrue( edgeExists( cfg, 7, 7, CFGEdge.NEXT_LABEL));
		assertTrue( edgeExists( cfg, 7, 14, CFGEdge.COMPLETE_LABEL));
		assertTrue( edgeExists( cfg, 14, 14, CFGEdge.NEXT_LABEL));
		assertTrue( edgeExists( cfg, 14, 24, CFGEdge.COMPLETE_LABEL));
		assertTrue( edgeExists( cfg, 24, 24, CFGEdge.NEXT_LABEL));
		assertTrue( edgeExists( cfg, 24, cfg.getExitNode(), CFGEdge.COMPLETE_LABEL));
	}

}
