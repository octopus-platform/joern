package antlr.tests;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class CodeSensorParserTest {


	private CodeSensorParser createParser(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lex);
        CodeSensorParser parser = new CodeSensorParser(tokens);
        return parser;
	}
	
	// Return values
	
	@Test
	public void testFunction_defNoReturnValue()
	{
		String input = "main(){}";
		String expected = "(function_def (function_name (identifier main)) (function_param_list ( )) (compound_statement { }))";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.equals(expected));
	}

	@Test
	public void testFunction_defReturnValue()
	{
		String input = "int main(){}";
		String expected = "(function_def (return_type (type_name int)) (function_name (identifier main)) (function_param_list ( )) (compound_statement { }))";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.equals(expected));
	}
	
	@Test
	public void testFunction_defPtrReturnValue()
	{
		String input = "int *foo(){}";
		String expected = "(function_def (return_type (type_name int) (ptr_operator *)) (function_name (identifier foo)) (function_param_list ( )) (compound_statement { }))";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.equals(expected));
	}
	
	@Test
	public void testClassDef()
	{
		String input = "struct foo{int x;};";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key struct) (class_name (identifier foo))"));
	}
	
}
