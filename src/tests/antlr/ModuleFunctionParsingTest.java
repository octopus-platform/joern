package tests.antlr;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.ModuleLexer;
import antlr.ModuleParser;

public class ModuleFunctionParsingTest {

	private ModuleParser createParser(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		ModuleLexer lex = new ModuleLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lex);
        ModuleParser parser = new ModuleParser(tokens);
        return parser;
	}
	
	// Return value
	
	@Test
	public void testFunction_defNoReturnValue()
	{
		String input = "main(){foo}";
		String expected = "(function_def (function_name (identifier main)) (function_param_list ( )) (compound_statement {";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.startsWith(expected));
	}

	@Test
	public void testFunction_defReturnValue()
	{
		String input = "int main(){}";
		String expected = "(function_def (return_type (type_name (base_type int))) (function_name (identifier main)) (function_param_list ( )) (compound_statement { }))";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.equals(expected));
	}
	
	@Test
	public void testFunction_defPtrReturnValue()
	{
		String input = "int *foo(){}";
		String expected = "(function_def (return_type (type_name (base_type int)) (ptr_operator *)) (function_name (identifier foo)) (function_param_list ( )) (compound_statement { }))";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.equals(expected));
	}
	
	@Test
	public void testFunction_defStaticUnsigned()
	{
		String input = "static unsigned my_atoi(const char *p){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		System.out.println(output);
		assertTrue(output.startsWith("(function_def (return_type (function_decl_specifiers static) (type_name unsigned)) (function_name (identifier my_atoi))"));
	}
	
	@Test
	public void testFunctionPtrParam()
	{
		String input = "int foo(char *(*param)(void)){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.startsWith("(function_def (return_type (type_name (base_type int))) (function_name (identifier foo)) (function_param_list ( (parameter_decl_clause (parameter_decl (param_decl_specifiers (type_name (base_type char))) (parameter_id (ptrs (ptr_operator *)) ( (parameter_id (ptrs (ptr_operator *)) (parameter_name (identifier param))) ) (type_suffix (param_type_list ( void )))))) )) (compound_statement { }))"));
	}

	@Test
	public void testVoidParamList()
	{
		String input = "static int altgid(void){}";
	
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
		assertTrue(output.startsWith("(function_def "));
	}
	
	@Test
	public void testParamVoidPtr()
	{
		String input = "static int altgid(void *ptr){}";
	
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.startsWith("(function_def"));
	}

	@Test
	public void testLinux__user()
	{
		String input = "static long aio_read_events_ring(struct kioctx *ctx, struct io_event __user *event, long nr){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		System.out.println(output);
	}
	
	
	@Test
	public void testParamConstVoidPtr()
	{
		String input = "static ssize_t _7z_write_data(struct archive_write *a, const void *buff, size_t s){}";
	
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);		
		assertTrue(output.startsWith("(function_def"));
	}

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
	public void testNestedFunctionName()
	{
		String input = "int (foo)(){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		System.out.println(output);
		assertTrue(output.startsWith("(function_def "));
	}
	
	@Test
	public void testOperatorOverloading()
	{
		String input = "inline bool operator == (const PlMessageHeader &b) const {}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		System.out.println(output);
		assertTrue(output.startsWith("(function_def "));
	}
	
	@Test
	public void testExceptionSpecificationCpp()
	{
		String input = "int foo() throw(){}";
		
		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);	
		System.out.println(output);
		assertTrue(output.startsWith("(function_def "));
	}
	
	@Test
	public void testPreprocIfBeforeFunc()
	{
		String input = "#ifdef foo\nint foo(){ #if x\n foo();\n #else\n #endif\n} abc\n #endif\n" ;
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("(water abc)"));
	}
	
	@Test
	public void testPreprocIfNesting()
	{
		String input = "foo(){ #ifdef x\n #ifdef y\n #else\n #endif\n#endif\n abc(); } foo();" ;
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("(compound_statement { #ifdef x\\n #ifdef y\\n #else\\n #endif\\n #endif\\n abc ( ) ; }))"));
	}
	
	@Test
	public void testPreprocIfInElse()
	{
		String input = "foo(){ #ifdef x\n #else\n #ifdef y\n #endif\n#endif\n abc(); } foo();" ;
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("(compound_statement { #ifdef x\\n #else\\n #ifdef y\\n #endif\\n #endif\\n abc ( ) ; }))"));
	}
	
	
	@Test
	public void testStartingPreProcElse()
	{
		String input = "#ifdef foo\n int foo(){ #else\n {\n#endif\n } abc\n #endif\n" ;
		ModuleParser parser = createParser(input);
		String output = parser.code().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("(water abc)"));
	}
	
	/* TODO: Adapt and move this test to FineParsing
	@Test
	public void testEscaping()
	{
		String input = "for (tp = \"\\tt\\bb\\rr\\nn\\vv\"; *tp; tp++) if (*tp++ == *cp) break;";
				;
		CodeSensorParser parser = createParser(input);
		String output = parser.statements().toStringTree(parser);
		System.out.println(output);
		assertTrue(output.contains("block_starter"));
	}
	*/
	
}


