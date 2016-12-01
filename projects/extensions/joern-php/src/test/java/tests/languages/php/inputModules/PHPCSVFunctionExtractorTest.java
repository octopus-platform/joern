package tests.languages.php.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import ast.functionDef.FunctionDefBase;
import ast.php.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVFunctionExtractorBasedTest;

public class PHPCSVFunctionExtractorTest extends PHPCSVFunctionExtractorBasedTest
{
	private StringReader nodeReader;
	private StringReader edgeReader;
	// See {@link https://github.com/jexp/batch-import} for detailed
	// information about the header file format
	private final static String DELIMITER = "\t";
	private final static String RECORD_SEPARATOR = "\n";
	String nodeHeader = "id:int" + DELIMITER +
						"type" + DELIMITER +
						"flags:string_array" + DELIMITER +
						"lineno:int" + DELIMITER +
						"code" + DELIMITER +
						"childnum:int" + DELIMITER +
						"funcid:int" + DELIMITER +
						"classname" + DELIMITER +
						"namespace" + DELIMITER +
						"endlineno:int" + DELIMITER +
						"name" + DELIMITER +
						"doccomment" + RECORD_SEPARATOR;
	String edgeHeader = "start" + DELIMITER +
						"end" + DELIMITER +
						"type" + RECORD_SEPARATOR;
	
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
	        FunctionDefBase function = extractor.getNextFunction();

