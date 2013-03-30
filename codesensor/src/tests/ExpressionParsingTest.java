package tests;

import static org.junit.Assert.*;

import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.AndExpression;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.BitAndExpression;
import main.codeitems.expressions.ConditionalExpression;
import main.codeitems.expressions.ExclusiveOrExpression;
import main.codeitems.expressions.InclusiveOrExpression;
import main.codeitems.expressions.OrExpression;
import main.codeitems.functionContent.BlockStarterItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.junit.Test;

public class ExpressionParsingTest {

	@Test
	public void testMostBasicAssignment()
	{
		String input = "x = y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.expr;
	
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
		assertTrue(expr.getRight().getCodeStr().equals("y"));
	}

	@Test
	public void testBasicAssignmentChain()
	{
		String input = "x = y = z;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.expr;
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
		assertTrue(expr.getRight().getCodeStr().equals("y = z"));
	}
	
	@Test
	public void testMostBasicLocalVar()
	{
		String input = "int x;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		IdentifierDeclStatement statementItem = (IdentifierDeclStatement) contentItem.statements.get(0);
		IdentifierDecl identifierDecl = statementItem.identifierDeclList.get(0);
		assertTrue(identifierDecl.name.getCodeStr().equals("x"));
	}
	
	@Test
	public void testConditionalExpr()
	{
		String input = "foo = cond? x : y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.expr;
		ConditionalExpression right = (ConditionalExpression) expr.getRight();
		assertTrue(right.getCondition().getCodeStr().equals("cond"));
	}
	
	@Test
	public void testOrExpr()
	{
		String input = "x || y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		OrExpression expr = (OrExpression) statementItem.expr;
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
	@Test
	public void testAndExpr()
	{
		String input = "x && y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		AndExpression expr = (AndExpression) statementItem.expr;
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
	@Test
	public void testInclusiveOrExpr()
	{
		String input = "x | y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		InclusiveOrExpression expr = (InclusiveOrExpression) statementItem.expr;
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
	@Test
	public void testExclusiveOrExpr()
	{
		String input = "x ^ y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		ExclusiveOrExpression expr = (ExclusiveOrExpression) statementItem.expr;
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
	@Test
	public void testBitAndExpr()
	{
		String input = "if(x & y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		BitAndExpression expr = (BitAndExpression) starter.getCondition();
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
}
