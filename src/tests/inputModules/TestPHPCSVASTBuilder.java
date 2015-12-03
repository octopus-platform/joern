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
import ast.expressions.AndExpression;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpression;
import ast.expressions.AssignmentWithOpExpression;
import ast.expressions.BinaryOperationExpression;
import ast.expressions.CallExpression;
import ast.expressions.ClassConstantExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.Constant;
import ast.expressions.ExpressionList;
import ast.expressions.GreaterExpression;
import ast.expressions.GreaterOrEqualExpression;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.InstanceofExpression;
import ast.expressions.NewExpression;
import ast.expressions.OrExpression;
import ast.expressions.PropertyExpression;
import ast.expressions.StaticPropertyExpression;
import ast.expressions.UnaryMinusExpression;
import ast.expressions.UnaryOperationExpression;
import ast.expressions.UnaryPlusExpression;
import ast.expressions.Variable;
import ast.functionDef.FunctionDef;
import ast.functionDef.Parameter;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.php.declarations.PHPClassDef;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.PHPArrayElement;
import ast.php.expressions.PHPArrayExpression;
import ast.php.expressions.PHPAssignmentByRefExpression;
import ast.php.expressions.PHPCloneExpression;
import ast.php.expressions.PHPCoalesceExpression;
import ast.php.expressions.PHPEmptyExpression;
import ast.php.expressions.PHPEncapsListExpression;
import ast.php.expressions.PHPIssetExpression;
import ast.php.expressions.PHPListExpression;
import ast.php.expressions.PHPReferenceExpression;
import ast.php.expressions.PHPSilenceExpression;
import ast.php.expressions.PHPUnpackExpression;
import ast.php.expressions.PHPYieldExpression;
import ast.php.expressions.PHPYieldFromExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.ClassConstantDeclaration;
import ast.php.statements.ConstantDeclaration;
import ast.php.statements.ConstantElement;
import ast.php.statements.PHPEchoStatement;
import ast.php.statements.PHPGlobalStatement;
import ast.php.statements.PHPGroupUseStatement;
import ast.php.statements.PHPHaltCompilerStatement;
import ast.php.statements.PHPUnsetStatement;
import ast.php.statements.PropertyDeclaration;
import ast.php.statements.PropertyElement;
import ast.php.statements.StaticVariableDeclaration;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.MethodReference;
import ast.php.statements.blockstarters.PHPDeclareStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPIfStatement;
import ast.php.statements.blockstarters.PHPSwitchCase;
import ast.php.statements.blockstarters.PHPSwitchList;
import ast.php.statements.blockstarters.PHPSwitchStatement;
import ast.php.statements.blockstarters.PHPTraitAdaptationElement;
import ast.php.statements.blockstarters.PHPTraitAdaptations;
import ast.php.statements.blockstarters.PHPTraitAlias;
import ast.php.statements.blockstarters.PHPTraitPrecedence;
import ast.php.statements.blockstarters.PHPUseTrait;
import ast.php.statements.jump.PHPBreakStatement;
import ast.php.statements.jump.PHPContinueStatement;
import ast.statements.UseElement;
import ast.statements.UseStatement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.NamespaceStatement;
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
	 * AST_CONST nodes are nodes holding constant names.
	 * 
	 * Any AST_CONST node has exactly one child which is of type Identifier, holding
	 * the constant's name (note that, as opposed to a Variable, a Constant may be
	 * namespaced.)
	 * 
	 * This test checks a few constant expressions' children in the following PHP code:
	 * 
	 * FOO;
	 * \BAR\BUZ;
	 */
	@Test
	public void testConstantCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"FOO\",0,1,,,\n";
		nodeStr += "6,AST_CONST,,4,,1,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_FQ,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"BAR\\BUZ\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)6);

		assertThat( node, instanceOf(Constant.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((Constant)node).getIdentifier());
		assertEquals( "FOO", ((Constant)node).getIdentifier().getNameChild().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(Constant.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((Constant)node2).getIdentifier());
		assertEquals( "BAR\\BUZ", ((Constant)node2).getIdentifier().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_UNPACK nodes are used to represent "unpack" operations which unpack traversable
	 * objects or arrays into argument lists, also known as the "splat" operator (mostly useful
	 * in combination with variadic functions).
	 * See https://wiki.php.net/rfc/argument_unpacking
	 * 
	 * Any AST_UNPACK node has exactly one child which is an expression whose evaluation yields
	 * a traversable object or array to be unpacked.
	 * 
	 * This test checks a few unpack expressions' children in the following PHP code:
	 * 
	 * foo( ...$traversable);
	 * foo( ...[4,2]);
	 */
	@Test
	public void testUnpackCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_UNPACK,,3,,0,1,,,\n";
		nodeStr += "8,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "9,string,,3,\"traversable\",0,1,,,\n";
		nodeStr += "10,AST_CALL,,4,,1,1,,,\n";
		nodeStr += "11,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "12,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "13,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "14,AST_UNPACK,,4,,0,1,,,\n";
		nodeStr += "15,AST_ARRAY,,4,,0,1,,,\n";
		nodeStr += "16,AST_ARRAY_ELEM,,4,,0,1,,,\n";
		nodeStr += "17,integer,,4,4,0,1,,,\n";
		nodeStr += "18,NULL,,4,,1,1,,,\n";
		nodeStr += "19,AST_ARRAY_ELEM,,4,,1,1,,,\n";
		nodeStr += "20,integer,,4,2,0,1,,,\n";
		nodeStr += "21,NULL,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,18,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "19,21,PARENT_OF\n";
		edgeStr += "15,19,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(PHPUnpackExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PHPUnpackExpression)node).getExpression());
		
		assertThat( node2, instanceOf(PHPUnpackExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((PHPUnpackExpression)node2).getExpression());
	}

	/**
	 * AST_UNARY_PLUS nodes are used to denote 'unary plus' operation expressions.
	 * 
	 * Any AST_UNARY_PLUS node has exactly exactly one child, representing the expression for which
	 * the operation is to be performed.
	 * 
	 * This test checks a unary plus operation expression's children in the following PHP code:
	 * 
	 * // arithmetic operators
	 * +$x;
	 */
	@Test
	public void testUnaryPlusCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_UNARY_PLUS,,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"x\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(UnaryPlusExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((UnaryPlusExpression)node).getExpression());
	}
	
	/**
	 * AST_UNARY_MINUS nodes are used to denote 'unary minus' operation expressions.
	 * 
	 * Any AST_UNARY_MINUS node has exactly exactly one child, representing the expression for which
	 * the operation is to be performed.
	 * 
	 * This test checks a unary minus operation expression's children in the following PHP code:
	 * 
	 * // arithmetic operators
	 * -$x;
	 */
	@Test
	public void testUnaryMinusCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_UNARY_MINUS,,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"x\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(UnaryMinusExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((UnaryMinusExpression)node).getExpression());
	}
	
	/**
	 * AST_EMPTY nodes are used to denote 'empty' operation expressions.
	 * 
	 * Any AST_EMPTY node has exactly exactly one child, representing the expression for which
	 * the operation is to be performed.
	 * 
	 * This test checks a few 'empty' operation expressions' children in the following PHP code:
	 * 
	 * empty($foo);
	 * empty(bar());
	 */
	@Test
	public void testEmptyCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_EMPTY,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_EMPTY,,4,,1,1,,,\n";
		nodeStr += "7,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "8,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "10,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PHPEmptyExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPEmptyExpression)node).getExpression());
		
		assertThat( node2, instanceOf(PHPEmptyExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PHPEmptyExpression)node2).getExpression());
	}
	
	/**
	 * AST_ISSET nodes are used to denote 'isset' operation expressions.
	 * 
	 * Any AST_ISSET node has exactly exactly one child, representing the variable for which
	 * the operation is to be performed.
	 * 
	 * This test checks a few 'isset' operation expressions' children in the following PHP code:
	 * 
	 * isset($foo);
	 * isset($bar->buz);
	 */
	@Test
	public void testIssetCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ISSET,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ISSET,,4,,1,1,,,\n";
		nodeStr += "7,AST_PROP,,4,,0,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "10,string,,4,\"buz\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PHPIssetExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPIssetExpression)node).getVariableExpression());
		
		assertThat( node2, instanceOf(PHPIssetExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PHPIssetExpression)node2).getVariableExpression());
	}
	
	/**
	 * AST_SILENCE nodes are used to denote 'silence' operation expressions.
	 * 
	 * Any AST_SILENCE node has exactly exactly one child, representing the expression for which
	 * error messages should be ignored.
	 * See http://php.net/manual/en/language.operators.errorcontrol.php
	 * 
	 * This test checks a few silence operation expressions' children in the following PHP code:
	 * 
	 * // error control operators
	 * @foo();
	 * @$bar[42];
	 */
	@Test
	public void testSilenceCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_SILENCE,,4,,0,1,,,\n";
		nodeStr += "4,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "5,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "6,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "7,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "8,AST_SILENCE,,5,,1,1,,,\n";
		nodeStr += "9,AST_DIM,,5,,0,1,,,\n";
		nodeStr += "10,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "11,string,,5,\"bar\",0,1,,,\n";
		nodeStr += "12,integer,,5,42,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,7,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(PHPSilenceExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPSilenceExpression)node).getExpression());
		
		assertThat( node2, instanceOf(PHPSilenceExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((PHPSilenceExpression)node2).getExpression());
	}
	
	/**
	 * AST_CLONE nodes are used to denote 'clone' operation expressions.
	 * 
	 * Any AST_CLONE node has exactly exactly one child, representing the expression whose
	 * evaluation yields the object to be cloned.
	 * 
	 * This test checks a few 'clone' operation expressions' children in the following PHP code:
	 * 
	 * clone($foo);
	 * clone(bar());
	 */
	@Test
	public void testCloneCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLONE,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_CLONE,,4,,1,1,,,\n";
		nodeStr += "7,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "8,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "10,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PHPCloneExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPCloneExpression)node).getExpression());
		
		assertThat( node2, instanceOf(PHPCloneExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PHPCloneExpression)node2).getExpression());
	}
	
	/**
	 * AST_UNARY_OP nodes are used to denote unary operation expressions.
	 * 
	 * Any AST_UNARY_OP node has exactly exactly one child, representing the expression for which
	 * the operation is to be performed.
	 * 
	 * This test checks a few of unary operation expressions' children in the following PHP code:
	 * 
	 * // bit operators
	 * ~$foo;
	 * // boolean operators
	 * !$foo;
	 */
	@Test
	public void testUnaryOperationCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_UNARY_OP,UNARY_BITWISE_NOT,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_UNARY_OP,UNARY_BOOL_NOT,6,,1,1,,,\n";
		nodeStr += "7,AST_VAR,,6,,0,1,,,\n";
		nodeStr += "8,string,,6,\"foo\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((UnaryOperationExpression)node).getExpression());
		
		assertThat( node2, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((UnaryOperationExpression)node2).getExpression());
	}
	
	/**
	 * AST_YIELD_FROM nodes are used to denote 'yield from' expressions used in generators.
	 * See http://php.net/manual/en/language.generators.syntax.php
	 * 
	 * Any AST_YIELD_FROM node has exactly one child, which is an expression that evaluates
	 * to another generator call, traversable object or array to be yielded from.
	 * 
	 * This test checks a few yield from expressions' children in the following PHP code:
	 * 
	 * function foo() {
	 *   yield from [4, 2];
	 *   yield from new ArrayIterator(["hello", "world"]);
	 *   yield from bar();
	 * }
	 */
	@Test
	public void testYieldFromCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,7,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_YIELD_FROM,,4,,0,3,,,\n";
		nodeStr += "8,AST_ARRAY,,4,,0,3,,,\n";
		nodeStr += "9,AST_ARRAY_ELEM,,4,,0,3,,,\n";
		nodeStr += "10,integer,,4,4,0,3,,,\n";
		nodeStr += "11,NULL,,4,,1,3,,,\n";
		nodeStr += "12,AST_ARRAY_ELEM,,4,,1,3,,,\n";
		nodeStr += "13,integer,,4,2,0,3,,,\n";
		nodeStr += "14,NULL,,4,,1,3,,,\n";
		nodeStr += "15,AST_YIELD_FROM,,5,,1,3,,,\n";
		nodeStr += "16,AST_NEW,,5,,0,3,,,\n";
		nodeStr += "17,AST_NAME,NAME_NOT_FQ,5,,0,3,,,\n";
		nodeStr += "18,string,,5,\"ArrayIterator\",0,3,,,\n";
		nodeStr += "19,AST_ARG_LIST,,5,,1,3,,,\n";
		nodeStr += "20,AST_ARRAY,,5,,0,3,,,\n";
		nodeStr += "21,AST_ARRAY_ELEM,,5,,0,3,,,\n";
		nodeStr += "22,string,,5,\"hello\",0,3,,,\n";
		nodeStr += "23,NULL,,5,,1,3,,,\n";
		nodeStr += "24,AST_ARRAY_ELEM,,5,,1,3,,,\n";
		nodeStr += "25,string,,5,\"world\",0,3,,,\n";
		nodeStr += "26,NULL,,5,,1,3,,,\n";
		nodeStr += "27,AST_YIELD_FROM,,6,,2,3,,,\n";
		nodeStr += "28,AST_CALL,,6,,0,3,,,\n";
		nodeStr += "29,AST_NAME,NAME_NOT_FQ,6,,0,3,,,\n";
		nodeStr += "30,string,,6,\"bar\",0,3,,,\n";
		nodeStr += "31,AST_ARG_LIST,,6,,1,3,,,\n";
		nodeStr += "32,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "21,23,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "24,26,PARENT_OF\n";
		edgeStr += "20,24,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "16,19,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "6,15,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "28,31,PARENT_OF\n";
		edgeStr += "27,28,PARENT_OF\n";
		edgeStr += "6,27,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,32,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)15);
		ASTNode node3 = ast.getNodeById((long)27);
		
		assertThat( node, instanceOf(PHPYieldFromExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PHPYieldFromExpression)node).getFromExpression());
		
		assertThat( node2, instanceOf(PHPYieldFromExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((PHPYieldFromExpression)node2).getFromExpression());
		
		assertThat( node3, instanceOf(PHPYieldFromExpression.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)28), ((PHPYieldFromExpression)node3).getFromExpression());
	}
	
	/**
	 * AST_GLOBAL nodes are used to denote 'global' statements used to make variables from
	 * the global scope available in a local function scope.
	 * 
	 * Any AST_GLOBAL node has exactly one child, which is a variable that is being made
	 * available in a local scope.
	 * 
	 * This test checks a few global statements' children in the following PHP code:
	 * 
	 * function foo() {
	 *   global $bar, $buz;
	 * }
	 */
	@Test
	public void testGlobalCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_STMT_LIST,,4,,0,3,,,\n";
		nodeStr += "8,AST_GLOBAL,,4,,0,3,,,\n";
		nodeStr += "9,AST_VAR,,4,,0,3,,,\n";
		nodeStr += "10,string,,4,\"bar\",0,3,,,\n";
		nodeStr += "11,AST_GLOBAL,,4,,1,3,,,\n";
		nodeStr += "12,AST_VAR,,4,,0,3,,,\n";
		nodeStr += "13,string,,4,\"buz\",0,3,,,\n";
		nodeStr += "14,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "7,11,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,14,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);
		ASTNode node2 = ast.getNodeById((long)11);

		assertThat( node, instanceOf(PHPGlobalStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((PHPGlobalStatement)node).getVariable());
		assertEquals( "bar", ((PHPGlobalStatement)node).getVariable().getNameChild().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(PHPGlobalStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((PHPGlobalStatement)node2).getVariable());
		assertEquals( "buz", ((PHPGlobalStatement)node2).getVariable().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_UNSET nodes are used to denote unset statements used to destroy variables.
	 * 
	 * Any AST_UNSET node has exactly one child, which is a reference to variable that
	 * is to be destroyed (e.g., AST_VAR, AST_PROP, AST_DIM, ...)
	 * 
	 * This test checks a few unset statement's children in the following PHP code:
	 * 
	 * unset($foo,$bar->buz,$qux[42]);
	 */
	@Test
	public void testUnsetCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "4,AST_UNSET,,3,,0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "7,AST_UNSET,,3,,1,1,,,\n";
		nodeStr += "8,AST_PROP,,3,,0,1,,,\n";
		nodeStr += "9,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "10,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "11,string,,3,\"buz\",1,1,,,\n";
		nodeStr += "12,AST_UNSET,,3,,2,1,,,\n";
		nodeStr += "13,AST_DIM,,3,,0,1,,,\n";
		nodeStr += "14,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "15,string,,3,\"qux\",0,1,,,\n";
		nodeStr += "16,integer,,3,42,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "13,16,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "3,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)12);

		assertThat( node, instanceOf(PHPUnsetStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((PHPUnsetStatement)node).getVariableExpression());
		
		assertThat( node2, instanceOf(PHPUnsetStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PHPUnsetStatement)node2).getVariableExpression());
		
		assertThat( node3, instanceOf(PHPUnsetStatement.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((PHPUnsetStatement)node3).getVariableExpression());
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
	 * AST_REF nodes are used to denote references to variables.
	 * TODO As far as I currently understand, this is a node useful *only* in the
	 * context of a foreach statement; for AST_ARRAY_ELEM nodes that designate a reference,
	 * functions that return references, and function parameters taken as references,
	 * a simple flag is used; for assignments, there is a special kind of node AST_ASSIGN_REF.
	 * But look into this more closely.
	 * 
	 * Any AST_REF node has exactly one child, which is a variable being referenced.
	 * 
	 * This test checks a reference expression's children in the following PHP code:
	 * 
	 * foreach( $iterable as $somekey => &$someval) {}
	 */
	@Test
	public void testReferenceCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FOREACH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"iterable\",0,1,,,\n";
		nodeStr += "6,AST_REF,,3,,1,1,,,\n";
		nodeStr += "7,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"someval\",0,1,,,\n";
		nodeStr += "9,AST_VAR,,3,,2,1,,,\n";
		nodeStr += "10,string,,3,\"somekey\",0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,3,,3,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";
		edgeStr += "3,11,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PHPReferenceExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PHPReferenceExpression)node).getVariable());
		assertEquals( "someval", ((PHPReferenceExpression)node).getVariable().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_HALT_COMPILER nodes are used to denote halt compiler statements which halt
	 * the PHP compiler.
	 * See http://php.net/manual/en/function.halt-compiler.php
	 * 
	 * Any AST_HALT_COMPILER node has exactly one child, which holds the offset (in bytes)
	 * in the file after which the compiler is to be halted; this offset is determined during parsing.
	 * TODO What does the offset look like if we throw an eval() on some user input, and
	 * the user input happens to be "__halt_compiler();"? ;-) Can be determined at runtime
	 * using the magic constant __COMPILER_HALT_OFFSET__, look into this.
	 * 
	 * This test checks a halt compiler statement's children in the following PHP code:
	 * 
	 * __halt_compiler();
	 */
	@Test
	public void testHaltCompilerCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_HALT_COMPILER,,3,,0,1,,,\n";
		nodeStr += "4,integer,,3,25,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(PHPHaltCompilerStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPHaltCompilerStatement)node).getOffset());
		assertEquals( "25", ((PHPHaltCompilerStatement)node).getOffset().getEscapedCodeStr());
	}
	
	/**
	 * AST_ECHO nodes are used to denote echo statements.
	 * 
	 * Any AST_ECHO node has exactly one child, which holds the expression to be
	 * evaluated and whose result is to be output.
	 * Note that an echo statement can take an arbitrary number of arguments (but not 0),
	 * in which case an AST_ECHO node is generated for each argument.
	 * TODO What's really weird though, is that an echo statement may not only generate
	 * an arbitrary number of AST_ECHO nodes (which is fine), but also generates a common
	 * AST_STMT_LIST mother node for them. I'm not sure why this should be necessary.
	 * Either find out the reason, or file a bug report.
	 * 
	 * This test checks a few echo statement's children in the following PHP code:
	 * 
	 * echo "Hello World!", PHP_EOL;
	 */
	@Test
	public void testEchoCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "4,AST_ECHO,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Hello World!\",0,1,,,\n";
		nodeStr += "6,AST_ECHO,,3,,1,1,,,\n";
		nodeStr += "7,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "8,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "9,string,,3,\"PHP_EOL\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PHPEchoStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((PHPEchoStatement)node).getEchoExpression());
		assertEquals( "Hello World!", ((PHPEchoStatement)node).getEchoExpression().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(PHPEchoStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PHPEchoStatement)node2).getEchoExpression());
		assertEquals( "PHP_EOL", ((Constant)((PHPEchoStatement)node2).getEchoExpression()).getIdentifier().getNameChild().getEscapedCodeStr());
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
	 * AST_DIM nodes are used to denote array indexing expressions.
	 * 
	 * Any AST_DIM node has exactly two children:
	 * 1) an expression, whose evaluation returns the array to be accessed
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 2) an expression or NULL, representing the key by which to access the array
	 *    (e.g., could be "string", "integer", AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 
	 * This test checks a few array indexing expressions' children in the following PHP code:
	 * 
	 * $foo[42];
	 * bar()['key'];
	 * $buz[qux()];
	 * SOMECONSTANT[];
	 */
	@Test
	public void testArrayIndexingCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_DIM,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,integer,,3,42,1,1,,,\n";
		nodeStr += "7,AST_DIM,,4,,1,1,,,\n";
		nodeStr += "8,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "11,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "12,string,,4,\"key\",1,1,,,\n";
		nodeStr += "13,AST_DIM,,5,,2,1,,,\n";
		nodeStr += "14,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "16,AST_CALL,,5,,1,1,,,\n";
		nodeStr += "17,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "18,string,,5,\"qux\",0,1,,,\n";
		nodeStr += "19,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "20,AST_DIM,,6,,3,1,,,\n";
		nodeStr += "21,AST_CONST,,6,,0,1,,,\n";
		nodeStr += "22,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "23,string,,6,\"SOMECONSTANT\",0,1,,,\n";
		nodeStr += "24,NULL,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,19,PARENT_OF\n";
		edgeStr += "13,16,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "20,24,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)13);
		ASTNode node4 = ast.getNodeById((long)20);
		
		assertThat( node, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((ArrayIndexing)node).getArrayExpression());
		assertEquals( ast.getNodeById((long)6), ((ArrayIndexing)node).getIndexExpression());

		assertThat( node2, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((ArrayIndexing)node2).getArrayExpression());
		assertEquals( ast.getNodeById((long)12), ((ArrayIndexing)node2).getIndexExpression());
		
		assertThat( node3, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((ArrayIndexing)node3).getArrayExpression());
		assertEquals( ast.getNodeById((long)16), ((ArrayIndexing)node3).getIndexExpression());
		
		assertThat( node4, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)21), ((ArrayIndexing)node4).getArrayExpression());
		// TODO ((ArrayIndexing)node4).getIndexExpression() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PHPArrayElement accepts arbitrary ASTNode's for indices,
		// when we actually only want to accept Expression's. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((ArrayIndexing)node4).getIndexExpression().getProperty("type"));
	}
	
	/**
	 * AST_PROP nodes are used to denote property access expressions.
	 * 
	 * Any AST_PROP node has exactly two children:
	 * 1) an expression, whose evaluation returns the object to be accessed
	 *    (e.g., could be AST_VAR, AST_CALL, etc...)
	 * 2) a string, representing the property name
	 * 
	 * This test checks a few property access expressions' children in the following PHP code:
	 * 
	 * $foo->bar;
	 * buz()->qux;
	 */
	@Test
	public void testPropertyCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_PROP,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,string,,3,\"bar\",1,1,,,\n";
		nodeStr += "7,AST_PROP,,4,,1,1,,,\n";
		nodeStr += "8,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "11,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "12,string,,4,\"qux\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(PropertyExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PropertyExpression)node).getObjectExpression());
		assertEquals( ast.getNodeById((long)6), ((PropertyExpression)node).getPropertyName());

		assertThat( node2, instanceOf(PropertyExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PropertyExpression)node2).getObjectExpression());
		assertEquals( ast.getNodeById((long)12), ((PropertyExpression)node2).getPropertyName());
	}
	
	/**
	 * AST_STATIC_PROP nodes are used to denote static property access expressions.
	 * 
	 * Any AST_STATIC_PROP node has exactly two children:
	 * 1) an expression, whose evaluation returns the class to be accessed
	 *    (e.g., could be AST_NAME, AST_VAR, AST_CALL, etc...)
	 * 2) a string, representing the property name
	 * 
	 * This test checks a few static property access expressions' children in the following PHP code:
	 * 
	 * Foo::$bar;
	 * $foo::$bar;
	 * buz()::$qux;
	 */
	@Test
	public void testStaticPropertyCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_STATIC_PROP,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Foo\",0,1,,,\n";
		nodeStr += "6,string,,3,\"bar\",1,1,,,\n";
		nodeStr += "7,AST_STATIC_PROP,,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "10,string,,4,\"bar\",1,1,,,\n";
		nodeStr += "11,AST_STATIC_PROP,,5,,2,1,,,\n";
		nodeStr += "12,AST_CALL,,5,,0,1,,,\n";
		nodeStr += "13,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "14,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "15,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "16,string,,5,\"qux\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(StaticPropertyExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((StaticPropertyExpression)node).getClassExpression());
		assertEquals( ast.getNodeById((long)6), ((StaticPropertyExpression)node).getPropertyName());

		assertThat( node2, instanceOf(StaticPropertyExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((StaticPropertyExpression)node2).getClassExpression());
		assertEquals( ast.getNodeById((long)10), ((StaticPropertyExpression)node2).getPropertyName());
		
		assertThat( node3, instanceOf(StaticPropertyExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((StaticPropertyExpression)node3).getClassExpression());
		assertEquals( ast.getNodeById((long)16), ((StaticPropertyExpression)node3).getPropertyName());
	}
	
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
	 * AST_CLASS_CONST nodes are used to denote class constant access expressions.
	 * 
	 * Any AST_CLASS_CONST node has exactly two children:
	 * 1) an expression, whose evaluation returns the class to be accessed
	 *    (e.g., could be AST_NAME, AST_VAR, AST_CALL, etc...)
	 * 2) a string, representing the constant name
	 * 
	 * This test checks a few class constant expressions' children in the following PHP code:
	 * 
	 * Foo::BAR;
	 * $foo::BAR;
	 * buz()::QUX;
	 */
	@Test
	public void testClassConstantCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS_CONST,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Foo\",0,1,,,\n";
		nodeStr += "6,string,,3,\"BAR\",1,1,,,\n";
		nodeStr += "7,AST_CLASS_CONST,,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "10,string,,4,\"BAR\",1,1,,,\n";
		nodeStr += "11,AST_CLASS_CONST,,5,,2,1,,,\n";
		nodeStr += "12,AST_CALL,,5,,0,1,,,\n";
		nodeStr += "13,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "14,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "15,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "16,string,,5,\"QUX\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(ClassConstantExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((ClassConstantExpression)node).getClassExpression());
		assertEquals( ast.getNodeById((long)6), ((ClassConstantExpression)node).getConstantName());

		assertThat( node2, instanceOf(ClassConstantExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((ClassConstantExpression)node2).getClassExpression());
		assertEquals( ast.getNodeById((long)10), ((ClassConstantExpression)node2).getConstantName());
		
		assertThat( node3, instanceOf(ClassConstantExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((ClassConstantExpression)node3).getClassExpression());
		assertEquals( ast.getNodeById((long)16), ((ClassConstantExpression)node3).getConstantName());
	}
	
	/**
	 * AST_ASSIGN nodes are used to denote assignment expressions.
	 * 
	 * Any AST_ASSIGN node has exactly two children:
	 * 1) an expression, representing the variable being assigned to
	 *    (e.g., could be AST_VAR, AST_DIM, AST_PROP, AST_STATIC_PROP, AST_LIST, etc...)
	 * 2) an expression, representing the expression to be evaluated and assigned to a variable
	 *    (e.g., could be int, string, AST_CONST, AST_CALL, AST_ARRAY, etc...)
	 * 
	 * This test checks a few assignment expressions' children in the following PHP code:
	 * 
	 * $foo = 42;
	 * $bar[3] = "bonjour";
	 * $buz->qux = SOMECONST;
	 * Buz::$qux = somecall();
	 * list($a) = [3];
	 */
	@Test
	public void testAssignCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ASSIGN,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,integer,,3,42,1,1,,,\n";
		nodeStr += "7,AST_ASSIGN,,4,,1,1,,,\n";
		nodeStr += "8,AST_DIM,,4,,0,1,,,\n";
		nodeStr += "9,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "11,integer,,4,3,1,1,,,\n";
		nodeStr += "12,string,,4,\"bonjour\",1,1,,,\n";
		nodeStr += "13,AST_ASSIGN,,5,,2,1,,,\n";
		nodeStr += "14,AST_PROP,,5,,0,1,,,\n";
		nodeStr += "15,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "16,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "17,string,,5,\"qux\",1,1,,,\n";
		nodeStr += "18,AST_CONST,,5,,1,1,,,\n";
		nodeStr += "19,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "20,string,,5,\"SOMECONST\",0,1,,,\n";
		nodeStr += "21,AST_ASSIGN,,6,,3,1,,,\n";
		nodeStr += "22,AST_STATIC_PROP,,6,,0,1,,,\n";
		nodeStr += "23,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "24,string,,6,\"Buz\",0,1,,,\n";
		nodeStr += "25,string,,6,\"qux\",1,1,,,\n";
		nodeStr += "26,AST_CALL,,6,,1,1,,,\n";
		nodeStr += "27,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "28,string,,6,\"somecall\",0,1,,,\n";
		nodeStr += "29,AST_ARG_LIST,,6,,1,1,,,\n";
		nodeStr += "30,AST_ASSIGN,,7,,4,1,,,\n";
		nodeStr += "31,AST_LIST,,7,,0,1,,,\n";
		nodeStr += "32,AST_VAR,,7,,0,1,,,\n";
		nodeStr += "33,string,,7,\"a\",0,1,,,\n";
		nodeStr += "34,AST_ARRAY,,7,,1,1,,,\n";
		nodeStr += "35,AST_ARRAY_ELEM,,7,,0,1,,,\n";
		nodeStr += "36,integer,,7,3,0,1,,,\n";
		nodeStr += "37,NULL,,7,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,17,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "13,18,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,25,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "27,28,PARENT_OF\n";
		edgeStr += "26,27,PARENT_OF\n";
		edgeStr += "26,29,PARENT_OF\n";
		edgeStr += "21,26,PARENT_OF\n";
		edgeStr += "32,33,PARENT_OF\n";
		edgeStr += "31,32,PARENT_OF\n";
		edgeStr += "30,31,PARENT_OF\n";
		edgeStr += "35,36,PARENT_OF\n";
		edgeStr += "35,37,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "30,34,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)13);
		ASTNode node4 = ast.getNodeById((long)21);
		ASTNode node5 = ast.getNodeById((long)30);
		
		assertThat( node, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((AssignmentExpression)node).getVariable());
		assertEquals( ast.getNodeById((long)6), ((AssignmentExpression)node).getAssignExpression());

		assertThat( node2, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((AssignmentExpression)node2).getVariable());
		assertEquals( ast.getNodeById((long)12), ((AssignmentExpression)node2).getAssignExpression());
		
		assertThat( node3, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((AssignmentExpression)node3).getVariable());
		assertEquals( ast.getNodeById((long)18), ((AssignmentExpression)node3).getAssignExpression());
		
		assertThat( node4, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)22), ((AssignmentExpression)node4).getVariable());
		assertEquals( ast.getNodeById((long)26), ((AssignmentExpression)node4).getAssignExpression());
		
		assertThat( node5, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node5.getChildCount());
		assertEquals( ast.getNodeById((long)31), ((AssignmentExpression)node5).getVariable());
		assertEquals( ast.getNodeById((long)34), ((AssignmentExpression)node5).getAssignExpression());
	}
	
	/**
	 * AST_ASSIGN_REF nodes are used to denote assignment by reference expressions.
	 * See
	 * http://php.net/manual/en/language.operators.assignment.php#language.operators.assignment.reference
	 * 
	 * Any AST_ASSIGN_REF node has exactly two children:
	 * 1) an expression, representing the variable being assigned to
	 *    (e.g., could be AST_VAR, AST_DIM, AST_PROP, AST_STATIC_PROP, etc...)
	 * 2) an expression, representing the expression to be evaluated to a reference and assigned to a variable
	 *    (e.g., AST_VAR, AST_DIM, AST_CALL, AST_METHOD_CALL, AST_STATIC_CALL, etc...)
	 * 
	 * This test checks a few assignment by reference expressions' children in the following PHP code:
	 * 
	 * $foo =& $someref;
	 * $bar[3] =& $someref[4];
	 * $buz->qux =& $buz->somecall();
	 * Buz::$qux =& Buz::somestaticcall();
	 */
	@Test
	public void testAssignByRefCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ASSIGN_REF,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "7,string,,3,\"someref\",0,1,,,\n";
		nodeStr += "8,AST_ASSIGN_REF,,4,,1,1,,,\n";
		nodeStr += "9,AST_DIM,,4,,0,1,,,\n";
		nodeStr += "10,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "11,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "12,integer,,4,3,1,1,,,\n";
		nodeStr += "13,AST_DIM,,4,,1,1,,,\n";
		nodeStr += "14,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "15,string,,4,\"someref\",0,1,,,\n";
		nodeStr += "16,integer,,4,4,1,1,,,\n";
		nodeStr += "17,AST_ASSIGN_REF,,5,,2,1,,,\n";
		nodeStr += "18,AST_PROP,,5,,0,1,,,\n";
		nodeStr += "19,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "20,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "21,string,,5,\"qux\",1,1,,,\n";
		nodeStr += "22,AST_METHOD_CALL,,5,,1,1,,,\n";
		nodeStr += "23,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "24,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "25,string,,5,\"somecall\",1,1,,,\n";
		nodeStr += "26,AST_ARG_LIST,,5,,2,1,,,\n";
		nodeStr += "27,AST_ASSIGN_REF,,6,,3,1,,,\n";
		nodeStr += "28,AST_STATIC_PROP,,6,,0,1,,,\n";
		nodeStr += "29,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "30,string,,6,\"Buz\",0,1,,,\n";
		nodeStr += "31,string,,6,\"qux\",1,1,,,\n";
		nodeStr += "32,AST_STATIC_CALL,,6,,1,1,,,\n";
		nodeStr += "33,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "34,string,,6,\"Buz\",0,1,,,\n";
		nodeStr += "35,string,,6,\"somestaticcall\",1,1,,,\n";
		nodeStr += "36,AST_ARG_LIST,,6,,2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "13,16,PARENT_OF\n";
		edgeStr += "8,13,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,21,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,25,PARENT_OF\n";
		edgeStr += "22,26,PARENT_OF\n";
		edgeStr += "17,22,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "28,31,PARENT_OF\n";
		edgeStr += "27,28,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "32,33,PARENT_OF\n";
		edgeStr += "32,35,PARENT_OF\n";
		edgeStr += "32,36,PARENT_OF\n";
		edgeStr += "27,32,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)8);
		ASTNode node3 = ast.getNodeById((long)17);
		ASTNode node4 = ast.getNodeById((long)27);
		
		assertThat( node, instanceOf(PHPAssignmentByRefExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPAssignmentByRefExpression)node).getVariable());
		assertEquals( ast.getNodeById((long)6), ((PHPAssignmentByRefExpression)node).getAssignExpression());

		assertThat( node2, instanceOf(PHPAssignmentByRefExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((PHPAssignmentByRefExpression)node2).getVariable());
		assertEquals( ast.getNodeById((long)13), ((PHPAssignmentByRefExpression)node2).getAssignExpression());
		
		assertThat( node3, instanceOf(PHPAssignmentByRefExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)18), ((PHPAssignmentByRefExpression)node3).getVariable());
		assertEquals( ast.getNodeById((long)22), ((PHPAssignmentByRefExpression)node3).getAssignExpression());
		
		assertThat( node4, instanceOf(PHPAssignmentByRefExpression.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)28), ((PHPAssignmentByRefExpression)node4).getVariable());
		assertEquals( ast.getNodeById((long)32), ((PHPAssignmentByRefExpression)node4).getAssignExpression());
	}
	
	/**
	 * AST_ASSIGN_OP nodes are used to denote assignment expressions with operations.
	 * 
	 * Any AST_ASSIGN_OP node has exactly two children:
	 * 1) an expression, representing the variable being assigned to
	 *    (e.g., could be AST_VAR, AST_DIM, AST_PROP, AST_STATIC_PROP, etc...)
	 * 2) an expression, representing the expression to be evaluated, combined with the
	 *    variable being assigned to using a given operator, and assigned to that variable
	 *    (e.g., could be int, string, AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 
	 * This test checks a few assignment with operation expressions' children in the following PHP code:
	 * 
	 * $foo += 42;
	 * $bar .= "bonjour";
	 * $buz ^= $onetimepad;
	 */
	@Test
	public void testAssignWithOpCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ASSIGN_OP,ASSIGN_ADD,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,integer,,3,42,1,1,,,\n";
		nodeStr += "7,AST_ASSIGN_OP,ASSIGN_CONCAT,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "10,string,,4,\"bonjour\",1,1,,,\n";
		nodeStr += "11,AST_ASSIGN_OP,ASSIGN_BITWISE_XOR,5,,2,1,,,\n";
		nodeStr += "12,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "13,string,,5,\"buz\",0,1,,,\n";
		nodeStr += "14,AST_VAR,,5,,1,1,,,\n";
		nodeStr += "15,string,,5,\"onetimepad\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(AssignmentWithOpExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((AssignmentWithOpExpression)node).getVariable());
		assertEquals( ast.getNodeById((long)6), ((AssignmentWithOpExpression)node).getAssignExpression());

		assertThat( node2, instanceOf(AssignmentWithOpExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((AssignmentWithOpExpression)node2).getVariable());
		assertEquals( ast.getNodeById((long)10), ((AssignmentWithOpExpression)node2).getAssignExpression());
		
		assertThat( node3, instanceOf(AssignmentWithOpExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((AssignmentWithOpExpression)node3).getVariable());
		assertEquals( ast.getNodeById((long)14), ((AssignmentWithOpExpression)node3).getAssignExpression());
	}
	
	/**
	 * AST_BINARY_OP nodes are used to denote binary operation expressions.
	 * 
	 * Any AST_BINARY_OP node has exactly two children:
	 * 1) an expression on the left-hand side
	 * 2) an expression on the right-hand side
	 * 
	 * This test checks a plethora of binary operation expressions' children in the following PHP code:
	 * 
	 * // bit operators
	 * $or1 | $or2;
	 * $and1 & $and2;
	 * $msg ^ $otp;
	 * $x << $y;
	 * $x >> $y;
	 * // string operators
	 * $str1 . $str2;
	 * // arithmetic operators
	 * $x + $y;
	 * $x - $y;
	 * $x * $y;
	 * $x / $y;
	 * $x % $y;
	 * $x ** $y;
	 * // boolean operators
	 * $x xor $y;
	 * // comparison operators
	 * $x === $y;
	 * $x !== $y;
	 * $x == $y;
	 * $x != $y;
	 * $x < $y;
	 * $x <= $y;
	 * $x <=> $y;
	 */
	@Test
	public void testBinaryOperationCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_BINARY_OP,BINARY_BITWISE_OR,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"or1\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "7,string,,3,\"or2\",0,1,,,\n";
		nodeStr += "8,AST_BINARY_OP,BINARY_BITWISE_AND,4,,1,1,,,\n";
		nodeStr += "9,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"and1\",0,1,,,\n";
		nodeStr += "11,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "12,string,,4,\"and2\",0,1,,,\n";
		nodeStr += "13,AST_BINARY_OP,BINARY_BITWISE_XOR,5,,2,1,,,\n";
		nodeStr += "14,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"msg\",0,1,,,\n";
		nodeStr += "16,AST_VAR,,5,,1,1,,,\n";
		nodeStr += "17,string,,5,\"otp\",0,1,,,\n";
		nodeStr += "18,AST_BINARY_OP,BINARY_CONCAT,7,,3,1,,,\n";
		nodeStr += "19,AST_VAR,,7,,0,1,,,\n";
		nodeStr += "20,string,,7,\"str1\",0,1,,,\n";
		nodeStr += "21,AST_VAR,,7,,1,1,,,\n";
		nodeStr += "22,string,,7,\"str2\",0,1,,,\n";
		nodeStr += "23,AST_BINARY_OP,BINARY_ADD,9,,4,1,,,\n";
		nodeStr += "24,AST_VAR,,9,,0,1,,,\n";
		nodeStr += "25,string,,9,\"x\",0,1,,,\n";
		nodeStr += "26,AST_VAR,,9,,1,1,,,\n";
		nodeStr += "27,string,,9,\"y\",0,1,,,\n";
		nodeStr += "28,AST_BINARY_OP,BINARY_SUB,10,,5,1,,,\n";
		nodeStr += "29,AST_VAR,,10,,0,1,,,\n";
		nodeStr += "30,string,,10,\"x\",0,1,,,\n";
		nodeStr += "31,AST_VAR,,10,,1,1,,,\n";
		nodeStr += "32,string,,10,\"y\",0,1,,,\n";
		nodeStr += "33,AST_BINARY_OP,BINARY_MUL,11,,6,1,,,\n";
		nodeStr += "34,AST_VAR,,11,,0,1,,,\n";
		nodeStr += "35,string,,11,\"x\",0,1,,,\n";
		nodeStr += "36,AST_VAR,,11,,1,1,,,\n";
		nodeStr += "37,string,,11,\"y\",0,1,,,\n";
		nodeStr += "38,AST_BINARY_OP,BINARY_DIV,12,,7,1,,,\n";
		nodeStr += "39,AST_VAR,,12,,0,1,,,\n";
		nodeStr += "40,string,,12,\"x\",0,1,,,\n";
		nodeStr += "41,AST_VAR,,12,,1,1,,,\n";
		nodeStr += "42,string,,12,\"y\",0,1,,,\n";
		nodeStr += "43,AST_BINARY_OP,BINARY_MOD,13,,8,1,,,\n";
		nodeStr += "44,AST_VAR,,13,,0,1,,,\n";
		nodeStr += "45,string,,13,\"x\",0,1,,,\n";
		nodeStr += "46,AST_VAR,,13,,1,1,,,\n";
		nodeStr += "47,string,,13,\"y\",0,1,,,\n";
		nodeStr += "48,AST_BINARY_OP,BINARY_POW,14,,9,1,,,\n";
		nodeStr += "49,AST_VAR,,14,,0,1,,,\n";
		nodeStr += "50,string,,14,\"x\",0,1,,,\n";
		nodeStr += "51,AST_VAR,,14,,1,1,,,\n";
		nodeStr += "52,string,,14,\"y\",0,1,,,\n";
		nodeStr += "53,AST_BINARY_OP,BINARY_SHIFT_LEFT,15,,10,1,,,\n";
		nodeStr += "54,AST_VAR,,15,,0,1,,,\n";
		nodeStr += "55,string,,15,\"x\",0,1,,,\n";
		nodeStr += "56,AST_VAR,,15,,1,1,,,\n";
		nodeStr += "57,string,,15,\"y\",0,1,,,\n";
		nodeStr += "58,AST_BINARY_OP,BINARY_SHIFT_RIGHT,16,,11,1,,,\n";
		nodeStr += "59,AST_VAR,,16,,0,1,,,\n";
		nodeStr += "60,string,,16,\"x\",0,1,,,\n";
		nodeStr += "61,AST_VAR,,16,,1,1,,,\n";
		nodeStr += "62,string,,16,\"y\",0,1,,,\n";
		nodeStr += "63,AST_BINARY_OP,BINARY_BOOL_XOR,18,,12,1,,,\n";
		nodeStr += "64,AST_VAR,,18,,0,1,,,\n";
		nodeStr += "65,string,,18,\"x\",0,1,,,\n";
		nodeStr += "66,AST_VAR,,18,,1,1,,,\n";
		nodeStr += "67,string,,18,\"y\",0,1,,,\n";
		nodeStr += "68,AST_BINARY_OP,BINARY_IS_IDENTICAL,20,,13,1,,,\n";
		nodeStr += "69,AST_VAR,,20,,0,1,,,\n";
		nodeStr += "70,string,,20,\"x\",0,1,,,\n";
		nodeStr += "71,AST_VAR,,20,,1,1,,,\n";
		nodeStr += "72,string,,20,\"y\",0,1,,,\n";
		nodeStr += "73,AST_BINARY_OP,BINARY_IS_NOT_IDENTICAL,21,,14,1,,,\n";
		nodeStr += "74,AST_VAR,,21,,0,1,,,\n";
		nodeStr += "75,string,,21,\"x\",0,1,,,\n";
		nodeStr += "76,AST_VAR,,21,,1,1,,,\n";
		nodeStr += "77,string,,21,\"y\",0,1,,,\n";
		nodeStr += "78,AST_BINARY_OP,BINARY_IS_EQUAL,22,,15,1,,,\n";
		nodeStr += "79,AST_VAR,,22,,0,1,,,\n";
		nodeStr += "80,string,,22,\"x\",0,1,,,\n";
		nodeStr += "81,AST_VAR,,22,,1,1,,,\n";
		nodeStr += "82,string,,22,\"y\",0,1,,,\n";
		nodeStr += "83,AST_BINARY_OP,BINARY_IS_NOT_EQUAL,23,,16,1,,,\n";
		nodeStr += "84,AST_VAR,,23,,0,1,,,\n";
		nodeStr += "85,string,,23,\"x\",0,1,,,\n";
		nodeStr += "86,AST_VAR,,23,,1,1,,,\n";
		nodeStr += "87,string,,23,\"y\",0,1,,,\n";
		nodeStr += "88,AST_BINARY_OP,BINARY_IS_SMALLER,24,,17,1,,,\n";
		nodeStr += "89,AST_VAR,,24,,0,1,,,\n";
		nodeStr += "90,string,,24,\"x\",0,1,,,\n";
		nodeStr += "91,AST_VAR,,24,,1,1,,,\n";
		nodeStr += "92,string,,24,\"y\",0,1,,,\n";
		nodeStr += "93,AST_BINARY_OP,BINARY_IS_SMALLER_OR_EQUAL,25,,18,1,,,\n";
		nodeStr += "94,AST_VAR,,25,,0,1,,,\n";
		nodeStr += "95,string,,25,\"x\",0,1,,,\n";
		nodeStr += "96,AST_VAR,,25,,1,1,,,\n";
		nodeStr += "97,string,,25,\"y\",0,1,,,\n";
		nodeStr += "98,AST_BINARY_OP,BINARY_SPACESHIP,26,,19,1,,,\n";
		nodeStr += "99,AST_VAR,,26,,0,1,,,\n";
		nodeStr += "100,string,,26,\"x\",0,1,,,\n";
		nodeStr += "101,AST_VAR,,26,,1,1,,,\n";
		nodeStr += "102,string,,26,\"y\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "2,8,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "13,16,PARENT_OF\n";
		edgeStr += "2,13,PARENT_OF\n";
		edgeStr += "19,20,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "18,21,PARENT_OF\n";
		edgeStr += "2,18,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "26,27,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "2,23,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "31,32,PARENT_OF\n";
		edgeStr += "28,31,PARENT_OF\n";
		edgeStr += "2,28,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "36,37,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "2,33,PARENT_OF\n";
		edgeStr += "39,40,PARENT_OF\n";
		edgeStr += "38,39,PARENT_OF\n";
		edgeStr += "41,42,PARENT_OF\n";
		edgeStr += "38,41,PARENT_OF\n";
		edgeStr += "2,38,PARENT_OF\n";
		edgeStr += "44,45,PARENT_OF\n";
		edgeStr += "43,44,PARENT_OF\n";
		edgeStr += "46,47,PARENT_OF\n";
		edgeStr += "43,46,PARENT_OF\n";
		edgeStr += "2,43,PARENT_OF\n";
		edgeStr += "49,50,PARENT_OF\n";
		edgeStr += "48,49,PARENT_OF\n";
		edgeStr += "51,52,PARENT_OF\n";
		edgeStr += "48,51,PARENT_OF\n";
		edgeStr += "2,48,PARENT_OF\n";
		edgeStr += "54,55,PARENT_OF\n";
		edgeStr += "53,54,PARENT_OF\n";
		edgeStr += "56,57,PARENT_OF\n";
		edgeStr += "53,56,PARENT_OF\n";
		edgeStr += "2,53,PARENT_OF\n";
		edgeStr += "59,60,PARENT_OF\n";
		edgeStr += "58,59,PARENT_OF\n";
		edgeStr += "61,62,PARENT_OF\n";
		edgeStr += "58,61,PARENT_OF\n";
		edgeStr += "2,58,PARENT_OF\n";
		edgeStr += "64,65,PARENT_OF\n";
		edgeStr += "63,64,PARENT_OF\n";
		edgeStr += "66,67,PARENT_OF\n";
		edgeStr += "63,66,PARENT_OF\n";
		edgeStr += "2,63,PARENT_OF\n";
		edgeStr += "69,70,PARENT_OF\n";
		edgeStr += "68,69,PARENT_OF\n";
		edgeStr += "71,72,PARENT_OF\n";
		edgeStr += "68,71,PARENT_OF\n";
		edgeStr += "2,68,PARENT_OF\n";
		edgeStr += "74,75,PARENT_OF\n";
		edgeStr += "73,74,PARENT_OF\n";
		edgeStr += "76,77,PARENT_OF\n";
		edgeStr += "73,76,PARENT_OF\n";
		edgeStr += "2,73,PARENT_OF\n";
		edgeStr += "79,80,PARENT_OF\n";
		edgeStr += "78,79,PARENT_OF\n";
		edgeStr += "81,82,PARENT_OF\n";
		edgeStr += "78,81,PARENT_OF\n";
		edgeStr += "2,78,PARENT_OF\n";
		edgeStr += "84,85,PARENT_OF\n";
		edgeStr += "83,84,PARENT_OF\n";
		edgeStr += "86,87,PARENT_OF\n";
		edgeStr += "83,86,PARENT_OF\n";
		edgeStr += "2,83,PARENT_OF\n";
		edgeStr += "89,90,PARENT_OF\n";
		edgeStr += "88,89,PARENT_OF\n";
		edgeStr += "91,92,PARENT_OF\n";
		edgeStr += "88,91,PARENT_OF\n";
		edgeStr += "2,88,PARENT_OF\n";
		edgeStr += "94,95,PARENT_OF\n";
		edgeStr += "93,94,PARENT_OF\n";
		edgeStr += "96,97,PARENT_OF\n";
		edgeStr += "93,96,PARENT_OF\n";
		edgeStr += "2,93,PARENT_OF\n";
		edgeStr += "99,100,PARENT_OF\n";
		edgeStr += "98,99,PARENT_OF\n";
		edgeStr += "101,102,PARENT_OF\n";
		edgeStr += "98,101,PARENT_OF\n";
		edgeStr += "2,98,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)8);
		ASTNode node3 = ast.getNodeById((long)13);
		ASTNode node4 = ast.getNodeById((long)18);
		ASTNode node5 = ast.getNodeById((long)23);
		ASTNode node6 = ast.getNodeById((long)28);
		ASTNode node7 = ast.getNodeById((long)33);
		ASTNode node8 = ast.getNodeById((long)38);
		ASTNode node9 = ast.getNodeById((long)43);
		ASTNode node10 = ast.getNodeById((long)48);
		ASTNode node11 = ast.getNodeById((long)53);
		ASTNode node12 = ast.getNodeById((long)58);
		ASTNode node13 = ast.getNodeById((long)63);
		ASTNode node14 = ast.getNodeById((long)68);
		ASTNode node15 = ast.getNodeById((long)73);
		ASTNode node16 = ast.getNodeById((long)78);
		ASTNode node17 = ast.getNodeById((long)83);
		ASTNode node18 = ast.getNodeById((long)88);
		ASTNode node19 = ast.getNodeById((long)93);
		ASTNode node20 = ast.getNodeById((long)98);
		
		assertThat( node, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((BinaryOperationExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)6), ((BinaryOperationExpression)node).getRight());
		
		assertThat( node2, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((BinaryOperationExpression)node2).getLeft());
		assertEquals( ast.getNodeById((long)11), ((BinaryOperationExpression)node2).getRight());
		
		assertThat( node3, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((BinaryOperationExpression)node3).getLeft());
		assertEquals( ast.getNodeById((long)16), ((BinaryOperationExpression)node3).getRight());
		
		assertThat( node4, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((BinaryOperationExpression)node4).getLeft());
		assertEquals( ast.getNodeById((long)21), ((BinaryOperationExpression)node4).getRight());
		
		assertThat( node5, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node5.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((BinaryOperationExpression)node5).getLeft());
		assertEquals( ast.getNodeById((long)26), ((BinaryOperationExpression)node5).getRight());
		
		assertThat( node6, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node6.getChildCount());
		assertEquals( ast.getNodeById((long)29), ((BinaryOperationExpression)node6).getLeft());
		assertEquals( ast.getNodeById((long)31), ((BinaryOperationExpression)node6).getRight());
		
		assertThat( node7, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node7.getChildCount());
		assertEquals( ast.getNodeById((long)34), ((BinaryOperationExpression)node7).getLeft());
		assertEquals( ast.getNodeById((long)36), ((BinaryOperationExpression)node7).getRight());
		
		assertThat( node8, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node8.getChildCount());
		assertEquals( ast.getNodeById((long)39), ((BinaryOperationExpression)node8).getLeft());
		assertEquals( ast.getNodeById((long)41), ((BinaryOperationExpression)node8).getRight());
		
		assertThat( node9, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node9.getChildCount());
		assertEquals( ast.getNodeById((long)44), ((BinaryOperationExpression)node9).getLeft());
		assertEquals( ast.getNodeById((long)46), ((BinaryOperationExpression)node9).getRight());
		
		assertThat( node10, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node10.getChildCount());
		assertEquals( ast.getNodeById((long)49), ((BinaryOperationExpression)node10).getLeft());
		assertEquals( ast.getNodeById((long)51), ((BinaryOperationExpression)node10).getRight());
		
		assertThat( node11, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node11.getChildCount());
		assertEquals( ast.getNodeById((long)54), ((BinaryOperationExpression)node11).getLeft());
		assertEquals( ast.getNodeById((long)56), ((BinaryOperationExpression)node11).getRight());
		
		assertThat( node12, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node12.getChildCount());
		assertEquals( ast.getNodeById((long)59), ((BinaryOperationExpression)node12).getLeft());
		assertEquals( ast.getNodeById((long)61), ((BinaryOperationExpression)node12).getRight());
		
		assertThat( node13, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node13.getChildCount());
		assertEquals( ast.getNodeById((long)64), ((BinaryOperationExpression)node13).getLeft());
		assertEquals( ast.getNodeById((long)66), ((BinaryOperationExpression)node13).getRight());
		
		assertThat( node14, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node14.getChildCount());
		assertEquals( ast.getNodeById((long)69), ((BinaryOperationExpression)node14).getLeft());
		assertEquals( ast.getNodeById((long)71), ((BinaryOperationExpression)node14).getRight());
		
		assertThat( node15, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node15.getChildCount());
		assertEquals( ast.getNodeById((long)74), ((BinaryOperationExpression)node15).getLeft());
		assertEquals( ast.getNodeById((long)76), ((BinaryOperationExpression)node15).getRight());
		
		assertThat( node16, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node16.getChildCount());
		assertEquals( ast.getNodeById((long)79), ((BinaryOperationExpression)node16).getLeft());
		assertEquals( ast.getNodeById((long)81), ((BinaryOperationExpression)node16).getRight());
		
		assertThat( node17, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node17.getChildCount());
		assertEquals( ast.getNodeById((long)84), ((BinaryOperationExpression)node17).getLeft());
		assertEquals( ast.getNodeById((long)86), ((BinaryOperationExpression)node17).getRight());
		
		assertThat( node18, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node18.getChildCount());
		assertEquals( ast.getNodeById((long)89), ((BinaryOperationExpression)node18).getLeft());
		assertEquals( ast.getNodeById((long)91), ((BinaryOperationExpression)node18).getRight());
		
		assertThat( node19, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node19.getChildCount());
		assertEquals( ast.getNodeById((long)94), ((BinaryOperationExpression)node19).getLeft());
		assertEquals( ast.getNodeById((long)96), ((BinaryOperationExpression)node19).getRight());
		
		assertThat( node20, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node20.getChildCount());
		assertEquals( ast.getNodeById((long)99), ((BinaryOperationExpression)node20).getLeft());
		assertEquals( ast.getNodeById((long)101), ((BinaryOperationExpression)node20).getRight());
	}
	
	/**
	 * AST_GREATER nodes are used to denote binary operation "greater than" expressions.
	 * 
	 * TODO once version 20 of Niki's php-ast extension is stable, update phpjoern parser and make
	 * this a normal AST_BINARY_OP node.
	 * 
	 * Any AST_GREATER node has exactly two children:
	 * 1) an expression on the left-hand side
	 * 2) an expression on the right-hand side
	 * 
	 * This test checks a "greater than" expression's children in the following PHP code:
	 * 
	 * // comparison operators
	 * $x > $y;
	 */
	@Test
	public void testGreaterCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_GREATER,,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"x\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "7,string,,4,\"y\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(GreaterExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((GreaterExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)6), ((GreaterExpression)node).getRight());
	}
	
	/**
	 * AST_GREATER_EQUAL nodes are used to denote binary operation "greater or equal than" expressions.
	 * 
	 * TODO once version 20 of Niki's php-ast extension is stable, update phpjoern parser and make
	 * this a normal AST_BINARY_OP node.
	 * 
	 * Any AST_GREATER_EQUAL node has exactly two children:
	 * 1) an expression on the left-hand side
	 * 2) an expression on the right-hand side
	 * 
	 * This test checks a "greater or equal than" expression's children in the following PHP code:
	 * 
	 * // comparison operators
	 * $x >= $y;
	 */
	@Test
	public void testGreaterOrEqualCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_GREATER_EQUAL,,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"x\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "7,string,,4,\"y\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(GreaterOrEqualExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((GreaterOrEqualExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)6), ((GreaterOrEqualExpression)node).getRight());
	}
	
	/**
	 * AST_AND nodes are used to denote binary operation "boolean and" expressions.
	 * 
	 * TODO once version 20 of Niki's php-ast extension is stable, update phpjoern parser and make
	 * this a normal AST_BINARY_OP node.
	 * 
	 * Any AST_AND node has exactly two children:
	 * 1) an expression on the left-hand side
	 * 2) an expression on the right-hand side
	 * 
	 * This test checks a "boolean and" expression's children in the following PHP code:
	 * 
	 * // boolean operators
	 * $x && $y;
	 */
	@Test
	public void testAndCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_AND,,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"x\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "7,string,,4,\"y\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(AndExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((AndExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)6), ((AndExpression)node).getRight());
	}
	
	/**
	 * AST_OR nodes are used to denote binary operation "boolean or" expressions.
	 * 
	 * TODO once version 20 of Niki's php-ast extension is stable, update phpjoern parser and make
	 * this a normal AST_BINARY_OP node.
	 * 
	 * Any AST_OR node has exactly two children:
	 * 1) an expression on the left-hand side
	 * 2) an expression on the right-hand side
	 * 
	 * This test checks a "boolean or" expression's children in the following PHP code:
	 * 
	 * // boolean operators
	 * $x || $y;
	 */
	@Test
	public void testOrCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_OR,,4,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "5,string,,4,\"x\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "7,string,,4,\"y\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(OrExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((OrExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)6), ((OrExpression)node).getRight());
	}
	
	/**
	 * AST_ARRAY_ELEM nodes are used to denote the individual elements of an array expression.
	 * They are the children of an AST_ARRAY node; see description of AST_ARRAY.
	 * 
	 * Any AST_ARRAY_ELEM node has exactly two children:
	 * 1) an expression, representing the array element's value
	 *    (e.g., could be "string", "integer", AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 2) an expression or NULL, representing the array element's key
	 *    (e.g., could be "string", "integer", AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 
	 * This test checks a few array elements' children in the following PHP code:
	 * 
	 * array("key1" => 42,
	 *       2 => "foo",
	 *       aconst => $bar,
	 *       buz());
	 */
	@Test
	public void testArrayElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ARRAY,,3,,0,1,,,\n";
		nodeStr += "4,AST_ARRAY_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,integer,,3,42,0,1,,,\n";
		nodeStr += "6,string,,3,\"key1\",1,1,,,\n";
		nodeStr += "7,AST_ARRAY_ELEM,,4,,1,1,,,\n";
		nodeStr += "8,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "9,integer,,4,2,1,1,,,\n";
		nodeStr += "10,AST_ARRAY_ELEM,,5,,2,1,,,\n";
		nodeStr += "11,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "12,string,,5,\"bar\",0,1,,,\n";
		nodeStr += "13,AST_CONST,,5,,1,1,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"aconst\",0,1,,,\n";
		nodeStr += "16,AST_ARRAY_ELEM,,6,,3,1,,,\n";
		nodeStr += "17,AST_CALL,,6,,0,1,,,\n";
		nodeStr += "18,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "19,string,,6,\"buz\",0,1,,,\n";
		nodeStr += "20,AST_ARG_LIST,,6,,1,1,,,\n";
		nodeStr += "21,NULL,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";
		edgeStr += "3,10,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,20,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,21,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)10);
		ASTNode node4 = ast.getNodeById((long)16);
		
		assertThat( node, instanceOf(PHPArrayElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((PHPArrayElement)node).getValue());
		assertEquals( ast.getNodeById((long)6), ((PHPArrayElement)node).getKey());

		assertThat( node2, instanceOf(PHPArrayElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PHPArrayElement)node2).getValue());
		assertEquals( ast.getNodeById((long)9), ((PHPArrayElement)node2).getKey());
		
		assertThat( node3, instanceOf(PHPArrayElement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((PHPArrayElement)node3).getValue());
		assertEquals( ast.getNodeById((long)13), ((PHPArrayElement)node3).getKey());
		
		assertThat( node4, instanceOf(PHPArrayElement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)17), ((PHPArrayElement)node4).getValue());
		// TODO ((PHPArrayElement)node4).getKey() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PHPArrayElement accepts arbitrary ASTNode's for keys,
		// when we actually only want to accept Expression's. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((PHPArrayElement)node4).getKey().getProperty("type"));
	}
	
	/**
	 * AST_NEW nodes are used to denote 'new' expressions used to create a new instance
	 * of a class.
	 * 
	 * Any AST_NEW node has exactly 2 children:
	 * 1) an expression, whose evaluation holds the name of the class to be instantiated
	 *    (e.g., could be AST_NAME, AST_VAR, ...)
	 * 2) AST_ARG_LIST, representing the argument list
	 * 
	 * This test checks a few new expressions' children in the following PHP code:
	 * 
	 * new Foo($bar);
	 * new $buz();
	 */
	@Test
	public void testNewCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_NEW,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";
		nodeStr += "7,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "8,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "9,AST_NEW,,4,,1,1,,,\n";
		nodeStr += "10,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "11,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "12,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)9);
		
		assertThat( node, instanceOf(NewExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((NewExpression)node).getTargetClass());
		assertEquals( "Foo", ((Identifier)((NewExpression)node).getTargetClass()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((NewExpression)node).getArgumentList());
		assertEquals( 1, ((NewExpression)node).getArgumentList().size());
		
		assertThat( node2, instanceOf(NewExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((NewExpression)node2).getTargetClass());
		assertEquals( "buz", ((Variable)((NewExpression)node2).getTargetClass()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)12), ((NewExpression)node2).getArgumentList());
		assertEquals( 0, ((NewExpression)node2).getArgumentList().size());
	}
	
	/**
	 * AST_INSTANCEOF nodes are used to denote 'instanceof' expressions used to check whether
	 * a given expression evaluates to an instance of a given class.
	 * 
	 * Any AST_INSTANCEOF node has exactly 2 children:
	 * 1) an expression, whose evaluation holds the object to be checked
	 *    (e.g., could be AST_VAR, AST_CALL, ...)
	 * 2) AST_NAME, representing the name of the class that the object
	 *    may or may not be an instance of.
	 * 
	 * This test checks a few instanceof expressions' children in the following PHP code:
	 * 
	 * $foo instanceof Foo;
	 * buz() instanceof Bar\Buz;
	 */
	@Test
	public void testInstanceofCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_INSTANCEOF,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_NAME,NAME_NOT_FQ,3,,1,1,,,\n";
		nodeStr += "7,string,,3,\"Foo\",0,1,,,\n";
		nodeStr += "8,AST_INSTANCEOF,,4,,1,1,,,\n";
		nodeStr += "9,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "11,string,,4,\"buz\",0,1,,,\n";
		nodeStr += "12,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "13,AST_NAME,NAME_NOT_FQ,4,,1,1,,,\n";
		nodeStr += "14,string,,4,\"Bar\\Buz\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "8,13,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(InstanceofExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((InstanceofExpression)node).getInstanceExpression());
		assertEquals( "foo", ((Variable)((InstanceofExpression)node).getInstanceExpression()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((InstanceofExpression)node).getClassIdentifier());
		assertEquals( "Foo", ((InstanceofExpression)node).getClassIdentifier().getNameChild().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(InstanceofExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((InstanceofExpression)node2).getInstanceExpression());
		assertEquals( "buz", ((Identifier)((CallExpression)((InstanceofExpression)node2).getInstanceExpression()).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)13), ((InstanceofExpression)node2).getClassIdentifier());
		assertEquals( "Bar\\Buz", ((InstanceofExpression)node2).getClassIdentifier().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_YIELD nodes are used to denote yield expressions used in generators.
	 * See http://php.net/manual/en/language.generators.syntax.php
	 * 
	 * Any AST_YIELD node has exactly 2 children:
	 * 1) an expression or NULL, whose evaluation holds the value to be yielded
	 *    (if it is NULL, then the function interrupts execution, but returns nothing)
	 * 2) an expression or NULL, specifying an optional key to be yielded
	 * 
	 * This test checks a few yield expressions' children in the following PHP code:
	 * 
	 * function foo() {
	 *   yield 42;
	 *   yield $somekey => bar();
	 * }
	 */
	@Test
	public void testYieldCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,6,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_YIELD,,4,,0,3,,,\n";
		nodeStr += "8,integer,,4,42,0,3,,,\n";
		nodeStr += "9,NULL,,4,,1,3,,,\n";
		nodeStr += "10,AST_YIELD,,5,,1,3,,,\n";
		nodeStr += "11,AST_CALL,,5,,0,3,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,5,,0,3,,,\n";
		nodeStr += "13,string,,5,\"bar\",0,3,,,\n";
		nodeStr += "14,AST_ARG_LIST,,5,,1,3,,,\n";
		nodeStr += "15,AST_VAR,,5,,1,3,,,\n";
		nodeStr += "16,string,,5,\"somekey\",0,3,,,\n";
		nodeStr += "17,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,14,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "10,15,PARENT_OF\n";
		edgeStr += "6,10,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,17,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)10);
		
		assertThat( node, instanceOf(PHPYieldExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((PHPYieldExpression)node).getValue());
		assertEquals( "42", ((PHPYieldExpression)node).getValue().getEscapedCodeStr());
		// TODO ((PHPYieldExpression)node).getKey() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PHPYieldExpression accepts arbitrary ASTNode's for keys,
		// when we actually only want to accept expressions. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((PHPYieldExpression)node).getKey().getProperty("type"));
		
		assertThat( node2, instanceOf(PHPYieldExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((PHPYieldExpression)node2).getValue());
		assertEquals( "bar", ((Identifier)((CallExpression)((PHPYieldExpression)node2).getValue()).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)15), ((PHPYieldExpression)node2).getKey());
		assertEquals( "somekey", ((Variable)((PHPYieldExpression)node2).getKey()).getNameChild().getEscapedCodeStr());
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
	 * AST_STATIC nodes are used to denote static variable declarations.
	 * See http://php.net/manual/en/language.variables.scope.php#language.variables.scope.static
	 * 
	 * Any AST_STATIC node has exactly two children:
	 * 1) string, indicating the static variable's name
	 * 2) various possible child types, representing the default value
	 *    (e.g., node type could be "NULL", "string", "integer", but also AST_CONST, etc.)
	 *    
	 * This test checks a few static variable declarations' children in the following PHP code:
	 * 
	 * function foo() {
	 *   static $bar, $buz = 42, $qux = norf();
	 * }
	 */
	@Test
	public void testStaticVariableCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_STMT_LIST,,4,,0,3,,,\n";
		nodeStr += "8,AST_STATIC,,4,,0,3,,,\n";
		nodeStr += "9,string,,4,\"bar\",0,3,,,\n";
		nodeStr += "10,NULL,,4,,1,3,,,\n";
		nodeStr += "11,AST_STATIC,,4,,1,3,,,\n";
		nodeStr += "12,string,,4,\"buz\",0,3,,,\n";
		nodeStr += "13,integer,,4,42,1,3,,,\n";
		nodeStr += "14,AST_STATIC,,4,,2,3,,,\n";
		nodeStr += "15,string,,4,\"qux\",0,3,,,\n";
		nodeStr += "16,AST_CALL,,4,,1,3,,,\n";
		nodeStr += "17,AST_NAME,NAME_NOT_FQ,4,,0,3,,,\n";
		nodeStr += "18,string,,4,\"norf\",0,3,,,\n";
		nodeStr += "19,AST_ARG_LIST,,4,,1,3,,,\n";
		nodeStr += "20,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,10,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,13,PARENT_OF\n";
		edgeStr += "7,11,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,19,PARENT_OF\n";
		edgeStr += "14,16,PARENT_OF\n";
		edgeStr += "7,14,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,20,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);
		ASTNode node2 = ast.getNodeById((long)11);
		ASTNode node3 = ast.getNodeById((long)14);
		
		assertThat( node, instanceOf(StaticVariableDeclaration.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((StaticVariableDeclaration)node).getNameChild());
		assertEquals( "bar", ((StaticVariableDeclaration)node).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)10), ((StaticVariableDeclaration)node).getDefault());
		// TODO ((StaticVariableDeclaration)node).getDefault() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because StaticVariableDeclaration accepts arbitrary ASTNode's for default values,
		// when we actually only want to accept strings. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((StaticVariableDeclaration)node).getDefault().getProperty("type"));

		assertThat( node2, instanceOf(StaticVariableDeclaration.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((StaticVariableDeclaration)node2).getNameChild());
		assertEquals( "buz", ((StaticVariableDeclaration)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)13), ((StaticVariableDeclaration)node2).getDefault());
		assertEquals( "42", ((StaticVariableDeclaration)node2).getDefault().getEscapedCodeStr());
		
		assertThat( node3, instanceOf(StaticVariableDeclaration.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((StaticVariableDeclaration)node3).getNameChild());
		assertEquals( "qux", ((StaticVariableDeclaration)node3).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)16), ((StaticVariableDeclaration)node3).getDefault());
		assertEquals( "norf", ((Identifier)((CallExpression)((StaticVariableDeclaration)node3).getDefault()).getTargetFunc()).getNameChild().getEscapedCodeStr());
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
	
	/**
	 * AST_DECLARE nodes are used to denote declare statements.
	 * See http://php.net/manual/en/control-structures.declare.php
	 * 
	 * Any AST_DECLARE node has exactly two children:
	 * 1) AST_CONST_DECL, holding the set directive(s)
	 * 2) AST_STMT_LIST or NULL, holding the code to be executed under the given directives
	 *    (If no curly brackets are used, then this child is NULL and the directives affect
	 *    all code following the declare statement.)
	 *    
	 * This test checks a few declare statement's children in the following PHP code:
	 * 
	 * declare(ticks=1) {}
	 * declare(encoding='ISO-8859-1');
	 */
	@Test
	public void testDeclareCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_DECLARE,,3,,0,1,,,\n";
		nodeStr += "4,AST_CONST_DECL,,3,,0,1,,,\n";
		nodeStr += "5,AST_CONST_ELEM,,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"ticks\",0,1,,,\n";
		nodeStr += "7,integer,,3,1,1,1,,,\n";
		nodeStr += "8,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "9,AST_DECLARE,,4,,1,1,,,\n";
		nodeStr += "10,AST_CONST_DECL,,4,,0,1,,,\n";
		nodeStr += "11,AST_CONST_ELEM,,4,,0,1,,,\n";
		nodeStr += "12,string,,4,\"encoding\",0,1,,,\n";
		nodeStr += "13,string,,4,\"ISO-8859-1\",1,1,,,\n";
		nodeStr += "14,NULL,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,7,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,13,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,14,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)9);
		
		assertThat( node, instanceOf(PHPDeclareStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPDeclareStatement)node).getDeclares());
		assertEquals( ast.getNodeById((long)8), ((PHPDeclareStatement)node).getContent());

		assertThat( node2, instanceOf(PHPDeclareStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((PHPDeclareStatement)node2).getDeclares());
		assertNull( ((PHPDeclareStatement)node2).getContent());
	}
	
	/**
	 * AST_PROP_ELEM nodes are used to denote the individual elements of a property declaration
	 * statement in the top-level scope of a class.
	 * They are the children of an AST_PROP_DECL node; see description of AST_PROP_DECL.
	 * 
	 * Any AST_PROP_ELEM node has exactly two children:
	 * 1) string, indicating the property's name
	 * 2) various possible child types, representing the default value
	 *    (e.g., node type could be "NULL", "string", "integer", but also AST_CONST, etc.)
	 *    
	 * This test checks a few property elements' children in the following PHP code:
	 * 
	 * class Foo {
	 *   public $foo, $bar = 3, $buz = "bonjour", $qux = SOMECONSTANT;
	 * }
	 */
	@Test
	public void testPropertyElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,2,,0,1,4,Foo,\n";
		nodeStr += "4,NULL,,2,,0,1,,,\n";
		nodeStr += "5,NULL,,2,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,2,,2,1,4,\"Foo\",\n";
		nodeStr += "7,AST_STMT_LIST,,2,,0,6,,,\n";
		nodeStr += "8,AST_PROP_DECL,MODIFIER_PUBLIC,3,,0,6,,,\n";
		nodeStr += "9,AST_PROP_ELEM,,3,,0,6,,,\n";
		nodeStr += "10,string,,3,\"foo\",0,6,,,\n";
		nodeStr += "11,NULL,,3,,1,6,,,\n";
		nodeStr += "12,AST_PROP_ELEM,,3,,1,6,,,\n";
		nodeStr += "13,string,,3,\"bar\",0,6,,,\n";
		nodeStr += "14,integer,,3,3,1,6,,,\n";
		nodeStr += "15,AST_PROP_ELEM,,3,,2,6,,,\n";
		nodeStr += "16,string,,3,\"buz\",0,6,,,\n";
		nodeStr += "17,string,,3,\"bonjour\",1,6,,,\n";
		nodeStr += "18,AST_PROP_ELEM,,3,,3,6,,,\n";
		nodeStr += "19,string,,3,\"qux\",0,6,,,\n";
		nodeStr += "20,AST_CONST,,3,,1,6,,,\n";
		nodeStr += "21,AST_NAME,NAME_NOT_FQ,3,,0,6,,,\n";
		nodeStr += "22,string,,3,\"SOMECONSTANT\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "15,17,PARENT_OF\n";
		edgeStr += "8,15,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "8,18,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)12);
		ASTNode node3 = ast.getNodeById((long)15);
		ASTNode node4 = ast.getNodeById((long)18);
		
		assertThat( node, instanceOf(PropertyElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((PropertyElement)node).getNameChild());
		assertEquals( "foo", ((PropertyElement)node).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)11), ((PropertyElement)node).getDefault());
		// TODO ((PropertyElement)node).getDefault() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PropertyElement accepts arbitrary ASTNode's for default values,
		// when we actually only want to accept strings. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((PropertyElement)node).getDefault().getProperty("type"));

		assertThat( node2, instanceOf(PropertyElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((PropertyElement)node2).getNameChild());
		assertEquals( "bar", ((PropertyElement)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)14), ((PropertyElement)node2).getDefault());
		assertEquals( "3", ((PropertyElement)node2).getDefault().getEscapedCodeStr());
		
		assertThat( node3, instanceOf(PropertyElement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((PropertyElement)node3).getNameChild());
		assertEquals( "buz", ((PropertyElement)node3).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)17), ((PropertyElement)node3).getDefault());
		assertEquals( "bonjour", ((PropertyElement)node3).getDefault().getEscapedCodeStr());
		
		assertThat( node4, instanceOf(PropertyElement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((PropertyElement)node4).getNameChild());
		assertEquals( "qux", ((PropertyElement)node4).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)20), ((PropertyElement)node4).getDefault());
		assertEquals( "SOMECONSTANT", ((Constant)((PropertyElement)node4).getDefault()).getIdentifier().getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_CONST_ELEM nodes are used to denote the individual elements of a constant declaration
	 * statement, either on top level or within the scope of a class.
	 * They are the children of AST_CONST_DECL and AST_CLASS_CONST_DECL nodes;
	 * see descriptions of these.
	 * 
	 * Any AST_CONST_ELEM node has exactly two children:
	 * 1) string, indicating the constant's name
	 * 2) various possible child types, representing the value
	 *    (e.g., node type could be "string", "integer", but also AST_CONST, etc.)
	 *    
	 * This test checks a few constant elements' children in the following PHP code:
	 * 
	 * const QUESTION = "any", ANSWER = 42;
	 */
	@Test
	public void testConstantElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CONST_DECL,,3,,0,1,,,\n";
		nodeStr += "4,AST_CONST_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"QUESTION\",0,1,,,\n";
		nodeStr += "6,string,,3,\"any\",1,1,,,\n";
		nodeStr += "7,AST_CONST_ELEM,,3,,1,1,,,\n";
		nodeStr += "8,string,,3,\"ANSWER\",0,1,,,\n";
		nodeStr += "9,integer,,3,42,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(ConstantElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((ConstantElement)node).getNameChild());
		assertEquals( "QUESTION", ((ConstantElement)node).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((ConstantElement)node).getValue());
		assertEquals( "any", ((ConstantElement)node).getValue().getEscapedCodeStr());

		assertThat( node2, instanceOf(ConstantElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((ConstantElement)node2).getNameChild());
		assertEquals( "ANSWER", ((ConstantElement)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((ConstantElement)node2).getValue());
		assertEquals( "42", ((ConstantElement)node2).getValue().getEscapedCodeStr());
	}
	
	/**
	 * AST_USE_TRAIT nodes are used to denote trait use statements. They can optionally
	 * contain trait adaptations.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 * 
	 * Any AST_USE_TRAIT node has exactly two children:
	 * 1) AST_NAME_LIST, holding a list of traits to be used
	 * 2) AST_TRAIT_ADAPTATIONS or NULL, representing the optional trait adaptations
	 *    for the used traits
	 *    
	 * This test checks a use trait statement's children in the following PHP code:
	 * 
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testUseTraitCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,9,SomeClass,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,9,\"SomeClass\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		nodeStr += "8,AST_USE_TRAIT,,4,,0,6,,,\n";
		nodeStr += "9,AST_NAME_LIST,,4,,0,6,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,6,,,\n";
		nodeStr += "11,string,,4,\"Foo\",0,6,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,1,6,,,\n";
		nodeStr += "13,string,,4,\"Bar\",0,6,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,4,,2,6,,,\n";
		nodeStr += "15,string,,4,\"Buz\",0,6,,,\n";
		nodeStr += "16,AST_TRAIT_ADAPTATIONS,,5,,1,6,,,\n";
		nodeStr += "17,AST_TRAIT_ALIAS,MODIFIER_PROTECTED,5,,0,6,,,\n";
		nodeStr += "18,AST_METHOD_REFERENCE,,5,,0,6,,,\n";
		nodeStr += "19,NULL,,5,,0,6,,,\n";
		nodeStr += "20,string,,5,\"qux\",1,6,,,\n";
		nodeStr += "21,string,,5,\"_qux\",1,6,,,\n";
		nodeStr += "22,AST_TRAIT_ALIAS,MODIFIER_PRIVATE,6,,1,6,,,\n";
		nodeStr += "23,AST_METHOD_REFERENCE,,6,,0,6,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,6,,0,6,,,\n";
		nodeStr += "25,string,,6,\"Bar\",0,6,,,\n";
		nodeStr += "26,string,,6,\"norf\",1,6,,,\n";
		nodeStr += "27,NULL,,6,,1,6,,,\n";
		nodeStr += "28,AST_TRAIT_PRECEDENCE,,7,,2,6,,,\n";
		nodeStr += "29,AST_METHOD_REFERENCE,,7,,0,6,,,\n";
		nodeStr += "30,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "31,string,,7,\"Foo\",0,6,,,\n";
		nodeStr += "32,string,,7,\"nicknack\",1,6,,,\n";
		nodeStr += "33,AST_NAME_LIST,,7,,1,6,,,\n";
		nodeStr += "34,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "35,string,,7,\"Bar\",0,6,,,\n";
		nodeStr += "36,AST_NAME,NAME_NOT_FQ,7,,1,6,,,\n";
		nodeStr += "37,string,,7,\"Buz\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "9,14,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,21,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,27,PARENT_OF\n";
		edgeStr += "16,22,PARENT_OF\n";
		edgeStr += "30,31,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "29,32,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "36,37,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "28,33,PARENT_OF\n";
		edgeStr += "16,28,PARENT_OF\n";
		edgeStr += "8,16,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(PHPUseTrait.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((PHPUseTrait)node).getTraits());
		assertEquals( "Foo", ((PHPUseTrait)node).getTraits().getIdentifier(0).getNameChild().getEscapedCodeStr());
		assertEquals( "Bar", ((PHPUseTrait)node).getTraits().getIdentifier(1).getNameChild().getEscapedCodeStr());
		assertEquals( "Buz", ((PHPUseTrait)node).getTraits().getIdentifier(2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)16), ((PHPUseTrait)node).getTraitAdaptations());
	}
	
	/**
	 * AST_TRAIT_PRECEDENCE nodes are used to denote trait precedence statements within a
	 * trait use statement. Such statements are used to resolve conflicts when using
	 * several traits that declare the same method name and indicate which of these
	 * methods is to be used.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 * 
	 * Any AST_TRAIT_PRECEDENCE node has exactly two children:
	 * 1) AST_METHOD_REFERENCE, representing the trait method to be used
	 * 2) AST_NAME_LIST, holding a list of trait names that declare the same
	 *    method name but whose method is not to be used
	 *    
	 * This test checks a trait precedence statement's children in the following PHP code:
	 * 
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testTraitPrecedenceCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,9,SomeClass,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,9,\"SomeClass\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		nodeStr += "8,AST_USE_TRAIT,,4,,0,6,,,\n";
		nodeStr += "9,AST_NAME_LIST,,4,,0,6,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,6,,,\n";
		nodeStr += "11,string,,4,\"Foo\",0,6,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,1,6,,,\n";
		nodeStr += "13,string,,4,\"Bar\",0,6,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,4,,2,6,,,\n";
		nodeStr += "15,string,,4,\"Buz\",0,6,,,\n";
		nodeStr += "16,AST_TRAIT_ADAPTATIONS,,5,,1,6,,,\n";
		nodeStr += "17,AST_TRAIT_ALIAS,MODIFIER_PROTECTED,5,,0,6,,,\n";
		nodeStr += "18,AST_METHOD_REFERENCE,,5,,0,6,,,\n";
		nodeStr += "19,NULL,,5,,0,6,,,\n";
		nodeStr += "20,string,,5,\"qux\",1,6,,,\n";
		nodeStr += "21,string,,5,\"_qux\",1,6,,,\n";
		nodeStr += "22,AST_TRAIT_ALIAS,MODIFIER_PRIVATE,6,,1,6,,,\n";
		nodeStr += "23,AST_METHOD_REFERENCE,,6,,0,6,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,6,,0,6,,,\n";
		nodeStr += "25,string,,6,\"Bar\",0,6,,,\n";
		nodeStr += "26,string,,6,\"norf\",1,6,,,\n";
		nodeStr += "27,NULL,,6,,1,6,,,\n";
		nodeStr += "28,AST_TRAIT_PRECEDENCE,,7,,2,6,,,\n";
		nodeStr += "29,AST_METHOD_REFERENCE,,7,,0,6,,,\n";
		nodeStr += "30,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "31,string,,7,\"Foo\",0,6,,,\n";
		nodeStr += "32,string,,7,\"nicknack\",1,6,,,\n";
		nodeStr += "33,AST_NAME_LIST,,7,,1,6,,,\n";
		nodeStr += "34,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "35,string,,7,\"Bar\",0,6,,,\n";
		nodeStr += "36,AST_NAME,NAME_NOT_FQ,7,,1,6,,,\n";
		nodeStr += "37,string,,7,\"Buz\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "9,14,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,21,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,27,PARENT_OF\n";
		edgeStr += "16,22,PARENT_OF\n";
		edgeStr += "30,31,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "29,32,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "36,37,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "28,33,PARENT_OF\n";
		edgeStr += "16,28,PARENT_OF\n";
		edgeStr += "8,16,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)28);
		
		assertThat( node, instanceOf(PHPTraitPrecedence.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)29), ((PHPTraitPrecedence)node).getMethod());
		assertEquals( ast.getNodeById((long)33), ((PHPTraitPrecedence)node).getInsteadOf());
		assertEquals( "Bar", ((PHPTraitPrecedence)node).getInsteadOf().getIdentifier(0).getNameChild().getEscapedCodeStr());
		assertEquals( "Buz", ((PHPTraitPrecedence)node).getInsteadOf().getIdentifier(1).getNameChild().getEscapedCodeStr());
	}
	
	/**
	 * AST_METHOD_REFERENCE nodes are used to denote references to methods.
	 * They are composed of a reference to the class that declares the referenced method,
	 * and the method name. They appear as children of trait adaptation elements;
	 * see AST_TRAIT_ALIAS and AST_TRAIT_PRECEDENCE.
	 * (TODO check if they can appear in other contexts)
	 * 
	 * Any AST_METHOD_REFERENCE node has exactly two children:
	 * 1) AST_NAME, representing the class that the referenced method is declared in
	 * 2) string, indicating the method's name
	 *    
	 * This test checks a few method references' children in the following PHP code:
	 * 
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testMethodReferenceCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,9,SomeClass,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,9,\"SomeClass\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		nodeStr += "8,AST_USE_TRAIT,,4,,0,6,,,\n";
		nodeStr += "9,AST_NAME_LIST,,4,,0,6,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,6,,,\n";
		nodeStr += "11,string,,4,\"Foo\",0,6,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,1,6,,,\n";
		nodeStr += "13,string,,4,\"Bar\",0,6,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,4,,2,6,,,\n";
		nodeStr += "15,string,,4,\"Buz\",0,6,,,\n";
		nodeStr += "16,AST_TRAIT_ADAPTATIONS,,5,,1,6,,,\n";
		nodeStr += "17,AST_TRAIT_ALIAS,MODIFIER_PROTECTED,5,,0,6,,,\n";
		nodeStr += "18,AST_METHOD_REFERENCE,,5,,0,6,,,\n";
		nodeStr += "19,NULL,,5,,0,6,,,\n";
		nodeStr += "20,string,,5,\"qux\",1,6,,,\n";
		nodeStr += "21,string,,5,\"_qux\",1,6,,,\n";
		nodeStr += "22,AST_TRAIT_ALIAS,MODIFIER_PRIVATE,6,,1,6,,,\n";
		nodeStr += "23,AST_METHOD_REFERENCE,,6,,0,6,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,6,,0,6,,,\n";
		nodeStr += "25,string,,6,\"Bar\",0,6,,,\n";
		nodeStr += "26,string,,6,\"norf\",1,6,,,\n";
		nodeStr += "27,NULL,,6,,1,6,,,\n";
		nodeStr += "28,AST_TRAIT_PRECEDENCE,,7,,2,6,,,\n";
		nodeStr += "29,AST_METHOD_REFERENCE,,7,,0,6,,,\n";
		nodeStr += "30,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "31,string,,7,\"Foo\",0,6,,,\n";
		nodeStr += "32,string,,7,\"nicknack\",1,6,,,\n";
		nodeStr += "33,AST_NAME_LIST,,7,,1,6,,,\n";
		nodeStr += "34,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "35,string,,7,\"Bar\",0,6,,,\n";
		nodeStr += "36,AST_NAME,NAME_NOT_FQ,7,,1,6,,,\n";
		nodeStr += "37,string,,7,\"Buz\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "9,14,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,21,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,27,PARENT_OF\n";
		edgeStr += "16,22,PARENT_OF\n";
		edgeStr += "30,31,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "29,32,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "36,37,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "28,33,PARENT_OF\n";
		edgeStr += "16,28,PARENT_OF\n";
		edgeStr += "8,16,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)18);
		ASTNode node2 = ast.getNodeById((long)23);
		ASTNode node3 = ast.getNodeById((long)29);
		
		assertThat( node, instanceOf(MethodReference.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((MethodReference)node).getClassIdentifier());
		assertEquals( ast.getNodeById((long)20), ((MethodReference)node).getMethodName());
		assertEquals( "qux", ((MethodReference)node).getMethodName().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(MethodReference.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((MethodReference)node2).getClassIdentifier());
		assertEquals( "Bar", ((MethodReference)node2).getClassIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)26), ((MethodReference)node2).getMethodName());
		assertEquals( "norf", ((MethodReference)node2).getMethodName().getEscapedCodeStr());
		
		assertThat( node3, instanceOf(MethodReference.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)30), ((MethodReference)node3).getClassIdentifier());
		assertEquals( "Foo", ((MethodReference)node3).getClassIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)32), ((MethodReference)node3).getMethodName());
		assertEquals( "nicknack", ((MethodReference)node3).getMethodName().getEscapedCodeStr());
	}

	/**
	 * AST_NAMESPACE nodes are used to denote namespace statements. They are composed
	 * of a name and a compound statement. Either of these, but not both, may be null
	 * (a namespace  without a compound statement declares a namespace for the code
	 * following until the next namespace statement; a namespace without a name opens
	 * a "non-namespaced" scope)
	 * See  http://php.net/manual/en/language.namespaces.definitionmultiple.php
	 * 
	 * Any AST_NAMESPACE node has exactly two children:
	 * 1) string or NULL, representing the namespace name
	 * 2) AST_STMT_LIST or NULL, holding the namespaced code
	 *    
	 * This test checks a few use namespace statements' children in the following PHP code:
	 * 
	 * namespace Foo {}
	 * namespace Bar;
	 * namespace {}
	 */
	@Test
	public void testNamespaceCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_NAMESPACE,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"Foo\",0,1,,,\n";
		nodeStr += "5,AST_STMT_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_NAMESPACE,,4,,1,1,,,\n";
		nodeStr += "7,string,,4,\"Bar\",0,1,,,\n";
		nodeStr += "8,NULL,,4,,1,1,,,\n";
		nodeStr += "9,AST_NAMESPACE,,5,,2,1,,,\n";
		nodeStr += "10,NULL,,5,,0,1,,,\n";
		nodeStr += "11,AST_STMT_LIST,,5,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,8,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)6);
		ASTNode node3 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(NamespaceStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((NamespaceStatement)node).getName());
		assertEquals( "Foo", ((NamespaceStatement)node).getName().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)5), ((NamespaceStatement)node).getContent());
		
		assertThat( node2, instanceOf(NamespaceStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((NamespaceStatement)node2).getName());
		assertEquals( "Bar", ((NamespaceStatement)node2).getName().getEscapedCodeStr());
		assertNull( ((NamespaceStatement)node2).getContent());
		
		assertThat( node3, instanceOf(NamespaceStatement.class));
		assertEquals( 2, node3.getChildCount());
		// TODO ((NamespaceStatement)node3).getName() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because NamespaceStatement accepts arbitrary ASTNode's for names,
		// when we actually only want to accept strings. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((NamespaceStatement)node3).getName().getProperty("type"));
		assertEquals( ast.getNodeById((long)11), ((NamespaceStatement)node3).getContent());
	}
	
	/**
	 * AST_USE_ELEM nodes are used to denote individual use statement elements within a
	 * use statement. They are the children of AST_USE nodes.
	 * 
	 * Any AST_USE_ELEM node has exactly two children:
	 * 1) string, representing the imported namespace
	 * 2) string or NULL, indicating the optional alias for the namespace
	 *    
	 * This test checks a few use statement elements' children in the following PHP code:
	 * 
	 * use Foo\Bar as Buz, Qux as Norf;
	 */
	@Test
	public void testUseElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_USE,T_CLASS,3,,0,1,,,\n";
		nodeStr += "4,AST_USE_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Foo\\Bar\",0,1,,,\n";
		nodeStr += "6,string,,3,\"Buz\",1,1,,,\n";
		nodeStr += "7,AST_USE_ELEM,,3,,1,1,,,\n";
		nodeStr += "8,string,,3,\"Qux\",0,1,,,\n";
		nodeStr += "9,string,,3,\"Norf\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)7);

		assertThat( node, instanceOf(UseElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)5), ((UseElement)node).getNamespace());
		assertEquals( "Foo\\Bar", ((UseElement)node).getNamespace().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)6), ((UseElement)node).getAlias());
		assertEquals( "Buz", ((UseElement)node).getAlias().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(UseElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((UseElement)node2).getNamespace());
		assertEquals( "Qux", ((UseElement)node2).getNamespace().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((UseElement)node2).getAlias());
		assertEquals( "Norf", ((UseElement)node2).getAlias().getEscapedCodeStr());
	}
	
	/**
	 * AST_TRAIT_ALIAS nodes are used to denote trait alias statements within a
	 * trait use statement. Such statements are used to declare aliases for
	 * trait methods, or to change the visibility of trait methods.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 * 
	 * Any AST_TRAIT_ALIAS node has exactly two children:
	 * 1) AST_METHOD_REFERENCE, representing the trait method being referenced
	 * 2) string or NULL, indicating: if it's a string, the alias name; or if it's NULL,
	 *    we are only changing a trait method's visibility without declaring an alias
	 *    
	 * This test checks a few trait alias statements' children in the following PHP code:
	 * 
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testTraitAliasCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,9,SomeClass,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,9,\"SomeClass\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		nodeStr += "8,AST_USE_TRAIT,,4,,0,6,,,\n";
		nodeStr += "9,AST_NAME_LIST,,4,,0,6,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,6,,,\n";
		nodeStr += "11,string,,4,\"Foo\",0,6,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,1,6,,,\n";
		nodeStr += "13,string,,4,\"Bar\",0,6,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,4,,2,6,,,\n";
		nodeStr += "15,string,,4,\"Buz\",0,6,,,\n";
		nodeStr += "16,AST_TRAIT_ADAPTATIONS,,5,,1,6,,,\n";
		nodeStr += "17,AST_TRAIT_ALIAS,MODIFIER_PROTECTED,5,,0,6,,,\n";
		nodeStr += "18,AST_METHOD_REFERENCE,,5,,0,6,,,\n";
		nodeStr += "19,NULL,,5,,0,6,,,\n";
		nodeStr += "20,string,,5,\"qux\",1,6,,,\n";
		nodeStr += "21,string,,5,\"_qux\",1,6,,,\n";
		nodeStr += "22,AST_TRAIT_ALIAS,MODIFIER_PRIVATE,6,,1,6,,,\n";
		nodeStr += "23,AST_METHOD_REFERENCE,,6,,0,6,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,6,,0,6,,,\n";
		nodeStr += "25,string,,6,\"Bar\",0,6,,,\n";
		nodeStr += "26,string,,6,\"norf\",1,6,,,\n";
		nodeStr += "27,NULL,,6,,1,6,,,\n";
		nodeStr += "28,AST_TRAIT_PRECEDENCE,,7,,2,6,,,\n";
		nodeStr += "29,AST_METHOD_REFERENCE,,7,,0,6,,,\n";
		nodeStr += "30,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "31,string,,7,\"Foo\",0,6,,,\n";
		nodeStr += "32,string,,7,\"nicknack\",1,6,,,\n";
		nodeStr += "33,AST_NAME_LIST,,7,,1,6,,,\n";
		nodeStr += "34,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "35,string,,7,\"Bar\",0,6,,,\n";
		nodeStr += "36,AST_NAME,NAME_NOT_FQ,7,,1,6,,,\n";
		nodeStr += "37,string,,7,\"Buz\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "9,14,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,21,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,27,PARENT_OF\n";
		edgeStr += "16,22,PARENT_OF\n";
		edgeStr += "30,31,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "29,32,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "36,37,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "28,33,PARENT_OF\n";
		edgeStr += "16,28,PARENT_OF\n";
		edgeStr += "8,16,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)17);
		ASTNode node2 = ast.getNodeById((long)22);
		
		assertThat( node, instanceOf(PHPTraitAlias.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)18), ((PHPTraitAlias)node).getMethod());
		assertEquals( ast.getNodeById((long)21), ((PHPTraitAlias)node).getAlias());
		assertEquals( "_qux", ((PHPTraitAlias)node).getAlias().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(PHPTraitAlias.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)23), ((PHPTraitAlias)node2).getMethod());
		// TODO ((PHPTraitAlias)node).getAlias() should
		// actually return null, not a null node. This currently does not work exactly
		// as expected because PHPTraitAlias accepts arbitrary ASTNode's for aliases,
		// when we actually only want to accept strings. Once the mapping is
		// finished, we can fix that.
		assertEquals( "NULL", ((PHPTraitAlias)node2).getAlias().getProperty("type"));
	}
	
	/**
	 * AST_GROUP_USE nodes are used to denote group use statements.
	 * This is a new feature in PHP 7, see
	 * http://php.net/manual/en/language.namespaces.importing.php#language.namespaces.importing.group
	 * 
	 * Any AST_GROUP_USE node has exactly two children:
	 * 1) string, representing the prefix of the namespaces to be used
	 * 2) AST_USE, holding the used namespaces
	 *    
	 * This test checks a group use statement's children in the following PHP code:
	 * 
	 * use Foo\{Bar as B, Buz, Qux as Q};
	 */
	@Test
	public void testGroupUseCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_GROUP_USE,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"Foo\",0,1,,,\n";
		nodeStr += "5,AST_USE,,3,,1,1,,,\n";
		nodeStr += "6,AST_USE_ELEM,T_CLASS,3,,0,1,,,\n";
		nodeStr += "7,string,,3,\"Bar\",0,1,,,\n";
		nodeStr += "8,string,,3,\"B\",1,1,,,\n";
		nodeStr += "9,AST_USE_ELEM,T_CLASS,3,,1,1,,,\n";
		nodeStr += "10,string,,3,\"Buz\",0,1,,,\n";
		nodeStr += "11,NULL,,3,,1,1,,,\n";
		nodeStr += "12,AST_USE_ELEM,T_CLASS,3,,2,1,,,\n";
		nodeStr += "13,string,,3,\"Qux\",0,1,,,\n";
		nodeStr += "14,string,,3,\"Q\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,8,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";
		edgeStr += "5,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "5,12,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(PHPGroupUseStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)4), ((PHPGroupUseStatement)node).getPrefix());
		assertEquals( "Foo", ((PHPGroupUseStatement)node).getPrefix().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)5), ((PHPGroupUseStatement)node).getUses());
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
		assertEquals( ast.getNodeById((long)6), ((ForEachStatement)node).getValueExpression());
		assertNull( ((ForEachStatement)node).getKeyVariable());
		assertEquals( ast.getNodeById((long)9), ((ForEachStatement)node).getStatement());
		
		assertThat( node2, instanceOf(ForEachStatement.class));
		assertEquals( 4, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((ForEachStatement)node2).getIteratedObject());
		assertEquals( ast.getNodeById((long)15), ((ForEachStatement)node2).getValueExpression());
		assertEquals( ast.getNodeById((long)17), ((ForEachStatement)node2).getKeyVariable());
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
	 * AST_LIST nodes are used to denote PHP list expressions.
	 * 
	 * Any AST_LIST node has between 1 and an arbitrarily large number of children.
	 * (Note: an empty list will generate an implicit NULL node child,
	 * see TestPHPCSVASTBuilderMinimal.testMinimalListCreation()).
	 * Each child corresponds to one element in the list.
	 * 
	 * This test checks a few PHP list expressions' children in the following PHP code:
	 * 
	 * list($a, , list($c, $d)) = array("foo", "bar", array("buz", "qux"));
	 */
	@Test
	public void testListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ASSIGN,,3,,0,1,,,\n";
		nodeStr += "4,AST_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"a\",0,1,,,\n";
		nodeStr += "7,NULL,,3,,1,1,,,\n";
		nodeStr += "8,AST_LIST,,3,,2,1,,,\n";
		nodeStr += "9,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "10,string,,3,\"c\",0,1,,,\n";
		nodeStr += "11,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "12,string,,3,\"d\",0,1,,,\n";
		nodeStr += "13,AST_ARRAY,,3,,1,1,,,\n";
		nodeStr += "14,AST_ARRAY_ELEM,,3,,0,1,,,\n";
		nodeStr += "15,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "16,NULL,,3,,1,1,,,\n";
		nodeStr += "17,AST_ARRAY_ELEM,,3,,1,1,,,\n";
		nodeStr += "18,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "19,NULL,,3,,1,1,,,\n";
		nodeStr += "20,AST_ARRAY_ELEM,,3,,2,1,,,\n";
		nodeStr += "21,AST_ARRAY,,3,,0,1,,,\n";
		nodeStr += "22,AST_ARRAY_ELEM,,3,,0,1,,,\n";
		nodeStr += "23,string,,3,\"buz\",0,1,,,\n";
		nodeStr += "24,NULL,,3,,1,1,,,\n";
		nodeStr += "25,AST_ARRAY_ELEM,,3,,1,1,,,\n";
		nodeStr += "26,string,,3,\"qux\",0,1,,,\n";
		nodeStr += "27,NULL,,3,,1,1,,,\n";
		nodeStr += "28,NULL,,3,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,7,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "4,8,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "14,16,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,19,PARENT_OF\n";
		edgeStr += "13,17,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,24,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "25,26,PARENT_OF\n";
		edgeStr += "25,27,PARENT_OF\n";
		edgeStr += "21,25,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "20,28,PARENT_OF\n";
		edgeStr += "13,20,PARENT_OF\n";
		edgeStr += "3,13,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)8);

		assertThat( node, instanceOf(PHPListExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( 3, ((PHPListExpression)node).size());
		assertEquals( ast.getNodeById((long)5), ((PHPListExpression)node).getElement(0));
		assertEquals( ast.getNodeById((long)7), ((PHPListExpression)node).getElement(1));
		assertEquals( ast.getNodeById((long)8), ((PHPListExpression)node).getElement(2));
		for( ASTNode element : (PHPListExpression)node) // TODO iterate over Expression's
			assertTrue( ast.containsValue(element));
		
		assertThat( node2, instanceOf(PHPListExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( 2, ((PHPListExpression)node2).size());
		assertEquals( ast.getNodeById((long)9), ((PHPListExpression)node2).getElement(0));
		assertEquals( ast.getNodeById((long)11), ((PHPListExpression)node2).getElement(1));
		for( ASTNode element : (PHPListExpression)node2) // TODO iterate over Expression's
			assertTrue( ast.containsValue(element));
	}
	
	/**
	 * AST_ARRAY nodes are used to denote array declaration expressions.
	 * 
	 * Any AST_ARRAY node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the array.
	 * 
	 * This test checks an array expression's children in the following PHP code:
	 * 
	 * array("key1" => 42,
	 *       2 => "foo",
	 *       aconst => $bar,
	 *       buz());
	 */
	@Test
	public void testArrayCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ARRAY,,3,,0,1,,,\n";
		nodeStr += "4,AST_ARRAY_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,integer,,3,42,0,1,,,\n";
		nodeStr += "6,string,,3,\"key1\",1,1,,,\n";
		nodeStr += "7,AST_ARRAY_ELEM,,4,,1,1,,,\n";
		nodeStr += "8,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "9,integer,,4,2,1,1,,,\n";
		nodeStr += "10,AST_ARRAY_ELEM,,5,,2,1,,,\n";
		nodeStr += "11,AST_VAR,,5,,0,1,,,\n";
		nodeStr += "12,string,,5,\"bar\",0,1,,,\n";
		nodeStr += "13,AST_CONST,,5,,1,1,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "15,string,,5,\"aconst\",0,1,,,\n";
		nodeStr += "16,AST_ARRAY_ELEM,,6,,3,1,,,\n";
		nodeStr += "17,AST_CALL,,6,,0,1,,,\n";
		nodeStr += "18,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "19,string,,6,\"buz\",0,1,,,\n";
		nodeStr += "20,AST_ARG_LIST,,6,,1,1,,,\n";
		nodeStr += "21,NULL,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";
		edgeStr += "3,10,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,20,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,21,PARENT_OF\n";
		edgeStr += "3,16,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(PHPArrayExpression.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((PHPArrayExpression)node).size());
		assertEquals( ast.getNodeById((long)4), ((PHPArrayExpression)node).getArrayElement(0));
		assertEquals( ast.getNodeById((long)7), ((PHPArrayExpression)node).getArrayElement(1));
		assertEquals( ast.getNodeById((long)10), ((PHPArrayExpression)node).getArrayElement(2));
		assertEquals( ast.getNodeById((long)16), ((PHPArrayExpression)node).getArrayElement(3));
		for( PHPArrayElement element : (PHPArrayExpression)node)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_ENCAPS_LIST nodes are used for holding strings with variables,
	 * i.e., non-constant strings wherein variable expansion occurs.
	 * See http://php.net/manual/en/language.types.string.php#language.types.string.parsing
	 * 
	 * Any AST_ENCAPS_LIST node has between 1 and an arbitrarily large number
	 * of children. Each child is either (a) a "string" node; or (b) an AST_VAR node;
	 * or (c) an AST_DIM node; or (d) an AST_PROP node.
	 * 
	 * This test checks an encapsulated list's children in the following PHP code:
	 * 
	 * "Hello {$foo}, {$bar['somekey']} and {$buz->qux}!";
	 */
	@Test
	public void testEncapsulatedList() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ENCAPS_LIST,,3,,0,1,,,\n";
		nodeStr += "4,string,,3,\"Hello \",0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "7,string,,3,\", \",2,1,,,\n";
		nodeStr += "8,AST_DIM,,3,,3,1,,,\n";
		nodeStr += "9,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "10,string,,3,\"bar\",0,1,,,\n";
		nodeStr += "11,string,,3,\"somekey\",1,1,,,\n";
		nodeStr += "12,string,,3,\" and \",4,1,,,\n";
		nodeStr += "13,AST_PROP,,3,,5,1,,,\n";
		nodeStr += "14,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "15,string,,3,\"buz\",0,1,,,\n";
		nodeStr += "16,string,,3,\"qux\",1,1,,,\n";
		nodeStr += "17,string,,3,\"!\",6,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "3,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "13,16,PARENT_OF\n";
		edgeStr += "3,13,PARENT_OF\n";
		edgeStr += "3,17,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(PHPEncapsListExpression.class));
		assertEquals( 7, node.getChildCount());
		assertEquals( 7, ((PHPEncapsListExpression)node).size());
		assertEquals( ast.getNodeById((long)4), ((PHPEncapsListExpression)node).getElement(0));
		assertEquals( ast.getNodeById((long)5), ((PHPEncapsListExpression)node).getElement(1));
		assertEquals( ast.getNodeById((long)7), ((PHPEncapsListExpression)node).getElement(2));
		assertEquals( ast.getNodeById((long)8), ((PHPEncapsListExpression)node).getElement(3));
		assertEquals( ast.getNodeById((long)12), ((PHPEncapsListExpression)node).getElement(4));
		assertEquals( ast.getNodeById((long)13), ((PHPEncapsListExpression)node).getElement(5));
		assertEquals( ast.getNodeById((long)17), ((PHPEncapsListExpression)node).getElement(6));
		for( ASTNode element : (PHPEncapsListExpression)node) // TODO iterate over Expression's
			assertTrue( ast.containsValue(element));
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
	 * AST_PROP_DECL nodes are used to denote property declaration statements
	 * in the top-level scope of a class.
	 * 
	 * Any AST_PROP_DECL node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the property declaration statement.
	 * 
	 * This test checks a property declaration statement's children in the following PHP code:
	 * 
	 * class Foo {
	 *   public $foo, $bar = 3, $buz = "bonjour", $qux = SOMECONSTANT;
	 * }
	 */
	@Test
	public void testPropertyDeclarationCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,2,,0,1,4,Foo,\n";
		nodeStr += "4,NULL,,2,,0,1,,,\n";
		nodeStr += "5,NULL,,2,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,2,,2,1,4,\"Foo\",\n";
		nodeStr += "7,AST_STMT_LIST,,2,,0,6,,,\n";
		nodeStr += "8,AST_PROP_DECL,MODIFIER_PUBLIC,3,,0,6,,,\n";
		nodeStr += "9,AST_PROP_ELEM,,3,,0,6,,,\n";
		nodeStr += "10,string,,3,\"foo\",0,6,,,\n";
		nodeStr += "11,NULL,,3,,1,6,,,\n";
		nodeStr += "12,AST_PROP_ELEM,,3,,1,6,,,\n";
		nodeStr += "13,string,,3,\"bar\",0,6,,,\n";
		nodeStr += "14,integer,,3,3,1,6,,,\n";
		nodeStr += "15,AST_PROP_ELEM,,3,,2,6,,,\n";
		nodeStr += "16,string,,3,\"buz\",0,6,,,\n";
		nodeStr += "17,string,,3,\"bonjour\",1,6,,,\n";
		nodeStr += "18,AST_PROP_ELEM,,3,,3,6,,,\n";
		nodeStr += "19,string,,3,\"qux\",0,6,,,\n";
		nodeStr += "20,AST_CONST,,3,,1,6,,,\n";
		nodeStr += "21,AST_NAME,NAME_NOT_FQ,3,,0,6,,,\n";
		nodeStr += "22,string,,3,\"SOMECONSTANT\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "15,17,PARENT_OF\n";
		edgeStr += "8,15,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "20,21,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "8,18,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);

		assertThat( node, instanceOf(PropertyDeclaration.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((PropertyDeclaration)node).size());
		assertEquals( ast.getNodeById((long)9), ((PropertyDeclaration)node).getPropertyElement(0));
		assertEquals( ast.getNodeById((long)12), ((PropertyDeclaration)node).getPropertyElement(1));
		assertEquals( ast.getNodeById((long)15), ((PropertyDeclaration)node).getPropertyElement(2));
		assertEquals( ast.getNodeById((long)18), ((PropertyDeclaration)node).getPropertyElement(3));
		for( PropertyElement element : (PropertyDeclaration)node)
			assertTrue( ast.containsValue(element));
	}
	
	/**
	 * AST_CONST_DECL nodes are used to denote constant declaration statements
	 * in top-level code.
	 * 
	 * Any AST_CONST_DECL node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the constant declaration statement.
	 * 
	 * This test checks a constant declaration statement's children in the following PHP code:
	 * 
	 * const QUESTION = "any", ANSWER = 42;
	 */
	@Test
	public void testConstantDeclarationCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CONST_DECL,,3,,0,1,,,\n";
		nodeStr += "4,AST_CONST_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"QUESTION\",0,1,,,\n";
		nodeStr += "6,string,,3,\"any\",1,1,,,\n";
		nodeStr += "7,AST_CONST_ELEM,,3,,1,1,,,\n";
		nodeStr += "8,string,,3,\"ANSWER\",0,1,,,\n";
		nodeStr += "9,integer,,3,42,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(ConstantDeclaration.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ConstantDeclaration)node).size());
		assertEquals( ast.getNodeById((long)4), ((ConstantDeclaration)node).getConstantElement(0));
		assertEquals( ast.getNodeById((long)7), ((ConstantDeclaration)node).getConstantElement(1));
		for( ConstantElement element : (ConstantDeclaration)node)
			assertTrue( ast.containsValue(element));
	}
	
	/**
	 * AST_CLASS_CONST_DECL nodes are used to denote class constant declaration statements
	 * in the top-level scope of a class.
	 * 
	 * Any AST_CLASS_CONST_DECL node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the class constant declaration statement.
	 * 
	 * This test checks a class constant declaration statement's children in the following PHP code:
	 * 
	 * class Foo {
	 *   const QUESTION = "any", ANSWER = 42;
	 * }
	 */
	@Test
	public void testClassConstantDeclarationCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "8,AST_CLASS_CONST_DECL,,4,,0,6,,,\n";
		nodeStr += "9,AST_CONST_ELEM,,4,,0,6,,,\n";
		nodeStr += "10,string,,4,\"QUESTION\",0,6,,,\n";
		nodeStr += "11,string,,4,\"any\",1,6,,,\n";
		nodeStr += "12,AST_CONST_ELEM,,4,,1,6,,,\n";
		nodeStr += "13,string,,4,\"ANSWER\",0,6,,,\n";
		nodeStr += "14,integer,,4,42,1,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,14,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);

		assertThat( node, instanceOf(ClassConstantDeclaration.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ClassConstantDeclaration)node).size());
		assertEquals( ast.getNodeById((long)9), ((ClassConstantDeclaration)node).getConstantElement(0));
		assertEquals( ast.getNodeById((long)12), ((ClassConstantDeclaration)node).getConstantElement(1));
		for( ConstantElement element : (ClassConstantDeclaration)node)
			assertTrue( ast.containsValue(element));
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
	
	/**
	 * AST_TRAIT_ADAPTATIONS nodes are used for holding a list of trait adaptations, i.e.,
	 * a list of AST_TRAIT_ALIAS and AST_TRAIT_PRECEDENCE nodes.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 * 
	 * Any AST_TRAIT_ADAPTATIONS node has between 1 and an arbitrarily large number
	 * of trait adaptations. Each child corresponds to one trait adaptation in the list.
	 *    
	 * This test checks a trait adaptations statement's children in the following PHP code:
	 * 
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testTraitAdaptations() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,9,SomeClass,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,9,\"SomeClass\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		nodeStr += "8,AST_USE_TRAIT,,4,,0,6,,,\n";
		nodeStr += "9,AST_NAME_LIST,,4,,0,6,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,6,,,\n";
		nodeStr += "11,string,,4,\"Foo\",0,6,,,\n";
		nodeStr += "12,AST_NAME,NAME_NOT_FQ,4,,1,6,,,\n";
		nodeStr += "13,string,,4,\"Bar\",0,6,,,\n";
		nodeStr += "14,AST_NAME,NAME_NOT_FQ,4,,2,6,,,\n";
		nodeStr += "15,string,,4,\"Buz\",0,6,,,\n";
		nodeStr += "16,AST_TRAIT_ADAPTATIONS,,5,,1,6,,,\n";
		nodeStr += "17,AST_TRAIT_ALIAS,MODIFIER_PROTECTED,5,,0,6,,,\n";
		nodeStr += "18,AST_METHOD_REFERENCE,,5,,0,6,,,\n";
		nodeStr += "19,NULL,,5,,0,6,,,\n";
		nodeStr += "20,string,,5,\"qux\",1,6,,,\n";
		nodeStr += "21,string,,5,\"_qux\",1,6,,,\n";
		nodeStr += "22,AST_TRAIT_ALIAS,MODIFIER_PRIVATE,6,,1,6,,,\n";
		nodeStr += "23,AST_METHOD_REFERENCE,,6,,0,6,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,6,,0,6,,,\n";
		nodeStr += "25,string,,6,\"Bar\",0,6,,,\n";
		nodeStr += "26,string,,6,\"norf\",1,6,,,\n";
		nodeStr += "27,NULL,,6,,1,6,,,\n";
		nodeStr += "28,AST_TRAIT_PRECEDENCE,,7,,2,6,,,\n";
		nodeStr += "29,AST_METHOD_REFERENCE,,7,,0,6,,,\n";
		nodeStr += "30,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "31,string,,7,\"Foo\",0,6,,,\n";
		nodeStr += "32,string,,7,\"nicknack\",1,6,,,\n";
		nodeStr += "33,AST_NAME_LIST,,7,,1,6,,,\n";
		nodeStr += "34,AST_NAME,NAME_NOT_FQ,7,,0,6,,,\n";
		nodeStr += "35,string,,7,\"Bar\",0,6,,,\n";
		nodeStr += "36,AST_NAME,NAME_NOT_FQ,7,,1,6,,,\n";
		nodeStr += "37,string,,7,\"Buz\",0,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "9,12,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "9,14,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "18,20,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,21,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "22,23,PARENT_OF\n";
		edgeStr += "22,27,PARENT_OF\n";
		edgeStr += "16,22,PARENT_OF\n";
		edgeStr += "30,31,PARENT_OF\n";
		edgeStr += "29,30,PARENT_OF\n";
		edgeStr += "29,32,PARENT_OF\n";
		edgeStr += "28,29,PARENT_OF\n";
		edgeStr += "34,35,PARENT_OF\n";
		edgeStr += "33,34,PARENT_OF\n";
		edgeStr += "36,37,PARENT_OF\n";
		edgeStr += "33,36,PARENT_OF\n";
		edgeStr += "28,33,PARENT_OF\n";
		edgeStr += "16,28,PARENT_OF\n";
		edgeStr += "8,16,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)16);
		
		assertThat( node, instanceOf(PHPTraitAdaptations.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( 3, ((PHPTraitAdaptations)node).size());
		assertEquals( ast.getNodeById((long)17), ((PHPTraitAdaptations)node).getTraitAdaptationElement(0));
		assertEquals( ast.getNodeById((long)22), ((PHPTraitAdaptations)node).getTraitAdaptationElement(1));
		assertEquals( ast.getNodeById((long)28), ((PHPTraitAdaptations)node).getTraitAdaptationElement(2));
		for( PHPTraitAdaptationElement traitAdaptation : (PHPTraitAdaptations)node)
			assertTrue( ast.containsValue(traitAdaptation));
	}
	
	/**
	 * AST_USE nodes are used to denote use statements.
	 * 
	 * Any AST_USE node has between 1 and an arbitrarily large number
	 * of use statement elements. Each child corresponds to one use element in the list.
	 *    
	 * This test checks a use statement's children in the following PHP code:
	 * 
	 * use Foo\Bar as Buz, Qux as Norf;
	 */
	@Test
	public void testUseStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_USE,T_CLASS,3,,0,1,,,\n";
		nodeStr += "4,AST_USE_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Foo\\Bar\",0,1,,,\n";
		nodeStr += "6,string,,3,\"Buz\",1,1,,,\n";
		nodeStr += "7,AST_USE_ELEM,,3,,1,1,,,\n";
		nodeStr += "8,string,,3,\"Qux\",0,1,,,\n";
		nodeStr += "9,string,,3,\"Norf\",1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(UseStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((UseStatement)node).size());
		assertEquals( ast.getNodeById((long)4), ((UseStatement)node).getUseElement(0));
		assertEquals( ast.getNodeById((long)7), ((UseStatement)node).getUseElement(1));
		for( UseElement useElement : (UseStatement)node)
			assertTrue( ast.containsValue(useElement));
	}
}
