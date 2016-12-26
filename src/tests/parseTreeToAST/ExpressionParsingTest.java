package tests.parseTreeToAST;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ast.declarations.IdentifierDecl;
import ast.expressions.AdditiveExpression;
import ast.expressions.AndExpression;
import ast.expressions.AssignmentExpr;
import ast.expressions.BitAndExpression;
import ast.expressions.CallExpression;
import ast.expressions.CastExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.EqualityExpression;
import ast.expressions.ExclusiveOrExpression;
import ast.expressions.InclusiveOrExpression;
import ast.expressions.MultiplicativeExpression;
import ast.expressions.OrExpression;
import ast.expressions.RelationalExpression;
import ast.expressions.ShiftExpression;
import ast.statements.BlockStarter;
import ast.statements.CompoundStatement;
import ast.statements.ExpressionStatement;
import ast.statements.IdentifierDeclStatement;

public class ExpressionParsingTest
{

	@Test
	public void testMostBasicAssignment()
	{
		String input = "x = y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.getExpression();

		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
		assertTrue(expr.getRight().getEscapedCodeStr().equals("y"));
	}

	@Test
	public void testBasicAssignmentChain()
	{
		String input = "x = y = z;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
		assertTrue(expr.getRight().getEscapedCodeStr().equals("y = z"));
	}

	@Test
	public void testMostBasicLocalVar()
	{
		String input = "int x;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IdentifierDeclStatement statementItem = (IdentifierDeclStatement) contentItem
				.getStatements().get(0);
		IdentifierDecl identifierDecl = (IdentifierDecl) statementItem
				.getIdentifierDeclList().get(0);
		assertTrue(identifierDecl.getName().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void testConditionalExpr()
	{
		String input = "foo = cond? x : y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.getExpression();
		ConditionalExpression right = (ConditionalExpression) expr.getRight();
		assertTrue(right.getChild(0).getEscapedCodeStr().equals("cond"));
	}

	@Test
	public void testOrExpr()
	{
		String input = "x || y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		OrExpression expr = (OrExpression) statementItem.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void testAndExpr()
	{
		String input = "x && y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		AndExpression expr = (AndExpression) statementItem.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void testInclusiveOrExpr()
	{
		String input = "x | y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		InclusiveOrExpression expr = (InclusiveOrExpression) statementItem
				.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void testExclusiveOrExpr()
	{
		String input = "x ^ y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement statementItem = (ExpressionStatement) contentItem
				.getStatements().get(0);
		ExclusiveOrExpression expr = (ExclusiveOrExpression) statementItem
				.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void testBitAndExpr()
	{
		String input = "if(x & y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		BitAndExpression expr = (BitAndExpression) starter.getCondition()
				.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void EqualityExpr()
	{
		String input = "if(x == y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		EqualityExpression expr = (EqualityExpression) starter.getCondition()
				.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void RelationalExpr()
	{
		String input = "if(x < y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		RelationalExpression expr = (RelationalExpression) starter
				.getCondition().getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void ShiftExpr()
	{
		String input = "if(x >> y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		ShiftExpression expr = (ShiftExpression) starter.getCondition()
				.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void AdditiveExpr()
	{
		String input = "if(x + y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		AdditiveExpression expr = (AdditiveExpression) starter.getCondition()
				.getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void MultiplicativeExpr()
	{
		String input = "if(x * y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		MultiplicativeExpression expr = (MultiplicativeExpression) starter
				.getCondition().getExpression();
		assertTrue(expr.getLeft().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void CastExpr()
	{
		String input = "if((some_type) y){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		CastExpression expr = (CastExpression) starter.getCondition()
				.getExpression();
		assertTrue(expr.getCastTarget().getEscapedCodeStr().equals("some_type"));
	}

	@Test
	public void funCall()
	{
		String input = "if(foo()){};";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) contentItem.getStatements()
				.get(0);
		CallExpression expr = (CallExpression) starter.getCondition()
				.getExpression();
		assertTrue(expr.getTarget().getEscapedCodeStr().equals("foo"));
	}

}
