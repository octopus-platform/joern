package tests.languages.php.ddgCreation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ast.ASTNode;
import cfg.CFG;
import ddg.CFGAndUDGToDefUseCFG;
import ddg.DDGCreator;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;
import ddg.DefUseCFG.DefUseCFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.cfg.PHPCFGFactory;
import tests.languages.php.PHPCSVBasedTest;
import tests.languages.php.samples.CSVASTUDGSamples;
import udg.CFGToUDGConverter;
import udg.useDefGraph.UseDefGraph;

public class PHPDDGCreatorTest extends PHPCSVBasedTest {

	/**
	 * Creates an AST for two given CSV strings (nodes and edges), and
	 * returns the AST node with the lowest id.
	 */
	protected ASTNode getASTForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		handle(nodeLines, edgeLines);

		return ast.getNodeWithLowestId();
	}
	
	/**
	 * Creates and returns a CFG for an AST given as two CSV strings (nodes and edges).
	 */
	protected CFG getCFGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		ASTNode rootnode = getASTForCSVLines(nodeLines, edgeLines);

		// This is a bit clumsy: to ensure that the structured flow visitor
		// is initialized correctly, we need to create a PHPCFGFactory
		// object despite the fact that we're only using the factory's static
		// methods.

		PHPCFGFactory phpcfgFactory = new PHPCFGFactory();
		return PHPCFGFactory.convert(rootnode);
	}
	
	/**
	 * Creates and returns a UDG for a given CFG.
	 */
	protected UseDefGraph getUDGForCFG(CFG cfg)
			throws IOException, InvalidCSVFile
	{
		CFGToUDGConverter cfgToUDG = new CFGToUDGConverter();
		cfgToUDG.setLanguage("PHP");
		
		return cfgToUDG.convert(cfg);
	}
	
	/**
	 * Creates and returns a DDG for a given CFG and UDG.
	 */
	private DDG getDDGForCFGAndUDG(CFG cfg, UseDefGraph udg) {
		
		CFGAndUDGToDefUseCFG udgAndCfgToDefUseCFG = new CFGAndUDGToDefUseCFG();
		DefUseCFG defUseCFG = udgAndCfgToDefUseCFG.convert(cfg, udg);

		//System.out.println(defUseCFG);

		DDGCreator ddgCreator = new DDGCreator();
		
		return ddgCreator.createForDefUseCFG(defUseCFG);
	}
	
	/**
	 * Checks whether an edge exists in a given DDG from a given
	 * source node to a given destination node for a given symbol.
	 */
	private boolean edgeExists( DDG ddg, String symbol, long srcid, long dstid) {
		
		for (DefUseRelation ddgEdge : ddg.getDefUseEdges()) {
			if( ddgEdge.symbol.equals(symbol)
					&& ddgEdge.src == ast.getNodeById(srcid)
					&& ddgEdge.dst == ast.getNodeById(dstid))
				return true;
		}

		return false;
	}
	
	
	/* **************** *
	 * The actual tests *
	 * **************** */
	
	/**
	 * $x = source();
	 * if( $x < MAX) {
	 *   $y = 2*$x;
	 *   sink($y);
	 * }
	 */
	@Test
	public void testSimpleFunction() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTUDGSamples.simpleFunctionNodeStr, CSVASTUDGSamples.simpleFunctionEdgeStr);
		UseDefGraph udg = getUDGForCFG(cfg);
		
		System.out.println(cfg);

		System.out.println("x: " + udg.getUsesAndDefsForSymbol("x"));
		System.out.println("y: " + udg.getUsesAndDefsForSymbol("y"));
		System.out.println("MAX: " + udg.getUsesAndDefsForSymbol("MAX"));
		System.out.println();
		
		DDG ddg = getDDGForCFGAndUDG(cfg, udg);

		for (DefUseRelation ddgEdge : ddg.getDefUseEdges())
			System.out.println(ddgEdge);
		
		// Looks real nice! :-)
		// TODO are we indeed happy or are we missing some edge?
		assertTrue( ddg.getDefUseEdges().size() == 3);
		assertTrue( edgeExists( ddg, "x", 3, 12));
		assertTrue( edgeExists( ddg, "x", 3, 19));
		assertTrue( edgeExists( ddg, "y", 19, 26));
	}

	/**
	 * $flag = source();
	 * if( $flag) {
	 *   $y++;
	 *   sink($y);
	 * }
	 */
	@Test
	public void testStandaloneFlag() throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(CSVASTUDGSamples.standaloneFlagNodeStr, CSVASTUDGSamples.standaloneFlagEdgeStr);
		UseDefGraph udg = getUDGForCFG(cfg);

		System.out.println(cfg);

		System.out.println("flag: " + udg.getUsesAndDefsForSymbol("flag"));
		System.out.println("y: " + udg.getUsesAndDefsForSymbol("y"));
		System.out.println();
		
		DDG ddg = getDDGForCFGAndUDG(cfg, udg);

		for (DefUseRelation ddgEdge : ddg.getDefUseEdges())
			System.out.println(ddgEdge);
		
		// Looks real nice! :-)
		// TODO are we indeed happy or are we missing some edge?
		assertTrue( ddg.getDefUseEdges().size() == 2);
		assertTrue( edgeExists( ddg, "flag", 3, 12));
		assertTrue( edgeExists( ddg, "y", 15, 18));
	}
}
