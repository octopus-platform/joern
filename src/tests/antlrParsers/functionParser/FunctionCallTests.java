package tests.antlrParsers.functionParser;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import parsing.ANTLRFunctionParserDriver;

public class FunctionCallTests
{

	@Test
	public void testFunctionCall()
	{
		String input = "foo(x);";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testTwoParameters()
	{
		String input = "foo(x,y);";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains(", (function_argument"));
	}

	@Test
	public void testCallViaPtr()
	{
		String input = "ptr->foo(x);";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testCallWithExprInArg()
	{
		String input = "foo(x == 1, x++);";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		assertTrue(output.contains("function_argument_list"));
	}
}
