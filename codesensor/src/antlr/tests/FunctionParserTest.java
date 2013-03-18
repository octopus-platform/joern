package antlr.tests;

import static org.junit.Assert.*;
import main.FunctionParser.FunctionParser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class FunctionParserTest {

	@Test
	public void testIf()
	{
		String input = "if(foo){}";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		String output = tree.toStringTree(functionParser.parser);
		System.out.println(output);
		assertTrue(output.contains("(if_statement"));
	}

	@Test
	public void testStructInFunc()
	{
		String input = "class foo{ int x; };";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		String output = tree.toStringTree(functionParser.parser);
		assertTrue(output.contains("class_def"));
	}

	@Test
	public void testPreprocIf()
	{
		String input = "#if foo\n #endif";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		String output = tree.toStringTree(functionParser.parser);
		System.out.println(output);
		assertTrue(output.equals("(statements (pre_opener #if foo\\n) (pre_closer #endif))"));
	}
	
	@Test
	public void testFunctionCall()
	{
		String input = "foo(x);";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		String output = tree.toStringTree(functionParser.parser);
		assertTrue(output.contains("function_argument_list"));
	}
	
	@Test
	public void testCallViaPtr()
	{
		String input = "ptr->foo(x);";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		String output = tree.toStringTree(functionParser.parser);
		assertTrue(output.contains("function_argument_list"));
	}
	
	@Test
	public void testCallWithExprInArg()
	{
		String input = "foo(x == 1, x++);";
		FunctionParser functionParser = new FunctionParser();
		ParseTree tree = functionParser.parse(input);
		String output = tree.toStringTree(functionParser.parser);
		assertTrue(output.contains("function_argument_list"));
	}
	
}
