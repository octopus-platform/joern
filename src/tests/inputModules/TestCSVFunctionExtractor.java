package tests.inputModules;

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
	String nodeHeader = "id:ID,type,funcid:int,code\n";
	String edgeHeader = "from,to,type\n";

	@Before
	public void init()
	{
		extractor = new CSVFunctionExtractor();
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
	public void testTopLevelOnlyNoStmtList() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,\"foo\"";
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();

		assertTrue(function == null);
	}

	@Test
	public void testSingleFunctionNodes() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,AST_METHOD,1\n";
		nodeStr += "1,type,1\n";
		nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		assertTrue(function != null);
	}

	@Test
	public void testTopLevelNodesOnly() throws IOException
	{
		String nodeStr = nodeHeader;
		nodeStr += "0,File,,,,,,,\"wp-login.php\",";
		nodeStr += "1,AST_STMT_LIST,,1,,0,,,,";
		StringReader nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();

		assertTrue(function != null);
		assertTrue(extractor.getNextFunction() == null);
	}

}
