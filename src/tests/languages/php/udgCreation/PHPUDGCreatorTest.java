package tests.languages.php.udgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ast.ASTNode;
import ast.ASTNodeProperties;
import ast.functionDef.FunctionDef;
import cfg.CFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;
import tests.languages.php.samples.CSVASTUDGAndDDGSamples;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;

public class PHPUDGCreatorTest extends PHPCSVFunctionConverterBasedTest {
	
	/**
	 * Helper method that does the conversions
	 * o AST -> CFG
	 * o CFG -> UDG
	 * for a given AST node.
	 */
	private UseDefGraph getUDGForASTNode(ASTNode rootnode) throws IOException, InvalidCSVFile {
		
		CFG cfg = getCFGForAST(rootnode);
		return transformCFGToUDG(cfg);
	}
	
	/**
	 * Helper method that does the conversions
	 * o AST -> CFG
	 * o CFG -> UDG
	 * for a given FunctionDef AST node.
	 */
	private UseDefGraph getUDGForFunctionNode(FunctionDef rootnode) throws IOException, InvalidCSVFile {
		
		CFG cfg = getCFGForFunctionNode(rootnode);
		return transformCFGToUDG(cfg);
	}

	private UseDefGraph transformCFGToUDG(CFG cfg) throws IOException, InvalidCSVFile {
		
		UseDefGraph udg = getUDGForCFG(cfg);
		
		System.out.println();
		System.out.println("CFG\n~~~");
		System.out.println(cfg);
	
		System.out.println("UDG\n~~~");
		for( String symbol : udg.keySet())
			System.out.println( symbol + ": " + udg.getUsesAndDefsForSymbol(symbol));
		System.out.println();
		
		return udg;
	}
	
