package antlr.tests;

import static org.junit.Assert.*;


import main.CoarseFunctionParser.CoarseFunctionParser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;


public class CoarseFunctionParserTest {
	
	@Test
	public void testCall()
	{
		String input = "foo();";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testFieldCall()
	{
		String input = "foo->bar();";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		assertTrue(output.contains("function_argument_list"));
	}

	@Test
	public void testCallExprArg()
	{
		String input = "foo->bar((x + 10 < 20) ? 1: 0);";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		assertTrue(output.contains("function_argument_list"));
	}
	
	@Test
	public void testCallInCall()
	{
		String input = "foo(bar());";
		CoarseFunctionParser parser = new CoarseFunctionParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		
		int occ = countOccurrences("function_argument_list", output);
		assertTrue(occ == 2);
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
