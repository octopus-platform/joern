package tests.languages.php.udgCreation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ast.ASTNode;
import cfg.CFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.cfg.PHPCFGFactory;
import tests.languages.php.PHPCSVBasedTest;
import tests.languages.php.samples.CSVASTUDGSamples;
import udg.CFGToUDGConverter;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;

public class PHPUDGCreatorTest extends PHPCSVBasedTest {

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
	 * Creates and returns a UDG for a given CFG created from two CSV strings (nodes and edges).
	 */
	protected UseDefGraph getUDGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForCSVLines(nodeLines, edgeLines);

		System.out.println(cfg);
		
		CFGToUDGConverter cfgToUDG = new CFGToUDGConverter();
		cfgToUDG.setLanguage("PHP");
		
		return cfgToUDG.convert(cfg);
	}

	private boolean containsDef( UseDefGraph udg, String symbol, long id) {
		return containsUseOrDef( udg, symbol, id, true);
	}
	
	private boolean containsUse( UseDefGraph udg, String symbol, long id) {
		return containsUseOrDef( udg, symbol, id, false);
	}
	
	/**
	 * Checks whether a collection of UseOrDef elements contains a definition/use
	 * of a given symbol for a given node.
	 */
	private boolean containsUseOrDef( UseDefGraph udg, String symbol, long id, boolean isDef) {
		
		List<UseOrDefRecord> useOrDefRecords = udg.getUsesAndDefsForSymbol(symbol);
		
		for( UseOrDefRecord useOrDefRecord : useOrDefRecords) {
			if( useOrDefRecord.getAstNode().equals( ast.getNodeById(id))
					&&  useOrDefRecord.isDef() == isDef)
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
		UseDefGraph udg = getUDGForCSVLines(CSVASTUDGSamples.simpleFunctionNodeStr, CSVASTUDGSamples.simpleFunctionEdgeStr);

		System.out.println("x: " + udg.getUsesAndDefsForSymbol("x"));
		System.out.println("y: " + udg.getUsesAndDefsForSymbol("y"));
		System.out.println("MAX: " + udg.getUsesAndDefsForSymbol("MAX"));

		assertTrue( containsDef( udg, "x", 3));
		assertTrue( containsUse( udg, "x", 12));
		// Note: something interesting happens here. There are *two* USEs of the
		// variable $x in the code line '$y = 2*$x;': once a USE within the
		// binary operation expression (id 22), and another USE within the
		// assignment itself (id 19).
		// TODO Is this a problem? In principle, it does make sense.
		assertTrue( containsUse( udg, "x", 19));
		assertTrue( containsUse( udg, "x", 22));

		assertTrue( containsDef( udg, "y", 19));
		assertTrue( containsUse( udg, "y", 26));
		
		assertTrue( containsUse( udg, "MAX", 12));
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
		UseDefGraph udg = getUDGForCSVLines(CSVASTUDGSamples.standaloneFlagNodeStr, CSVASTUDGSamples.standaloneFlagEdgeStr);

		System.out.println("flag: " + udg.getUsesAndDefsForSymbol("flag"));
		System.out.println("y: " + udg.getUsesAndDefsForSymbol("y"));

		assertTrue( containsDef( udg, "flag", 3));
		assertTrue( containsUse( udg, "flag", 12));
		assertTrue( containsDef( udg, "y", 15));
		assertTrue( containsUse( udg, "y", 15));
		assertTrue( containsUse( udg, "y", 18));
	}
	
	/**
	 * const MAX = 10;
	 * 
	 * function foo() {
	 *   $x = source();
	 *   if( $x < MAX) {
	 *     $y = 2*$x;
	 *     sink($y);
	 *   }
	 * }
	 * 
	 * function source() {
	 *   global $argv;
	 *   return $argv[1];
	 * }
	 * 
	 * function sink($arg) {
	 *   echo $arg, PHP_EOL;
	 * }
	 * 
	 * foo();
	 */
	@Test
	public void testSimpleCompleteProgram() throws IOException, InvalidCSVFile
	{
		UseDefGraph udg = getUDGForCSVLines(CSVASTUDGSamples.simpleCompleteProgramNodeStr, CSVASTUDGSamples.simpleCompleteProgramEdgeStr);
	}
	
}