	        assertNull(function);
	}

	
	/**
	 * function foo() {}
	 */
	@Test
	public void testSingleFunction() throws IOException, InvalidCSVFile
	{
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testSingleFunction");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testFunctionPlusTopLevel");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testTopLevelFuncTopLevel");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testTwoFunctions");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testFunctionWithInnerFunction");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testTwoFunctionsAndInnerFunction");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		FunctionDef function4 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testFunctionWithClosure");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testTwoFiles");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		FunctionDef function4 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testSingleClass");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testFunctionAndTwoClassesWithMethod");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		FunctionDef function4 = it.next();
		FunctionDef function5 = it.next();
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testTwoFilesWithClassesAndMethods");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next();
		FunctionDef function2 = it.next();
		FunctionDef function3 = it.next();
		FunctionDef function4 = it.next();
		FunctionDef function5 = it.next();
		FunctionDef function6 = it.next();
		
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
		nodeStr +=
				"0	File									\"foo.php\"	" + RECORD_SEPARATOR +
				//"1	AST_TOPLEVEL	TOPLEVEL_FILE	1					\"\"	3	\"foo.php\"	" + RECORD_SEPARATOR +
				"2	CFG_FUNC_ENTRY					1				\"foo.php\"	" + RECORD_SEPARATOR +
				"3	CFG_FUNC_EXIT					1				\"foo.php\"	" + RECORD_SEPARATOR +
				"4	AST_STMT_LIST		1		0	1		\"\"			" + RECORD_SEPARATOR +
				"5	AST_FUNC_DECL		3		0	1		\"\"	3	foo	" + RECORD_SEPARATOR +
				"6	CFG_FUNC_ENTRY					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"7	CFG_FUNC_EXIT					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"8	AST_PARAM_LIST		3		0	5		\"\"			" + RECORD_SEPARATOR +
				"9	NULL		3		1	5		\"\"			" + RECORD_SEPARATOR +
				"10	AST_STMT_LIST		3		2	5		\"\"			" + RECORD_SEPARATOR +
				"11	NULL		3		3	5		\"\"			" + RECORD_SEPARATOR;


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
		nodeStr +=
				"0	File									\"foo.php\"	" + RECORD_SEPARATOR +
				"1	AST_TOPLEVEL	TOPLEVEL_FILE	1					\"\"	3	\"foo.php\"	" + RECORD_SEPARATOR +
				"2	CFG_FUNC_ENTRY					1				\"foo.php\"	" + RECORD_SEPARATOR +
				"3	CFG_FUNC_EXIT					1				\"foo.php\"	" + RECORD_SEPARATOR +
				"4	AST_STMT_LIST		1		0	1		\"\"			" + RECORD_SEPARATOR +
				//"5	AST_FUNC_DECL		3		0	1		\"\"	3	foo	" + RECORD_SEPARATOR +
				"6	CFG_FUNC_ENTRY					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"7	CFG_FUNC_EXIT					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"8	AST_PARAM_LIST		3		0	5		\"\"			" + RECORD_SEPARATOR +
				"9	NULL		3		1	5		\"\"			" + RECORD_SEPARATOR +
				"10	AST_STMT_LIST		3		2	5		\"\"			" + RECORD_SEPARATOR +
				"11	NULL		3		3	5		\"\"			" + RECORD_SEPARATOR;
		
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
		nodeStr +=
				"0	Directory									\"foobar\"	" + RECORD_SEPARATOR +
				"1	File									\"foo.php\"	" + RECORD_SEPARATOR +
				"2	AST_TOPLEVEL	TOPLEVEL_FILE	1					\"\"	0	\"foobar/foo.php\"	" + RECORD_SEPARATOR +
				"3	CFG_FUNC_ENTRY					2				\"foobar/foo.php\"	" + RECORD_SEPARATOR +
				"4	CFG_FUNC_EXIT					2				\"foobar/foo.php\"	" + RECORD_SEPARATOR +
				"5	NULL		0		0	2		\"\"			" + RECORD_SEPARATOR +
				//"6	File									\"bar.php\"	" + RECORD_SEPARATOR +
				"7	AST_TOPLEVEL	TOPLEVEL_FILE	1					\"\"	0	\"foobar/bar.php\"	" + RECORD_SEPARATOR +
				"8	CFG_FUNC_ENTRY					7				\"foobar/bar.php\"	" + RECORD_SEPARATOR +
				"9	CFG_FUNC_EXIT					7				\"foobar/bar.php\"	" + RECORD_SEPARATOR +
				"10	NULL		0		0	7		\"\"			" + RECORD_SEPARATOR;
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testSingleFunction");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next(); // function foo()
		FunctionDef function2 = it.next(); // <./foo.php>
		
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
		HashMap<String,FunctionDef> funcs = getAllFuncASTs( "testTwoFiles");

		Iterator<FunctionDef> it = funcs.values().iterator();
		
		FunctionDef function = it.next(); // function foo()
		FunctionDef function2 = it.next(); // <./foobar/foo.php>
		FunctionDef function3 = it.next(); // function bar()
		FunctionDef function4 = it.next(); // <./foobar/bar.php>
		
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
		nodeStr +=
				"0	File									\"bla.php\"	" + RECORD_SEPARATOR +
				"1	AST_TOPLEVEL	TOPLEVEL_FILE	1					\"\"	3	\"bla.php\"	" + RECORD_SEPARATOR +
				"2	CFG_FUNC_ENTRY					1				\"bla.php\"	" + RECORD_SEPARATOR +
				"3	CFG_FUNC_EXIT					1				\"bla.php\"	" + RECORD_SEPARATOR +
				"4	AST_STMT_LIST		1		0	1		\"\"			" + RECORD_SEPARATOR +
				"5	AST_FUNC_DECL		3		0	1		\"\"	3	foo	" + RECORD_SEPARATOR +
				"6	CFG_FUNC_ENTRY					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"7	CFG_FUNC_EXIT					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"8	AST_PARAM_LIST		3		0	5		\"\"			" + RECORD_SEPARATOR +
				"9	NULL		3		1	5		\"\"			" + RECORD_SEPARATOR +
				"10	AST_STMT_LIST		3		2	5		\"\"			" + RECORD_SEPARATOR +
				"11	NULL		3		3	5		\"\"			" + RECORD_SEPARATOR;

		String edgeStr = edgeHeader;
		edgeStr +=
				"1	2	ENTRY" + RECORD_SEPARATOR +
				"1	3	EXIT" + RECORD_SEPARATOR +
				"5	6	ENTRY" + RECORD_SEPARATOR +
				"5	7	EXIT" + RECORD_SEPARATOR +
				"5	8	PARENT_OF" + RECORD_SEPARATOR +
				"5	9	PARENT_OF" + RECORD_SEPARATOR +
				"5	10	somerandomtype" + RECORD_SEPARATOR +
				"5	11	PARENT_OF" + RECORD_SEPARATOR +
				"4	5	PARENT_OF" + RECORD_SEPARATOR +
				"1	4	PARENT_OF" + RECORD_SEPARATOR +
				"0	1	FILE_OF" + RECORD_SEPARATOR;
		
		this.nodeReader = new StringReader(nodeStr);
		this.edgeReader = new StringReader(edgeStr);

		super.extractor.initialize(this.nodeReader, this.edgeReader);
		super.extractor.getNextFunction();
	}
	
}
