package tests.antlrParsers.moduleParser;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.ModuleLexer;
import antlr.ModuleParser;

public class FunctionDefinitionTests {

	protected ModuleParser createParser(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		ModuleLexer lex = new ModuleLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lex);
        ModuleParser parser = new ModuleParser(tokens);
        return parser;
	}
	
	@Test
	public void testNestedFunctionName()
	{
		String input = "int (foo)(){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		assertTrue(output.startsWith("(function_def "));
	}
	
	@Test
	public void testOperatorOverloading()
	{
		String input = "inline bool operator == (const PlMessageHeader &b) const {}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		
		assertTrue(output.startsWith("(function_def "));
	}
	
	@Test
	public void testExceptionSpecificationCpp()
	{
		String input = "int foo() throw(){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		
		assertTrue(output.startsWith("(function_def "));
	}
		
}


