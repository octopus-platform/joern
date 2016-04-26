package tests.languages.php.cgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import cg.CG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionConverterBasedTest;

public class PHPCGCreatorTest extends PHPCSVFunctionConverterBasedTest {

	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "cgCreation");
	}
	
	
	/* **************** *
	 * The actual tests *
	 * **************** */
	
	/**
	 * function funcone() {
	 *   funcone();
	 *   functwo("foo");
	 * }
	 * 
	 * function functwo($a) {
	 *   funcone();
	 *   functwo("bar");
	 * }
	 * 
	 * funcone();
	 * functwo();
	 */
	@Test
	public void testSimpleCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testSimpleCalls");
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 12, 6));
		assertTrue( edgeExists( cg, 16, 22));
		assertTrue( edgeExists( cg, 32, 6));
		assertTrue( edgeExists( cg, 36, 22));
		assertTrue( edgeExists( cg, 42, 6));
		assertTrue( edgeExists( cg, 46, 22));
	}

	/**
     * foo.php
     * -------
     * 
     * include_once "bar.php";
     * 
     * function foo() {}
     * 
     * bar();
     * 
     * bar.php
     * -------
     * 
     * include_once "foo.php";
     * 
     * function bar() {}
     * 
     * foo();
	 */
	@Test
	public void testTwoFiles() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFiles");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 15, 26));
		assertTrue( edgeExists( cg, 33, 8));
	}
	
	/**
     * foo.php
     * -------
     * namespace A;
     * 
     * include_once "bar.php";
     * 
     * function foo() {}
     * 
     * \B\bar();
     * 
     * bar.php
     * -------
     * namespace B;
     * 
     * include_once "foo.php";
     * 
     * function bar() {}
     * 
     * \A\foo();
	 */
	@Test
	public void testTwoNamespacedFiles() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoNamespacedFiles");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 18, 32));
		assertTrue( edgeExists( cg, 39, 11));
	}

	/**
	 * namespace A\B {
	 * 
	 *   function foo() {}
	 *   function bar() {}
	 *   
	 *   foo(); // calls \A\B\foo()
	 *   \A\B\foo(); // calls \A\B\foo()
	 *   \A\B\bar(); // calls \A\B\bar()
	 *   buz(); // calls global buz()
	 * }
	 * 
	 * namespace {
	 * 
	 *   function foo() {}
	 *   function buz() {}
	 *   
	 *   foo(); // calls global foo()
	 *   \A\B\foo(); // calls \A\B\foo()
	 *   \A\B\bar(); // calls \A\B\bar()
	 *   buz(); // calls global buz()
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespace() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespace");
		
		// 12 nodes: 8 calls and 4 definitions
		assertEquals(12, cg.size());
		assertEquals(8, cg.numberOfCallers());
		assertEquals(4, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 23, 9));
		assertTrue( edgeExists( cg, 27, 9));
		assertTrue( edgeExists( cg, 31, 16));
		assertTrue( edgeExists( cg, 35, 49));
		assertTrue( edgeExists( cg, 56, 42));
		assertTrue( edgeExists( cg, 60, 9));
		assertTrue( edgeExists( cg, 64, 16));
		assertTrue( edgeExists( cg, 68, 49));
	}
}
