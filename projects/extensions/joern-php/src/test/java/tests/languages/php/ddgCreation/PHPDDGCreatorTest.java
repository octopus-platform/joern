package tests.languages.php.ddgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import ddg.DataDependenceGraph.DDG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;

public class PHPDDGCreatorTest extends PHPCSVFunctionConverterBasedTest {

	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "ddgCreation");
	}
	
	
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
		DDG ddg = getTopDDGForCSVFiles( "testSimpleFunction");

		// Looks real nice! :-)
		assertEquals( 3, ddg.getDefUseEdges().size());
		assertTrue( edgeExists( ddg, "x", 6, 15));
		assertTrue( edgeExists( ddg, "x", 6, 22));
		assertTrue( edgeExists( ddg, "y", 22, 29));
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
		DDG ddg = getTopDDGForCSVFiles( "testStandaloneFlag");
		
		// Looks real nice! :-)
		assertEquals( 2, ddg.getDefUseEdges().size());
		assertTrue( edgeExists( ddg, "flag", 6, 15));
		assertTrue( edgeExists( ddg, "y", 18, 21));
	}
	
	/**
	 * const MAX = 10;           ( 6) ConstantDeclaration; (7) ConstantElement
	 * 
	 * function foo() {          (10)
	 *   $x = source();          (16)
	 *   if( $x < MAX) {         (25)
	 *     $y = 2*$x;            (32) AssignmentExpression; (35) BinaryOperationExpression
	 *     sink($y);             (39)
	 *   }
	 * }
	 * 
	 * function source() {       (46)
	 *   global $argv;           (52)
	 *   return $argv[1];        (55)
	 * }
	 * 
	 * function sink($arg) {     (61) PHPFunctionDef; (65) PHPParameter
	 *   echo $arg, PHP_EOL;     (71) PHPEchoStatement; (74) PHPEchoStatement
	 * }
	 * 
	 * foo();                    (79)
	 */
	@Test
	public void testSimpleCompleteProgram() throws IOException, InvalidCSVFile
	{
		HashMap<String,DDG> ddgs = getAllDDGsForCSVFiles( "testSimpleCompleteProgram");

		
		// Testing DDG of foo()
		DDG fooDDG = ddgs.get( "foo");

		assertEquals( 3, fooDDG.getDefUseEdges().size());
		assertTrue( edgeExists( fooDDG, "x", 16, 25));
		assertTrue( edgeExists( fooDDG, "x", 16, 32));
		assertTrue( edgeExists( fooDDG, "y", 32, 39));

		
		// Testing DDG of source()
		DDG sourceDDG = ddgs.get( "source");

		assertEquals( 1, sourceDDG.getDefUseEdges().size());
		assertTrue( edgeExists( sourceDDG, "argv", 52, 55));
		
		
		// Testing DDG of sink($arg)
		DDG sinkDDG = ddgs.get( "sink");

		assertEquals( 1, sinkDDG.getDefUseEdges().size());
		assertTrue( edgeExists( sinkDDG, "arg", 65, 71));

		
		// Testing DDG of top-level function
		DDG __topUDG = ddgs.get( "<./foo.php>");

		assertEquals( 0, __topUDG.getDefUseEdges().size());
	}
}
