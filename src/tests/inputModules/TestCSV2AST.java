package tests.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
import inputModules.csv.csv2ast.CSV2AST;

public class TestCSV2AST
{

	String edgeFileHeader = "START_ID, END_ID, TYPE";

	@Test
	public void testMethodCreation() throws IOException
	{
		String str = "id:ID,type,name\n1,AST_METHOD,foo";
		FunctionDef func = createASTFromStrings(str, edgeFileHeader);
		assertTrue(func != null);
	}

	@Test
	public void testMethodName() throws IOException
	{
		String str = "id:ID,type,name\n1,AST_METHOD,foo";
		FunctionDef funcDef = createASTFromStrings(str, edgeFileHeader);
		assertEquals("foo", funcDef.getName().getEscapedCodeStr());
	}

	@Test
	public void testMissingMethodName() throws IOException
	{
		String str = "id:ID,type\n1,AST_METHOD";
		FunctionDef funcDef = createASTFromStrings(str, edgeFileHeader);
		assertEquals("", funcDef.getName().getEscapedCodeStr());
	}

	@Test
	public void testEdgeBetweenFuncAndName() throws IOException
	{
		String str = "id:ID,type,name\n1,AST_METHOD,foo";
		FunctionDef funcDef = createASTFromStrings(str, edgeFileHeader);
		ASTNode child = funcDef.getChild(0);
		assertTrue(child instanceof Identifier);
	}

	@Test
	public void testSimpleEdgeImport() throws IOException
	{
		String nodeStr = "id:ID,type,name\n1,AST_METHOD,foo\n"
				+ "2,AST_STMT_LIST\n" + "3,AST_ASSIGN";
		String edgeStr = "START_ID,END_ID,TYPE\n1,2\n2,3\n";

		FunctionDef funcDef = createASTFromStrings(nodeStr, edgeStr);
		CompoundStatement content = funcDef.getContent();
		assertEquals(1, content.getChildCount());
	}

	private FunctionDef createASTFromStrings(String nodeStr, String edgeStr)
			throws IOException
	{
		CSV2AST csv2AST = new CSV2AST();
		StringReader nodeReader = new StringReader(nodeStr);
		StringReader edgeReader = new StringReader(edgeStr);
		csv2AST.setLanguage("PHP");
		return csv2AST.convert(nodeReader, edgeReader);
	}

}
