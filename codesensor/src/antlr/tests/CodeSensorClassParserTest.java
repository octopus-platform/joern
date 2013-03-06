package antlr.tests;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class CodeSensorClassParserTest {

	private CodeSensorParser createParser(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lex);
        CodeSensorParser parser = new CodeSensorParser(tokens);
        return parser;
	}
	
	
	@Test
	public void testSimpleStructDef()
	{
		String input = "struct foo{int x;};";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key struct) (class_name (identifier foo))"));
	}
	
	@Test
	public void testAnonymousStructDef()
	{
		String input = "struct {int x;}v;";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key struct) {"));
	}
	
	@Test
	public void testClassMethod()
	{
		String input = "class foo{ int func(){} };";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key class) (class_name (identifier foo)) { (class_content (function_def (return_type (type_name (base_type int)))"));
	}
	
	@Test
	public void testClassMethodDecl()
	{
		String input = "class foo{ int func(char *); };";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key class) (class_name (identifier foo)) { (class_content (simple_decl (var_decl (type_name (base_type int)) (init_declarator_list (init_declarator (identifier func) (type_suffix (param_type_list ( (param_type"));
	}
	
	@Test
	public void testStructureInit()
	{
		String input = "struct archive_contents" +
				"{ const char *f; struct contents *c; } files[] " +
				"={{\"sparse\",archive_contents_sparse }, {\"sparse2\", archive_contents_sparse2} };";
			
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key struct) (class_name (identifier archive_contents)) { (class_content (simple_decl (var_decl (type_name (cv_qualifier const) (base_type char)) (init_declarator_list (init_declarator (ptrs (ptr_operator *)) (identifier f)))) ;) (simple_decl (var_decl (type_name (class_key struct) (base_type contents)) (init_declarator_list (init_declarator (ptrs (ptr_operator *)) (identifier c)))) ;)) }) (init_declarator_list (init_declarator (identifier files) (type_suffix [ constant_expr ])"));
	}
	

	
}
