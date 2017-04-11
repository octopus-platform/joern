package tests.languages.php.udgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;
import udg.useDefGraph.UseDefGraph;

public class PHPUDGCreatorTest extends PHPCSVFunctionConverterBasedTest {
	
	// set sample directory
	@Before
	public void setSampleDir() {
		// we use the ddgCreation folder even though we are in the udgCreation
		// package because these are meant as intermediate tests for DDG generation
		// and the same tests are also used in the ddgCreation package
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
		UseDefGraph udg = getTopUDGForCSVFiles( "testSimpleFunction");

		assertEquals( 1, numberOfDefsForSymbol( udg, "x"));
		assertEquals( 3, numberOfUsesForSymbol( udg, "x"));
		assertTrue( containsDef( udg, "x", 6));
		assertTrue( containsUse( udg, "x", 15));
		// Note: something interesting happens here. There are *two* USEs of the
		// variable $x in the code line '$y = 2*$x;': once a USE within the
		// binary operation expression (id 22), and another USE within the
		// assignment itself (id 19).
		// TODO Is this a problem? In principle, it does make sense.
		assertTrue( containsUse( udg, "x", 22));
		assertTrue( containsUse( udg, "x", 25));

		assertEquals( 1, numberOfDefsForSymbol( udg, "y"));
		assertEquals( 1, numberOfUsesForSymbol( udg, "y"));
		assertTrue( containsDef( udg, "y", 22));
		assertTrue( containsUse( udg, "y", 29));
		
		assertEquals( 0, numberOfDefsForSymbol( udg, "MAX"));
		assertEquals( 1, numberOfUsesForSymbol( udg, "MAX"));
		assertTrue( containsUse( udg, "MAX", 15));
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
		UseDefGraph udg = getTopUDGForCSVFiles( "testStandaloneFlag");

		assertEquals( 1, numberOfDefsForSymbol( udg, "flag"));
		assertEquals( 1, numberOfUsesForSymbol( udg, "flag"));
		assertTrue( containsDef( udg, "flag", 6));
		assertTrue( containsUse( udg, "flag", 15));
		
		assertEquals( 1, numberOfDefsForSymbol( udg, "y"));
		assertEquals( 2, numberOfUsesForSymbol( udg, "y"));
		assertTrue( containsDef( udg, "y", 18));
		assertTrue( containsUse( udg, "y", 18));
		assertTrue( containsUse( udg, "y", 21));
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
		HashMap<String,UseDefGraph> udgs = getAllUDGsForCSVFiles( "testSimpleCompleteProgram");
		
		
		// Testing UDG of foo()
		UseDefGraph fooUDG = udgs.get( "foo");

		assertEquals( 1, numberOfDefsForSymbol( fooUDG, "x"));
		assertEquals( 3, numberOfUsesForSymbol( fooUDG, "x"));
		assertTrue( containsDef( fooUDG, "x", 16));
		assertTrue( containsUse( fooUDG, "x", 25));
		// "double" use of x:
		assertTrue( containsUse( fooUDG, "x", 32));
		assertTrue( containsUse( fooUDG, "x", 35));

		assertEquals( 1, numberOfDefsForSymbol( fooUDG, "y"));
		assertEquals( 1, numberOfUsesForSymbol( fooUDG, "y"));
		assertTrue( containsDef( fooUDG, "y", 32));
		assertTrue( containsUse( fooUDG, "y", 39));
		
		assertEquals( 0, numberOfDefsForSymbol( fooUDG, "MAX"));
		assertEquals( 1, numberOfUsesForSymbol( fooUDG, "MAX"));
		assertTrue( containsUse( fooUDG, "MAX", 25));
		
		
		// Testing UDG of source()
		UseDefGraph sourceUDG = udgs.get( "source");

		assertEquals( 1, numberOfDefsForSymbol( sourceUDG, "argv"));
		assertEquals( 1, numberOfUsesForSymbol( sourceUDG, "argv"));
		assertTrue( containsDef( sourceUDG, "argv", 52));
		assertTrue( containsUse( sourceUDG, "argv", 55));
		
		
		// Testing UDG of sink($arg)
		UseDefGraph sinkUDG = udgs.get( "sink");

		assertEquals( 1, numberOfDefsForSymbol( sinkUDG, "arg"));
		assertEquals( 1, numberOfUsesForSymbol( sinkUDG, "arg"));
		assertTrue( containsDef( sinkUDG, "arg", 65));
		assertTrue( containsUse( sinkUDG, "arg", 71));

		assertEquals( 0, numberOfDefsForSymbol( sinkUDG, "PHP_EOL"));
		assertEquals( 1, numberOfUsesForSymbol( sinkUDG, "PHP_EOL"));
		assertTrue( containsUse( sinkUDG, "PHP_EOL", 74));
		
		
		// Testing UDG of top-level function
		System.out.println(udgs);
		UseDefGraph __topUDG = udgs.get( "<./foo.php>");
		
		assertEquals( 2, numberOfDefsForSymbol( __topUDG, "MAX"));
		assertEquals( 0, numberOfUsesForSymbol( __topUDG, "MAX"));
		// "double" definition of MAX:
		assertTrue( containsDef( __topUDG, "MAX", 6));
		assertTrue( containsDef( __topUDG, "MAX", 7));
	}
	
}
