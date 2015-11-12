package tests.inputModules;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.functionDef.FunctionDef;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.php.declarations.PHPClassDef;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.statements.blockstarters.WhileStatement;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import tools.phpast2cfg.PHPCSVEdgeInterpreter;
import tools.phpast2cfg.PHPCSVNodeInterpreter;

public class TestPHPCSVASTBuilder
{
	PHPCSVNodeInterpreter nodeInterpreter = new PHPCSVNodeInterpreter();
	PHPCSVEdgeInterpreter edgeInterpreter = new PHPCSVEdgeInterpreter();
	
	ASTUnderConstruction ast;
	KeyedCSVReader nodeReader;
	KeyedCSVReader edgeReader;
	
	// See {@link http://neo4j.com/docs/stable/import-tool-header-format.html} for detailed
	// information about the header file format
	String nodeHeader = "id:ID,type,flags:string[],lineno:int,code,childnum:int,funcid:int,endlineno:int,name,doccomment\n";
	String edgeHeader = ":START_ID,:END_ID,:TYPE\n";

	@Before
	public void init()
	{
		ast = new ASTUnderConstruction();	
		nodeReader = new KeyedCSVReader();
		edgeReader = new KeyedCSVReader();
	}
	
	private void handle(String nodeStr, String edgeStr)
			throws IOException, InvalidCSVFile
	{
		nodeReader.init(new StringReader(nodeStr));
		edgeReader.init(new StringReader(edgeStr));
		
		KeyedCSVRow keyedRow;
		while ((keyedRow = nodeReader.getNextRow()) != null)
			nodeInterpreter.handle(keyedRow, ast);
		while ((keyedRow = edgeReader.getNextRow()) != null)
			edgeInterpreter.handle(keyedRow, ast);
	}
	
	
	/* special nodes */	
	
