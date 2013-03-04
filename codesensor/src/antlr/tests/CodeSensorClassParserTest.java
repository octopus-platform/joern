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
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key class) (class_name (identifier foo)) { (class_content (function_def (return_type (type_name int))"));
	}
	
	@Test
	public void testClassMethodDecl()
	{
		String input = "class foo{ int func(char *); };";
		
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		System.out.println(output);
		
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key class) (class_name (identifier foo)) { (class_content (simple_decl (var_decl (type_name int) (init_declarator_list (init_declarator (identifier func) (type_suffix (param_type_list ( (param_type"));
	}
	
}
