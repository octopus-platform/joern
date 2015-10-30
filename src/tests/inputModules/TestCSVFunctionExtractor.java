package tests.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		// Currently we always generate exactly one top-level CSVAST.
		// TODO this will change once we introduce File nodes.
		//assertTrue(function == null);
		assertEquals("<toplevel>", function.getName().getEscapedCodeStr());
	}

	/**
	 * function foo() {}
	 */
	@Test
	public void testSingleFunction() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		//nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,NULL,,3,,3,2,,,\n";
		
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		
		assertEquals("foo", function.getName().getEscapedCodeStr());
		assertEquals("<toplevel>", function2.getName().getEscapedCodeStr());
	}

	/**
	 * function foo() {}
	 * true;
	 */
	@Test
	public void testFunctionPlusTopLevel() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		//nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,NULL,,3,,3,2,,,\n";
		nodeStr += "7,AST_CONST,,5,,1,,,,\n";
		nodeStr += "8,AST_NAME,NAME_NOT_FQ,5,,0,,,,\n";
		nodeStr += "9,string,,5,\"true\",0,,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		
		assertEquals("foo", function.getName().getEscapedCodeStr());
		assertEquals("<toplevel>", function2.getName().getEscapedCodeStr());
		assertTrue(function3 == null);
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
		//nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		nodeStr += "2,AST_CONST,,3,,0,,,,\n";
		nodeStr += "3,AST_NAME,NAME_NOT_FQ,3,,0,,,,\n";
		nodeStr += "4,string,,3,\"true\",0,,,,\n";
		nodeStr += "5,AST_FUNC_DECL,,5,,1,,5,foo,\n";
		nodeStr += "6,AST_PARAM_LIST,,5,,0,5,,,\n";
		nodeStr += "7,NULL,,5,,1,5,,,\n";
		nodeStr += "8,AST_STMT_LIST,,5,,2,5,,,\n";
		nodeStr += "9,NULL,,5,,3,5,,,\n";
		nodeStr += "10,AST_CONST,,7,,2,,,,\n";
		nodeStr += "11,AST_NAME,NAME_NOT_FQ,7,,0,,,,\n";
		nodeStr += "12,string,,7,\"true\",0,,,,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();

		assertEquals("foo", function.getName().getEscapedCodeStr());
		assertEquals("<toplevel>", function2.getName().getEscapedCodeStr());
		assertTrue(function3 == null);
	}

	/**
	 * function foo() {}
	 * function bar() {}
	 */
	@Test
	public void testTwoFunctions() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		//nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,NULL,,3,,3,2,,,\n";
		nodeStr += "7,AST_FUNC_DECL,,5,,1,,5,bar,\n";
		nodeStr += "8,AST_PARAM_LIST,,5,,0,7,,,\n";
		nodeStr += "9,NULL,,5,,1,7,,,\n";
		nodeStr += "10,AST_STMT_LIST,,5,,2,7,,,\n";
		nodeStr += "11,NULL,,5,,3,7,,,\n";
		
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();

		assertEquals("foo", function.getName().getEscapedCodeStr());
		assertEquals("bar", function2.getName().getEscapedCodeStr());
		assertEquals("<toplevel>", function3.getName().getEscapedCodeStr());
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
		//nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,5,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,AST_FUNC_DECL,,4,,0,2,4,bar,\n";
		nodeStr += "7,AST_PARAM_LIST,,4,,0,6,,,\n";
		nodeStr += "8,NULL,,4,,1,6,,,\n";
		nodeStr += "9,AST_STMT_LIST,,4,,2,6,,,\n";
		nodeStr += "10,NULL,,4,,3,6,,,\n";
		nodeStr += "11,NULL,,3,,3,2,,,\n";
	
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();

		assertEquals("bar", function.getName().getEscapedCodeStr());
		assertEquals("foo", function2.getName().getEscapedCodeStr());
		assertEquals("<toplevel>", function3.getName().getEscapedCodeStr());
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
		nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,5,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,AST_FUNC_DECL,,4,,0,2,4,bar,\n";
		nodeStr += "7,AST_PARAM_LIST,,4,,0,6,,,\n";
		nodeStr += "8,NULL,,4,,1,6,,,\n";
		nodeStr += "9,AST_STMT_LIST,,4,,2,6,,,\n";
		nodeStr += "10,NULL,,4,,3,6,,,\n";
		nodeStr += "11,NULL,,3,,3,2,,,\n";
		nodeStr += "12,AST_FUNC_DECL,,7,,1,,7,buz,\n";
		nodeStr += "13,AST_PARAM_LIST,,7,,0,12,,,\n";
		nodeStr += "14,NULL,,7,,1,12,,,\n";
		nodeStr += "15,AST_STMT_LIST,,7,,2,12,,,\n";
		nodeStr += "16,NULL,,7,,3,12,,,\n";

	
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		FunctionDef function3 = extractor.getNextFunction();
		FunctionDef function4 = extractor.getNextFunction();

		assertEquals("bar", function.getName().getEscapedCodeStr());
		assertEquals("foo", function2.getName().getEscapedCodeStr());
		assertEquals("buz", function3.getName().getEscapedCodeStr());
		assertEquals("<toplevel>", function4.getName().getEscapedCodeStr());
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
		//nodeStr += "0,File,,,,,,,\"foo.php\",\n";
		//nodeStr += "1,AST_STMT_LIST,,1,,0,,,,\n";
		//nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,NULL,,3,,3,2,,,\n";
		
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		extractor.getNextFunction();
	}
}
