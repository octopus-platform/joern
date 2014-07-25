package tests.antlrParsers.functionParser;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import parsing.ANTLRFunctionParserDriver;

public class ForLoopTests
{

	@Test
	public void testEmptyFor()
	{
		String input = "for(; ;){}";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("selection_or_iteration"));
	}

	@Test
	public void testDeclInFor()
	{
		String input = "for(int k = 0; k < 10; k++ ){}";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output
				.contains("for ( (for_init_statement (simple_decl (var_decl (type_name (base_type int))"));
	}

	@Test
	public void testComplexFor()
	{
		String input = "for(int k = 0; k < 10; ( k += ((c = text[k]) >= sBMHCharSetSize) ? patlen : skip[c]) ){}";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("assign_expr"));
	}
}
