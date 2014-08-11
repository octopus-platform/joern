package tests.antlrParsers.moduleParser;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import antlr.C.ModuleParser;

public class FunctionParameterTests extends FunctionDefinitionTests
{

	@Test
	public void testFunctionPtrParam()
	{
		String input = "int foo(char *(*param)(void)){}";

		ModuleParser parser = createParser(input);
		String output = parser.function_def().toStringTree(parser);

		assertTrue(output
				.startsWith("(function_def (return_type (type_name (base_type int))) (function_name (identifier foo)) (function_param_list ( (parameter_decl_clause (parameter_decl (param_decl_specifiers (type_name (base_type char))) (parameter_id (ptrs (ptr_operator *)) ( (parameter_id (ptrs (ptr_operator *)) (parameter_name (identifier param))) ) (type_suffix (param_type_list ( void )))))) )) (compound_statement { }))"));
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
}
