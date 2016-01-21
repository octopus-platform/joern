package tests.languages.php.ddgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.functionDef.FunctionDef;
import cfg.CFG;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;
import tests.languages.php.samples.CSVASTUDGAndDDGSamples;
import udg.useDefGraph.UseDefGraph;

public class PHPDDGCreatorTest extends PHPCSVFunctionConverterBasedTest {

	/**
	 * Helper method that does the conversions
	 * o AST -> CFG
	 * o CFG -> UDG
	 * o CFG & UDG -> DDG
	 * for a given AST node.
	 */
	protected DDG getDDGForASTNode(ASTNode rootnode)
			throws IOException, InvalidCSVFile
	{
		CFG cfg = getCFGForAST(rootnode);
		UseDefGraph udg = getUDGForCFG(cfg);
		DDG ddg = getDDGForCFGAndUDG(cfg, udg);
		
		System.out.println();
		System.out.println("CFG\n~~~");
		System.out.println(cfg);
		
		System.out.println("UDG\n~~~");
		for( String symbol : udg.keySet())
			System.out.println( symbol + ": " + udg.getUsesAndDefsForSymbol(symbol));
		System.out.println();

		System.out.println("DDG\n~~~");
		for (DefUseRelation ddgEdge : ddg.getDefUseEdges())
			System.out.println(ddgEdge);
		System.out.println();

		return ddg;		
	}
	
	/**
	 * Creates an AST for two given CSV files and computes a DDG.
	 */
	private DDG getDDGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		ASTNode rootnode = getASTForCSVLines(nodeLines, edgeLines);
		return getDDGForASTNode(rootnode);		
	}
	
	/**
	 * Obtains a function AST from the function extractor and computes a DDG.
	 */
	private DDG getDDGForNextFunction()
			throws IOException, InvalidCSVFile
	{
		FunctionDef rootnode = getASTOfNextFunction();
		// TODO actually, we want rootnode instead of rootnode.getContent() !
		return getDDGForASTNode(rootnode.getContent());
	}
	
	/**
	 * Checks whether an edge exists in a given DDG from a given
	 * source node to a given destination node for a given symbol.
	 */
	private boolean edgeExists( DDG ddg, String symbol, long srcid, long dstid) {
		
		for (DefUseRelation ddgEdge : ddg.getDefUseEdges()) {
			
			assert ddgEdge.src instanceof ASTNode;
			assert ddgEdge.dst instanceof ASTNode;

			if( ddgEdge.symbol.equals(symbol)
					&& ((ASTNode)ddgEdge.src).getProperty(ASTNodeProperties.NODE_ID).equals( String.valueOf(srcid))
					&& ((ASTNode)ddgEdge.dst).getProperty(ASTNodeProperties.NODE_ID).equals( String.valueOf(dstid)))
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
	public void testDDGSimpleFunction() throws IOException, InvalidCSVFile
	{
		DDG ddg = getDDGForCSVLines(CSVASTUDGAndDDGSamples.simpleFunctionNodeStr, CSVASTUDGAndDDGSamples.simpleFunctionEdgeStr);

		// Looks real nice! :-)
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
	public void testDDGStandaloneFlag() throws IOException, InvalidCSVFile
	{
		DDG ddg = getDDGForCSVLines(CSVASTUDGAndDDGSamples.standaloneFlagNodeStr, CSVASTUDGAndDDGSamples.standaloneFlagEdgeStr);
		
		// Looks real nice! :-)
		assertTrue( ddg.getDefUseEdges().size() == 2);
		assertTrue( edgeExists( ddg, "flag", 3, 12));
		assertTrue( edgeExists( ddg, "y", 15, 18));
	}
	
	/**
	 * const MAX = 10;           ( 3) ConstantDeclaration; (4) ConstantElement
	 * 
	 * function foo() {          ( 7)
	 *   $x = source();          (11)
	 *   if( $x < MAX) {         (20)
	 *     $y = 2*$x;            (27) AssignmentExpression; (30) BinaryOperationExpression
	 *     sink($y);             (34)
	 *   }
	 * }
	 * 
	 * function source() {       (41)
	 *   global $argv;           (46)
	 *   return $argv[1];        (49)
	 * }
	 * 
	 * function sink($arg) {     (55)
	 *   echo $arg, PHP_EOL;     (64) PHPEchoStatement; (67) PHPEchoStatement
	 * }
	 * 
	 * foo();                    (72)
	 */
	@Test
	public void testDDGSimpleCompleteProgram() throws IOException, InvalidCSVFile
	{
		initFunctionExtractor(CSVASTUDGAndDDGSamples.simpleCompleteProgramNodeStr, CSVASTUDGAndDDGSamples.simpleCompleteProgramEdgeStr);
		
		// Testing DDG of foo()
		DDG fooDDG = getDDGForNextFunction(); // gets DDG for foo()
		assertEquals( 3, fooDDG.getDefUseEdges().size());
		assertTrue( edgeExists( fooDDG, "x", 11, 20));
		assertTrue( edgeExists( fooDDG, "x", 11, 27));
		assertTrue( edgeExists( fooDDG, "y", 27, 34));

		
		// Testing DDG of source()
		DDG sourceDDG = getDDGForNextFunction(); // gets DDG for source()
		assertEquals( 1, sourceDDG.getDefUseEdges().size());
		assertTrue( edgeExists( sourceDDG, "argv", 46, 49));
		
		
		// Testing DDG of sink($arg)
		DDG sinkDDG = getDDGForNextFunction(); // gets DDG for sink($arg)
		assertEquals( 0, sinkDDG.getDefUseEdges().size());
		
		
		// Testing DDG of top-level function
		DDG __topUDG = getDDGForNextFunction(); // gets DDG for artificial top-level function
		assertEquals( 0, __topUDG.getDefUseEdges().size());
	}
}
