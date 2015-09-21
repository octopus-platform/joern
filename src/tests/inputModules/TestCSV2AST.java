package tests.inputModules;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import ast.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;

public class TestCSV2AST
{

	@Test
	public void testMethodCreation() throws InvalidCSVFile, IOException
	{
		String str = "nodeId:ID,type,name\n1,AST_METHOD,foo";
		createASTFromString(str);
	}

	@Test
	public void testMethodName() throws InvalidCSVFile, IOException
	{
		String str = "nodeId:ID,type,name\n1,AST_METHOD,foo";
		FunctionDef funcDef = createASTFromString(str);
		assertEquals("foo", funcDef.getName().getEscapedCodeStr());
	}

	private FunctionDef createASTFromString(String str)
			throws InvalidCSVFile, IOException
	{
		CSV2AST csv2AST = new CSV2AST();
		StringReader nodeReader = new StringReader(str);
		return csv2AST.convert(nodeReader, null);
	}

}
