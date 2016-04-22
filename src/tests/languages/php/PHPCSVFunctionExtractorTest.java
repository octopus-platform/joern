package tests.languages.php;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import ast.functionDef.FunctionDef;
import ast.php.functionDef.PHPFunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;

public class PHPCSVFunctionExtractorTest extends PHPCSVFunctionExtractorBasedTest
{
	private StringReader nodeReader;
	private StringReader edgeReader;
	private String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment\n";
	private String edgeHeader = ":START_ID,:END_ID,:TYPE\n";
	
	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "funcExtraction");
	}
	
	@Before
	public void init() {
		
		super.init();
		
		// we need these for tests that do not read from CSV files
		this.nodeReader = new StringReader(nodeHeader);
		this.edgeReader = new StringReader(edgeHeader);
	}

	/*
	 * -------------
	 * Reading nodes
	 * -------------
	 */
	
	/**
	 * Note that it is not actually possible to generate a header-only
	 * CSV file with our PHP parser. Even an empty file will generate
	 * two nodes: one File node and one AST_STMT_LIST node.
	 */
	@Test
	public void testHeaderOnly() throws IOException, InvalidCSVFile
	{
	        super.extractor.initialize( this.nodeReader, this.edgeReader);
	        FunctionDef function = extractor.getNextFunction();

	        assertNull(function);
	}

	
	/**
	 * function foo() {}
	 */
	@Test
	public void testSingleFunction() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testSingleFunction");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		
		assertEquals( 2, funcs.size());
		
		assertEquals( "foo", function.getName());
		assertEquals( "<./foo.php>", function2.getName());
	}

	/**
	 * function foo() {}
	 * true;
	 */
	@Test
	public void testFunctionPlusTopLevel() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testFunctionPlusTopLevel");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		
		assertEquals( 2, funcs.size());
		
		assertEquals("foo", function.getName());
		assertEquals("<./foo.php>", function2.getName());
	}

	/**
	 * true;
	 * function foo() {}
	 * true;
	 */
	@Test
	public void testTopLevelFuncTopLevel() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testTopLevelFuncTopLevel");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		
		assertEquals( 2, funcs.size());
		
		assertEquals("foo", function.getName());
		assertEquals("<./foo.php>", function2.getName());
	}

	/**
	 * function foo() {}
	 * function bar() {}
	 */
	@Test
	public void testTwoFunctions() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testTwoFunctions");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		
		assertEquals( 3, funcs.size());

		assertEquals("foo", function.getName());
		assertEquals("bar", function2.getName());
		assertEquals("<./foo.php>", function3.getName());
	}
	
	/**
	 * function foo() {
	 *   function bar() {}
	 * }
	 */
	@Test
	public void testFunctionWithInnerFunction() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testFunctionWithInnerFunction");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		
		assertEquals( 3, funcs.size());

		assertEquals("bar", function.getName());
		assertEquals("foo", function2.getName());
		assertEquals("<./foo.php>", function3.getName());
	}
	
	/**
	 * function foo() {
	 *   function bar() {}
	 * }
	 * function buz() {}
	 */
	@Test
	public void testTwoFunctionsAndInnerFunction() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testTwoFunctionsAndInnerFunction");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		PHPFunctionDef function4 = it.next();
		
		assertEquals( 4, funcs.size());

		assertEquals("bar", function.getName());
		assertEquals("foo", function2.getName());
		assertEquals("buz", function3.getName());
		assertEquals("<./foo.php>", function4.getName());
	}

	/**
	 * function foo() {
	 *   function() {};
	 * }
	 */
	@Test
	public void testFunctionWithClosure() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testFunctionWithClosure");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		
		assertEquals( 3, funcs.size());

		assertEquals("{closure}", function.getName());
		assertEquals("foo", function2.getName());
		assertEquals("<./foo.php>", function3.getName());
	}

	/**
	 * foo.php
	 * -------
	 * function foo() {}
	 *
	 * bar.php
	 * -------
	 * function bar() {}
	 */
	@Test
	public void testTwoFiles() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testTwoFiles");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		PHPFunctionDef function4 = it.next();
		
		assertEquals( 4, funcs.size());

		assertEquals("foo", function.getName());
		assertEquals("<./foobar/foo.php>", function2.getName());
		assertEquals("bar", function3.getName());
		assertEquals("<./foobar/bar.php>", function4.getName());
	}
	
	/**
	 * class foo {}
	 */
	@Test
	public void testSingleClass() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testSingleClass");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		
		assertEquals( 2, funcs.size());

		assertEquals("[foo]", function.getName());
		assertEquals("<./foo.php>", function2.getName());
	}
	
	/**
	 * function foo() {}
	 * class foo {
	 *   function bar() {}
	 * }
	 * class buz {}
	 */
	@Test
	public void testFunctionAndTwoClassesWithMethod() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testFunctionAndTwoClassesWithMethod");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		PHPFunctionDef function4 = it.next();
		PHPFunctionDef function5 = it.next();
		
		assertEquals( 5, funcs.size());

		assertEquals("foo", function.getName());
		assertEquals("bar", function2.getName());
		assertEquals("[foo]", function3.getName());
		assertEquals("[buz]", function4.getName());
		assertEquals("<./foo.php>", function5.getName());
	}
	
	/**
	 * foo.php
	 * -------
	 * class foo {
	 *   function foo() {}
	 * }
	 *
	 * bar.php
	 * -------
	 * class bar {
	 *   function bar() {}
	 * }
	 */
	@Test
	public void testTwoFilesWithClassesAndMethods() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testTwoFilesWithClassesAndMethods");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next();
		PHPFunctionDef function2 = it.next();
		PHPFunctionDef function3 = it.next();
		PHPFunctionDef function4 = it.next();
		PHPFunctionDef function5 = it.next();
		PHPFunctionDef function6 = it.next();
		
		assertEquals( 6, funcs.size());

		assertEquals("foo", function.getName());
		assertEquals("[foo]", function2.getName());
		assertEquals("<./foobar/foo.php>", function3.getName());
		assertEquals("bar", function4.getName());
		assertEquals("[bar]", function5.getName());
		assertEquals("<./foobar/bar.php>", function6.getName());
	}

	/**
	 * An invalid CSV file which contains no toplevel node of a file to
	 * initialize top-level code.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidNoFileTopLevelNode() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";

		this.nodeReader = new StringReader(nodeStr);

		super.extractor.initialize(this.nodeReader, this.edgeReader);
		super.extractor.getNextFunction();
	}
	
	/**
	 * An invalid CSV file which contains a line that refers to a
	 * funcid that has not previously been declared by a function
	 * declaration node.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidUninitializedFuncId() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		//nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";
		
		this.nodeReader = new StringReader(nodeStr);

		super.extractor.initialize(this.nodeReader, this.edgeReader);
		super.extractor.getNextFunction();
	}
	
	/**
	 * An invalid CSV file which contains a toplevel node of a file
	 * before the previous file has been cleared by a new File node.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidToplevelNodeWithoutFileNode() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";
		//nodeStr += "8,File,,,,,,,\"bar.php\",\n";
		nodeStr += "9,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"bar.php\",\n";
		
		this.nodeReader = new StringReader(nodeStr);

		super.extractor.initialize(this.nodeReader, this.edgeReader);
		super.extractor.getNextFunction();
	}
	
	
	/*
	 * -------------
	 * Reading edges
	 * -------------
	 */

	/**
	 * function foo() {}
	 */
	@Test
	public void testSingleFunctionEdges() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testSingleFunction");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next(); // function foo()
		PHPFunctionDef function2 = it.next(); // <./foo.php>
		
		assertEquals( 2, funcs.size());
		
		assertEquals( 4, function.getChildCount());
		assertEquals( 1, function2.getChildCount());
		// Note: the top-level function does not have any children,
		// since the only statement in it - the function declaration of function foo() -
		// is ignored within the top-level function, as foo() gets its own AST and analysis.
		assertEquals( 0, function2.getContent().getChildCount());
	}
	
	/**
	 * foo.php
	 * -------
	 * function foo() {}
	 *
	 * bar.php
	 * -------
	 * function bar() {}
	 */
	@Test
	public void testTwoFilesEdges() throws IOException, InvalidCSVFile
	{
		HashMap<String,PHPFunctionDef> funcs = getAllFuncASTs( "testTwoFiles");

		Iterator<PHPFunctionDef> it = funcs.values().iterator();
		
		PHPFunctionDef function = it.next(); // function foo()
		PHPFunctionDef function2 = it.next(); // <./foobar/foo.php>
		PHPFunctionDef function3 = it.next(); // function bar()
		PHPFunctionDef function4 = it.next(); // <./foobar/bar.php>
		
		assertEquals( 4, funcs.size());
		
		assertEquals( 4, function.getChildCount());
		assertEquals( 1, function2.getChildCount());
		assertEquals( 4, function3.getChildCount());
		assertEquals( 1, function4.getChildCount());
		
		assertEquals( 0, function.getContent().getChildCount());
		// Note: the top-level function <foobar/foo.php> does not have any children,
		// since the only statement in it - the function declaration of function foo() -
		// is ignored within the top-level function, as foo() gets its own AST and analysis.
		assertEquals( 0, function2.getContent().getChildCount());
		assertEquals( 0, function3.getContent().getChildCount());
		// Note: the top-level function <foobar/bar.php> does not have any children,
		// since the only statement in it - the function declaration of function bar() -
		// is ignored within the top-level function, as foo() gets its own AST and analysis.
		assertEquals( 0, function4.getContent().getChildCount());
	}
	
	/**
	 * An invalid CSV file which contains an invalid edge type.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidEdgeType() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,7,somerandomtype\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "1,2,PARENT_OF\n";
		edgeStr += "0,1,FILE_OF\n";
		
		this.nodeReader = new StringReader(nodeStr);
		this.edgeReader = new StringReader(edgeStr);

		super.extractor.initialize(this.nodeReader, this.edgeReader);
		super.extractor.getNextFunction();
	}
	
}
