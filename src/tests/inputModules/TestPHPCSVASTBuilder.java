package tests.inputModules;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.ArgumentList;
import ast.expressions.CallExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.ExpressionList;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.Variable;
import ast.functionDef.FunctionDef;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.php.declarations.PHPClassDef;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.PHPCoalesceExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPIfStatement;
import ast.php.statements.blockstarters.PHPSwitchCase;
import ast.php.statements.blockstarters.PHPSwitchList;
import ast.php.statements.blockstarters.PHPSwitchStatement;
import ast.php.statements.jump.PHPBreakStatement;
import ast.php.statements.jump.PHPContinueStatement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
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
	 * 3) AST_STMT_LIST or NULL (possible for abstract methods)
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
	
	
	/* nodes with exactly 1 child */
	
	/**
	 * AST_VAR nodes are nodes holding variables names.
	 * 
	 * Any AST_VAR node has exactly one child which is of type "string", holding
	 * the variable's name.
	 * 
	 * This test checks the names 'somearray', 'foo' and 'bar' in the following PHP code:
	 * 
	 * foreach ($somearray as $bar => $foo) {}
	 */
	@Test
	public void testVariableCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FOREACH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"somearray\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "7,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "8,AST_VAR,,3,,2,1,,,\n";
		nodeStr += "9,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "10,AST_STMT_LIST,,3,,3,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "3,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)6);
		ASTNode node3 = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(Variable.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((Variable)node).getNameChild());
		assertEquals( "somearray", ((Variable)node).getNameChild().getEscapedCodeStr());

		assertThat( node2, instanceOf(Variable.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((Variable)node2).getNameChild());
		assertEquals( "foo", ((Variable)node2).getNameChild().getEscapedCodeStr());
		
		assertThat( node3, instanceOf(Variable.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((Variable)node3).getNameChild());
		assertEquals( "bar", ((Variable)node3).getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_RETURN nodes are nodes representing a return statement.
	 * 
	 * Any AST_RETURN node has exactly one child holding the expression to be
	 * returned or a null node if nothing is returned
	 * (e.g., could be NULL, AST_NEW, AST_CONST, AST_VAR, AST_CALL, etc.).
	 * 
	 * This test checks a return statement's child in the following PHP code:
	 * 
	 * function foo() : int {
	 *   return 42;
	 * }
	 */
	@Test
	public void testReturnStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_RETURN,,4,,0,3,,,\n";
		nodeStr += "8,integer,,4,42,0,3,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,3,,3,3,,,\n";
		nodeStr += "10,string,,3,\"int\",0,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(ReturnStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((ReturnStatement)node).getReturnExpression());
		assertEquals( "42", ((ReturnStatement)node).getReturnExpression().getEscapedCodeStr());
	}
	
	/**
	 * AST_LABEL nodes are nodes representing a label statement.
	 * 
	 * Any AST_LABEL node has exactly one child of type "string" holding the label's name.
	 * 
	 * This test checks a label statement's child in the following PHP code:
	 * 
	 * goto a;
	 * a:
	 */
	@Test
	public void testLabelStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_GOTO,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"a\",0,1,,,\n";
		nodeStr += "5,AST_LABEL,,4,,1,1,,,\n";
		nodeStr += "6,string,,4,\"a\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(Label.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)6), ((Label)node).getNameChild());
		assertEquals( "a", ((Label)node).getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_THROW nodes are nodes representing a throw statement.
	 * 
	 * Any AST_THROW node has exactly one child holding the expression to
	 * be thrown (e.g., could be AST_NEW, AST_CONST, AST_VAR, AST_CALL, etc.)
	 * 
	 * This test checks a throw statement's child in the following PHP code:
	 * 
	 * throw new Exception("foo");
	 */
	@Test
	public void testThrowStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_THROW,,3,,0,1,,,\n";
		nodeStr += "4,AST_NEW,,3,,0,1,,,\n";
		nodeStr += "5,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"Exception\",0,1,,,\n";
		nodeStr += "7,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "8,string,,3,\"foo\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "4,7,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(ThrowStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((ThrowStatement)node).getThrowExpression());
	}
	
	/**
	 * AST_GOTO nodes are nodes representing a goto statement.
	 * 
	 * Any AST_GOTO node has exactly one child of type "string" holding the target label's name.
	 * 
	 * This test checks a goto statement's child in the following PHP code:
	 * 
	 * goto a;
	 * a:
	 */
	@Test
	public void testGotoStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_GOTO,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"a\",0,1,,,\n";
		nodeStr += "5,AST_LABEL,,4,,1,1,,,\n";
		nodeStr += "6,string,,4,\"a\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(GotoStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((GotoStatement)node).getTargetLabel());
		assertEquals( "a", ((GotoStatement)node).getTargetLabel().getEscapedCodeStr());
	}
	
	/**
	 * AST_BREAK nodes are nodes representing a break statement.
	 * 
	 * Any AST_BREAK node has exactly one child which is of type "integer", holding
	 * the number of enclosing structures to be broken out of.
	 * 
	 * This test checks a few break statements' children in the following PHP code:
	 * 
	 * while (1) {
	 *   while (1) {
	 *     break 2;
	 *   }
	 *   break 1;
	 * }
	 */
	@Test
	public void testBreakStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,integer,,3,1,0,1,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_WHILE,,4,,0,1,,,\n";
		nodeStr += "7,integer,,4,1,0,1,,,\n";
		nodeStr += "8,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "9,AST_BREAK,,5,,0,1,,,\n";
		nodeStr += "10,integer,,5,2,0,1,,,\n";
		nodeStr += "11,AST_BREAK,,7,,1,1,,,\n";
		nodeStr += "12,integer,,7,1,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "6,8,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "5,11,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(PHPBreakStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((PHPBreakStatement)node).getDepth());
		assertEquals( "2", ((PHPBreakStatement)node).getDepth().getEscapedCodeStr());

		assertThat( node2, instanceOf(PHPBreakStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((PHPBreakStatement)node2).getDepth());
		assertEquals( "1", ((PHPBreakStatement)node2).getDepth().getEscapedCodeStr());
	}
	
	/**
	 * AST_CONTINUE nodes are nodes representing a continue statement.
	 * 
	 * Any AST_CONTINUE node has exactly one child which is of type "integer", holding
	 * the number of enclosing loops to be skipped to the end of.
	 * 
	 * This test checks a few continue statements' children in the following PHP code:
	 * 
	 * while (1) {
	 *   while (1) {
	 *     continue 2;
	 *   }
	 *   continue 1;
	 * }
	 */
	@Test
	public void testContinueStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,integer,,3,1,0,1,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_WHILE,,4,,0,1,,,\n";
		nodeStr += "7,integer,,4,1,0,1,,,\n";
		nodeStr += "8,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "9,AST_CONTINUE,,5,,0,1,,,\n";
		nodeStr += "10,integer,,5,2,0,1,,,\n";
		nodeStr += "11,AST_CONTINUE,,7,,1,1,,,\n";
		nodeStr += "12,integer,,7,1,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "6,8,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "5,11,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(PHPContinueStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((PHPContinueStatement)node).getDepth());
		assertEquals( "2", ((PHPContinueStatement)node).getDepth().getEscapedCodeStr());

		assertThat( node2, instanceOf(PHPContinueStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((PHPContinueStatement)node2).getDepth());
		assertEquals( "1", ((PHPContinueStatement)node2).getDepth().getEscapedCodeStr());
	}
	

	/* nodes with exactly 2 children */
	
	/**
	 * AST_CALL nodes are used to denote call expressions.
	 * 
	 * Any AST_CALL node has exactly 2 children:
	 * 1) an expression, representing the target
	 *    (e.g., could be AST_NAME, AST_VAR, AST_CALL, ...)
	 * 2) AST_ARG_LIST, representing the argument list
	 * 
	 * This test checks a few call expressions' children in the following PHP code:
	 * 
	 * foo($bar, "yabadabadoo");
	 * $buz(1);
	 */
	@Test
	public void testCallCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "9,string,,3,\"yabadabadoo\",1,1,,,\n";
		nodeStr += "10,AST_CALL,,4,,1,1,,,\n";
		nodeStr += "11,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "12,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "13,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "14,integer,,4,1,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)10);
		
		assertThat( node, instanceOf(CallExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((CallExpression)node).getTargetFunc());
		assertEquals( "foo", ((Identifier)((CallExpression)node).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((CallExpression)node).getArgumentList());
		assertEquals( 2, ((CallExpression)node).getArgumentList().size());
		
		assertThat( node2, instanceOf(CallExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((CallExpression)node2).getTargetFunc());
		assertEquals( "buz", ((Variable)((CallExpression)node2).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)13), ((CallExpression)node2).getArgumentList());
		assertEquals( 1, ((CallExpression)node2).getArgumentList().size());
	}
	
	/**
	 * AST_COALESCE nodes are used to represent coalesce expressions, i.e., expressions
	 * using the ?? operator.
	 * 
	 * Any AST_COALESCE node has exactly two children:
	 * 1) various possible types (including plain nodes), representing
	 *    the expression on the left side
	 * 2) various possible types (including plain nodes), representing
	 *    the expression on the right side
	 * 
	 * This test checks a coalesce expression's children in the following PHP code:
	 * 
	 * "foo" ?? "bar";
	 */
	@Test
	public void testCoalesceCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_COALESCE,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "5,string,,3,\"bar\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(PHPCoalesceExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPCoalesceExpression)node).getLeftExpression());
		assertEquals( ast.getNodeById((long)5), ((PHPCoalesceExpression)node).getRightExpression());
	}
	
	/**
	 * AST_WHILE nodes are used to declare while loops.
	 * 
	 * Any AST_WHILE node has exactly two children:
	 * 1) various possible types, representing the expression in the loop's guard,
	 *    also known as "condition" or "predicate"
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
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
		assertEquals( ast.getNodeById((long)6), ((WhileStatement)node).getStatement());

		assertThat( node2, instanceOf(WhileStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((WhileStatement)node2).getCondition());
		assertEquals( ast.getNodeById((long)11), ((WhileStatement)node2).getStatement());
		
		assertThat( node3, instanceOf(WhileStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((WhileStatement)node3).getCondition());
		assertEquals( ast.getNodeById((long)17), ((WhileStatement)node3).getStatement());
		
		assertThat( node4, instanceOf(WhileStatement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((WhileStatement)node4).getCondition());
		assertEquals( ast.getNodeById((long)23), ((WhileStatement)node4).getStatement());
	}

	/**
	 * AST_DO_WHILE nodes are used to declare do-while loops.
	 * 
	 * Any AST_DO_WHILE node has exactly two children:
	 * 1) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 * 2) various possible types, representing the expression in the loop's guard,
	 *    also known as "condition" or "predicate"
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 
	 * This test checks a few while loops' children in the following PHP code:
	 * 
	 * do {} while($foo);
	 * do {} while(true);
	 * do {} while(somecall());
	 * do {} while($var === 1);
	 */
	@Test
	public void testDoCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_DO_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "7,AST_DO_WHILE,,4,,1,1,,,\n";
		nodeStr += "8,AST_STMT_LIST,,4,,0,1,,,\n";
		nodeStr += "9,AST_CONST,,4,,1,1,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "11,string,,4,\"true\",0,1,,,\n";
		nodeStr += "12,AST_DO_WHILE,,5,,2,1,,,\n";
		nodeStr += "13,AST_STMT_LIST,,5,,0,1,,,\n";
		nodeStr += "14,AST_CALL,,5,,1,1,,,\n";
		nodeStr += "15,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "16,string,,5,\"somecall\",0,1,,,\n";
		nodeStr += "17,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "18,AST_DO_WHILE,,6,,3,1,,,\n";
		nodeStr += "19,AST_STMT_LIST,,6,,0,1,,,\n";
		nodeStr += "20,AST_BINARY_OP,BINARY_IS_IDENTICAL,6,,1,1,,,\n";
		nodeStr += "21,AST_VAR,,6,,0,1,,,\n";
		nodeStr += "22,string,,6,\"var\",0,1,,,\n";
		nodeStr += "23,integer,,6,1,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,17,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "20,23,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)12);
		ASTNode node4 = ast.getNodeById((long)18);
		
		assertThat( node, instanceOf(DoStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((DoStatement)node).getStatement());
		assertEquals( ast.getNodeById((long)5), ((DoStatement)node).getCondition());

		assertThat( node2, instanceOf(DoStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((DoStatement)node2).getStatement());
		assertEquals( ast.getNodeById((long)9), ((DoStatement)node2).getCondition());
		
		assertThat( node3, instanceOf(DoStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((DoStatement)node3).getStatement());
		assertEquals( ast.getNodeById((long)14), ((DoStatement)node3).getCondition());
		
		assertThat( node4, instanceOf(DoStatement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((DoStatement)node4).getStatement());
		assertEquals( ast.getNodeById((long)20), ((DoStatement)node4).getCondition());
	}

	/**
	 * AST_IF_ELEM nodes are used to denote the individual elements of an if-statement.
	 * Similarly as while or do-while loops, they are composed of a condition and
	 * a statement; see description of AST_IF for the bigger picture.
	 * 
	 * Any AST_IF_ELEM node has exactly two children:
	 * 1) various possible types or NULL, representing the expression in the element's guard,
	 *    also known as "condition" or "predicate"; NULL is used when there is no such
	 *    expression, i.e., in "pure" unconditional else-branches.
	 *    (e.g., could be NULL, AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 * 
	 * This test checks a few if-elements' children in the following PHP code:
	 * 
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */
	@Test
	public void testIfElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_IF,,3,,0,1,,,\n";
		nodeStr += "4,AST_IF_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "7,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "8,AST_IF_ELEM,,4,,1,1,,,\n";
		nodeStr += "9,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "12,AST_IF_ELEM,,5,,2,1,,,\n";
		nodeStr += "13,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "14,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "15,AST_STMT_LIST,,5,,1,1,,,\n";
		nodeStr += "16,AST_IF_ELEM,,6,,3,1,,,\n";
		nodeStr += "17,NULL,,6,,0,1,,,\n";
		nodeStr += "18,AST_STMT_LIST,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,7,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "3,12,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,18,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)8);
		ASTNode node3 = ast.getNodeById((long)12);
		ASTNode node4 = ast.getNodeById((long)16);
		
		assertThat( node, instanceOf(PHPIfElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((PHPIfElement)node).getCondition());
		assertEquals( ast.getNodeById((long)7), ((PHPIfElement)node).getStatement());

		assertThat( node2, instanceOf(PHPIfElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((PHPIfElement)node2).getCondition());
		assertEquals( ast.getNodeById((long)11), ((PHPIfElement)node2).getStatement());
		
		assertThat( node3, instanceOf(PHPIfElement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((PHPIfElement)node3).getCondition());
		assertEquals( ast.getNodeById((long)15), ((PHPIfElement)node3).getStatement());
		
		assertThat( node4, instanceOf(PHPIfElement.class));
		assertEquals( 2, node4.getChildCount());
		// TODO ((PHPIfElement)node4).getCondition() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PHPIfElement accepts arbitrary ASTNode's for conditions,
		// when we actually only want to accept Expression's. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((PHPIfElement)node4).getCondition().getProperty("type"));
		assertEquals( ast.getNodeById((long)18), ((PHPIfElement)node4).getStatement());
	}
	
	/**
	 * AST_SWITCH nodes are used to denote switch-statements.
	 * They are composed of an expression that evaluates to a value (matched against the different
	 * switch-element's values) and a switch list composed of switch-elements.
	 * 
	 * Any AST_SWITCH node has exactly two children:
	 * 1) various possible types, representing the expression in the switch statement's guard,
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) AST_SWITCH_LIST, a list of switch-elements in the switch statement's body
	 * 
	 * This test checks a switch-statement's children in the following PHP code:
	 * 
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitchCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_SWITCH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"i\",0,1,,,\n";
		nodeStr += "6,AST_SWITCH_LIST,,4,,1,1,,,\n";
		nodeStr += "7,AST_SWITCH_CASE,,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "9,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "10,AST_BREAK,,5,,0,1,,,\n";
		nodeStr += "11,NULL,,5,,0,1,,,\n";
		nodeStr += "12,AST_SWITCH_CASE,,6,,1,1,,,\n";
		nodeStr += "13,double,,6,1.42,0,1,,,\n";
		nodeStr += "14,AST_STMT_LIST,,6,,1,1,,,\n";
		nodeStr += "15,AST_SWITCH_CASE,,7,,2,1,,,\n";
		nodeStr += "16,integer,,7,2,0,1,,,\n";
		nodeStr += "17,AST_STMT_LIST,,7,,1,1,,,\n";
		nodeStr += "18,AST_BREAK,,8,,0,1,,,\n";
		nodeStr += "19,NULL,,8,,0,1,,,\n";
		nodeStr += "20,AST_SWITCH_CASE,,9,,3,1,,,\n";
		nodeStr += "21,NULL,,9,,0,1,,,\n";
		nodeStr += "22,AST_STMT_LIST,,9,,1,1,,,\n";
		nodeStr += "23,AST_CALL,,10,,0,1,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,10,,0,1,,,\n";
		nodeStr += "25,string,,10,\"buz\",0,1,,,\n";
		nodeStr += "26,AST_ARG_LIST,,10,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "6,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "15,17,PARENT_OF\n";
		edgeStr += "6,15,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "20,22,PARENT_OF\n";
		edgeStr += "6,20,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(PHPSwitchStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPSwitchStatement)node).getExpression());
		assertEquals( "i", ((Variable)((PHPSwitchStatement)node).getExpression()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((PHPSwitchStatement)node).getSwitchList());
		assertEquals( 4, ((PHPSwitchStatement)node).getSwitchList().size());
	}
	
	/**
	 * AST_SWITCH_CASE nodes are used to denote the individual switch-elements of a switch list.
	 * Similarly as if-elements, they are composed of a value (matched against a condition) and
	 * a statement list; see description of AST_SWITCH_LIST and AST_SWITCH for the bigger picture.
	 * 
	 * Any AST_SWITCH_CASE node has exactly two children:
	 * 1) a plain node or NULL, representing the value in the switch element's guard,
	 *    NULL is used when there is no such value, i.e., in "default" switch-elements.
	 * 2) AST_STMT_LIST, representing the code in the switch element's body
	 * 
	 * This test checks a few switch-elements' children in the following PHP code:
	 * 
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitchCaseCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_SWITCH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"i\",0,1,,,\n";
		nodeStr += "6,AST_SWITCH_LIST,,4,,1,1,,,\n";
		nodeStr += "7,AST_SWITCH_CASE,,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "9,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "10,AST_BREAK,,5,,0,1,,,\n";
		nodeStr += "11,NULL,,5,,0,1,,,\n";
		nodeStr += "12,AST_SWITCH_CASE,,6,,1,1,,,\n";
		nodeStr += "13,double,,6,1.42,0,1,,,\n";
		nodeStr += "14,AST_STMT_LIST,,6,,1,1,,,\n";
		nodeStr += "15,AST_SWITCH_CASE,,7,,2,1,,,\n";
		nodeStr += "16,integer,,7,2,0,1,,,\n";
		nodeStr += "17,AST_STMT_LIST,,7,,1,1,,,\n";
		nodeStr += "18,AST_BREAK,,8,,0,1,,,\n";
		nodeStr += "19,NULL,,8,,0,1,,,\n";
		nodeStr += "20,AST_SWITCH_CASE,,9,,3,1,,,\n";
		nodeStr += "21,NULL,,9,,0,1,,,\n";
		nodeStr += "22,AST_STMT_LIST,,9,,1,1,,,\n";
		nodeStr += "23,AST_CALL,,10,,0,1,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,10,,0,1,,,\n";
		nodeStr += "25,string,,10,\"buz\",0,1,,,\n";
		nodeStr += "26,AST_ARG_LIST,,10,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "6,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "15,17,PARENT_OF\n";
		edgeStr += "6,15,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "20,22,PARENT_OF\n";
		edgeStr += "6,20,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)12);
		ASTNode node3 = ast.getNodeById((long)15);
		ASTNode node4 = ast.getNodeById((long)20);
		
		assertThat( node, instanceOf(PHPSwitchCase.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PHPSwitchCase)node).getValue());
		assertEquals( "string", ((PHPSwitchCase)node).getValue().getProperty("type"));
		assertEquals( "foo", ((PHPSwitchCase)node).getValue().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((PHPSwitchCase)node).getStatement());
		
		assertThat( node2, instanceOf(PHPSwitchCase.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((PHPSwitchCase)node2).getValue());
		assertEquals( "double", ((PHPSwitchCase)node2).getValue().getProperty("type"));
		assertEquals( "1.42", ((PHPSwitchCase)node2).getValue().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)14), ((PHPSwitchCase)node2).getStatement());
		
		assertThat( node3, instanceOf(PHPSwitchCase.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((PHPSwitchCase)node3).getValue());
		assertEquals( "integer", ((PHPSwitchCase)node3).getValue().getProperty("type"));
		assertEquals( "2", ((PHPSwitchCase)node3).getValue().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)17), ((PHPSwitchCase)node3).getStatement());
		
		assertThat( node4, instanceOf(PHPSwitchCase.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)21), ((PHPSwitchCase)node4).getValue());
		// TODO ((PHPSwitchCase)node4).getValue() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PHPSwitchCase accepts arbitrary ASTNode's for values,
		// when we actually only want to accept ints/strings/doubles. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((PHPSwitchCase)node4).getValue().getProperty("type"));
		assertEquals( ast.getNodeById((long)22), ((PHPSwitchCase)node4).getStatement());
	}

	
	/* nodes with exactly 3 children */
	
	/**
	 * AST_METHOD_CALL nodes are used to denote method call expressions.
	 * 
	 * Any AST_METHOD_CALL node has exactly 3 children:
	 * 1) an expression node, representing the expression whose evaluation yields the
	 *    object that the target method belongs to
	 *    (e.g., could be AST_VAR, AST_CALL, AST_PROP, ...)
	 * 2) an expression node, representing the expression whose evaluation yields the
	 *    target method's name
	 *    (e.g., could be AST_VAR, "string", AST_BINARY_OP, ...)
	 * 3) AST_ARG_LIST, representing the argument list
	 * 
	 * This test checks a few method call expressions' children in the following PHP code:
	 * 
	 * $buz->foo($bar, "yabadabadoo");
	 * buz()->$foo($bar, "yabadabadoo");
	 */
	@Test
	public void testMethodCallCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_METHOD_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"buz\",0,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",1,1,,,\n";
		nodeStr += "7,AST_ARG_LIST,,3,,2,1,,,\n";
		nodeStr += "8,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "9,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "10,string,,3,\"yabadabadoo\",1,1,,,\n";
		nodeStr += "11,AST_METHOD_CALL,,4,,1,1,,,\n";
		nodeStr += "12,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "13,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "14,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "15,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "16,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "17,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "18,AST_ARG_LIST,,4,,2,1,,,\n";
		nodeStr += "19,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "20,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "21,string,,4,\"yabadabadoo\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "11,16,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,21,PARENT_OF\n";
		edgeStr += "11,18,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(MethodCallExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((MethodCallExpression)node).getTargetObject());
		assertEquals( "buz", ((Variable)((MethodCallExpression)node).getTargetObject()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((MethodCallExpression)node).getTargetFunc());
		assertEquals( "foo", ((MethodCallExpression)node).getTargetFunc().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)7), ((MethodCallExpression)node).getArgumentList());
		assertEquals( 2, ((MethodCallExpression)node).getArgumentList().size());
		
		assertThat( node2, instanceOf(MethodCallExpression.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((MethodCallExpression)node2).getTargetObject());
		assertEquals( "buz", ((Identifier)((CallExpression)((MethodCallExpression)node2).getTargetObject()).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)16), ((MethodCallExpression)node2).getTargetFunc());
		assertEquals( "foo", ((Variable)((MethodCallExpression)node2).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)18), ((MethodCallExpression)node2).getArgumentList());
		assertEquals( 2, ((MethodCallExpression)node2).getArgumentList().size());
	}
	
	/**
	 * AST_STATIC_CALL nodes are used to denote static call expressions.
	 * 
	 * Any AST_STATIC_CALL node has exactly 3 children:
	 * 1) AST_NAME, representing the class name that the static target method belongs to
	 * 2) a "string" node, representing the static method's name within the class
	 * 3) AST_ARG_LIST, representing the argument list
	 * 
	 * This test checks a static call expression's children in the following PHP code:
	 * 
	 * Buz::foo($bar, "yabadabadoo");
	 */
	@Test
	public void testStaticCallCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_STATIC_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Buz\",0,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",1,1,,,\n";
		nodeStr += "7,AST_ARG_LIST,,3,,2,1,,,\n";
		nodeStr += "8,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "9,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "10,string,,3,\"yabadabadoo\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(StaticCallExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((StaticCallExpression)node).getTargetClass());
		assertEquals( "Buz", ((StaticCallExpression)node).getTargetClass().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((StaticCallExpression)node).getTargetFunc());
		assertEquals( "foo", ((StaticCallExpression)node).getTargetFunc().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)7), ((StaticCallExpression)node).getArgumentList());
		assertEquals( 2, ((StaticCallExpression)node).getArgumentList().size());
	}
	
	/**
	 * AST_CONDITIONAL nodes are used to represent conditional expressions using the ?: operator,
	 * also known as the ternary conditional operator.
	 * 
	 * Any AST_CONDITIONAL node has exactly three children:
	 * 1) an expression representing the conditional
	 * 2) an expression representing the true branch, or NULL
	 * 3) an expression representing the false branch
	 * 
	 * This test checks a conditional expression's children in the following PHP code:
	 * 
	 * true ? "foo" : "bar";
	 */
	@Test
	public void testConditionalCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CONDITIONAL,,3,,0,1,,,\n";
		nodeStr += "4,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "5,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"true\",0,1,,,\n";
		nodeStr += "7,string,,3,\"foo\",1,1,,,\n";
		nodeStr += "8,string,,3,\"bar\",2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(ConditionalExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((ConditionalExpression)node).getCondition());
		assertEquals( ast.getNodeById((long)7), ((ConditionalExpression)node).getTrueExpression());
		assertEquals( ast.getNodeById((long)8), ((ConditionalExpression)node).getFalseExpression());
	}
	
	/**
	 * AST_TRY nodes are used for try statements.
	 * 
	 * Any AST_TRY node has exactly three children:
	 * 1) AST_STMT_LIST, representing the code to be "tried"
	 * 2) AST_CATCH_LIST, representing the list of catch statements, i.e.,
	 *    the list of caught exceptions.
	 * 3) AST_STMT_LIST or NULL, representing a finally statement, if it exists.
	 * 
	 * This test checks a few catch statements' children in the following PHP code:
	 * 
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testTryCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_TRY,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_CATCH_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_CATCH,,4,,0,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"FooException\",0,1,,,\n";
		nodeStr += "9,string,,4,\"f\",1,1,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,1,,,\n";
		nodeStr += "11,AST_CATCH,,5,,1,1,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "13,string,,5,\"BarException\",0,1,,,\n";
		nodeStr += "14,string,,5,\"b\",1,1,,,\n";
		nodeStr += "15,AST_STMT_LIST,,5,,2,1,,,\n";
		nodeStr += "16,AST_STMT_LIST,,6,,2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "6,10,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";
		edgeStr += "11,15,PARENT_OF\n";
		edgeStr += "5,11,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(TryStatement.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((TryStatement)node).getContent());
		assertEquals( ast.getNodeById((long)5), ((TryStatement)node).getCatchList());
		assertEquals( ast.getNodeById((long)16), ((TryStatement)node).getFinallyContent());
	}
	
	/**
	 * AST_CATCH nodes are used for catch statements.
	 * 
	 * Any AST_CATCH node has exactly three children:
	 * 1) AST_NAME, representing the exception's name
	 * 2) string, indicating the variable name holding the exception 
	 * 3) AST_STMT_LIST, representing the catch statement's content
	 * 
	 * This test checks a few catch statements' children in the following PHP code:
	 * 
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testCatchCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_TRY,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_CATCH_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_CATCH,,4,,0,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"FooException\",0,1,,,\n";
		nodeStr += "9,string,,4,\"f\",1,1,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,1,,,\n";
		nodeStr += "11,AST_CATCH,,5,,1,1,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "13,string,,5,\"BarException\",0,1,,,\n";
		nodeStr += "14,string,,5,\"b\",1,1,,,\n";
		nodeStr += "15,AST_STMT_LIST,,5,,2,1,,,\n";
		nodeStr += "16,AST_STMT_LIST,,6,,2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "6,10,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";
		edgeStr += "11,15,PARENT_OF\n";
		edgeStr += "5,11,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(CatchStatement.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((CatchStatement)node).getExceptionIdentifier());
		assertEquals( ast.getNodeById((long)8), ((CatchStatement)node).getExceptionIdentifier().getNameChild());
		assertEquals( "FooException", ((CatchStatement)node).getExceptionIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((CatchStatement)node).getVariableName());
		assertEquals( "f", ((CatchStatement)node).getVariableName().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)10), ((CatchStatement)node).getContent());
		
		assertThat( node2, instanceOf(CatchStatement.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((CatchStatement)node2).getExceptionIdentifier());
		assertEquals( ast.getNodeById((long)13), ((CatchStatement)node2).getExceptionIdentifier().getNameChild());
		assertEquals( "BarException", ((CatchStatement)node2).getExceptionIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)14), ((CatchStatement)node2).getVariableName());
		assertEquals( "b", ((CatchStatement)node2).getVariableName().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)15), ((CatchStatement)node2).getContent());
	}

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

	
	/* nodes with exactly 4 children */

	/**
	 * AST_FOR nodes are used to declare for-loops.
	 * 
	 * Any AST_FOR node has exactly four children:
	 * 1) AST_EXPR_LIST or NULL, representing the list of expressions
	 *    used to initialize the loop
	 * 2) AST_EXPR_LIST or NULL, representing the list of expressions
	 *    in the loop's guard, used to check whether to continue iterating
	 * 3) AST_EXPR_LIST or NULL, representing the list of expressions
	 *    used to increment or otherwise modify variables in each step
	 * 4) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 * 
	 * This test checks a for loop's children in the following PHP code:
	 * 
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */
	@Test
	public void testForCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FOR,,3,,0,1,,,\n";
		nodeStr += "4,AST_EXPR_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_ASSIGN,,3,,0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "7,string,,3,\"i\",0,1,,,\n";
		nodeStr += "8,integer,,3,0,1,1,,,\n";
		nodeStr += "9,AST_ASSIGN,,3,,1,1,,,\n";
		nodeStr += "10,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "11,string,,3,\"j\",0,1,,,\n";
		nodeStr += "12,integer,,3,1,1,1,,,\n";
		nodeStr += "13,AST_EXPR_LIST,,3,,1,1,,,\n";
		nodeStr += "14,AST_BINARY_OP,BINARY_IS_SMALLER,3,,0,1,,,\n";
		nodeStr += "15,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "16,string,,3,\"i\",0,1,,,\n";
		nodeStr += "17,integer,,3,3,1,1,,,\n";
		nodeStr += "18,AST_EXPR_LIST,,3,,2,1,,,\n";
		nodeStr += "19,AST_POST_INC,,3,,0,1,,,\n";
		nodeStr += "20,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "21,string,,3,\"i\",0,1,,,\n";
		nodeStr += "22,AST_POST_INC,,3,,1,1,,,\n";
		nodeStr += "23,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "24,string,,3,\"j\",0,1,,,\n";
		nodeStr += "25,AST_STMT_LIST,,3,,3,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "4,9,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,17,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "3,13,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "18,22,PARENT_OF\n";
		edgeStr += "3,18,PARENT_OF\n";
		edgeStr += "3,25,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(ForStatement.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((ForStatement)node).getForInitExpression());
		assertEquals( ast.getNodeById((long)13), ((ForStatement)node).getCondition());
		assertEquals( ast.getNodeById((long)18), ((ForStatement)node).getForLoopExpression());
		assertEquals( ast.getNodeById((long)25), ((ForStatement)node).getStatement());
	}
	
	/**
	 * AST_FOREACH nodes are used to declare foreach-loops.
	 * 
	 * Any AST_FOREACH node has exactly four children:
	 * 1) various possible types, representing the array or object to be iterated over
	 *    (e.g., could be AST_VAR, AST_CALL, AST_CONST, etc...)
	 * 2) AST_VAR, representing the value of the current element
	 * 3) AST_VAR or NULL, representing the key of the current element
	 * 4) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 * 
	 * This test checks a foreach loop's children in the following PHP code:
	 * 
	 * foreach ($somearray as $foo) {}
	 * foreach (somecall() as $bar => $foo) {}
	 */
	@Test
	public void testForEachCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FOREACH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"somearray\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "7,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "8,NULL,,3,,2,1,,,\n";
		nodeStr += "9,AST_STMT_LIST,,3,,3,1,,,\n";
		nodeStr += "10,AST_FOREACH,,4,,1,1,,,\n";
		nodeStr += "11,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "13,string,,4,\"somecall\",0,1,,,\n";
		nodeStr += "14,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "15,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "16,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "17,AST_VAR,,4,,2,1,,,\n";
		nodeStr += "18,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "19,AST_STMT_LIST,,4,,3,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "10,15,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "10,17,PARENT_OF\n";
		edgeStr += "10,19,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(ForEachStatement.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((ForEachStatement)node).getIteratedObject());
		assertEquals( ast.getNodeById((long)6), ((ForEachStatement)node).getValueVar());
		assertNull( ((ForEachStatement)node).getKeyVar());
		assertEquals( ast.getNodeById((long)9), ((ForEachStatement)node).getStatement());
		
		assertThat( node2, instanceOf(ForEachStatement.class));
		assertEquals( 4, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((ForEachStatement)node2).getIteratedObject());
		assertEquals( ast.getNodeById((long)15), ((ForEachStatement)node2).getValueVar());
		assertEquals( ast.getNodeById((long)17), ((ForEachStatement)node2).getKeyVar());
		assertEquals( ast.getNodeById((long)19), ((ForEachStatement)node2).getStatement());
	}


	/* nodes with an arbitrary number of children */

	/**
	 * AST_ARG_LIST nodes are used to denote a list of arguments in a function call.
	 * 
	 * Any AST_ARG_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one argument in the list.
	 * 
	 * This test checks a few argument lists' children in the following PHP code:
	 * 
	 * foo($bar, "yabadabadoo");
	 * $buz(1);
	 */
	@Test
	public void testArgumentListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "9,string,,3,\"yabadabadoo\",1,1,,,\n";
		nodeStr += "10,AST_CALL,,4,,1,1,,,\n";
		nodeStr += "11,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "12,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "13,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "14,integer,,4,1,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)13);
		
		assertThat( node, instanceOf(ArgumentList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ArgumentList)node).size());
		assertEquals( ast.getNodeById((long)7), ((ArgumentList)node).getArgument(0));
		assertEquals( ast.getNodeById((long)9), ((ArgumentList)node).getArgument(1));
		for( ASTNode argument : (ArgumentList)node)
			assertTrue( ast.containsValue(argument));
		
		assertThat( node2, instanceOf(ArgumentList.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( 1, ((ArgumentList)node2).size());
		assertEquals( ast.getNodeById((long)14), ((ArgumentList)node2).getArgument(0));
		for( ASTNode argument : (ArgumentList)node)
			assertTrue( ast.containsValue(argument));
	}
	
	/**
	 * AST_EXPR_LIST nodes are used for holding a list of expressions, e.g.,
	 * a list of initializations in a for-loop.
	 * 
	 * Any AST_EXPR_LIST node has between 1 and an arbitrarily large number
	 * of children. Each child corresponds to one expression in the list.
	 * TODO I am not sure at the moment whether there are situations where
	 * an AST_EXPR_LIST with 0 children can be generated; I do not think so,
	 * but look into it more closely.
	 * 
	 * This test checks an expression list's children in the following PHP code:
	 * 
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */
	@Test
	public void testExpressionList() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FOR,,3,,0,1,,,\n";
		nodeStr += "4,AST_EXPR_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_ASSIGN,,3,,0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "7,string,,3,\"i\",0,1,,,\n";
		nodeStr += "8,integer,,3,0,1,1,,,\n";
		nodeStr += "9,AST_ASSIGN,,3,,1,1,,,\n";
		nodeStr += "10,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "11,string,,3,\"j\",0,1,,,\n";
		nodeStr += "12,integer,,3,1,1,1,,,\n";
		nodeStr += "13,AST_EXPR_LIST,,3,,1,1,,,\n";
		nodeStr += "14,AST_BINARY_OP,BINARY_IS_SMALLER,3,,0,1,,,\n";
		nodeStr += "15,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "16,string,,3,\"i\",0,1,,,\n";
		nodeStr += "17,integer,,3,3,1,1,,,\n";
		nodeStr += "18,AST_EXPR_LIST,,3,,2,1,,,\n";
		nodeStr += "19,AST_POST_INC,,3,,0,1,,,\n";
		nodeStr += "20,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "21,string,,3,\"i\",0,1,,,\n";
		nodeStr += "22,AST_POST_INC,,3,,1,1,,,\n";
		nodeStr += "23,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "24,string,,3,\"j\",0,1,,,\n";
		nodeStr += "25,AST_STMT_LIST,,3,,3,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "4,9,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,17,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "3,13,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "18,22,PARENT_OF\n";
		edgeStr += "3,18,PARENT_OF\n";
		edgeStr += "3,25,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)13);
		ASTNode node3 = ast.getNodeById((long)18);

		assertThat( node, instanceOf(ExpressionList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ExpressionList)node).size());
		assertEquals( ast.getNodeById((long)5), ((ExpressionList)node).getExpression(0));
		assertEquals( ast.getNodeById((long)9), ((ExpressionList)node).getExpression(1));
		for( ASTNode expression : (ExpressionList)node) // TODO iterate over Expression's
			assertTrue( ast.containsValue(expression));
		
		assertThat( node2, instanceOf(ExpressionList.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( 1, ((ExpressionList)node2).size());
		assertEquals( ast.getNodeById((long)14), ((ExpressionList)node2).getExpression(0));
		for( ASTNode expression : (ExpressionList)node2) // TODO iterate over Expression's
			assertTrue( ast.containsValue(expression));
		
		assertThat( node3, instanceOf(ExpressionList.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( 2, ((ExpressionList)node3).size());
		assertEquals( ast.getNodeById((long)19), ((ExpressionList)node3).getExpression(0));
		assertEquals( ast.getNodeById((long)22), ((ExpressionList)node3).getExpression(1));
		for( ASTNode expression : (ExpressionList)node3) // TODO iterate over Expression's
			assertTrue( ast.containsValue(expression));
	}
	
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
	 * AST_IF nodes are used to denote if-statements.
	 * 
	 * Any AST_IF node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one if-element. Such if-elements are composed of an
	 * expression and a statement (see description of AST_IF_ELEM). The PHP interpreter
	 * simply goes through the list of if-elements in order and evaluates the if-elements'
	 * expressions until the first such expression evaluates to true. Then, the
	 * corresponding statement is executed. This allows to represent if-statements with
	 * multiple 'elseif' constructs in a flat hierarchy, instead of an arbitrarily deep
	 * nesting that would be obtained when using 'else if' instead.
	 * 
	 * This test checks an if-statement's children in the following PHP code:
	 * 
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */
	@Test
	public void testIfStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_IF,,3,,0,1,,,\n";
		nodeStr += "4,AST_IF_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "7,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "8,AST_IF_ELEM,,4,,1,1,,,\n";
		nodeStr += "9,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "12,AST_IF_ELEM,,5,,2,1,,,\n";
		nodeStr += "13,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "14,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "15,AST_STMT_LIST,,5,,1,1,,,\n";
		nodeStr += "16,AST_IF_ELEM,,6,,3,1,,,\n";
		nodeStr += "17,NULL,,6,,0,1,,,\n";
		nodeStr += "18,AST_STMT_LIST,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,7,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "3,12,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,18,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(PHPIfStatement.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((PHPIfStatement)node).size());
		assertEquals( ast.getNodeById((long)4), ((PHPIfStatement)node).getIfElement(0));
		assertEquals( ast.getNodeById((long)8), ((PHPIfStatement)node).getIfElement(1));
		assertEquals( ast.getNodeById((long)12), ((PHPIfStatement)node).getIfElement(2));
		assertEquals( ast.getNodeById((long)16), ((PHPIfStatement)node).getIfElement(3));
	}
	
	/**
	 * AST_SWITCH_LIST nodes are used to denote a list of switch-elements.
	 * 
	 * Any AST_SWITCH_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one switch-case. Such switch-cases are composed of a
	 * value and a statement list (see description of AST_SWITCH_CASE). AST_SWITCH_LIST nodes
	 * are always a child of AST_SWITCH nodes, and always have exactly one sister which
	 * represents an expression whose evaluated form is matched against the values of the
	 * AST_SWITCH_CASE children (see description of AST_SWITCH).
	 * 
	 * This test checks a switch list's children in the following PHP code:
	 * 
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitchListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_SWITCH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"i\",0,1,,,\n";
		nodeStr += "6,AST_SWITCH_LIST,,4,,1,1,,,\n";
		nodeStr += "7,AST_SWITCH_CASE,,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "9,AST_STMT_LIST,,4,,1,1,,,\n";
		nodeStr += "10,AST_BREAK,,5,,0,1,,,\n";
		nodeStr += "11,NULL,,5,,0,1,,,\n";
		nodeStr += "12,AST_SWITCH_CASE,,6,,1,1,,,\n";
		nodeStr += "13,double,,6,1.42,0,1,,,\n";
		nodeStr += "14,AST_STMT_LIST,,6,,1,1,,,\n";
		nodeStr += "15,AST_SWITCH_CASE,,7,,2,1,,,\n";
		nodeStr += "16,integer,,7,2,0,1,,,\n";
		nodeStr += "17,AST_STMT_LIST,,7,,1,1,,,\n";
		nodeStr += "18,AST_BREAK,,8,,0,1,,,\n";
		nodeStr += "19,NULL,,8,,0,1,,,\n";
		nodeStr += "20,AST_SWITCH_CASE,,9,,3,1,,,\n";
		nodeStr += "21,NULL,,9,,0,1,,,\n";
		nodeStr += "22,AST_STMT_LIST,,9,,1,1,,,\n";
		nodeStr += "23,AST_CALL,,10,,0,1,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,10,,0,1,,,\n";
		nodeStr += "25,string,,10,\"buz\",0,1,,,\n";
		nodeStr += "26,AST_ARG_LIST,,10,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "6,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "15,17,PARENT_OF\n";
		edgeStr += "6,15,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "20,22,PARENT_OF\n";
		edgeStr += "6,20,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(PHPSwitchList.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((PHPSwitchList)node).size());

		assertEquals( ast.getNodeById((long)7), ((PHPSwitchList)node).getSwitchCase(0));
		assertEquals( ast.getNodeById((long)12), ((PHPSwitchList)node).getSwitchCase(1));
		assertEquals( ast.getNodeById((long)15), ((PHPSwitchList)node).getSwitchCase(2));
		assertEquals( ast.getNodeById((long)20), ((PHPSwitchList)node).getSwitchCase(3));
		for( PHPSwitchCase switchcase : (PHPSwitchList)node)
			assertTrue( ast.containsValue(switchcase));
	}
	
	/**
	 * AST_CATCH_LIST nodes are used to denote a list of catch statements.
	 * 
	 * Any AST_CATCH_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one catch statement in the list.
	 * 
	 * This test checks a catch list's children in the following PHP code:
	 * 
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testCatchListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_TRY,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_CATCH_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_CATCH,,4,,0,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"FooException\",0,1,,,\n";
		nodeStr += "9,string,,4,\"f\",1,1,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,1,,,\n";
		nodeStr += "11,AST_CATCH,,5,,1,1,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "13,string,,5,\"BarException\",0,1,,,\n";
		nodeStr += "14,string,,5,\"b\",1,1,,,\n";
		nodeStr += "15,AST_STMT_LIST,,5,,2,1,,,\n";
		nodeStr += "16,AST_STMT_LIST,,6,,2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "6,10,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";
		edgeStr += "11,15,PARENT_OF\n";
		edgeStr += "5,11,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(CatchList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((CatchList)node).size());
		
		assertEquals( ast.getNodeById((long)6), ((CatchList)node).getCatchStatement(0));
		assertEquals( ast.getNodeById((long)11), ((CatchList)node).getCatchStatement(1));
		for( CatchStatement catchstatement : (CatchList)node)
			assertTrue( ast.containsValue(catchstatement));
	}

	/**
	 * AST_PARAM_LIST nodes are used to denote a list of function parameters.
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
		assertEquals( 2, ((ParameterList)node).size());
		assertEquals( ast.getNodeById((long)5), ((ParameterList)node).getParameter(0));
		assertEquals( ast.getNodeById((long)10), ((ParameterList)node).getParameter(1));
		for( Parameter parameter : (ParameterList)node)
			assertTrue( ast.containsValue(parameter));
	}
	
	/**
	 * AST_CLOSURE_USES nodes are used for holding a list of variables that
	 * occur within the 'use' language construct of closure declarations.
	 * 
	 * Any AST_CLOSURE_USES node has between 1 and an arbitrarily large number
	 * of children. Each child corresponds to one closure variable in the list.
	 * (It cannot have 0 children as the 'use' construct can only be used in
	 * conjunction with at least 1 variable name.)
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
		assertEquals( 2, ((ClosureUses)node).size());
		assertEquals( ast.getNodeById((long)6), ((ClosureUses)node).getClosureVar(0));
		assertEquals( ast.getNodeById((long)8), ((ClosureUses)node).getClosureVar(1));
		for( ClosureVar closurevar : (ClosureUses)node)
			assertTrue( ast.containsValue(closurevar));
	}
	
	/**
	 * AST_NAME_LIST nodes are used for holding a list of identifiers, e.g.,
	 * a list of names referring to interfaces that a class extends.
	 * 
	 * Any AST_NAME_LIST node has between 1 and an arbitrarily large number
	 * of children. Each child corresponds to one identifier in the list.
	 * TODO I am not sure at the moment whether there are situations where
	 * an AST_NAME_LIST with 0 children can be generated; I do not think so,
	 * but look into it more closely.
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
		assertEquals( 2, ((IdentifierList)node).size());
		assertEquals( ast.getNodeById((long)7), ((IdentifierList)node).getIdentifier(0));
		assertEquals( ast.getNodeById((long)9), ((IdentifierList)node).getIdentifier(1));
		for( Identifier identifier : (IdentifierList)node)
			assertTrue( ast.containsValue(identifier));
	}
}
