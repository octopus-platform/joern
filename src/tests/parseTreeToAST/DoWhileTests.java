package tests.parseTreeToAST;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import astnodes.statements.CompoundStatement;
import astnodes.statements.DoStatement;

public class DoWhileTests
{

	@Test
	public void testDoWhile()
	{
		String input = "do{ foo(); }while(bar);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil.parseAndWalk(input);
		DoStatement doItem = (DoStatement) contentItem.getStatements().get(0);
		
		String condExprString = doItem.getCondition().getExpression().getEscapedCodeStr();
		assertTrue(condExprString.equals("bar"));
		
	}
	
	@Test
	public void testWhileInDoWhile()
	{
		String input = "do{ while(foo0) foo(); }while(bar);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil.parseAndWalk(input);
		DoStatement doItem = (DoStatement) contentItem.getStatements().get(0);
		
		String condExprString = doItem.getCondition().getExpression().getEscapedCodeStr();
		System.out.println(condExprString);
		assertTrue(condExprString.equals("bar"));
		
	}
	
	
}
