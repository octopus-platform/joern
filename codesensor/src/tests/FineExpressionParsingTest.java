package tests;

import static org.junit.Assert.*;

import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ExprStatementItem;

import org.junit.Test;

public class FineExpressionParsingTest {

	@Test
	public void testMostBasicAssignment()
	{
		String input = "x = y;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.expr;
		assertTrue(expr.assignments.size() == 1);
	}

	@Test
	public void testBasicAssignmentChain()
	{
		String input = "x = y = z;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		AssignmentExpr expr = (AssignmentExpr) statementItem.expr;
		assertTrue(expr.assignments.size() == 2);
	}
	
}
