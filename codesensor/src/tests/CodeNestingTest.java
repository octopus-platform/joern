package tests;

import static org.junit.Assert.*;

import main.codeitems.expressions.AssignmentExpr;
import main.codeitems.expressions.BinaryExpression;
import main.codeitems.expressions.Expression;
import main.codeitems.functionContent.BlockStarterItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.IfItem;

import org.junit.Test;

import antlr.FineFunctionGrammarParser.StatementsContext;

public class CodeNestingTest {

	@Test
	public void testLineNumbers()
	{
		String input = "if(foo)\nbar();\nfoo()\n";
		StatementsContext ctx = (StatementsContext) FineFuncContentTestUtil.parse(input);
		assert(ctx.start.getLine() == 1);
		assert(ctx.stop.getLine() == 3);
	}
	
	
	@Test
	public void emptyContent()
	{
		String input = "";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		assert(item.statements.size() == 0);
	}
	
	@Test
	public void compoundWithoutBlockStart()
	{
		String input = "bar(); {}";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.statements.size() == 2);
	}
	
	@Test
	public void ifBlockCompound()
	{
		String input = "if(foo){}";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.statements.size() == 1);
	}
	
	@Test
	public void ifBlockNoCompound()
	{
		String input = "if(foo) bar();";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.statements.size() == 1);
	}
	
	@Test
	public void NestedIfndefs()
	{
		String input = "#ifdef foo\n#else\n #ifdef foo\n#else\n#endif\n#endif";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.statements.size() == 0);
	}
	
	@Test
	public void nestedIfBlocksNoCompound()
	{
		String input = "if(foo) if(fooAgain) bar();";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.statements.size() == 1);
	}
	
	@Test
	public void condition()
	{
		String input = "if(foo){}";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) item.statements.get(0);
		Expression condition = starter.getCondition();
		System.out.println(condition.getCodeStr());
		assertTrue(condition.getCodeStr().equals("foo"));
	}
	
	@Test
	public void assignmentInCondition()
	{
		String input = "if(foo = bar){}";
		CompoundItem item = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarterItem starter = (BlockStarterItem) item.statements.get(0);
		AssignmentExpr condition = (AssignmentExpr) starter.getCondition();
		System.out.println(condition.getCodeStr());
		assertTrue(condition.getCodeStr().equals("foo = bar"));
	}
		
	@Test
	public void ifElse()
	{
		String input = "if(foo) foo(); else bar();";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		IfItem ifItem = (IfItem) contentItem.statements.get(0);
		
		System.out.println(contentItem.statements.size());
		
		assertTrue(ifItem.elseItem != null);
		assertTrue(contentItem.statements.size() == 1);
		
	}
	
	@Test
	public void testPreElseSkipping()
	{
		String input = "#if foo\n bar(); #else\n foo(); foo(); #endif";
		CompoundItem contentItem = (CompoundItem) FineFuncContentTestUtil.parseAndWalk(input);
		System.out.println(contentItem.statements.size());
		assertTrue(contentItem.statements.size() == 1);
	}

}