	/**
	 * AST_NAME nodes are used to identify certain names in PHP code,
	 * such as for example the name of a class that a class declaration extends,
	 * the name of an interface that a class declaration implements,
	 * or the name of a type returned by a function.
	 * Other examples include names of called functions/methods, class
	 * names associated with 'new' or 'instanceof' operators, etc.
	 * 
	 * Any AST_NAME node has exactly one child which is of type "string".
	 * 
	 * This test checks the names 'bar' and 'buz' in the following PHP code:
	 * 
	 * class foo extends bar implements buz {}
	 */
	@Test
	public void testNameCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "3,AST_CLASS,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "6,AST_NAME_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"buz\",0,1,,,\n";
		nodeStr += "9,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n";
		nodeStr += "10,AST_STMT_LIST,,3,,0,9,,,\n";
		
		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(Identifier.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((Identifier)node).getNameChild());
		assertEquals( "bar", ((Identifier)node).getNameChild().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(Identifier.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((Identifier)node2).getNameChild());
		assertEquals( "buz", ((Identifier)node2).getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_CLOSURE_VAR nodes are special nodes holding variables that
	 * occur within the 'use' language construct of closure declarations.
	 * 
	 * Any AST_CLOSURE_VAR node has exactly one child which is of type "string".
	 * 
	 * This test checks the names 'foo' and 'bar' in the following PHP code:
	 * 
	 * function() use ($foo,$bar) {};
	 */
	@Test
	public void testClosureVarCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLOSURE,,3,,0,1,3,{closure},\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,AST_CLOSURE_USES,,3,,1,3,,,\n";
		nodeStr += "6,AST_CLOSURE_VAR,,3,,0,3,,,\n";
		nodeStr += "7,string,,3,\"foo\",0,3,,,\n";
		nodeStr += "8,AST_CLOSURE_VAR,,3,,1,3,,,\n";
		nodeStr += "9,string,,3,\"bar\",0,3,,,\n";
		nodeStr += "10,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "11,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,10,PARENT_OF\n";
		edgeStr += "3,11,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(ClosureVar.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ClosureVar)node).getNameChild());
		assertEquals( "foo", ((ClosureVar)node).getNameChild().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(ClosureVar.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((ClosureVar)node2).getNameChild());
		assertEquals( "bar", ((ClosureVar)node2).getNameChild().getEscapedCodeStr());
	}
	
	
	/* declaration nodes */	
	
	/**
	 * AST_TOPLEVEL nodes are artificial function-declaring nodes for
	 * the top-level context of files and classes. We give such nodes the
	 * name "<path/to/file>" under file nodes, and "[classname]" under class nodes. 
	 * 
	 * Any AST_TOPLEVEL node has exactly one child which is of type AST_STMT_LIST.
	 * 
	 * This test checks the name '<foo.php>' of the toplevel node of a file foo.php
	 * and the name '[bar]' of a class bar in the following PHP code:
	 * 
	 * class bar {}
	 */
	@Test
	public void testTopLevelFuncCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,3,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_CLASS,,3,,0,1,3,bar,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"bar\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "1,2,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)1);
		ASTNode node2 = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(TopLevelFunctionDef.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( "<foo.php>", ((TopLevelFunctionDef)node).getName());
		assertEquals( ast.getNodeById((long)2), ((TopLevelFunctionDef)node).getContent());
		
		assertThat( node2, instanceOf(TopLevelFunctionDef.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( "[bar]", ((TopLevelFunctionDef)node2).getName());
		assertEquals( ast.getNodeById((long)7), ((TopLevelFunctionDef)node2).getContent());
	}
	
	/**
	 * AST_FUNC_DECL nodes are function-declaring nodes for top-level functions
	 * (as opposed to methods declared within a class scope.) 
	 * 
	 * Any AST_FUNC_DECL node has exactly four children:
	 * 1) AST_PARAM_LIST
	 * 2) NULL, for structural compatibility with AST_CLOSURE
	 * 3) AST_STMT_LIST
	 * 4) AST_NAME or NULL, indicating the return type
	 * 
	 * This test checks a function's name and children in the following PHP code:
	 * 
	 * function foo() : int {}
	 */
	@Test
	public void testFunctionDefCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,3,,3,3,,,\n";
		nodeStr += "8,string,,3,\"int\",0,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		
		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(FunctionDef.class));
		assertEquals( "foo", ((FunctionDef)node).getName());
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((FunctionDef)node).getParameterList());
		assertEquals( ast.getNodeById((long)6), ((FunctionDef)node).getContent());
		assertEquals( ast.getNodeById((long)7), ((FunctionDef)node).getReturnType());
		assertEquals( ast.getNodeById((long)8), ((FunctionDef)node).getReturnType().getNameChild());
		assertEquals( "int", ((FunctionDef)node).getReturnType().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_CLOSURE nodes are function-declaring nodes for closures (anonymous functions).
	 * We always give them the artificial name "{closure}".
	 * 
	 * Any AST_CLOSURE node has exactly four children:
	 * 1) AST_PARAM_LIST
	 * 2) AST_CLOSURE_USES or NULL
	 * 3) AST_STMT_LIST
	 * 4) AST_NAME or NULL, indicating the return type
	 * 
	 * This test checks a closure's pseudo-name and children in the following PHP code:
	 * 
	 * function() use ($foo) : int {};
	 */
	@Test
	public void testClosureCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "3,AST_CLOSURE,,3,,0,1,3,{closure},\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,AST_CLOSURE_USES,,3,,1,3,,,\n";
		nodeStr += "6,AST_CLOSURE_VAR,,3,,0,3,,,\n";
		nodeStr += "7,string,,3,\"foo\",0,3,,,\n";
		nodeStr += "8,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,3,,3,3,,,\n";
		nodeStr += "10,string,,3,\"int\",0,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(Closure.class));
		assertEquals( "{closure}", ((Closure)node).getName());
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((Closure)node).getParameterList());
		assertEquals( ast.getNodeById((long)5), ((Closure)node).getClosureUses());
		assertEquals( ast.getNodeById((long)8), ((Closure)node).getContent());
		assertEquals( ast.getNodeById((long)9), ((Closure)node).getReturnType());
		assertEquals( ast.getNodeById((long)10), ((Closure)node).getReturnType().getNameChild());
		assertEquals( "int", ((Closure)node).getReturnType().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_METHOD nodes are function-declaring nodes for class-level functions
	 * (as opposed to functions declared within a top-level scope.) 
	 * 
	 * Any AST_METHOD node has exactly four children:
	 * 1) AST_PARAM_LIST
	 * 2) NULL, for structural compatibility with AST_CLOSURE
	 * 3) AST_STMT_LIST
	 * 4) AST_NAME or NULL, indicating the return type
	 * 
	 * This test checks a method's name and children in the following PHP code:
	 * 
	 * class bar {
	 *   function foo() : int {}
	 * }
	 */
	@Test
	public void testMethodCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "8,AST_METHOD,MODIFIER_PUBLIC,4,,0,6,4,foo,\n";
		nodeStr += "9,AST_PARAM_LIST,,4,,0,8,,,\n";
		nodeStr += "10,NULL,,4,,1,8,,,\n";
		nodeStr += "11,AST_STMT_LIST,,4,,2,8,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,3,8,,,\n";
		nodeStr += "13,string,,4,\"int\",0,8,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,10,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(Method.class));
		assertEquals( "foo", ((Method)node).getName());
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((Method)node).getParameterList());
		assertEquals( ast.getNodeById((long)11), ((Method)node).getContent());
		assertEquals( ast.getNodeById((long)12), ((Method)node).getReturnType());
		assertEquals( ast.getNodeById((long)13), ((Method)node).getReturnType().getNameChild());
		assertEquals( "int", ((Method)node).getReturnType().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_CLASS nodes are used to declare classes.
	 * 
	 * Any AST_CLASS node has exactly three children:
	 * 1) AST_NAME or NULL, indicating the parent class
	 * 2) AST_NAME_LIST or NULL, indicating the implemented interfaces
	 * 3) AST_TOPLEVEL, this class's top-level method
	 * 
	 * This test checks a class's name and its children in the following PHP code:
	 * 
	 * class foo extends bar implements buz {}
	 */
	@Test
	public void testClassCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "3,AST_CLASS,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "6,AST_NAME_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"buz\",0,1,,,\n";
		nodeStr += "9,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n";
		nodeStr += "10,AST_STMT_LIST,,3,,0,9,,,\n";
		
		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(PHPClassDef.class));
		assertEquals( "foo", ((PHPClassDef)node).getName());
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPClassDef)node).getExtends());
		assertEquals( ast.getNodeById((long)5), ((PHPClassDef)node).getExtends().getNameChild());
		assertEquals( "bar", ((PHPClassDef)node).getExtends().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((PHPClassDef)node).getImplements());
		assertEquals( ast.getNodeById((long)7), ((PHPClassDef)node).getImplements().getIdentifier(0));
		assertEquals( ast.getNodeById((long)8), ((PHPClassDef)node).getImplements().getIdentifier(0).getNameChild());
		assertEquals( "buz", ((PHPClassDef)node).getImplements().getIdentifier(0).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((PHPClassDef)node).getTopLevelFunc());
		assertEquals( "[foo]", ((PHPClassDef)node).getTopLevelFunc().getName());
		assertEquals( ast.getNodeById((long)10), ((PHPClassDef)node).getTopLevelFunc().getContent());
	}
	
	
	/* nodes with exactly 2 children */
	
	/**
	 * AST_WHILE nodes are used to declare while loops.
	 * 
	 * Any AST_WHILE node has exactly two children:
	 * 1) various possible types, representing the expression in the loop's guard,
	 *    also known as "condition" or "predicate"
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) AST_STMT_LIST, representing the statements executed in the loop's body
	 * 
	 * This test checks a few while loops' children in the following PHP code:
	 * 
	 * while($foo) {}
	 * while(true) {}
	 * while(somecall()) {}
	 * while($var === 1) {}
	 */
	@Test
	public void testWhileCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_WHILE,,4,,1,1,,,\n";
		nodeStr += "8,AST_CONST,,4,,0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"true\",0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "12,AST_WHILE,,5,,2,1,,,\n";
		nodeStr += "13,AST_CALL,,5,,0,1,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"somecall\",0,1,,,\n";
		nodeStr += "16,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "17,AST_STMT_LIST,,5,,1,1,,,\n";
		nodeStr += "18,AST_WHILE,,6,,3,1,,,\n";
		nodeStr += "19,AST_BINARY_OP,BINARY_IS_IDENTICAL,6,,0,1,,,\n";
		nodeStr += "20,AST_VAR,,6,,0,1,,,\n";
		nodeStr += "21,string,,6,\"var\",0,1,,,\n";
		nodeStr += "22,integer,,6,1,1,1,,,\n";
		nodeStr += "23,AST_STMT_LIST,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,11,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "13,16,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,17,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "19,22,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,23,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)12);
		ASTNode node4 = ast.getNodeById((long)18);
		
		assertThat( node, instanceOf(WhileStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((WhileStatement)node).getCondition());
		assertEquals( ast.getNodeById((long)6), ((WhileStatement)node).getContent());

		assertThat( node2, instanceOf(WhileStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((WhileStatement)node2).getCondition());
		assertEquals( ast.getNodeById((long)11), ((WhileStatement)node2).getContent());
		
		assertThat( node3, instanceOf(WhileStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((WhileStatement)node3).getCondition());
		assertEquals( ast.getNodeById((long)17), ((WhileStatement)node3).getContent());
		
		assertThat( node4, instanceOf(WhileStatement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((WhileStatement)node4).getCondition());
		assertEquals( ast.getNodeById((long)23), ((WhileStatement)node4).getContent());
	}


	/* nodes with exactly 3 children */
	
	/**
	 * AST_PARAM nodes are used for function parameters.
	 * 
	 * Any AST_PARAM node has exactly three children:
	 * 1) AST_NAME or NULL, representing the parameter's type
	 * 2) string, indicating the parameter's name
	 * 3) various possible child types, representing the default value
	 *    (e.g., node type could be "NULL", "string", "integer", but also AST_CONST, etc.)
	 * 
	 * This test checks a parameter's children in the following PHP code:
	 * 
	 * function foo(int $bar = 3, string $buz = "yabadabadoo") {}
	 */
	@Test
	public void testParameterCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,AST_PARAM,,3,,0,3,,,\n";
		nodeStr += "6,AST_NAME,NAME_NOT_FQ,3,,0,3,,,\n";
		nodeStr += "7,string,,3,\"int\",0,3,,,\n";
		nodeStr += "8,string,,3,\"bar\",1,3,,,\n";
		nodeStr += "9,integer,,3,3,2,3,,,\n";
		nodeStr += "10,AST_PARAM,,3,,1,3,,,\n";
		nodeStr += "11,AST_NAME,NAME_NOT_FQ,3,,0,3,,,\n";
		nodeStr += "12,string,,3,\"string\",0,3,,,\n";
		nodeStr += "13,string,,3,\"buz\",1,3,,,\n";
		nodeStr += "14,string,,3,\"yabadabadoo\",2,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "5,9,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";
		edgeStr += "10,14,PARENT_OF\n";
		edgeStr += "4,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		ASTNode node2 = ast.getNodeById((long)10);
		
		assertThat( node, instanceOf(PHPParameter.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)6), ((PHPParameter)node).getType());
		assertEquals( ast.getNodeById((long)7), ((PHPParameter)node).getType().getNameChild());
		assertEquals( "int", ((PHPParameter)node).getType().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)8), ((PHPParameter)node).getNameChild());
		assertEquals( "bar", ((PHPParameter)node).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((PHPParameter)node).getDefault());
		assertEquals( "3", ((PHPParameter)node).getDefault().getEscapedCodeStr());

		assertThat( node2, instanceOf(PHPParameter.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((PHPParameter)node2).getType());
		assertEquals( ast.getNodeById((long)12), ((PHPParameter)node2).getType().getNameChild());
		assertEquals( "string", ((PHPParameter)node2).getType().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)13), ((PHPParameter)node2).getNameChild());
		assertEquals( "buz", ((PHPParameter)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)14), ((PHPParameter)node2).getDefault());
		assertEquals( "yabadabadoo", ((PHPParameter)node2).getDefault().getEscapedCodeStr());
	}
	
	
	/* nodes with an arbitrary number of children */

	/**
	 * AST_STMT_LIST nodes are used to declare lists (or "blocks") of statements.
	 * 
	 * Any AST_STMT_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one statement in the list.
	 * 
	 * This test checks statements lists' children in the following PHP code:
	 * 
	 * function foo() {}
	 * foo();
	 */
	@Test
	public void testCompoundStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,4,\"foo.php\",\n";
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";
		nodeStr += "8,AST_CALL,,4,,1,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "11,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "2,8,PARENT_OF\n";
		edgeStr += "1,2,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)2);
		ASTNode node2 = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(CompoundStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((CompoundStatement)node).getStatements().size());
		for( ASTNode stmt : (CompoundStatement)node)
			assertTrue( ast.containsValue(stmt));
		assertEquals( ast.getNodeById((long)3), node.getChild(0));
		assertEquals( ast.getNodeById((long)8), node.getChild(1));

		assertThat( node2, instanceOf(CompoundStatement.class));
		assertEquals( 0, node2.getChildCount());
		assertEquals( 0, ((CompoundStatement)node2).getStatements().size());
		for( ASTNode stmt : (CompoundStatement)node2)
			assertTrue( ast.containsValue(stmt));
	}
	
	/**
	 * AST_PARAM_LIST nodes are used for function parameters.
	 * 
	 * Any AST_PARAM_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one parameter in the list.
	 * 
	 * This test checks a parameter list's children in the following PHP code:
	 * 
	 * function foo(int $bar = 3, string $buz = "yabadabadoo") {}
	 */
	@Test
	public void testParameterListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,AST_PARAM,,3,,0,3,,,\n";
		nodeStr += "6,AST_NAME,NAME_NOT_FQ,3,,0,3,,,\n";
		nodeStr += "7,string,,3,\"int\",0,3,,,\n";
		nodeStr += "8,string,,3,\"bar\",1,3,,,\n";
		nodeStr += "9,integer,,3,3,2,3,,,\n";
		nodeStr += "10,AST_PARAM,,3,,1,3,,,\n";
		nodeStr += "11,AST_NAME,NAME_NOT_FQ,3,,0,3,,,\n";
		nodeStr += "12,string,,3,\"string\",0,3,,,\n";
		nodeStr += "13,string,,3,\"buz\",1,3,,,\n";
		nodeStr += "14,string,,3,\"yabadabadoo\",2,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "5,9,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";
		edgeStr += "10,14,PARENT_OF\n";
		edgeStr += "4,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		
		assertThat( node, instanceOf(ParameterList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((ParameterList)node).getParameter(0));
		assertEquals( ast.getNodeById((long)10), ((ParameterList)node).getParameter(1));
		for( Parameter parameter : (ParameterList)node)
			assertTrue( ast.containsValue(parameter));
	}
	
	/**
	 * AST_CLOSURE_USES nodes are used for holding a list of variables that
	 * occur within the 'use' language construct of closure declarations.
	 * 
	 * Any AST_CLOSURE_USES node has between 0 and an arbitrarily large number
	 * of children. Each child corresponds to one closure variable in the list.
	 * 
	 * This test checks a closure 'uses' list's children in the following PHP code:
	 * 
	 * function() use ($foo,$bar) {};
	 */
	@Test
	public void testClosureUsesCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLOSURE,,3,,0,1,3,{closure},\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,AST_CLOSURE_USES,,3,,1,3,,,\n";
		nodeStr += "6,AST_CLOSURE_VAR,,3,,0,3,,,\n";
		nodeStr += "7,string,,3,\"foo\",0,3,,,\n";
		nodeStr += "8,AST_CLOSURE_VAR,,3,,1,3,,,\n";
		nodeStr += "9,string,,3,\"bar\",0,3,,,\n";
		nodeStr += "10,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "11,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,10,PARENT_OF\n";
		edgeStr += "3,11,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(ClosureUses.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)6), ((ClosureUses)node).getClosureVar(0));
		assertEquals( ast.getNodeById((long)8), ((ClosureUses)node).getClosureVar(1));
		for( ClosureVar closurevar : (ClosureUses)node)
			assertTrue( ast.containsValue(closurevar));
	}
	
	/**
	 * AST_NAME_LIST nodes are used for holding a list of identifiers, e.g.,
	 * a list of names referring to interfaces that a class extends.
	 * 
	 * Any AST_NAME_LIST node has between 0 and an arbitrarily large number
	 * of children. Each child corresponds to one identifier in the list.
	 * 
	 * This test checks an identifier list's children in the following PHP code:
	 * 
	 * class foo extends bar implements buz, qux {}
	 */
	@Test
	public void testIdentifierList() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "6,AST_NAME_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"buz\",0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,3,,1,1,,,\n";
		nodeStr += "10,string,,3,\"qux\",0,1,,,\n";
		nodeStr += "11,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n";
		nodeStr += "12,AST_STMT_LIST,,3,,0,11,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "3,11,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(IdentifierList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((IdentifierList)node).getIdentifier(0));
		assertEquals( ast.getNodeById((long)9), ((IdentifierList)node).getIdentifier(1));
		for( Identifier identifier : (IdentifierList)node)
			assertTrue( ast.containsValue(identifier));
	}
}
