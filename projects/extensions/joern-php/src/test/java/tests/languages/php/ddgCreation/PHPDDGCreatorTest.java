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
		assertTrue( edgeExists( sourceDDG, "argv", 53, 56));
		
		
		// Testing DDG of sink($arg)
		DDG sinkDDG = ddgs.get( "sink");

		assertEquals( 1, sinkDDG.getDefUseEdges().size());
		assertTrue( edgeExists( sinkDDG, "arg", 66, 73));

		
		// Testing DDG of top-level function
		DDG __topUDG = ddgs.get( "<./foo.php>");

		assertEquals( 0, __topUDG.getDefUseEdges().size());
	}
}
