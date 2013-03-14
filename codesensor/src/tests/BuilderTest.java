package tests;

import static org.junit.Assert.*;

import java.util.List;

import main.TokenSubStream;
import main.ShallowParser.ShallowParser;
import main.codeitems.CodeItem;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.function.FunctionDef;
import main.processors.TestProcessor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Test;

import antlr.CodeSensorLexer;

public class BuilderTest {

	@Test
	public void testNestedStructs()
	{
		String input = "struct x{ struct y { struct z{}; }; };";
		List<CodeItem> codeItems = parseInput(input);
		assertTrue(codeItems.size() == 3);
	}
	
	@Test
	public void testStructName()
	{
		String input = "struct foo{};";
		List<CodeItem> codeItems = parseInput(input);
		ClassDef codeItem = (ClassDef) codeItems.get(0);
		assertTrue(codeItem.name.getCodeStr().equals("foo"));
	}
	
	@Test
	public void testFuncName()
	{
		String input = "void foo(){};";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		assertTrue(codeItem.name.getCodeStr().equals("foo"));
	}
	
	@Test
	public void testFuncSignature()
	{
		String input = "void foo(int x, char **ptr){};";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		System.out.println(codeItem.getCodeStr());
		assertTrue(codeItem.getCodeStr().equals("foo (int x , char * * ptr)"));
	}
	
	@Test
	public void testDecl()
	{
		String input = "int foo;";
		List<CodeItem> codeItems = parseInput(input);
		IdentifierDecl codeItem = (IdentifierDecl) codeItems.get(0);
		assertTrue(codeItem.name.getCodeStr().equals("foo"));
	}

	
	private List<CodeItem> parseInput(String input)
	{
		ShallowParser parser = new ShallowParser();		
		parser.setProcessor(new TestProcessor());
		
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		
		parser.parseAndWalk(tokens);
		TestProcessor processor = (TestProcessor) parser.listener.getProcessor();
		return processor.codeItems;
	}

}
