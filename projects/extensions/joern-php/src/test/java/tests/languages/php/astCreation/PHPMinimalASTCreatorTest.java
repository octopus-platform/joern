package tests.languages.php.astCreation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.ArgumentList;
import ast.expressions.ConditionalExpression;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.php.declarations.ClassDef;
import ast.php.expressions.ArrayExpression;
import ast.php.expressions.ExitExpression;
import ast.php.expressions.ListExpression;
import ast.php.expressions.YieldExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.Method;
import ast.php.functionDef.FunctionDef;
import ast.php.functionDef.Parameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.blockstarters.IfElement;
import ast.php.statements.blockstarters.SwitchCase;
import ast.php.statements.blockstarters.SwitchList;
import ast.php.statements.blockstarters.UseTrait;
import ast.statements.ExpressionStatement;
import ast.statements.UseElement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForEachStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.BreakStatement;
import ast.statements.jump.ContinueStatement;
import ast.statements.jump.ReturnStatement;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVBasedTest;

/**
 * This class implements some tests similar to those in TestPHPCSVASTBuilder,
 * but re-implements those tests in a "minimal" way in that these tests try
 * to parse PHP code that generates as few child nodes as possible: e.g.,
 * classes that do not extend another class or implement any interfaces,
 * functions that do not take parameters or return anything, methods that
 * are abstract and unimplemented, etc. (whereas tests in TestPHPCSVASTBuilder
 * do the exact opposite and aim to generate every possible child for testing.)
 */
