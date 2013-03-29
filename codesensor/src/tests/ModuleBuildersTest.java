package tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import main.ModuleParser.ModuleParser;
import main.codeitems.CodeItem;
import main.codeitems.Name;
import main.codeitems.declarations.ClassDef;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.function.FunctionDef;
import main.codeitems.function.Parameter;
import main.codeitems.function.ParameterType;
import main.codeitems.functionContent.IdentifierDeclStatement;
import main.processors.TestProcessor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Test;

import tools.index.TokenSubStream;

import antlr.CodeSensorLexer;

public class ModuleBuildersTest {

	@Test
	public void testNestedStructs()
	{
		String input = "struct x{ struct y { struct z{}; }; };";
		List<CodeItem> codeItems = parseInput(input);
		ClassDef classDef = (ClassDef) codeItems.get(0);
		ClassDef yClass = (ClassDef) classDef.content.statements.get(0);
		ClassDef zClass = (ClassDef) yClass.content.statements.get(0);
		
		assertTrue(codeItems.size() == 1);
		assertTrue(yClass.getName().getCodeStr().equals("y"));
		assertTrue(zClass.getName().getCodeStr().equals("z"));
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
	public void testStructContent()
	{
		String input = "struct foo{};";
		List<CodeItem> codeItems = parseInput(input);
		ClassDef codeItem = (ClassDef) codeItems.get(0);
		assertTrue(codeItem.content != null);
	}
	
	@Test
	public void testFunctionInClass()
	{
		String input = "class foo{ bar(){} };";
		List<CodeItem> codeItems = parseInput(input);
		ClassDef codeItem = (ClassDef) codeItems.get(0);
		assertTrue(codeItem.content != null);
	}
	
	
	@Test
	public void testDecl()
	{
		String input = "int foo;";
		List<CodeItem> codeItems = parseInput(input);
		IdentifierDeclStatement codeItem = (IdentifierDeclStatement) codeItems.get(0);
		IdentifierDecl decl = codeItem.identifierDeclList.get(0);
		assertTrue(decl.name.getCodeStr().equals("foo"));
	}

	@Test
	public void testDeclListAfterClass()
	{
		String input = "class foo{int x;} y;";
		List<CodeItem> codeItems = parseInput(input);
		IdentifierDeclStatement codeItem = (IdentifierDeclStatement) codeItems.get(codeItems.size() - 1);
		IdentifierDecl decl = codeItem.identifierDeclList.get(0);
		System.out.println(decl.name.getCodeStr());
		assertTrue(decl.name.getCodeStr().equals("y"));
	}
	
	@Test
	public void testClassDefBeforeContent()
	{
		String input = "class foo{int x;}";
		List<CodeItem> codeItems = parseInput(input);
		
		ClassDef classCodeItem = (ClassDef) codeItems.get(0);
		IdentifierDeclStatement identifierCodeItem = (IdentifierDeclStatement) classCodeItem.content.statements.get(0);
		IdentifierDecl decl = identifierCodeItem.identifierDeclList.get(0);
		
		assertTrue(classCodeItem.name.getCodeStr().equals("foo"));
		assertTrue(decl.name.getCodeStr().equals("x"));
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
	public void testParamListGetCodeStr()
	{
		String input = "int foo(char *myParam, myType x){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		String codeStr = codeItem.parameterList.getCodeStr();
		System.out.println(codeStr);
		assertTrue(codeStr.equals("char * myParam , myType x"));
	}
	
	@Test
	public void testParamGetCodeStr()
	{
		String input = "int foo(char *myParam, myType x){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		Parameter parameter = codeItem.parameterList.parameters.get(0);
		String codeStr = parameter.getCodeStr();
		System.out.println(codeStr);
		assertTrue(codeStr.equals("char * myParam"));
	}
		
	@Test
	public void testParamName()
	{
		String input = "int foo(myType myParam){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		Name name = codeItem.parameterList.parameters.get(0).name;
		assertTrue(name.getCodeStr().equals("myParam"));
	}
	
	@Test
	public void testParamType()
	{
		String input = "int foo(char *myParam){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		ParameterType type = codeItem.parameterList.parameters.get(0).type;
		System.out.println(type.getCodeStr());
		assertTrue(type.getCodeStr().equals("char *"));
	}
	
	@Test
	public void testFunctionPtrParam()
	{
		String input = "int foo(void (*ptr)(char *)){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		System.out.println(codeItem.getCodeStr());
		assertTrue(codeItem.name.getCodeStr().equals("foo"));
	}

	@Test
	public void testEmptyParamList()
	{
		String input = "int foo(){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		assertTrue(codeItem.parameterList.getCodeStr().equals(""));
	}
	
	@Test
	public void testEmptyParamListLocation()
	{
		String input = "int foo(){}";
		List<CodeItem> codeItems = parseInput(input);
		FunctionDef codeItem = (FunctionDef) codeItems.get(0);
		assertTrue(codeItem.parameterList.location != null);
	}
	
	private List<CodeItem> parseInput(String input)
	{
		ModuleParser parser = new ModuleParser();		
		TestProcessor testProcessor = new TestProcessor();
		parser.addObserver(testProcessor);
		
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		
		parser.parseAndWalkStream(tokens);
		return testProcessor.codeItems;
	}

}
