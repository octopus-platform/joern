package tests.antlrParsers.functionParser;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import parsing.ANTLRFunctionParserDriver;

public class FunctionParserTest
{

	@Test
	public void testIf()
	{
		String input = "if(foo){}";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("(selection_or_iteration if"));
	}

	@Test
	public void testStructInFunc()
	{
		String input = "class foo{ int x; };";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("class_def"));
	}

	@Test
	public void testSizeofStruct()
	{
		String input = "while((buffer + len) > (tmp + sizeof(struct stun_attrib))) {}";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("selection_or_iteration while"));
	}

}
