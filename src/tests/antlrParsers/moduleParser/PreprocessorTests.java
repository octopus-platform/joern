package tests.antlrParsers.moduleParser;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import antlr.C.ModuleParser;

public class PreprocessorTests extends FunctionDefinitionTests
{

	@Test
	public void testPreprocessorIfs()
	{
		String input = "int foo(){ #if bar\n { #endif\n}";

		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.startsWith("(function_def "));
	}

	@Test
	public void testNestedPreprocessorIfs()
	{
		String input = "int foo(){ #if bar\n #if bar2\n { #endif #endif\n}";

		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.startsWith("(function_def "));
	}

	@Test
	public void testPreprocIfBeforeFunc()
	{
		String input = "#ifdef foo\nint foo(){ #if x\n foo();\n #else\n #endif\n} abc\n #endif\n";
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("(water abc)"));
	}

	@Test
	public void testPreprocIfNesting()
	{
		String input = "foo(){ #ifdef x\n #ifdef y\n #else\n #endif\n#endif\n abc(); } foo();";
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output
				.contains("(compound_statement { #ifdef x\\n #ifdef y\\n #else\\n #endif\\n #endif\\n abc ( ) ; }))"));
	}

	@Test
	public void testPreprocIfInElse()
	{
		String input = "foo(){ #ifdef x\n #else\n #ifdef y\n #endif\n#endif\n abc(); } foo();";
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output
				.contains("(compound_statement { #ifdef x\\n #else\\n #ifdef y\\n #endif\\n #endif\\n abc ( ) ; }))"));
	}

	@Test
	public void testStartingPreProcElse()
	{
		String input = "#ifdef foo\n int foo(){ #else\n {\n#endif\n } abc\n #endif\n";
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("(water abc)"));
	}

}
