package tests;

import static org.junit.Assert.*;

import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.junit.Test;

public class FineFunctionParsingTest {

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
	
	@Test
	public void testMostBasicLocalVar()
	{
		String input = "int x;";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		IdentifierDeclStatement statementItem = (IdentifierDeclStatement) contentItem.statements.get(0);
		IdentifierDecl identifierDecl = statementItem.identifierDeclList.get(0);
		assertTrue(identifierDecl.name.getCodeStr().equals("x"));
	}
	
}
