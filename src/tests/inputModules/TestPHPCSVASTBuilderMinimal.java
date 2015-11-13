package tests.inputModules;

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
import ast.functionDef.FunctionDef;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.php.declarations.PHPClassDef;
import ast.php.functionDef.Closure;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPParameter;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.WhileStatement;
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
		
		assertThat( node, instanceOf(FunctionDef.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((FunctionDef)node).getReturnType());
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
	
	
	/* nodes with exactly 2 children */
	
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
	}


	/* nodes with exactly 3 children */
	
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
		// Note that ((PHPParameter)node).getDefault() is always non-null,
		// even when there is no default type. Technically, this is because
		// we allow arbitrary node types to designate the default value anyway,
		// including the null node (more generally, all plain nodes are fine)
		assertEquals( "NULL", ((PHPParameter)node).getDefault().getProperty("type"));
	}
	
	
	/* nodes with an arbitrary number of children */

	/**
	 * <empty file>
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
	}
}
