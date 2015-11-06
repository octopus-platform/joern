package tests.inputModules;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;

public class TestCSVFunctionExtractor
{
	CSVFunctionExtractor extractor;
	StringReader nodeReader;
	StringReader edgeReader;
	// See {@link http://neo4j.com/docs/stable/import-tool-header-format.html} for detailed
	// information about the header file format
	String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment\n";
	String edgeHeader = ":START_ID,:END_ID,:TYPE\n";

	@Before
	public void init()
	{
		extractor = new CSVFunctionExtractor();
		extractor.setLanguage("PHP");
		nodeReader = new StringReader(nodeHeader);
		edgeReader = new StringReader(edgeHeader);
	}

	/**
	 * Note that it is not actually possible to generate a header-only
	 * CSV file with our PHP parser. Even an empty file will generate
	 * two nodes: one File node and one AST_STMT_LIST node.
	 */
	@Test
	public void testHeaderOnly() throws IOException, InvalidCSVFile
	{
		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();

		assertEquals(null, function);
	}

	
	/*
	 * -------------
	 * Reading nodes
	 * -------------
	 */
	
	/**
	 * function foo() {}
	 */
	@Test
	public void testSingleFunction() throws IOException, InvalidCSVFile
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

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();

		assertEquals("foo", function.getName());
		assertEquals("<foo.php>", function2.getName());
		assertEquals(null, function3);
	}

	/**
	 * function foo() {}
	 * true;
	 */
	@Test
	public void testFunctionPlusTopLevel() throws IOException, InvalidCSVFile
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
		nodeStr += "8,AST_CONST,,5,,1,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "10,string,,5,\"true\",0,1,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		
		assertEquals("foo", function.getName());
		assertEquals("<foo.php>", function2.getName());
		assertEquals(null, function3);
	}

	/**
	 * true;
	 * function foo() {}
	 * true;
	 */
	@Test
	public void testTopLevelFuncTopLevel() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"true\",0,1,,,\n";
		nodeStr += "6,AST_FUNC_DECL,,5,,1,1,5,foo,\n";
		nodeStr += "7,AST_PARAM_LIST,,5,,0,6,,,\n";
		nodeStr += "8,NULL,,5,,1,6,,,\n";
		nodeStr += "9,AST_STMT_LIST,,5,,2,6,,,\n";
		nodeStr += "10,NULL,,5,,3,6,,,\n";
		nodeStr += "11,AST_CONST,,7,,2,1,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,7,,0,1,,,\n";
		nodeStr += "13,string,,7,\"true\",0,1,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();

		assertEquals("foo", function.getName());
		assertEquals("<foo.php>", function2.getName());
		assertEquals(null, function3);
	}

	/**
	 * function foo() {}
	 * function bar() {}
	 */
	@Test
	public void testTwoFunctions() throws IOException, InvalidCSVFile
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
		nodeStr += "8,AST_FUNC_DECL,,5,,1,1,5,bar,\n";
		nodeStr += "9,AST_PARAM_LIST,,5,,0,8,,,\n";
		nodeStr += "10,NULL,,5,,1,8,,,\n";
		nodeStr += "11,AST_STMT_LIST,,5,,2,8,,,\n";
		nodeStr += "12,NULL,,5,,3,8,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();

		assertEquals("foo", function.getName());
		assertEquals("bar", function2.getName());
		assertEquals("<foo.php>", function3.getName());
		assertEquals(null, function4);
	}
	
	/**
	 * function foo() {
	 *   function bar() {}
	 * }
	 */
	@Test
	public void testFunctionWithInnerFunction() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_FUNC_DECL,,4,,0,3,4,bar,\n";
		nodeStr += "8,AST_PARAM_LIST,,4,,0,7,,,\n";
		nodeStr += "9,NULL,,4,,1,7,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,7,,,\n";
		nodeStr += "11,NULL,,4,,3,7,,,\n";
		nodeStr += "12,NULL,,3,,3,3,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();

		assertEquals("bar", function.getName());
		assertEquals("foo", function2.getName());
		assertEquals("<foo.php>", function3.getName());
		assertEquals(null, function4);
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
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_FUNC_DECL,,4,,0,3,4,bar,\n";
		nodeStr += "8,AST_PARAM_LIST,,4,,0,7,,,\n";
		nodeStr += "9,NULL,,4,,1,7,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,7,,,\n";
		nodeStr += "11,NULL,,4,,3,7,,,\n";
		nodeStr += "12,NULL,,3,,3,3,,,\n";
		nodeStr += "13,AST_FUNC_DECL,,7,,1,1,7,buz,\n";
		nodeStr += "14,AST_PARAM_LIST,,7,,0,13,,,\n";
		nodeStr += "15,NULL,,7,,1,13,,,\n";
		nodeStr += "16,AST_STMT_LIST,,7,,2,13,,,\n";
		nodeStr += "17,NULL,,7,,3,13,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();
		FunctionDef function5 = extractor.getNextFunction();

		assertEquals("bar", function.getName());
		assertEquals("foo", function2.getName());
		assertEquals("buz", function3.getName());
		assertEquals("<foo.php>", function4.getName());
		assertEquals(null, function5);
	}

	/**
	 * function foo() {
	 *   function() {};
	 * }
	 */
	@Test
	public void testFunctionWithClosure() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_CLOSURE,,4,,0,3,4,{closure},\n";
		nodeStr += "8,AST_PARAM_LIST,,4,,0,7,,,\n";
		nodeStr += "9,NULL,,4,,1,7,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,7,,,\n";
		nodeStr += "11,NULL,,4,,3,7,,,\n";
		nodeStr += "12,NULL,,3,,3,3,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();

		assertEquals("{closure}", function.getName());
		assertEquals("foo", function2.getName());
		assertEquals("<foo.php>", function3.getName());
		assertEquals(null, function4);
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
		String nodeStr = nodeHeader;
		nodeStr += "0,Directory,,,,,,,\"foobar\",\n";
		nodeStr += "1,File,,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foobar/foo.php\",\n";
		nodeStr += "3,AST_STMT_LIST,,1,,0,2,,,\n";
		nodeStr += "4,AST_FUNC_DECL,,3,,0,2,3,foo,\n";
		nodeStr += "5,AST_PARAM_LIST,,3,,0,4,,,\n";
		nodeStr += "6,NULL,,3,,1,4,,,\n";
		nodeStr += "7,AST_STMT_LIST,,3,,2,4,,,\n";
		nodeStr += "8,NULL,,3,,3,4,,,\n";
		nodeStr += "9,File,,,,,,,\"bar.php\",\n";
		nodeStr += "10,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foobar/bar.php\",\n";
		nodeStr += "11,AST_STMT_LIST,,1,,0,10,,,\n";
		nodeStr += "12,AST_FUNC_DECL,,3,,0,10,3,bar,\n";
		nodeStr += "13,AST_PARAM_LIST,,3,,0,12,,,\n";
		nodeStr += "14,NULL,,3,,1,12,,,\n";
		nodeStr += "15,AST_STMT_LIST,,3,,2,12,,,\n";
		nodeStr += "16,NULL,,3,,3,12,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();
		FunctionDef function5 = extractor.getNextFunction();

		assertEquals("foo", function.getName());
		assertEquals("<foobar/foo.php>", function2.getName());
		assertEquals("bar", function3.getName());
		assertEquals("<foobar/bar.php>", function4.getName());
		assertEquals(null, function5);
	}
	
	/**
	 * class foo {}
	 */
	@Test
	public void testSingleClass() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CLASS,,3,,0,1,3,foo,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();

		assertEquals("[foo]", function.getName());
		assertEquals("<foo.php>", function2.getName());
		assertEquals(null, function3);
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
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";
		nodeStr += "8,AST_CLASS,,5,,1,1,7,foo,\n";
		nodeStr += "9,NULL,,5,,0,1,,,\n";
		nodeStr += "10,NULL,,5,,1,1,,,\n";
		nodeStr += "11,AST_TOPLEVEL,TOPLEVEL_CLASS,5,,2,1,7,\"foo\",\n";
		nodeStr += "12,AST_STMT_LIST,,5,,0,11,,,\n";
		nodeStr += "13,AST_METHOD,MODIFIER_PUBLIC,6,,0,11,6,bar,\n";
		nodeStr += "14,AST_PARAM_LIST,,6,,0,13,,,\n";
		nodeStr += "15,NULL,,6,,1,13,,,\n";
		nodeStr += "16,AST_STMT_LIST,,6,,2,13,,,\n";
		nodeStr += "17,NULL,,6,,3,13,,,\n";
		nodeStr += "18,AST_CLASS,,9,,2,1,9,buz,\n";
		nodeStr += "19,NULL,,9,,0,1,,,\n";
		nodeStr += "20,NULL,,9,,1,1,,,\n";
		nodeStr += "21,AST_TOPLEVEL,TOPLEVEL_CLASS,9,,2,1,9,\"buz\",\n";
		nodeStr += "22,AST_STMT_LIST,,9,,0,21,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();
		FunctionDef function5 = extractor.getNextFunction();
		FunctionDef function6 = extractor.getNextFunction();

		assertEquals("foo", function.getName());
		assertEquals("bar", function2.getName());
		assertEquals("[foo]", function3.getName());
		assertEquals("[buz]", function4.getName());
		assertEquals("<foo.php>", function5.getName());
		assertEquals(null, function6);
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
		String nodeStr = nodeHeader;
		nodeStr += "0,Directory,,,,,,,\"foobar\",\n";
		nodeStr += "1,File,,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foobar/foo.php\",\n";
		nodeStr += "3,AST_STMT_LIST,,1,,0,2,,,\n";
		nodeStr += "4,AST_CLASS,,3,,0,2,5,foo,\n";
		nodeStr += "5,NULL,,3,,0,2,,,\n";
		nodeStr += "6,NULL,,3,,1,2,,,\n";
		nodeStr += "7,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,2,5,\"foo\",\n";
		nodeStr += "8,AST_STMT_LIST,,3,,0,7,,,\n";
		nodeStr += "9,AST_METHOD,MODIFIER_PUBLIC,4,,0,7,4,foo,\n";
		nodeStr += "10,AST_PARAM_LIST,,4,,0,9,,,\n";
		nodeStr += "11,NULL,,4,,1,9,,,\n";
		nodeStr += "12,AST_STMT_LIST,,4,,2,9,,,\n";
		nodeStr += "13,NULL,,4,,3,9,,,\n";
		nodeStr += "14,File,,,,,,,\"bar.php\",\n";
		nodeStr += "15,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foobar/bar.php\",\n";
		nodeStr += "16,AST_STMT_LIST,,1,,0,15,,,\n";
		nodeStr += "17,AST_CLASS,,3,,0,15,5,bar,\n";
		nodeStr += "18,NULL,,3,,0,15,,,\n";
		nodeStr += "19,NULL,,3,,1,15,,,\n";
		nodeStr += "20,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,15,5,\"bar\",\n";
		nodeStr += "21,AST_STMT_LIST,,3,,0,20,,,\n";
		nodeStr += "22,AST_METHOD,MODIFIER_PUBLIC,4,,0,20,4,bar,\n";
		nodeStr += "23,AST_PARAM_LIST,,4,,0,22,,,\n";
		nodeStr += "24,NULL,,4,,1,22,,,\n";
		nodeStr += "25,AST_STMT_LIST,,4,,2,22,,,\n";
		nodeStr += "26,NULL,,4,,3,22,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();
		FunctionDef function5 = extractor.getNextFunction();
		FunctionDef function6 = extractor.getNextFunction();

		assertEquals("foo", function.getName());
		assertEquals("[foo]", function2.getName());
		assertEquals("<foobar/foo.php>", function3.getName());
		assertEquals("bar", function4.getName());
		assertEquals("[bar]", function5.getName());
		assertEquals("<foobar/bar.php>", function6.getName());
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

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		extractor.getNextFunction();
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
		
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		extractor.getNextFunction();
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
		
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		extractor.getNextFunction();
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
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "1,2,PARENT_OF\n";
		edgeStr += "0,1,FILE_OF\n";
		
		nodeReader = new StringReader(nodeStr);
		edgeReader = new StringReader(edgeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();

		assertEquals(4, function.getChildCount());
		assertEquals(1, function2.getChildCount());
		assertEquals(1, function2.getContent().getChildCount());
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
		String nodeStr = nodeHeader;
		nodeStr += "0,Directory,,,,,,,\"foobar\",\n";
		nodeStr += "1,File,,,,,,,\"foo.php\",\n";
		nodeStr += "2,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foobar/foo.php\",\n";
		nodeStr += "3,AST_STMT_LIST,,1,,0,2,,,\n";
		nodeStr += "4,AST_FUNC_DECL,,3,,0,2,3,foo,\n";
		nodeStr += "5,AST_PARAM_LIST,,3,,0,4,,,\n";
		nodeStr += "6,NULL,,3,,1,4,,,\n";
		nodeStr += "7,AST_STMT_LIST,,3,,2,4,,,\n";
		nodeStr += "8,NULL,,3,,3,4,,,\n";
		nodeStr += "9,File,,,,,,,\"bar.php\",\n";
		nodeStr += "10,AST_TOPLEVEL,TOPLEVEL_FILE,,,,,,\"foobar/bar.php\",\n";
		nodeStr += "11,AST_STMT_LIST,,1,,0,10,,,\n";
		nodeStr += "12,AST_FUNC_DECL,,3,,0,10,3,bar,\n";
		nodeStr += "13,AST_PARAM_LIST,,3,,0,12,,,\n";
		nodeStr += "14,NULL,,3,,1,12,,,\n";
		nodeStr += "15,AST_STMT_LIST,,3,,2,12,,,\n";
		nodeStr += "16,NULL,,3,,3,12,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "4,7,PARENT_OF\n";
		edgeStr += "4,8,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "1,2,FILE_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "12,16,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,FILE_OF\n";
		edgeStr += "0,1,DIRECTORY_OF\n";
		edgeStr += "0,9,DIRECTORY_OF\n";

		nodeReader = new StringReader(nodeStr);
		edgeReader = new StringReader(edgeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();

		assertEquals(4, function.getChildCount());
		assertEquals(1, function2.getChildCount());
		assertEquals(4, function3.getChildCount());
		assertEquals(1, function4.getChildCount());
		
		assertEquals(0, function.getContent().getChildCount());
		assertEquals(1, function2.getContent().getChildCount());
		assertEquals(0, function3.getContent().getChildCount());
		assertEquals(1, function4.getContent().getChildCount());
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
		
		nodeReader = new StringReader(nodeStr);
		edgeReader = new StringReader(edgeStr);

		extractor.initialize(nodeReader, edgeReader);
		extractor.getNextFunction();
	}
	
}
