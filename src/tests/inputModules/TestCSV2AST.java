package tests.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;

public class TestCSV2AST
{
	// See {@link http://neo4j.com/docs/stable/import-tool-header-format.html} for detailed
	// information about the header file format
	String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment\n";
	String edgeHeader = ":START_ID,:END_ID,:TYPE\n";

	private FunctionDef createASTFromStrings(String nodeStr, String edgeStr)
			throws IOException, InvalidCSVFile
	{
		CSV2AST csv2AST = new CSV2AST();
		StringReader nodeReader = new StringReader(nodeStr);
		StringReader edgeReader = new StringReader(edgeStr);
		csv2AST.setLanguage("PHP");
		return csv2AST.convert(nodeReader, edgeReader);
	}
	
	@Test
	public void testFunctionCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);
		
		assertTrue(func != null);
	}

	@Test
	public void testFunctionName() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);
		
		assertEquals("foo", func.getName());
	}

	@Test
	public void testMissingFunctionName() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,,\n";
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);
		
		assertEquals("", func.getName());
	}
	
	@Test
	public void testMethodFlags() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "13,AST_METHOD,MODIFIER_PUBLIC,6,,0,11,6,bar,\n";
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);
		
		assertEquals("bar", func.getName());
		assertEquals("MODIFIER_PUBLIC", func.getFlags());
	}

	/**
	 * function foo() {
	 *   $a = 3;
	 * }
	 */
	@Test
	public void testSimpleEdgeImport() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_FUNC_DECL,,3,,0,,3,foo,\n";
		nodeStr += "3,AST_PARAM_LIST,,3,,0,2,,,\n";
		nodeStr += "4,NULL,,3,,1,2,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,2,2,,,\n";
		nodeStr += "6,AST_ASSIGN,,4,,0,2,,,\n";
		nodeStr += "7,AST_VAR,,4,,0,2,,,\n";
		nodeStr += "8,string,,4,\"a\",0,2,,,\n";
		nodeStr += "9,integer,,4,3,1,2,,,\n";
		nodeStr += "10,NULL,,3,,3,2,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "2,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "2,5,PARENT_OF\n";
		edgeStr += "2,10,PARENT_OF\n";

		FunctionDef func = createASTFromStrings(nodeStr, edgeStr);
		CompoundStatement content = func.getContent();

		assertEquals(1, content.getChildCount());
	}

	/**
	 * An invalid CSV file that does not start with a function declaration.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidCSVNoFuncType() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		
		createASTFromStrings(nodeStr, edgeHeader);
	}
	
	/**
	 * An invalid CSV file that contains a toplevel node with invalid flags.
	 */
	@Test
	public void testInvalidTopLevelFuncFlags() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "1,AST_TOPLEVEL,somerandomflags,,,,,,\"foo.php\",\n";
		
		createASTFromStrings(nodeStr, edgeHeader);
	}
}
