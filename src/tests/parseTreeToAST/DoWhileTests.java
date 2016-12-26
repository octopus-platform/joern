package tests.parseTreeToAST;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ast.statements.CompoundStatement;
import ast.statements.DoStatement;
import ast.statements.IfStatement;
import ast.statements.WhileStatement;

public class DoWhileTests
{

	@Test
	public void testDoWhile()
	{
		String input = "do{ foo(); }while(bar);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		DoStatement doItem = (DoStatement) contentItem.getStatements().get(0);

		String condExprString = doItem.getCondition().getExpression()
				.getEscapedCodeStr();
		assertTrue(condExprString.equals("bar"));

	}

	@Test
	public void testWhileInDoWhile()
	{
		String input = "do{ while(foo0) foo(); }while(bar);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		DoStatement doItem = (DoStatement) contentItem.getStatements().get(0);

		CompoundStatement doCompound = (CompoundStatement) doItem
				.getStatement();
		WhileStatement whileStatement = (WhileStatement) doCompound.getChild(0);
		assertTrue(whileStatement.getCondition() != null);

		String condExprString = doItem.getCondition().getExpression()
				.getEscapedCodeStr();
		assertTrue(condExprString.equals("bar"));

	}

	@Test
	public void testIfElseInDoWhile()
	{
		String input = "do{ if(foo)foo0(); else x++; }while(bar);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		DoStatement doItem = (DoStatement) contentItem.getStatements().get(0);

		String condExprString = doItem.getCondition().getExpression()
				.getEscapedCodeStr();
		assertTrue(condExprString.equals("bar"));
	}

	@Test
	public void testDoWhileInIf()
	{
		String input = "if(foo) do x++; while(bar); ";

		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IfStatement ifStatement = (IfStatement) contentItem.getStatements()
				.get(0);
		DoStatement doItem = (DoStatement) ifStatement.getStatement();

		String condExprString = doItem.getCondition().getExpression()
				.getEscapedCodeStr();
		assertTrue(condExprString.equals("bar"));
	}

	@Test
	public void testNestedDoWhile()
	{
		String input = "do{ do foo(); while(x); }while(bar);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		DoStatement doItem = (DoStatement) contentItem.getStatements().get(0);

		String condExprString = doItem.getCondition().getExpression()
				.getEscapedCodeStr();
		assertTrue(condExprString.equals("bar"));
	}

}
