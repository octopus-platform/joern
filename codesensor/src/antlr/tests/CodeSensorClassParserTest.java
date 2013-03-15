package antlr.tests;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;
import antlr.CodeSensorParser.Class_defContext;

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
	public void testStructureInitArray()
	{
		String input = "struct archive_contents" +
				"{ const char *f; struct contents *c; } files[] " +
				"= {{\"sparse\",archive_contents_sparse }, {\"sparse2\", archive_contents_sparse2} };";
			
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);
		System.out.println(output);
		
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key struct) (class_name (identifier archive_contents)) { const char * f ; struct contents * c ; }) (init_declarator_list (init_declarator (identifier files) (type_suffix [ constant_expr_w_ ]) = (assign_expr_w_ {"));
	}

	@Test
	public void testStructureInitSimple()
	{
		String input = "struct foo{ int x; } y;";			
		CodeSensorParser parser = createParser(input);
		String output = parser.simple_decl().toStringTree(parser);		
		assertTrue(output.startsWith("(simple_decl (var_decl (class_def (class_key struct) (class_name (identifier foo)) { int x ; }) (init_declarator_list (init_declarator (identifier y)) ;)))"));
	}
	
	@Test
	public void testClassContentExtraction()
	{
		String input = "class foo{ foobar; }";
		
		CodeSensorParser parser = createParser(input);
		Class_defContext class_def = parser.class_def();

		int startIndex = class_def.OPENING_CURLY().getSymbol().getTokenIndex();
		int stopIndex = class_def.stop.getTokenIndex();		
		assertTrue((startIndex == 2) && (stopIndex == 5));
	}

}
