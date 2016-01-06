package tests.languages.php.astCreation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.ArgumentList;
import ast.expressions.ConditionalExpression;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.php.declarations.PHPClassDef;
import ast.php.expressions.PHPArrayExpression;
import ast.php.expressions.PHPExitExpression;
import ast.php.expressions.PHPListExpression;
import ast.php.expressions.PHPYieldExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPFunctionDef;
import ast.php.functionDef.PHPParameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.blockstarters.ForEachStatement;
import ast.php.statements.blockstarters.PHPIfElement;
import ast.php.statements.blockstarters.PHPSwitchCase;
import ast.php.statements.blockstarters.PHPSwitchList;
import ast.php.statements.blockstarters.PHPUseTrait;
import ast.php.statements.jump.PHPBreakStatement;
import ast.php.statements.jump.PHPContinueStatement;
import ast.statements.ExpressionStatement;
import ast.statements.UseElement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.ReturnStatement;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import tools.phpast2cfg.PHPCSVEdgeInterpreter;
import tools.phpast2cfg.PHPCSVNodeInterpreter;

/**
 * This class implements some tests similar to those in TestPHPCSVASTBuilder,
 * but re-implements those tests in a "minimal" way in that these tests try
 * to parse PHP code that generates as few child nodes as possible: e.g.,
 * classes that do not extend another class or implement any interfaces,
 * functions that do not take parameters or return anything, methods that
 * are abstract and unimplemented, etc. (whereas tests in TestPHPCSVASTBuilder
 * do the exact opposite and aim to generate every possible child for testing.)
 */
