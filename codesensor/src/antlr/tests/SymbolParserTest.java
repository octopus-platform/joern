package antlr.tests;

import static org.junit.Assert.*;


import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import SymbolParser.SymbolParser;

public class SymbolParserTest {

	@Test
	public void testCall()
	{
		String input = "foo();";
		SymbolParser parser = new SymbolParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		assert(output.contains("function_argument_list"));
	}

	@Test
	public void testFieldCall()
	{
		String input = "foo->bar();";
		SymbolParser parser = new SymbolParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		assert(output.contains("function_argument_list"));
	}

	@Test
	public void testCallExprArg()
	{
		String input = "foo->bar((x + 10 < 20) ? 1: 0);";
		SymbolParser parser = new SymbolParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		assert(output.contains("function_argument_list"));
	}
	
	@Test
	public void testCallInCall()
	{
		String input = "foo(bar());";
		SymbolParser parser = new SymbolParser();
		ParseTree tree = parser.parseString(input);
		String output = tree.toStringTree(parser.parser);
		System.out.println(output);
		
		int occ = countOccurrences("function_argument_list", output);
		assert(occ == 2);
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
