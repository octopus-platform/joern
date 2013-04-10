package tests.antlr;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import parsing.CoarseFunctionParser;


public class CoarseFunctionParserTest {
	
	@Test
	public void testCall()
	{
		String input = "foo();";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.getParser());
		System.out.println(output);
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testFieldCall()
	{
		String input = "foo->bar();";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.getParser());
		System.out.println(output);
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testCallExprArg()
	{
		String input = "foo->bar((x + 10 < 20) ? 1: 0);";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.getParser());
		System.out.println(output);
		assertTrue(output.contains("function_argument_list"));
	}
	
	@Test
	public void testCallInCall()
	{
		String input = "foo(bar());";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.getParser());
		System.out.println(output);
		
		int occ = countOccurrences("function_argument_list", output);
		assertTrue(occ == 2);
	}
	
	@Test
	public void testSimpleSimpleDecl()
	{
		String input = "int x;";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.getParser());
		System.out.println(output);
		assertTrue(output.contains("simple_decl"));
	}
	
	private int countOccurrences(String needle, String haystack)
	{
		int result = 0;
		int needleLen = needle.length();
		int start = haystack.indexOf(needle);
		while (start != -1) {
			result++;
			start = haystack.indexOf(needle, start+needleLen);
		}
		return result;
	}
	
}
