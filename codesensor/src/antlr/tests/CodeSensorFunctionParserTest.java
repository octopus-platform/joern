package antlr.tests;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class CodeSensorFunctionParserTest {

	private CodeSensorParser createParser(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lex);
        CodeSensorParser parser = new CodeSensorParser(tokens);
        return parser;
	}
	
	// Return value
	
	@Test
	public void testFunction_defNoReturnValue()
	{
		String input = "main(){foo}";
		String expected = "(function_def (function_name (identifier main)) (function_param_list ( )) (compound_statement {";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.startsWith(expected));
	}

	@Test
	public void testFunction_defReturnValue()
	{
		String input = "int main(){}";
		String expected = "(function_def (return_type (type_name (base_type int))) (function_name (identifier main)) (function_param_list ( )) (compound_statement { }))";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.equals(expected));
	}
	
	@Test
	public void testFunction_defPtrReturnValue()
	{
		String input = "int *foo(){}";
		String expected = "(function_def (return_type (type_name (base_type int)) (ptr_operator *)) (function_name (identifier foo)) (function_param_list ( )) (compound_statement { }))";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.equals(expected));
	}
	
	@Test
	public void testFunction_defStaticUnsigned()
	{
		String input = "static unsigned my_atoi(const char *p){}";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		System.out.println(output);
		assertTrue(output.startsWith("(function_def (return_type (function_decl_specifiers static) (type_name unsigned)) (function_name (identifier my_atoi))"));
	}
	
	@Test
	public void testFunctionPtrParam()
	{
		String input = "int foo(char *(*param)(void)){}";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.startsWith("(function_def (return_type (type_name (base_type int))) (function_name (identifier foo)) (function_param_list ( (parameter_decl_clause (parameter_decl (param_decl_specifiers (type_name (base_type char))) (parameter_id (ptrs (ptr_operator *)) ( (parameter_id (ptrs (ptr_operator *)) (parameter_name (identifier param))) ) (type_suffix (param_type_list ( void )))))) )) (compound_statement { }))"));
	}

	@Test
	public void testVoidParamList()
	{
		String input = "static int altgid(void){}";
	
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.startsWith("(function_def (return_type (function_decl_specifiers static) (type_name (base_type int))) (function_name (identifier altgid)) (function_param_list ( (parameter_decl_clause void) )) (compound_statement { }))"));
	}
	
	@Test
	public void testParamVoidPtr()
	{
		String input = "static int altgid(void *ptr){}";
	
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.startsWith("(function_def"));
	}

	@Test
	public void testParamConstVoidPtr()
	{
		String input = "static ssize_t _7z_write_data(struct archive_write *a, const void *buff, size_t s){}";
	
		CodeSensorParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.startsWith("(function_def"));
	}
		
}