public class PHPMinimalASTCreatorTest extends PHPCSVBasedTest
{
	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "astCreation");
	}


	/* declaration nodes */

	/**
	 * <empty file>
	 */
	@Test
	public void testMinimalTopLevelFuncCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalTopLevelFunc");

		ASTNode node = ast.getNodeById((long)2);

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
		handleCSVFiles( "testMinimalFunctionDef");

		ASTNode node = ast.getNodeById((long)6);

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
		handleCSVFiles( "testMinimalClosure");

		ASTNode node = ast.getNodeById((long)6);

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
		handleCSVFiles( "testMinimalMethod");

		ASTNode node = ast.getNodeById((long)13);

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
		handleCSVFiles( "testMinimalClass");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ClassDef.class));
		assertEquals( 3, node.getChildCount());
		assertNull( ((ClassDef)node).getExtends());
		assertNull( ((ClassDef)node).getImplements());
	}


	/* nodes with exactly 1 child */

	/**
	 * exit;
	 */
	@Test
	public void testMinimalExitCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalExit");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ExitExpression.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((ExitExpression)node).getExpression());
	}

	/**
	 * function foo() {
	 *   return;
	 * }
	 */
	@Test
	public void testMinimalReturnCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalReturn");

		ASTNode node = ast.getNodeById((long)12);

		assertThat( node, instanceOf(ReturnStatement.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((ReturnStatement)node).getReturnExpression());
	}

	/**
	 * while (1)
	 *   break;
	 */
	@Test
	public void testMinimalBreakCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalBreak");

		ASTNode node = ast.getNodeById((long)8);

		assertThat( node, instanceOf(BreakStatement.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((BreakStatement)node).getDepth());
	}

	/**
	 * while (1)
	 *   continue;
	 */
	@Test
	public void testMinimalContinueCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalContinue");

		ASTNode node = ast.getNodeById((long)8);

		assertThat( node, instanceOf(ContinueStatement.class));
		assertEquals( 1, node.getChildCount());
		assertNull( ((ContinueStatement)node).getDepth());
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
		handleCSVFiles( "testMinimalYield");

		ASTNode node = ast.getNodeById((long)12);

		assertThat( node, instanceOf(YieldExpression.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((YieldExpression)node).getValue());
		assertNull( ((YieldExpression)node).getKey());
	}

	/**
	 * while($foo);
	 * while($foo) bar();
	 */
	@Test
	public void testMinimalWhileCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalWhile");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(WhileStatement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((WhileStatement)node).getStatement());

		assertThat( node2, instanceOf(WhileStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertThat( ((WhileStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((WhileStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)13), ((ExpressionStatement)((WhileStatement)node2).getStatement()).getExpression());
		// the expression wrapper should have the same node id as the expression itself
		assertEquals( Long.valueOf(13), ((ExpressionStatement)((WhileStatement)node2).getStatement()).getNodeId());
	}

	/**
	 * do ; while($foo);
	 * do bar(); while($foo);
	 */
	@Test
	public void testMinimalDoCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalDo");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(DoStatement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((DoStatement)node).getStatement());

		assertThat( node2, instanceOf(DoStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertThat( ((DoStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((DoStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)11), ((ExpressionStatement)((DoStatement)node2).getStatement()).getExpression());
		// the expression wrapper should have the same node id as the expression itself
		assertEquals( Long.valueOf(11), ((ExpressionStatement)((DoStatement)node2).getStatement()).getNodeId());
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
		handleCSVFiles( "testMinimalIf");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)12);
		ASTNode node3 = ast.getNodeById((long)16);
		ASTNode node4 = ast.getNodeById((long)24);

		assertThat( node, instanceOf(IfElement.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((IfElement)node).getStatement());

		assertThat( node2, instanceOf(IfElement.class));
		assertEquals( 2, node2.getChildCount());
		assertNull( ((IfElement)node2).getCondition());
		assertNull( ((IfElement)node2).getStatement());

		assertThat( node3, instanceOf(IfElement.class));
		assertEquals( 2, node3.getChildCount());
		assertThat( ((IfElement)node3).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((IfElement)node3).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)20), ((ExpressionStatement)((IfElement)node3).getStatement()).getExpression());
		// the expression wrapper should have the same node id as the expression itself
		assertEquals( Long.valueOf(20), ((ExpressionStatement)((IfElement)node3).getStatement()).getNodeId());

		assertThat( node4, instanceOf(IfElement.class));
		assertEquals( 2, node4.getChildCount());
		assertNull( ((IfElement)node4).getCondition());
		assertThat( ((IfElement)node4).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((IfElement)node4).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)26), ((ExpressionStatement)((IfElement)node4).getStatement()).getExpression());
		// the expression wrapper should have the same node id as the expression itself
		assertEquals( Long.valueOf(26), ((ExpressionStatement)((IfElement)node4).getStatement()).getNodeId());
	}

	/**
	 * switch ($i) {}
	 * switch ($j) {
	 *   default:
	 * }
	 */
	@Test
	public void testMinimalSwitchCaseCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalSwitch");

		ASTNode node = ast.getNodeById((long)14);

		assertThat( node, instanceOf(SwitchCase.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((SwitchCase)node).getValue());
	}

	/**
	 * class SomeClass {
	 *   use Foo;
	 * }
	 */
	@Test
	public void testMinimalUseTraitCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalUseTrait");

		ASTNode node = ast.getNodeById((long)13);

		assertThat( node, instanceOf(UseTrait.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((UseTrait)node).getTraitAdaptations());
	}

	/**
	 * use Foo\Bar;
	 */
	@Test
	public void testMinimalUseElementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalUse");

		ASTNode node = ast.getNodeById((long)7);

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
		handleCSVFiles( "testMinimalConditional");

		ASTNode node = ast.getNodeById((long)6);

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
		handleCSVFiles( "testMinimalTry");

		ASTNode node = ast.getNodeById((long)6);

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
		handleCSVFiles( "testMinimalParameter");

		ASTNode node = ast.getNodeById((long)10);

		assertThat( node, instanceOf(Parameter.class));
		assertEquals( 3, node.getChildCount());
		assertNull( ((Parameter)node).getType());
		assertNull( ((Parameter)node).getDefault());
	}


	/* nodes with exactly 4 children */

	/**
	 * for (;;);
	 * for (;;) foo();
	 */
	@Test
	public void testMinimalForCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalFor");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)11);

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
		assertEquals( ast.getNodeById((long)15), ((ExpressionStatement)((ForStatement)node2).getStatement()).getExpression());
		// the expression wrapper should have the same node id as the expression itself
		assertEquals( Long.valueOf(15), ((ExpressionStatement)((ForStatement)node2).getStatement()).getNodeId());
	}

	/**
	 * foreach ($somearray as $foo);
	 * foreach ($somearray as $foo) bar();
	 */
	@Test
	public void testMinimalForEachCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalForEach");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)13);

		assertThat( node, instanceOf(ForEachStatement.class));
		assertEquals( 4, node.getChildCount());
		assertNull( ((ForEachStatement)node).getKeyExpression());
		assertNull( ((ForEachStatement)node).getStatement());

		assertThat( node2, instanceOf(ForEachStatement.class));
		assertEquals( 4, node2.getChildCount());
		assertNull( ((ForEachStatement)node2).getKeyExpression());
		assertThat( ((ForEachStatement)node2).getStatement(), not(instanceOf(CompoundStatement.class)));
		assertThat( ((ForEachStatement)node2).getStatement(), instanceOf(ExpressionStatement.class));
		assertEquals( ast.getNodeById((long)19), ((ExpressionStatement)((ForEachStatement)node2).getStatement()).getExpression());
		// the expression wrapper should have the same node id as the expression itself
		assertEquals( Long.valueOf(19), ((ExpressionStatement)((ForEachStatement)node2).getStatement()).getNodeId());
	}


	/* nodes with an arbitrary number of children */

	/**
	 * foo();
	 */
	@Test
	public void testMinimalArgumentListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalArgumentList");

		ASTNode node = ast.getNodeById((long)9);

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
		handleCSVFiles( "testMinimalList");

		ASTNode node = ast.getNodeById((long)7);

		assertThat( node, instanceOf(ListExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( 1, ((ListExpression)node).size());
		assertNull( ((ListExpression)node).getElement(0));
	}

	/**
	 * array();
	 */
	@Test
	public void testMinimalArrayCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalArray");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ArrayExpression.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((ArrayExpression)node).size());
	}

	/**
	 * <?php
	 */
	@Test
	public void testMinimalCompoundStatementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalCompoundStatement");

		ASTNode node = ast.getNodeById((long)5);

		assertThat( node, instanceOf(CompoundStatement.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((CompoundStatement)node).getStatements().size());
	}

	/**
	 * switch ($i) {}
	 * switch ($j) {
	 *   default:
	 * }
	 */
	@Test
	public void testMinimalSwitchListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalSwitch");

		ASTNode node = ast.getNodeById((long)9);

		assertThat( node, instanceOf(SwitchList.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((SwitchList)node).size());
	}

	/**
	 * try {}
	 * finally {}
	 */
	@Test
	public void testMinimalCatchListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMinimalCatchList");

		ASTNode node = ast.getNodeById((long)8);

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
		handleCSVFiles( "testMinimalParameterList");

		ASTNode node = ast.getNodeById((long)9);

		assertThat( node, instanceOf(ParameterList.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( 0, ((ParameterList)node).size());
	}
}
