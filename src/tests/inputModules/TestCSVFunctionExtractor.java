package tests.inputModules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.functionDef.FunctionDef;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;

public class TestCSVFunctionExtractor
{
	CSVFunctionExtractor extractor;
	StringReader nodeReader;
	StringReader edgeReader;
	String nodeHeader = "id:ID,type,funcId:int,name\n";
	String edgeHeader = "from,to,type\n";

	@Before
	public void init()
	{
		extractor = new CSVFunctionExtractor();
		extractor.setLanguage("PHP");
		nodeReader = new StringReader(nodeHeader);
		edgeReader = new StringReader(edgeHeader);
	}

	@Test
	public void testHeaderOnly() throws IOException
	{
		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		assertTrue(function == null);
	}

	@Test
	public void testSingleFunction() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,AST_METHOD,1,foo\n";
		nodeStr += "1,type,1\n";
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		assertEquals("foo", function.getName().getEscapedCodeStr());
	}

	@Test
	public void testFunctionPlusTopLevel() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,AST_METHOD,1\n";
		nodeStr += "1,type,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		assertTrue(function != null);
		FunctionDef function2 = extractor.getNextFunction();
		assertTrue(function2 != null);
		FunctionDef function3 = extractor.getNextFunction();
		assertTrue(function3 == null);
	}

	@Test
	public void testTopLevelFuncTopLevel() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,type,\n";
		nodeStr += "1,AST_METHOD,1,foo\n";
		nodeStr += "2,type,\n";

		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		assertTrue(function != null);
		FunctionDef function2 = extractor.getNextFunction();
		assertTrue(function2 != null);
		FunctionDef function3 = extractor.getNextFunction();
		assertTrue(function3 == null);

	}

	@Test
	public void testTwoFunctions() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,AST_METHOD,1,foo\n";
		nodeStr += "1,AST_METHOD,2,bar\n";
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		FunctionDef function2 = extractor.getNextFunction();
		assertEquals("foo", function.getName().getEscapedCodeStr());
		assertEquals("bar", function2.getName().getEscapedCodeStr());
	}

}
