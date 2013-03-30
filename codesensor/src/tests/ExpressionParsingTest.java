package tests;

import static org.junit.Assert.*;

import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.AdditiveExpression;
import main.codeitems.expressions.AndExpression;
import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.BitAndExpression;
import main.codeitems.expressions.CallExpression;
import main.codeitems.expressions.CallItem;
import main.codeitems.expressions.CastExpression;
import main.codeitems.expressions.ConditionalExpression;
import main.codeitems.expressions.EqualityExpression;
import main.codeitems.expressions.ExclusiveOrExpression;
import main.codeitems.expressions.FieldExpression;
import main.codeitems.expressions.InclusiveOrExpression;
import main.codeitems.expressions.MultiplicativeExpression;
import main.codeitems.expressions.OrExpression;
import main.codeitems.expressions.RelationalExpression;
import main.codeitems.expressions.ShiftExpression;
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
	
	@Test
	public void EqualityExpr()
	{
		String input = "if(x == y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		EqualityExpression expr = (EqualityExpression) starter.getCondition();
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
	@Test
	public void RelationalExpr()
	{
		String input = "if(x < y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		RelationalExpression expr = (RelationalExpression) starter.getCondition();
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}
	
	@Test
	public void ShiftExpr()
	{
		String input = "if(x >> y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		ShiftExpression expr = (ShiftExpression) starter.getCondition();
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}

	@Test
	public void AdditiveExpr()
	{
		String input = "if(x + y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		AdditiveExpression expr = (AdditiveExpression) starter.getCondition();
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}

	@Test
	public void MultiplicativeExpr()
	{
		String input = "if(x * y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		MultiplicativeExpression expr = (MultiplicativeExpression) starter.getCondition();
		assertTrue(expr.getLeft().getCodeStr().equals("x"));
	}

	
	@Test
	public void CastExpr()
	{
		String input = "if((some_type) y){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		CastExpression expr = (CastExpression) starter.getCondition();
		assertTrue(expr.getCastTarget().getCodeStr().equals("some_type"));
	}
	
	@Test
	public void funCall()
	{
		String input = "if(foo()){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		CallExpression expr = (CallExpression) starter.getCondition();
		assertTrue(expr.getTarget().getCodeStr().equals("foo"));
	}
	
	@Test
	public void fieldOnly()
	{
		String input = "if(foo->bar){};";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) contentItem.statements.get(0);
		FieldExpression expr = (FieldExpression) starter.getCondition();
		assertTrue(expr.getCodeStr().equals("foo -> bar"));
	}
	
}
