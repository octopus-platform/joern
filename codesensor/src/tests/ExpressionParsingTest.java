package tests;

import static org.junit.Assert.*;

import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.ConditionalExpression;
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
		assertTrue(right != null);
	}
	
}
