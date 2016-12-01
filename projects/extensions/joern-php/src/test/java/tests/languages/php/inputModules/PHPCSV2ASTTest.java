package tests.languages.php.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import ast.expressions.AssignmentExpression;
import ast.expressions.Variable;
import ast.logical.statements.CompoundStatement;
import ast.php.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;
import inputModules.csv.csv2ast.PHPCSV2AST;
import tools.php.ast2cpg.PHPCSVEdgeInterpreter;
import tools.php.ast2cpg.PHPCSVNodeInterpreter;

public class PHPCSV2ASTTest
{
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

	public static FunctionDef createASTFromStrings(String nodeStr, String edgeStr)
			throws IOException, InvalidCSVFile
	{
		CSV2AST csv2AST = new PHPCSV2AST();
		StringReader nodeReader = new StringReader(nodeStr);
		StringReader edgeReader = new StringReader(edgeStr);
		csv2AST.setInterpreters(new PHPCSVNodeInterpreter(), new PHPCSVEdgeInterpreter());

		return (FunctionDef)csv2AST.convert(nodeReader, edgeReader);
	}

	@Test
	public void testFunctionCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "5	AST_FUNC_DECL		3		0	1		\"\"	3	foo	" + RECORD_SEPARATOR;
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);

		assertTrue(func != null);
	}

	@Test
	public void testFunctionName() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "5	AST_FUNC_DECL		3		0	1		\"\"	3	foo	" + RECORD_SEPARATOR;
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);

		assertEquals("foo", func.getName());
	}

	@Test
	public void testMissingFunctionName() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "5	AST_FUNC_DECL		3		0	1		\"\"	3		" + RECORD_SEPARATOR;
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);

		assertEquals("", func.getName());
	}

	@Test
	public void testMethodFlags() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "12	AST_METHOD	MODIFIER_PUBLIC	4		0	8	Foo	\"\"	6	bar	" + RECORD_SEPARATOR;
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);

		assertEquals("bar", func.getName());
		assertEquals("MODIFIER_PUBLIC", func.getFlags());
	}

	@Test
	public void testMethodLocation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "12	AST_METHOD	MODIFIER_PUBLIC	4		0	8	Foo	\"\"	6	bar	" + RECORD_SEPARATOR;
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);

		assertEquals("bar", func.getName());
		assertEquals(4, func.getLocation().startLine);
		assertEquals(6, func.getLocation().endLine);
	}

	@Test
	public void testDocComment() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "5	AST_FUNC_DECL		9		0	1		\"\"	9	foo	\"/**\n" +
				" * This is a doccomment\n" +
				" * with evil newlines\n" +
				" * and evil \\\"quotes\\\" as\n" +
				" * well as evil	tabs	.\n" +
				" */\"" + RECORD_SEPARATOR;
		FunctionDef func = createASTFromStrings(nodeStr, edgeHeader);

		assertEquals("foo", func.getName());
		assertEquals("/**\n" +
				" * This is a doccomment\n" +
				" * with evil newlines\n" +
				" * and evil \"quotes\" as\n" +
				" * well as evil	tabs	.\n" +
				" */", func.getDocComment());
	}

	/**
	 * function foo() {
	 *   $a = 3;
	 * }
	 */
	@Test
	public void testEdgeImportAndCodeStr() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr +=
				//"0	File									\"foo.php\"	" + RECORD_SEPARATOR +
				//"1	AST_TOPLEVEL	TOPLEVEL_FILE	1					\"\"	5	\"foo.php\"	" + RECORD_SEPARATOR +
				//"2	CFG_FUNC_ENTRY					1				\"foo.php\"	" + RECORD_SEPARATOR +
				//"3	CFG_FUNC_EXIT					1				\"foo.php\"	" + RECORD_SEPARATOR +
				//"4	AST_STMT_LIST		1		0	1		\"\"			" + RECORD_SEPARATOR +
				"5	AST_FUNC_DECL		3		0	1		\"\"	5	foo	" + RECORD_SEPARATOR +
				//"6	CFG_FUNC_ENTRY					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				//"7	CFG_FUNC_EXIT					5		\"\"		\"foo\"	" + RECORD_SEPARATOR +
				"8	AST_PARAM_LIST		3		0	5		\"\"			" + RECORD_SEPARATOR +
				"9	NULL		3		1	5		\"\"			" + RECORD_SEPARATOR +
				"10	AST_STMT_LIST		3		2	5		\"\"			" + RECORD_SEPARATOR +
				"11	AST_ASSIGN		4		0	5		\"\"			" + RECORD_SEPARATOR +
				"12	AST_VAR		4		0	5		\"\"			" + RECORD_SEPARATOR +
				"13	string		4	\"a\"	0	5		\"\"			" + RECORD_SEPARATOR +
				"14	integer		4	3	1	5		\"\"			" + RECORD_SEPARATOR +
				"15	NULL		3		3	5		\"\"			" + RECORD_SEPARATOR;

		String edgeStr = edgeHeader;
		edgeStr +=
				//"1	2	ENTRY" + RECORD_SEPARATOR +
				//"1	3	EXIT" + RECORD_SEPARATOR +
				//"5	6	ENTRY" + RECORD_SEPARATOR +
				//"5	7	EXIT" + RECORD_SEPARATOR +
				"5	8	PARENT_OF" + RECORD_SEPARATOR +
				"5	9	PARENT_OF" + RECORD_SEPARATOR +
				"12	13	PARENT_OF" + RECORD_SEPARATOR +
				"11	12	PARENT_OF" + RECORD_SEPARATOR +
				"11	14	PARENT_OF" + RECORD_SEPARATOR +
				"10	11	PARENT_OF" + RECORD_SEPARATOR +
				"5	10	PARENT_OF" + RECORD_SEPARATOR +
				"5	15	PARENT_OF" + RECORD_SEPARATOR;
				//"4	5	PARENT_OF" + RECORD_SEPARATOR +
				//"1	4	PARENT_OF" + RECORD_SEPARATOR +
				//"0	1	FILE_OF" + RECORD_SEPARATOR;

		FunctionDef func = createASTFromStrings(nodeStr, edgeStr);
		CompoundStatement content = func.getContent();

		assertEquals( 1, content.getChildCount());

		AssignmentExpression assignment = (AssignmentExpression)content.getStatement(0);

		assertEquals( "a", ((Variable)assignment.getLeft()).getNameExpression().getEscapedCodeStr());
		assertEquals( "3", assignment.getRight().getEscapedCodeStr());
	}

	/**
	 * An invalid CSV file that is empty.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidCSVEmpty() throws IOException, InvalidCSVFile
	{
		createASTFromStrings(nodeHeader, edgeHeader);
	}

	/**
	 * An invalid CSV file that does not start with a function declaration.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidCSVNoFuncType() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "4	AST_STMT_LIST		1		0	1		\"\"			" + RECORD_SEPARATOR;

		createASTFromStrings(nodeStr, edgeHeader);
	}

	/**
	 * An invalid CSV file that contains a toplevel node with invalid flags.
	 */
	@Test(expected=InvalidCSVFile.class)
	public void testInvalidTopLevelFuncFlags() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "1	AST_TOPLEVEL	somerandomflags	1					\"\"	1	\"foo.php\"	";

		createASTFromStrings(nodeStr, edgeHeader);
	}
}
