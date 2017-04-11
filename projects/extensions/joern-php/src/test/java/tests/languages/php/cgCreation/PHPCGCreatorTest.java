package tests.languages.php.cgCreation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	public void testSimpleFunctionCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testSimpleFunctionCalls");
		
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
	public void testTwoFilesFunctionCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesFunctionCalls");
		
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
	public void testTwoFilesNamespacedFunctionCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesNamespacedFunctionCalls");
		
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
	 *   \foo(); // calls global foo()
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
	 *   \foo(); // calls global foo()
	 *   \A\B\foo(); // calls \A\B\foo()
	 *   \A\B\bar(); // calls \A\B\bar()
	 *   buz(); // calls global buz()
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespaceFunctionCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespaceFunctionCalls");
		
		// 14 nodes: 10 calls and 4 definitions
		assertEquals(14, cg.size());
		assertEquals(10, cg.numberOfCallers());
		assertEquals(4, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 23, 9));
		assertTrue( edgeExists( cg, 27, 46));
		assertTrue( edgeExists( cg, 31, 9));
		assertTrue( edgeExists( cg, 35, 16));
		assertTrue( edgeExists( cg, 39, 53));
		assertTrue( edgeExists( cg, 60, 46));
		assertTrue( edgeExists( cg, 64, 46));
		assertTrue( edgeExists( cg, 68, 9));
		assertTrue( edgeExists( cg, 72, 16));
		assertTrue( edgeExists( cg, 76, 53));
	}
	
	/**
     * foo.php
     * -------
     * namespace A\B\C;
     * use \D\E\F;
     * 
     * include_once "bar.php";
     * 
     * function foo() {}
     * 
     * \D\E\F\bar(); // absolute reference - works
     * F\bar(); // translated to D\E\F\bar(); - works
     * \F\bar(); // absolute reference, not translated - not found
     * 
     * namespace X; // cancels all uses in effect
     * 
     * F\bar(); // not found
     * use \D\E\F;
     * F\bar(); // translated to D\E\F\bar(); - works
     * 
     * bar.php
     * -------
     * 
     * namespace D\E\F;
     * use A\B\C as G, D\E\F as H;
     * 
     * include_once "foo.php";
     * 
     * function bar() {}
     * 
     * \A\B\C\foo(); // absolute reference - works
     * G\foo(); // translated to A\B\C\foo(); - works
     * H\bar(); // translated to A\B\C\foo(); - works
     * \G\foo(); // absolute reference, not translated - not found
     * 
     * namespace Y; // cancels all uses in effect
     * 
     * G\foo(); // not found
     * use A\B\C as G;
     * G\foo(); // translated to D\E\F\bar(); - works
	 */
	@Test
	public void testTwoFilesNamespaceImportFunctionCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesNamespaceImportFunctionCalls");
		
		// 9 nodes: 7 calls and 2 definitions
		assertEquals(9, cg.size());
		assertEquals(7, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 22, 66));
		assertTrue( edgeExists( cg, 26, 66));
		assertFalse( edgeExists( cg, 30, 66)); // \F\bar(); should not be found, see above
		assertFalse( edgeExists( cg, 37, 66)); // F\bar(); in namespace X should not be found, see above
		assertTrue( edgeExists( cg, 45, 66));
		assertTrue( edgeExists( cg, 73, 15));
		assertTrue( edgeExists( cg, 77, 15));
		assertTrue( edgeExists( cg, 81, 66));
		assertFalse( edgeExists( cg, 85, 15)); // \G\foo(); should not be found, see above
		assertFalse( edgeExists( cg, 92, 15)); // G\foo(); in namespace Y should not be found, see above
		assertTrue( edgeExists( cg, 100, 15));
	}
	
	/**
	 * namespace A\B {
	 * 
	 *   function foo() {}
	 *   
	 *   C\bar();
	 * }
	 * 
	 * namespace A\B\C {
	 * 
	 *   use A\B as D;
	 *   
	 *   function bar() {}
	 *   
	 *   D\foo(); // calls \A\B\foo()
	 *   D\C\bar(); // calls \A\B\C\bar()
	 * }
	 * 
	 * namespace {
	 * 
	 *   use A\B, A\B\C as E;
	 *   
	 *   B\foo(); // calls \A\B\foo()
	 *   \B\foo(); // absolute reference, not translated - not found
	 *   B\C\bar(); // calls \A\B\C\bar()
	 *   E\bar(); // calls \A\B\C\bar()
	 *   \D\bar(); // absolute reference, not translated - not found
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespaceImportFunctionCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespaceImportFunctionCalls");
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 16, 27));
		assertTrue( edgeExists( cg, 34, 9));
		assertTrue( edgeExists( cg, 38, 27));
		assertTrue( edgeExists( cg, 53, 9));
		assertFalse( edgeExists( cg, 57, 9)); // \B\foo(); should not be found, see above
		assertTrue( edgeExists( cg, 61, 27));
		assertTrue( edgeExists( cg, 65, 27));
		assertFalse( edgeExists( cg, 69, 27)); // \D\bar(); should not be found, see above
	}
	
	/**
	 * class ClassOne {
	 *   static function funcone() {
	 *     ClassOne::funcone();
	 *     ClassTwo::functwo("foo");
	 *   }
	 * }
	 * 
	 * class ClassTwo {
	 *   static function functwo($a) {
	 *     ClassOne::funcone();
	 *     ClassTwo::functwo("bar");
	 *   }
	 * }
	 * 
	 * ClassOne::funcone();
	 * ClassTwo::functwo();
	 */
	@Test
	public void testSimpleStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testSimpleStaticCalls");
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 19, 13));
		assertTrue( edgeExists( cg, 24, 38));
		assertTrue( edgeExists( cg, 48, 13));
		assertTrue( edgeExists( cg, 53, 38));
		assertTrue( edgeExists( cg, 60, 13));
		assertTrue( edgeExists( cg, 65, 38));
	}
	
	/**
     * foo.php
     * -------
     * 
     * include_once "bar.php";
     * 
     * class ClassOne {
     *   static function foo() {}
     * }
     * 
     * ClassTwo::bar();
     * 
     * bar.php
     * -------
     * 
     * include_once "foo.php";
     * 
     * class ClassTwo {
     *   static function bar() {}
     * }
     * 
     * ClassOne::foo();
	 */
	@Test
	public void testTwoFilesStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesStaticCalls");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 22, 41));
		assertTrue( edgeExists( cg, 48, 15));
	}
	
	/**
     * foo.php
     * -------
     * namespace A;
     * 
     * include_once "bar.php";
     * 
     * class ClassOne {
     *   static function foo() {}
     * }
     * 
     * \B\ClassTwo::bar();
     * 
     * bar.php
     * -------
     * namespace B;
     * 
     * include_once "foo.php";
     * 
     * class ClassTwo {
     *   static function bar() {}
     * }
     * 
     * \A\ClassOne::foo();
	 */
	@Test
	public void testTwoFilesNamespacedStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesNamespacedStaticCalls");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 25, 47));
		assertTrue( edgeExists( cg, 54, 18));
	}
	
	/**
	 * namespace A\B {
	 * 
	 *   class ClassFoo {
	 *     static function foo() {}
	 *   }
	 * 
	 *   class ClassBar {
	 *     static function foo() {}
	 *   }
	 * 
	 *   ClassFoo::foo(); // calls \A\B\ClassFoo::foo()
	 *   \ClassFoo::foo(); // calls global ClassFoo::foo()
	 *   \A\B\ClassFoo::foo(); // calls \A\B\ClassFoo::foo()
	 *   \A\B\ClassBar::foo(); // calls \A\B\ClassBar::foo()
	 *   ClassBuz::foo(); // not found
	 *   \ClassBuz::foo(); // calls global ClassBuz::foo()
	 * }
	 * 
	 * namespace {
	 * 
	 *   class ClassFoo {
	 *     static function foo() {}
	 *   }
	 *   
	 *   class ClassBuz {
	 *     static function foo() {}
	 *   }
	 *   
	 *   ClassFoo::foo(); // calls global ClassFoo::foo()
	 *   \ClassFoo::foo(); // calls global ClassFoo::foo()
	 *   \A\B\ClassFoo::foo(); // calls \A\B\ClassFoo::foo()
	 *   \A\B\ClassBar::foo(); // calls \A\B\ClassBar::foo()
	 *   ClassBuz::foo(); // calls global ClassBuz::foo()
	 *   \ClassBuz::foo(); // calls global ClassBuz::foo()
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespaceStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespaceStaticCalls");
		
		// 15 nodes: 11 calls (not 12!) and 4 definitions
		assertEquals(15, cg.size());
		assertEquals(11, cg.numberOfCallers());
		assertEquals(4, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 37, 16));
		assertTrue( edgeExists( cg, 42, 77));
		assertTrue( edgeExists( cg, 47, 16));
		assertTrue( edgeExists( cg, 52, 30));
		assertFalse( edgeExists( cg, 57, 91)); // the "not found" call (see above)---there should be no edge
		assertTrue( edgeExists( cg, 62, 91));
		assertTrue( edgeExists( cg, 98, 77));
		assertTrue( edgeExists( cg, 103, 77));
		assertTrue( edgeExists( cg, 108, 16));
		assertTrue( edgeExists( cg, 113, 30));
		assertTrue( edgeExists( cg, 118, 91)); // the same call within the global namespace is found, though
		assertTrue( edgeExists( cg, 123, 91));
	}
	
	/**
	 * class ClassOne {
	 *   public function __construct() {
	 *     new ClassOne();
	 *     new ClassTwo("foo");
	 *   }
	 * }
	 * 
	 * class ClassTwo {
	 *   public function __construct($a) {
	 *     new ClassOne();
	 *     new ClassTwo("bar");
	 *   }
	 * }
	 * 
	 * new ClassOne();
	 * new ClassTwo("bar");
	 */
	@Test
	public void testSimpleConstructorCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testSimpleConstructorCalls");
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 19, 13));
		assertTrue( edgeExists( cg, 23, 36));
		assertTrue( edgeExists( cg, 46, 13));
		assertTrue( edgeExists( cg, 50, 36));
		assertTrue( edgeExists( cg, 56, 13));
		assertTrue( edgeExists( cg, 60, 36));
	}
	
	/**
     * foo.php
     * -------
     * 
     * include_once "bar.php";
     * 
     * class ClassOne {
     *   public function __construct() {}
     * }
     * 
     * new ClassTwo();
     * 
     * bar.php
     * -------
     * 
     * include_once "foo.php";
     * 
     * class ClassTwo {
     *   public function ClassTwo() {}
     * }
     * 
     * new ClassOne();
	 */
	@Test
	public void testTwoFilesConstructorCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesConstructorCalls");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 22, 40));
		assertTrue( edgeExists( cg, 47, 15));
	}
	
	/**
     * foo.php
     * -------
     * namespace A;
     * 
     * include_once "bar.php";
     * 
     * class ClassOne {
     *   public function __construct() {}
     * }
     * 
     * new \B\ClassTwo();
     * 
     * bar.php
     * -------
     * namespace B;
     * 
     * include_once "foo.php";
     * 
     * class ClassTwo {
     *   public function ClassTwo() {}
     * }
     * 
     * new \A\ClassOne();
	 */
	@Test
	public void testTwoFilesNamespacedConstructorCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesNamespacedConstructorCalls");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 25, 46));
		assertTrue( edgeExists( cg, 53, 18));
	}
	
	/**
	 * namespace A\B {
	 * 
	 *   class ClassFoo {
	 *     public function __construct() {}
	 *   }
	 *   
	 *   class ClassBar {
	 *     public function __construct() {}
	 *   }
	 *   
	 *   new ClassFoo(); // calls \A\B\ClassFoo::__construct()
	 *   new \ClassFoo(); // calls global ClassFoo::__construct()
	 *   new \A\B\ClassFoo(); // calls \A\B\ClassFoo::__construct()
	 *   new \A\B\ClassBar(); // calls \A\B\ClassBar::__construct()
	 *   new ClassBuz(); // not found
	 *   new \ClassBuz(); // calls global ClassBuz::__construct()
	 * }
	 * 
	 * namespace {
	 * 
	 *   class ClassFoo {
	 *     public function __construct() {}
	 *   }
	 *   
	 *   class ClassBuz {
	 *     public function __construct() {}
	 *   }
	 *   
	 *   new ClassFoo(); // calls global ClassFoo::__construct()
	 *   new \ClassFoo(); // calls global ClassFoo::__construct()
	 *   new \A\B\ClassFoo(); // calls \A\B\ClassFoo::__construct()
	 *   new \A\B\ClassBar(); // calls \A\B\ClassBar::__construct()
	 *   new ClassBuz(); // calls global ClassBuz::__construct()
	 *   new \ClassBuz(); // calls global ClassBuz::__construct()
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespaceConstructorCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespaceConstructorCalls");
		
		// 15 nodes: 11 calls (not 12!) and 4 definitions
		assertEquals(15, cg.size());
		assertEquals(11, cg.numberOfCallers());
		assertEquals(4, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 37, 16));
		assertTrue( edgeExists( cg, 41, 71));
		assertTrue( edgeExists( cg, 45, 16));
		assertTrue( edgeExists( cg, 49, 30));
		assertFalse( edgeExists( cg, 53, 85)); // the "not found" call (see above)---there should be no edge
		assertTrue( edgeExists( cg, 57, 85));
		assertTrue( edgeExists( cg, 92, 71));
		assertTrue( edgeExists( cg, 96, 71));
		assertTrue( edgeExists( cg, 100, 16));
		assertTrue( edgeExists( cg, 104, 30));
		assertTrue( edgeExists( cg, 108, 85)); // the same call within the global namespace is found, though
		assertTrue( edgeExists( cg, 112, 85));
	}
	
	/**
	 * class ClassOne {
	 *   public function funcone() {
	 *     $this->funcone();
	 *     $classtwo = new ClassTwo();
	 *     $classtwo->functwo("foo");
	 *   }
	 * }
	 * 
	 * class ClassTwo {
	 *   public function functwo($a) {
	 *     $classone = new ClassOne();
	 *     $classone->funcone();
	 *     $this->functwo("bar");
	 *   }
	 * }
	 * 
	 * $classone = new ClassOne();
	 * $classtwo = new ClassTwo();
	 * $classone->funcone();
	 * $classtwo->functwo("foo");
	 */
	@Test
	public void testSimpleNonStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testSimpleNonStaticCalls");
		
		// as long as non-static method names are unique, we can still build call edges to them!
		
		// 8 nodes: 6 calls and 2 definitions
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 19, 13));
		assertTrue( edgeExists( cg, 31, 45));
		assertTrue( edgeExists( cg, 62, 13));
		assertTrue( edgeExists( cg, 67, 45));
		assertTrue( edgeExists( cg, 88, 13));
		assertTrue( edgeExists( cg, 93, 45));
	}
	
	/**
	 * class ClassOne {
	 *   public function foo() {
	 *     $this->foo();
	 *     $classtwo = new ClassTwo();
	 *     $classtwo->foo("foo");
	 *   }
	 * }
	 * 
	 * class ClassTwo {
	 *   public function foo($a) {
	 *     $classone = new ClassOne();
	 *     $classone->foo();
	 *     $this->foo("bar");
	 *   }
	 * }
	 * 
	 * $classone = new ClassOne();
	 * $classtwo = new ClassTwo();
	 * $classone->foo();
	 * $classtwo->foo("foo");
	 */
	@Test
	public void testSimpleNonStaticCallsWithNameCollision() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testSimpleNonStaticCallsWithNameCollision");

		// the non-static method names are not unique,
		// hence we only construct call edges for $this->... calls
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 19, 13));
		assertTrue( edgeExists( cg, 67, 45));
	}
	
	/**
     * foo.php
     * -------
     * 
     * include_once "bar.php";
     * 
     * class ClassOne {
     *   public function foo() {}
     * }
     * 
     * $classtwo = new ClassTwo();
     * $classtwo->bar();
     * 
     * bar.php
     * -------
     * 
     * include_once "foo.php";
     * 
     * class ClassTwo {
     *   public function bar() {}
     * }
     * 
     * $classone = new ClassOne();
     * $classone->foo();
	 */
	@Test
	public void testTwoFilesNonStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesNonStaticCalls");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 29, 48));
		assertTrue( edgeExists( cg, 62, 15));
	}
	
	/**
     * foo.php
     * -------
     * namespace A;
     * 
     * include_once "bar.php";
     * 
     * class ClassOne {
     *   public function foo() {}
     * }
     * 
     * $classtwo = new \B\ClassTwo();
     * $classtwo->bar();
     * 
     * bar.php
     * -------
     * namespace B;
     * 
     * include_once "foo.php";
     * 
     * class ClassTwo {
     *   public function bar() {}
     * }
     * 
     * $classone = new \A\ClassOne();
     * $classone->foo();
	 */
	@Test
	public void testTwoFilesNamespacedNonStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testTwoFilesNamespacedNonStaticCalls");
		
		// 4 nodes: 2 calls and 2 definitions
		assertEquals(4, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 32, 54));
		assertTrue( edgeExists( cg, 68, 18));
	}
	
	/**
	 * namespace A\B {
	 * 
	 *   class ClassFoo {
	 *     public function foo() {}
	 *   }
	 *   
	 *   class ClassBar {
	 *     public function foo() {}
	 *   }
	 *   
	 *   (new ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
	 *   (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
	 *   (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
	 *   (new \A\B\ClassBar())->foo(); // calls \A\B\ClassBar()->foo()
	 *   (new ClassBuz())->foo(); // not found
	 *   (new \ClassBuz())->foo(); // calls global ClassBuz()->foo()
	 * }
	 * 
	 * namespace {
	 * 
	 *   class ClassFoo {
	 *     public function foo() {}
	 *   }
	 *   
	 *   class ClassBuz {
	 *     public function foo() {}
	 *   }
	 *   
	 *   (new ClassFoo())->foo(); // calls global ClassFoo()->foo()
	 *   (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
	 *   (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
	 *   (new \A\B\ClassBar())->foo(); // calls \A\B\ClassBar()->foo()
	 *   (new ClassBuz())->foo(); // calls global ClassBuz()->foo()
	 *   (new \ClassBuz())->foo(); // calls global ClassBuz()->foo()
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespaceNonStaticCalls() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespaceNonStaticCalls");
		
		// the non-static method names are not unique, hence our call graph is empty
		assertEquals(0, cg.size());
	}
	
	/**
	 * namespace A\B {
	 * 
	 *   class ClassFoo {
	 *     public function foo() { echo "ab foo", PHP_EOL; }
	 *   }
	 *   
	 *   class ClassBar {
	 *     public function bar() { echo "ab bar", PHP_EOL; }
	 *   }
	 *   
	 *   (new ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
	 *   (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
	 *   (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
	 *   (new \A\B\ClassBar())->bar(); // calls \A\B\ClassBar()->bar()
	 *   (new ClassBuz())->buz(); // not found
	 *   (new \ClassBuz())->buz(); // calls global ClassBuz()->buz()
	 * }
	 * 
	 * namespace {
	 * 
	 *   class ClassFoo {
	 *     public function foo() { echo "global foo", PHP_EOL; }
	 *   }
	 *   
	 *   class ClassBuz {
	 *     public function buz() { echo "global buz", PHP_EOL; }
	 *   }
	 *   
	 *   (new ClassFoo())->foo(); // calls global ClassFoo()->foo()
	 *   (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
	 *   (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
	 *   (new \A\B\ClassBar())->bar(); // calls \A\B\ClassBar()->bar()
	 *   (new ClassBuz())->buz(); // calls global ClassBuz()->buz()
	 *   (new \ClassBuz())->buz(); // calls global ClassBuz()->buz()
	 * }
	 */
	@Test
	public void testGlobalAndOtherNamespaceNonStaticCallsWithLessCollisions() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testGlobalAndOtherNamespaceNonStaticCallsWithLessCollisions");
		
		// 8 nodes: 6 calls to *unique* method names and 2 method definitions with *unique* names
		assertEquals(8, cg.size());
		assertEquals(6, cg.numberOfCallers());
		assertEquals(2, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		// note that non-unique method names do not get call edges,
		// i.e., we do not have any edges to nodes 16 or 103 because
		// both represent a method called foo, though in different classes
		
		assertFalse( edgeExists( cg, 49, 16)); // we can't find it because of the "double" definition
		assertFalse( edgeExists( cg, 56, 101)); // we can't find it because of the "double" definition
		assertFalse( edgeExists( cg, 63, 16)); // we can't find it because of the "double" definition
		assertTrue( edgeExists( cg, 70, 36));
		assertTrue( edgeExists( cg, 77, 121)); // the "not found" call is *there*!
		// this is because its method name is unique, so we construct the edge even
		// though the class cannot be found in namespace \A\B
		// it doesn't hurt us to build this edge, because in practice this call
		// would lead to a fatal PHP error as the class cannot be found, and we
		// are only interested in sensible code that actually works
		assertTrue( edgeExists( cg, 84, 121));
		assertFalse( edgeExists( cg, 134, 101)); // we can't find it because of the "double" definition
		assertFalse( edgeExists( cg, 141, 101)); // we can't find it because of the "double" definition
		assertFalse( edgeExists( cg, 148, 16)); // we can't find it because of the "double" definition
		assertTrue( edgeExists( cg, 155, 36));
		assertTrue( edgeExists( cg, 162, 121)); // the same call as the "not found" call discussed above
		                                        // within the global namespace is (and should be) found
		assertTrue( edgeExists( cg, 169, 121));
	}
	
	/**
	 * interface A {
	 *   abstract public function foo();
	 * }
	 * 
	 * class B implements A {
	 *   public function foo() {
	 *     $this->foo();
	 *   }
	 * }
	 * 
	 * $b =  new B();
	 * $b->foo();
	 */
	@Test
	public void testAbstractMethodImplementationCall() throws IOException, InvalidCSVFile
	{
		CG cg = getCGForCSVFiles( "testAbstractMethodImplementationCall");
		
		// 3 nodes: 2 calls to the *unique* method foo() and 1 method definition with a *unique* name;
		// note that we do not count abstract methods since these cannot be called in the first place
		assertEquals(3, cg.size());
		assertEquals(2, cg.numberOfCallers());
		assertEquals(1, cg.numberOfCallees());
		
		assertEquals(cg.numberOfEdges(), cg.numberOfCallers());

		assertTrue( edgeExists( cg, 35, 29));
		assertTrue( edgeExists( cg, 48, 29));
		// there should be no edges to the abstract method:
		assertFalse( edgeExists( cg, 35, 13));
		assertFalse( edgeExists( cg, 48, 13));
	}
}
