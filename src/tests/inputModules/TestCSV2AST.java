package tests.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import ast.functionDef.FunctionDef;
import inputModules.csv.csv2ast.CSV2AST;

public class TestCSV2AST
{

	@Test
	public void testMethodCreation() throws IOException
	{
		String str = "nodeId:ID,type,name\n1,AST_METHOD,foo";
		FunctionDef func = createASTFromString(str);
		assertTrue(func != null);
	}

	@Test
	public void testMethodName() throws IOException
	{
		String str = "nodeId:ID,type,name\n1,AST_METHOD,foo";
		FunctionDef funcDef = createASTFromString(str);
		assertEquals("foo", funcDef.getName().getEscapedCodeStr());
	}

	@Test
	public void testMissingMethodName() throws IOException
	{
		String str = "nodeId:ID,type\n1,AST_METHOD";
		FunctionDef funcDef = createASTFromString(str);
		assertEquals("", funcDef.getName().getEscapedCodeStr());
	}

	private FunctionDef createASTFromString(String str) throws IOException
	{
		CSV2AST csv2AST = new CSV2AST();
		StringReader nodeReader = new StringReader(str);
		csv2AST.setLanguage("PHP");
		return csv2AST.convert(nodeReader, null);
	}

}