public class TestPHPCSVASTBuilderMinimal
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


	/* declaration nodes */	

	/**
	 * <empty file>
	 */
	@Test
	public void testMinimalTopLevelFunctionDefCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "1,AST_TOPLEVEL,TOPLEVEL_FILE,1,,,,0,\"foo.php\",\n";
		nodeStr += "2,NULL,,0,,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "1,2,PARENT_OF\n";
		
		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)1);
		
		assertThat( node, instanceOf(TopLevelFunctionDef.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((TopLevelFunctionDef)node).getContent());
	}
	
	/**
	 * function foo() {}
	 */
	@Test
	public void testMinimalFunctionDefCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,3,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		
		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(PHPFunctionDef.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((PHPFunctionDef)node).getReturnType());
	}

	/**
	 * function() {};
	 */
	@Test
	public void testMinimalClosureCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLOSURE,,3,,0,1,3,{closure},\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(Closure.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((Closure)node).getClosureUses());
		assertNull( ((Closure)node).getReturnType());
	}

	/**
	 * abstract class bar {
	 *   function foo();
	 * }
	 */
	@Test
	public void testMinimalMethodCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "8,AST_METHOD,MODIFIER_PUBLIC,4,,0,6,4,foo,\n";
		nodeStr += "9,AST_PARAM_LIST,,4,,0,8,,,\n";
		nodeStr += "10,NULL,,4,,1,8,,,\n";
		nodeStr += "11,NULL,,4,,2,8,,,\n";
		nodeStr += "12,NULL,,4,,3,8,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,10,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(Method.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((Method)node).getContent());
		assertNull( ((Method)node).getReturnType());
	}
	
	/**
	 * class foo {}
	 */
	@Test
	public void testMinimalClassCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		
		nodeStr += "3,AST_CLASS,,3,,0,1,3,foo,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,3,\"foo\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		
		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(PHPClassDef.class));
		assertEquals( 3, node.getChildCount());
		assertNull( ((PHPClassDef)node).getExtends());
		assertNull( ((PHPClassDef)node).getImplements());
	}
	
	
	/* nodes with exactly 1 child */
	
	/**
	 * exit;
	 */
	@Test
	public void testMinimalExitCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_EXIT,,3,,0,1,,,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(PHPExitExpression.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((PHPExitExpression)node).getExpression());
	}
	
	/**
	 * function foo() {
	 *   return;
	 * }
	 */
	@Test
	public void testMinimalReturnStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_RETURN,,4,,0,3,,,\n";
		nodeStr += "8,NULL,,4,,0,3,,,\n";
		nodeStr += "9,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(ReturnStatement.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((ReturnStatement)node).getReturnExpression());
	}
	
	/**
	 * while (1)
	 *   break;
	 */
	@Test
	public void testMinimalBreakStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,integer,,3,1,0,1,,,\n";
		nodeStr += "5,AST_BREAK,,4,,1,1,,,\n";
		nodeStr += "6,NULL,,4,,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(PHPBreakStatement.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((PHPBreakStatement)node).getDepth());
	}
	
	/**
	 * while (1)
	 *   continue;
	 */
	@Test
	public void testMinimalContinueStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,integer,,3,1,0,1,,,\n";
		nodeStr += "5,AST_CONTINUE,,4,,1,1,,,\n";
		nodeStr += "6,NULL,,4,,0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(PHPContinueStatement.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((PHPContinueStatement)node).getDepth());
	}


	/* nodes with exactly 2 children */
	
	/**
	 * function foo() {
	 *   yield;
	 * }
	 */
	@Test
	public void testMinimalYieldCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_FUNC_DECL,,3,,0,1,5,foo,\n";
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,NULL,,3,,1,3,,,\n";
		nodeStr += "6,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "7,AST_YIELD,,4,,0,3,,,\n";
		nodeStr += "8,NULL,,4,,0,3,,,\n";
		nodeStr += "9,NULL,,4,,1,3,,,\n";
		nodeStr += "10,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "7,9,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(PHPYieldExpression.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((PHPYieldExpression)node).getValue());
		assertNull( ((PHPYieldExpression)node).getKey());
	}
	
	/**
	 * while($foo);
	 * while($foo) bar();
	 */
	@Test
	public void testMinimalWhileCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,NULL,,3,,1,1,,,\n";
		nodeStr += "7,AST_WHILE,,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "10,AST_CALL,,4,,1,1,,,\n";
		nodeStr += "11,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "12,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "13,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);

		assertThat( node, instanceOf(WhileStatement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((WhileStatement)node).getStatement());

		assertThat( node2, instanceOf(WhileStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertThat( ((WhileStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((WhileStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)10), ((ExpressionStatement)((WhileStatement)node2).getStatement()).getExpression());
	}

	/**
	 * do ; while($foo);
	 * do bar(); while($foo);
	 */
	@Test
	public void testMinimalDoCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_DO_WHILE,,3,,0,1,,,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "6,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "7,AST_DO_WHILE,,4,,1,1,,,\n";
		nodeStr += "8,AST_CALL,,4,,0,1,,,\n";
		nodeStr += "9,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "10,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "11,AST_ARG_LIST,,4,,1,1,,,\n";
		nodeStr += "12,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "13,string,,4,\"foo\",0,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "7,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)7);
		
		assertThat( node, instanceOf(DoStatement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((DoStatement)node).getStatement());

		assertThat( node2, instanceOf(DoStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertThat( ((DoStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((DoStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)8), ((ExpressionStatement)((DoStatement)node2).getStatement()).getExpression());
	}
	
	/**
	 * if(true) ;
	 * else ;
	 * if(true) foo();
	 * else bar();
	 */
	@Test
	public void testMinimalIfElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_IF,,3,,0,1,,,\n";
		nodeStr += "4,AST_IF_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "6,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "7,string,,3,\"true\",0,1,,,\n";
		nodeStr += "8,NULL,,3,,1,1,,,\n";
		nodeStr += "9,AST_IF_ELEM,,4,,1,1,,,\n";
		nodeStr += "10,NULL,,4,,0,1,,,\n";
		nodeStr += "11,NULL,,4,,1,1,,,\n";
		nodeStr += "12,AST_IF,,5,,1,1,,,\n";
		nodeStr += "13,AST_IF_ELEM,,5,,0,1,,,\n";
		nodeStr += "14,AST_CONST,,5,,0,1,,,\n";
		nodeStr += "15,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "16,string,,5,\"true\",0,1,,,\n";
		nodeStr += "17,AST_CALL,,5,,1,1,,,\n";
		nodeStr += "18,AST_NAME,NAME_NOT_FQ,5,,0,1,,,\n";
		nodeStr += "19,string,,5,\"foo\",0,1,,,\n";
		nodeStr += "20,AST_ARG_LIST,,5,,1,1,,,\n";
		nodeStr += "21,AST_IF_ELEM,,6,,1,1,,,\n";
		nodeStr += "22,NULL,,6,,0,1,,,\n";
		nodeStr += "23,AST_CALL,,6,,1,1,,,\n";
		nodeStr += "24,AST_NAME,NAME_NOT_FQ,6,,0,1,,,\n";
		nodeStr += "25,string,,6,\"bar\",0,1,,,\n";
		nodeStr += "26,AST_ARG_LIST,,6,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,8,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "9,11,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "15,16,PARENT_OF\n";
		edgeStr += "14,15,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "18,19,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "17,20,PARENT_OF\n";
		edgeStr += "13,17,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "21,22,PARENT_OF\n";
		edgeStr += "24,25,PARENT_OF\n";
		edgeStr += "23,24,PARENT_OF\n";
		edgeStr += "23,26,PARENT_OF\n";
		edgeStr += "21,23,PARENT_OF\n";
		edgeStr += "12,21,PARENT_OF\n";
		edgeStr += "2,12,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		ASTNode node2 = ast.getNodeById((long)9);
		ASTNode node3 = ast.getNodeById((long)13);
		ASTNode node4 = ast.getNodeById((long)21);
		
		assertThat( node, instanceOf(PHPIfElement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((PHPIfElement)node).getStatement());

		assertThat( node2, instanceOf(PHPIfElement.class));
		assertEquals( 2, node2.getChildCount());
		assertNull( ((PHPIfElement)node2).getCondition());
		assertNull( ((PHPIfElement)node2).getStatement());
		
		assertThat( node3, instanceOf(PHPIfElement.class));
		assertEquals( 2, node3.getChildCount());
		assertThat( ((PHPIfElement)node3).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((PHPIfElement)node3).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)17), ((ExpressionStatement)((PHPIfElement)node3).getStatement()).getExpression());
		
		assertThat( node4, instanceOf(PHPIfElement.class));
		assertEquals( 2, node4.getChildCount());
		assertNull( ((PHPIfElement)node4).getCondition());
		assertThat( ((PHPIfElement)node4).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((PHPIfElement)node4).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)23), ((ExpressionStatement)((PHPIfElement)node4).getStatement()).getExpression());
	}
	
	/**
	 * switch ($j) {
	 *   default:
	 * }
	 */
	@Test
	public void testMinimalSwitchCaseCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "7,AST_SWITCH,,4,,1,1,,,\n";
		nodeStr += "8,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "9,string,,4,\"j\",0,1,,,\n";
		nodeStr += "10,AST_SWITCH_LIST,,5,,1,1,,,\n";
		nodeStr += "11,AST_SWITCH_CASE,,5,,0,1,,,\n";
		nodeStr += "12,NULL,,5,,0,1,,,\n";
		nodeStr += "13,AST_STMT_LIST,,5,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "11,13,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "7,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)11);
		
		assertThat( node, instanceOf(PHPSwitchCase.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((PHPSwitchCase)node).getValue());
	}
	
	/**
	 * class SomeClass {
	 *   use Foo;
	 * }
	 */
	@Test
	public void testMinimalUseTraitCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CLASS,,3,,0,1,5,SomeClass,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,AST_TOPLEVEL,TOPLEVEL_CLASS,3,,2,1,5,\"SomeClass\",\n";
		nodeStr += "7,AST_STMT_LIST,,3,,0,6,,,\n";
		nodeStr += "8,AST_USE_TRAIT,,4,,0,6,,,\n";
		nodeStr += "9,AST_NAME_LIST,,4,,0,6,,,\n";
		nodeStr += "10,AST_NAME,NAME_NOT_FQ,4,,0,6,,,\n";
		nodeStr += "11,string,,4,\"Foo\",0,6,,,\n";
		nodeStr += "12,NULL,,4,,1,6,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "9,10,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)8);
		
		assertThat( node, instanceOf(PHPUseTrait.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((PHPUseTrait)node).getTraitAdaptations());
	}
	
	/**
	 * use Foo\Bar;
	 */
	@Test
	public void testMinimalUseElementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_USE,T_CLASS,3,,0,1,,,\n";
		nodeStr += "4,AST_USE_ELEM,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"Foo\\Bar\",0,1,,,\n";
		nodeStr += "6,NULL,,3,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "4,6,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);

		assertThat( node, instanceOf(UseElement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((UseElement)node).getAlias());
	}


	/* nodes with exactly 3 children */
	
	/**
	 * true ?: "bar";
	 */
	@Test
	public void testMinimalConditionalCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CONDITIONAL,,3,,0,1,,,\n";
		nodeStr += "4,AST_CONST,,3,,0,1,,,\n";
		nodeStr += "5,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "6,string,,3,\"true\",0,1,,,\n";
		nodeStr += "7,NULL,,3,,1,1,,,\n";
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
		assertNull( ((ConditionalExpression)node).getTrueExpression());
	}

	/**
	 * try {}
	 * catch(Exception $e) {}
	 */
	@Test
	public void testMinimalTryCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_TRY,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_CATCH_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_CATCH,,4,,0,1,,,\n";
		nodeStr += "7,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "8,string,,4,\"Exception\",0,1,,,\n";
		nodeStr += "9,string,,4,\"e\",1,1,,,\n";
		nodeStr += "10,AST_STMT_LIST,,4,,2,1,,,\n";
		nodeStr += "11,NULL,,3,,2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "7,8,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "6,9,PARENT_OF\n";
		edgeStr += "6,10,PARENT_OF\n";
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,11,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		
		assertThat( node, instanceOf(TryStatement.class));
		assertEquals( 3, node.getChildCount());
		assertNull( ((TryStatement)node).getFinallyContent());
	}
	
	/**
	 * function foo($bar) {}
	 */
	@Test
	public void testMinimalParameterCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";
		nodeStr += "5,AST_PARAM,,3,,0,3,,,\n";
		nodeStr += "6,NULL,,3,,0,3,,,\n";
		nodeStr += "7,string,,3,\"bar\",1,3,,,\n";
		nodeStr += "8,NULL,,3,,2,3,,,\n";
		nodeStr += "9,NULL,,3,,1,3,,,\n";
		nodeStr += "10,AST_STMT_LIST,,3,,2,3,,,\n";
		nodeStr += "11,NULL,,3,,3,3,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "5,6,PARENT_OF\n";
		edgeStr += "5,7,PARENT_OF\n";
		edgeStr += "5,8,PARENT_OF\n";
		edgeStr += "4,5,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(PHPParameter.class));
		assertEquals( 3, node.getChildCount());
		assertNull( ((PHPParameter)node).getType());
		assertNull( ((PHPParameter)node).getDefault());
	}

	
	/* nodes with exactly 4 children */

	/**
	 * for (;;);
	 * for (;;) foo();
	 */
	@Test
	public void testMinimalForCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FOR,,3,,0,1,,,\n";
		nodeStr += "4,NULL,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,1,1,,,\n";
		nodeStr += "6,NULL,,3,,2,1,,,\n";
		nodeStr += "7,NULL,,3,,3,1,,,\n";
		nodeStr += "8,AST_FOR,,4,,1,1,,,\n";
		nodeStr += "9,NULL,,4,,0,1,,,\n";
		nodeStr += "10,NULL,,4,,1,1,,,\n";
		nodeStr += "11,NULL,,4,,2,1,,,\n";
		nodeStr += "12,AST_CALL,,4,,3,1,,,\n";
		nodeStr += "13,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "14,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "15,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,7,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "8,9,PARENT_OF\n";
		edgeStr += "8,10,PARENT_OF\n";
		edgeStr += "8,11,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "12,13,PARENT_OF\n";
		edgeStr += "12,15,PARENT_OF\n";
		edgeStr += "8,12,PARENT_OF\n";
		edgeStr += "2,8,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)8);

		assertThat( node, instanceOf(ForStatement.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((ForStatement)node).getForInitExpression());
		assertNull( ((ForStatement)node).getCondition());
		assertNull( ((ForStatement)node).getForLoopExpression());
		assertNull( ((ForStatement)node).getStatement());

		assertThat( node2, instanceOf(ForStatement.class));
		assertEquals( 4, node2.getChildCount());
		assertNull( ((ForStatement)node2).getForInitExpression());
		assertNull( ((ForStatement)node2).getCondition());
		assertNull( ((ForStatement)node2).getForLoopExpression());
		assertThat( ((ForStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((ForStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)12), ((ExpressionStatement)((ForStatement)node2).getStatement()).getExpression());
	}
	
	/**
	 * foreach ($somearray as $foo);
	 * foreach ($somearray as $foo) bar();
	 */
	@Test
	public void testMinimalForEachCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";
		nodeStr += "3,AST_FOREACH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"somearray\",0,1,,,\n";
		nodeStr += "6,AST_VAR,,3,,1,1,,,\n";
		nodeStr += "7,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "8,NULL,,3,,2,1,,,\n";
		nodeStr += "9,NULL,,3,,3,1,,,\n";
		nodeStr += "10,AST_FOREACH,,4,,1,1,,,\n";
		nodeStr += "11,AST_VAR,,4,,0,1,,,\n";
		nodeStr += "12,string,,4,\"somearray\",0,1,,,\n";
		nodeStr += "13,AST_VAR,,4,,1,1,,,\n";
		nodeStr += "14,string,,4,\"foo\",0,1,,,\n";
		nodeStr += "15,NULL,,4,,2,1,,,\n";
		nodeStr += "16,AST_CALL,,4,,3,1,,,\n";
		nodeStr += "17,AST_NAME,NAME_NOT_FQ,4,,0,1,,,\n";
		nodeStr += "18,string,,4,\"bar\",0,1,,,\n";
		nodeStr += "19,AST_ARG_LIST,,4,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "6,7,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";
		edgeStr += "3,8,PARENT_OF\n";
		edgeStr += "3,9,PARENT_OF\n";
		edgeStr += "2,3,PARENT_OF\n";
		edgeStr += "11,12,PARENT_OF\n";
		edgeStr += "10,11,PARENT_OF\n";
		edgeStr += "13,14,PARENT_OF\n";
		edgeStr += "10,13,PARENT_OF\n";
		edgeStr += "10,15,PARENT_OF\n";
		edgeStr += "17,18,PARENT_OF\n";
		edgeStr += "16,17,PARENT_OF\n";
		edgeStr += "16,19,PARENT_OF\n";
		edgeStr += "10,16,PARENT_OF\n";
		edgeStr += "2,10,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(ForEachStatement.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((ForEachStatement)node).getKeyVariable());
		assertNull( ((ForEachStatement)node).getStatement());
		
		assertThat( node2, instanceOf(ForEachStatement.class));
		assertEquals( 4, node2.getChildCount());
		assertNull( ((ForEachStatement)node2).getKeyVariable());
		assertThat( ((ForEachStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((ForEachStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)16), ((ExpressionStatement)((ForEachStatement)node2).getStatement()).getExpression());
	}


	/* nodes with an arbitrary number of children */

	/**
	 * foo();
	 */
	@Test
	public void testMinimalArgumentListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_CALL,,3,,0,1,,,\n";
		nodeStr += "4,AST_NAME,NAME_NOT_FQ,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"foo\",0,1,,,\n";
		nodeStr += "6,AST_ARG_LIST,,3,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(ArgumentList.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((ArgumentList)node).size());
	}
	
	/**
	 * Fun note: The following code was perfectly valid prior to PHP 7.
	 * Starting with PHP 7, it will throw a runtime exception.
	 * However, it will *parse* fine in all cases.
	 * 
	 * list() = array();
	 */
	@Test
	public void testMinimalListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ASSIGN,,3,,0,1,,,\n";
		nodeStr += "4,AST_LIST,,3,,0,1,,,\n";
		nodeStr += "5,NULL,,3,,0,1,,,\n";
		nodeStr += "6,AST_ARRAY,,3,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);

		assertThat( node, instanceOf(PHPListExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( 1, ((PHPListExpression)node).size());
		assertNull( ((PHPListExpression)node).getElement(0));
	}
	
	/**
	 * array();
	 */
	@Test
	public void testMinimalArrayCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_ARRAY,,3,,0,1,,,\n";

		String edgeStr = edgeHeader;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)3);

		assertThat( node, instanceOf(PHPArrayExpression.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((PHPArrayExpression)node).size());
	}
	
	/**
	 * <?php
	 */
	@Test
	public void testMinimalCompoundStatementCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;	
		nodeStr += "2,AST_STMT_LIST,,1,,0,1,,,\n";

		String edgeStr = edgeHeader;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)2);
		
		assertThat( node, instanceOf(CompoundStatement.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((CompoundStatement)node).getStatements().size());
	}
	
	/**
	 * switch ($i) {}
	 */
	@Test
	public void testMinimalSwitchListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_SWITCH,,3,,0,1,,,\n";
		nodeStr += "4,AST_VAR,,3,,0,1,,,\n";
		nodeStr += "5,string,,3,\"i\",0,1,,,\n";
		nodeStr += "6,AST_SWITCH_LIST,,3,,1,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "4,5,PARENT_OF\n";
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)6);
		
		assertThat( node, instanceOf(PHPSwitchList.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((PHPSwitchList)node).size());
	}
	
	/**
	 * try {}
	 * finally {}
	 */
	@Test
	public void testMinimalCatchListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "3,AST_TRY,,3,,0,1,,,\n";
		nodeStr += "4,AST_STMT_LIST,,3,,0,1,,,\n";
		nodeStr += "5,AST_CATCH_LIST,,3,,1,1,,,\n";
		nodeStr += "6,AST_STMT_LIST,,4,,2,1,,,\n";

		String edgeStr = edgeHeader;
		edgeStr += "3,4,PARENT_OF\n";
		edgeStr += "3,5,PARENT_OF\n";
		edgeStr += "3,6,PARENT_OF\n";

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)5);
		
		assertThat( node, instanceOf(CatchList.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((CatchList)node).size());
	}
	
	/**
	 * function foo() {}
	 */
	@Test
	public void testMinimalParameterListCreation() throws IOException, InvalidCSVFile
	{
		String nodeStr = nodeHeader;
		nodeStr += "4,AST_PARAM_LIST,,3,,0,3,,,\n";

		String edgeStr = edgeHeader;

		handle(nodeStr, edgeStr);

		ASTNode node = ast.getNodeById((long)4);
		
		assertThat( node, instanceOf(ParameterList.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((ParameterList)node).size());
	}
}