	/**
	 * Creates an AST for two given CSV files and computes a UDG.
	 */
	private UseDefGraph getUDGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		ASTNode rootnode = getASTForCSVLines(nodeLines, edgeLines);
		return getUDGForASTNode(rootnode);		
	}
	
	/**
	 * Obtains a function AST from the function extractor and computes a UDG.
	 */
	private UseDefGraph getUDGForNextFunction()
			throws IOException, InvalidCSVFile
	{
		FunctionDef rootnode = getASTOfNextFunction();
		return getUDGForFunctionNode(rootnode);
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
			if( useOrDefRecord.getAstNode().getProperty(ASTNodeProperties.NODE_ID).equals( String.valueOf(id))
					&&  useOrDefRecord.isDef() == isDef)
				return true;
		}
		return false;
	}
	
	private int numberOfDefsForSymbol( UseDefGraph udg, String symbol) {
		
		return numberOfDefsOrUsesForSymbol( udg, symbol,  true);
	}
	
	private int numberOfUsesForSymbol( UseDefGraph udg, String symbol) {
		
		return numberOfDefsOrUsesForSymbol( udg, symbol, false);
	}
	
	/**
	 * Checks whether a collection of UseOrDef elements contains an expected number
	 * of definitions/uses of a given symbol.
	 */
	private int numberOfDefsOrUsesForSymbol( UseDefGraph udg, String symbol, boolean isDef) {
		
		List<UseOrDefRecord> useOrDefRecords = udg.getUsesAndDefsForSymbol(symbol);
		
		int number = 0;
		
		for( UseOrDefRecord useOrDefRecord : useOrDefRecords) {
			if( useOrDefRecord.isDef() == isDef)
				number++;
		}
		
		return number;
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
	public void testUDGSimpleFunction() throws IOException, InvalidCSVFile
	{
		UseDefGraph udg = getUDGForCSVLines(CSVASTUDGAndDDGSamples.simpleFunctionNodeStr, CSVASTUDGAndDDGSamples.simpleFunctionEdgeStr);

		assertEquals( 1, numberOfDefsForSymbol( udg, "x"));
		assertEquals( 3, numberOfUsesForSymbol( udg, "x"));
		assertTrue( containsDef( udg, "x", 3));
		assertTrue( containsUse( udg, "x", 12));
		// Note: something interesting happens here. There are *two* USEs of the
		// variable $x in the code line '$y = 2*$x;': once a USE within the
		// binary operation expression (id 22), and another USE within the
		// assignment itself (id 19).
		// TODO Is this a problem? In principle, it does make sense.
		assertTrue( containsUse( udg, "x", 19));
		assertTrue( containsUse( udg, "x", 22));

		assertEquals( 1, numberOfDefsForSymbol( udg, "y"));
		assertEquals( 1, numberOfUsesForSymbol( udg, "y"));
		assertTrue( containsDef( udg, "y", 19));
		assertTrue( containsUse( udg, "y", 26));
		
		assertEquals( 0, numberOfDefsForSymbol( udg, "MAX"));
		assertEquals( 1, numberOfUsesForSymbol( udg, "MAX"));
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
	public void testUDGStandaloneFlag() throws IOException, InvalidCSVFile
	{
		UseDefGraph udg = getUDGForCSVLines(CSVASTUDGAndDDGSamples.standaloneFlagNodeStr, CSVASTUDGAndDDGSamples.standaloneFlagEdgeStr);

		assertEquals( 1, numberOfDefsForSymbol( udg, "flag"));
		assertEquals( 1, numberOfUsesForSymbol( udg, "flag"));
		assertTrue( containsDef( udg, "flag", 3));
		assertTrue( containsUse( udg, "flag", 12));
		
		assertEquals( 1, numberOfDefsForSymbol( udg, "y"));
		assertEquals( 2, numberOfUsesForSymbol( udg, "y"));
		assertTrue( containsDef( udg, "y", 15));
		assertTrue( containsUse( udg, "y", 15));
		assertTrue( containsUse( udg, "y", 18));
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
	 * function sink($arg) {     (55) PHPFunctionDef; (57) PHPParameter
	 *   echo $arg, PHP_EOL;     (64) PHPEchoStatement; (67) PHPEchoStatement
	 * }
	 * 
	 * foo();                    (72)
	 */
	@Test
	public void testUDGSimpleCompleteProgram() throws IOException, InvalidCSVFile
	{
		initFunctionExtractor(CSVASTUDGAndDDGSamples.simpleCompleteProgramNodeStr, CSVASTUDGAndDDGSamples.simpleCompleteProgramEdgeStr);
		
		// Testing UDG of foo()
		UseDefGraph fooUDG = getUDGForNextFunction(); // gets UDG for foo()

		assertEquals( 1, numberOfDefsForSymbol( fooUDG, "x"));
		assertEquals( 3, numberOfUsesForSymbol( fooUDG, "x"));
		assertTrue( containsDef( fooUDG, "x", 11));
		assertTrue( containsUse( fooUDG, "x", 20));
		// "double" use of x:
		assertTrue( containsUse( fooUDG, "x", 27));
		assertTrue( containsUse( fooUDG, "x", 30));

		assertEquals( 1, numberOfDefsForSymbol( fooUDG, "y"));
		assertEquals( 1, numberOfUsesForSymbol( fooUDG, "y"));
		assertTrue( containsDef( fooUDG, "y", 27));
		assertTrue( containsUse( fooUDG, "y", 34));
		
		assertEquals( 0, numberOfDefsForSymbol( fooUDG, "MAX"));
		assertEquals( 1, numberOfUsesForSymbol( fooUDG, "MAX"));
		assertTrue( containsUse( fooUDG, "MAX", 20));
		
		
		// Testing UDG of source()
		UseDefGraph sourceUDG = getUDGForNextFunction(); // gets UDG for source()

		assertEquals( 1, numberOfDefsForSymbol( sourceUDG, "argv"));
		assertEquals( 1, numberOfUsesForSymbol( sourceUDG, "argv"));
		assertTrue( containsDef( sourceUDG, "argv", 46));
		assertTrue( containsUse( sourceUDG, "argv", 49));
		
		
		// Testing UDG of sink($arg)
		UseDefGraph sinkUDG = getUDGForNextFunction(); // gets UDG for sink($arg)

		assertEquals( 1, numberOfDefsForSymbol( sinkUDG, "arg"));
		assertEquals( 1, numberOfUsesForSymbol( sinkUDG, "arg"));
		assertTrue( containsDef( sinkUDG, "arg", 57));
		assertTrue( containsUse( sinkUDG, "arg", 64));

		assertEquals( 0, numberOfDefsForSymbol( sinkUDG, "PHP_EOL"));
		assertEquals( 1, numberOfUsesForSymbol( sinkUDG, "PHP_EOL"));
		assertTrue( containsUse( sinkUDG, "PHP_EOL", 67));
		
		
		// Testing UDG of top-level function
		UseDefGraph __topUDG = getUDGForNextFunction(); // gets UDG for artificial top-level function
		assertEquals( 2, numberOfDefsForSymbol( __topUDG, "MAX"));
		assertEquals( 0, numberOfUsesForSymbol( __topUDG, "MAX"));
		// "double" definition of MAX:
		assertTrue( containsDef( __topUDG, "MAX", 3));
		assertTrue( containsDef( __topUDG, "MAX", 4));
	}
	
}
