package tests.inputModules;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.declarations.ClassDefStatement;
import ast.expressions.Identifier;
import ast.functionDef.FunctionDef;
import ast.logical.statements.CompoundStatement;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.TopLevelFunctionDef;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import tools.phpast2cfg.PHPCSVEdgeInterpreter;
import tools.phpast2cfg.PHPCSVNodeInterpreter;

public class TestPHPCSVNodeInterpreter
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
	 * or the name of an interface that a class declaration implements.
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
		assertEquals( "bar", ((Identifier)node).getName().getEscapedCodeStr());
		assertThat( node2, instanceOf(Identifier.class));
		assertEquals( "buz", ((Identifier)node2).getName().getEscapedCodeStr());
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
		assertEquals( "foo", ((ClosureVar)node).getName().getEscapedCodeStr());
		assertThat( node2, instanceOf(ClosureVar.class));
		assertEquals( "bar", ((ClosureVar)node2).getName().getEscapedCodeStr());
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
		assertEquals( "<foo.php>", ((TopLevelFunctionDef)node).getName());
		assertThat( ((TopLevelFunctionDef)node).getContent(), instanceOf(CompoundStatement.class));
		
		assertThat( node2, instanceOf(TopLevelFunctionDef.class));
		assertEquals( "[bar]", ((TopLevelFunctionDef)node2).getName());
		assertThat( ((TopLevelFunctionDef)node2).getContent(), instanceOf(CompoundStatement.class));
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
		// TODO map AST_PARAM_LIST to ParameterList and check here
		assertThat( ((FunctionDef)node).getContent(), instanceOf(CompoundStatement.class));
		assertThat( ((FunctionDef)node).getReturnType(), instanceOf(Identifier.class));
		assertEquals( "int", ((Identifier)((FunctionDef)node).getReturnType()).getName().getEscapedCodeStr());
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
		// TODO map AST_PARAM_LIST to ParameterList and check here
		// TODO map AST_CLOSURE_USES to ClosureUses and check here
		assertThat( ((FunctionDef)node).getContent(), instanceOf(CompoundStatement.class));
		assertThat( ((FunctionDef)node).getReturnType(), instanceOf(Identifier.class));
		assertEquals( "int", ((Identifier)((Closure)node).getReturnType()).getName().getEscapedCodeStr());
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
		// TODO map AST_PARAM_LIST to ParameterList and check here
		assertThat( ((Method)node).getContent(), instanceOf(CompoundStatement.class));
		assertThat( ((Method)node).getReturnType(), instanceOf(Identifier.class));
		assertEquals( "int", ((Identifier)((Method)node).getReturnType()).getName().getEscapedCodeStr());
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
		
		assertThat( node, instanceOf(ClassDefStatement.class));
		assertEquals( "foo", ((ClassDefStatement)node).getName());
		assertThat( ((ClassDefStatement)node).getExtends(), instanceOf(Identifier.class));
		assertEquals( "bar", ((ClassDefStatement)node).getExtends().getName().getEscapedCodeStr());
		// TODO map AST_NAME_LIST to IdentifierList and check here
		assertThat( ((ClassDefStatement)node).getTopLevelFunc(), instanceOf(TopLevelFunctionDef.class));
		assertEquals( "[foo]", ((ClassDefStatement)node).getTopLevelFunc().getName());
	}
	
}
