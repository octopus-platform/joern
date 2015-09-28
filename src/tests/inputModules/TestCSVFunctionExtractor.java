package tests.inputModules;

import static org.junit.Assert.assertTrue;

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

	@Before
	public void init()
	{
		extractor = new CSVFunctionExtractor();
		nodeReader = new StringReader("");
		edgeReader = new StringReader("");

	}

	@Test
	public void testEmptyFiles()
	{
		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();
		assertTrue(function == null);
	}

	@Test
	public void testHeaderOnly()
	{
		String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment";
		nodeReader = new StringReader(nodeHeader);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();

		assertTrue(function == null);
	}

	@Test
	public void testTopLevelOnlyNoStmtList()
	{
		String nodeStr = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment";
		nodeStr += "0,File,,,,,,,\"wp-login.php\",";
		StringReader nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();

		assertTrue(function == null);
	}

	@Test
	public void testTopLevelNodesOnly()
	{
		String nodeStr = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment";
		nodeStr += "0,File,,,,,,,\"wp-login.php\",";
		nodeStr += "1,AST_STMT_LIST,,1,,0,,,,";
		StringReader nodeReader = new StringReader(nodeStr);

		extractor.initialize(nodeReader, edgeReader);
		FunctionDef function = extractor.getNextFunction();

		assertTrue(function != null);
		assertTrue(extractor.getNextFunction() == null);
	}

}
