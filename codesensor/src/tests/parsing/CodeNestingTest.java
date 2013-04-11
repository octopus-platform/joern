package tests.parsing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import antlr.FineFunctionGrammarParser.StatementsContext;
import astnodes.ASTNode;
import astnodes.declarations.ClassDef;
import astnodes.declarations.IdentifierDecl;
import astnodes.expressions.Argument;
import astnodes.expressions.ArgumentList;
import astnodes.expressions.AssignmentExpr;
import astnodes.expressions.CallExpression;
import astnodes.expressions.Expression;
import astnodes.statements.BlockStarter;
import astnodes.statements.CompoundStatement;
import astnodes.statements.Condition;
import astnodes.statements.ExpressionStatement;
import astnodes.statements.ForStatement;
import astnodes.statements.IdentifierDeclStatement;
import astnodes.statements.IfStatement;


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
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assert(item.getStatements().size() == 0);
	}
	
	@Test
	public void compoundWithoutBlockStart()
	{
		String input = "bar(); {}";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 2);
	}
	
	@Test
	public void ifBlockCompound()
	{
		String input = "if(foo){}";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 1);
	}
	
	@Test
	public void ifBlockNoCompound()
	{
		String input = "if(foo) bar();";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 1);
	}
	
	@Test
	public void NestedIfndefs()
	{
		String input = "#ifdef foo\n#else\n #ifdef foo\n#else\n#endif\n#endif";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 0);
	}
	
	@Test
	public void nestedIfBlocksNoCompound()
	{
		String input = "if(foo) if(fooAgain) bar();";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 1);
	}
	
	@Test
	public void condition()
	{
		String input = "if(foo){}";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) item.getStatements().get(0);
		Expression condition = starter.getCondition().getExpression();
		System.out.println(condition.getCodeStr());
		assertTrue(condition.getCodeStr().equals("foo"));
	}
	
	@Test
	public void assignmentInCondition()
	{
		String input = "if(foo = bar){}";
		CompoundStatement item = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) item.getStatements().get(0);
		AssignmentExpr condition = (AssignmentExpr) starter.getCondition().getExpression();
		System.out.println(condition.getCodeStr());
		assertTrue(condition.getCodeStr().equals("foo = bar"));
	}
		
	@Test
	public void ifElse()
	{
		String input = "if(foo) lr->f = stdin; else lr->f = fopen(pathname, \"r\");";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		IfStatement ifItem = (IfStatement) contentItem.getStatements().get(0);
		
		System.out.println(contentItem.getStatements().size());
		
		assertTrue(ifItem.elseItem != null);
		assertTrue(ifItem.elseItem.getChild(1) != null);
		assertTrue(contentItem.getStatements().size() == 1);
	}
	
	@Test
	public void testIf()
	{
		String input = "if(a == b) foo();";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		IfStatement ifItem = (IfStatement) contentItem.getStatements().get(0);
		Condition condition = ifItem.getCondition();
		Expression expression = condition.getExpression();
		ASTNode firstChild = expression.getChild(0);
		assertTrue(firstChild.getChildCount() == 0);
	}

	@Test
	public void testFor()
	{
		String input = "for(i = 0; i < 10; i++){}";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		ForStatement forItem = (ForStatement) contentItem.getStatements().get(0);
		
		String condExprString = forItem.getCondition().getExpression().getCodeStr();
		assertTrue(condExprString.equals("i < 10"));
		
	}
	
	@Test
	public void testVarDeclName()
	{
		String input = "int x = 2*y;";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		IdentifierDeclStatement declStatement = (IdentifierDeclStatement) contentItem.getStatements().get(0);	
		IdentifierDecl decl = (IdentifierDecl) declStatement.getChild(0);
		assertTrue(decl.getName().getCodeStr().equals("x"));
	}	
	
	@Test
	public void testVarDeclType()
	{
		String input = "int x = 2*y;";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		IdentifierDeclStatement declStatement = (IdentifierDeclStatement) contentItem.getStatements().get(0);	
		IdentifierDecl decl = (IdentifierDecl) declStatement.getChild(0);
		System.out.println(decl.getType().getCodeStr());
		assertTrue(decl.getType().getCodeStr().equals("int"));
	}
	
	@Test
	public void testAssignment()
	{
		String input = "const char *m = \"Usage: untar [-tvx] [-f file] [file]\\n\";";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		IdentifierDeclStatement declStatement = (IdentifierDeclStatement) contentItem.getStatements().get(0);	
		IdentifierDecl decl = (IdentifierDecl) declStatement.getChild(0);	
		
		AssignmentExpr assign = (AssignmentExpr) decl.getChild(decl.getChildCount() -1);
		assertTrue(assign.getLeft().getCodeStr().equals("m"));
		assertTrue(assign.getRight().getCodeStr().equals("\"Usage: untar [-tvx] [-f file] [file]\\n\""));
	}
	
	@Test
	public void testDeclRightAfterStruct()
	{
		String input = "struct foo{ int x; } foo;";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(contentItem.getChildCount() == 1);
		ClassDef classDef = (ClassDef) contentItem.getChild(0);
		assertTrue(classDef.getChildCount() == 1);
		IdentifierDecl decl = (IdentifierDecl) classDef.getChild(0);
		assertTrue(decl.getName().getCodeStr().equals("foo"));
	}
	
	@Test
	public void testCall()
	{
		String input = "foo(x);";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		ExpressionStatement stmt = (ExpressionStatement) contentItem.getStatements().get(0);
		CallExpression expr = (CallExpression) stmt.getChild(0);
		assertTrue(expr.getTarget().getCodeStr().equals("foo"));
		ArgumentList argList = (ArgumentList) expr.getChild(1);
		Argument arg = (Argument) argList.getChild(0);
	}
	
	@Test
	public void testCallWithTwoArguments()
	{
		String input = "foo(x,y);";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		ExpressionStatement stmt = (ExpressionStatement) contentItem.getStatements().get(0);
		CallExpression expr = (CallExpression) stmt.getChild(0);
		assertTrue(expr.getTarget().getCodeStr().equals("foo"));
	}
	
	@Test
	public void testClassContent()
	{
		// TODO: implement content-parsing for classes defined inside functions
		String input = "struct foo{ int x; } foo;";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		assertTrue(contentItem.getChildCount() == 1);
		ClassDef classDef = (ClassDef) contentItem.getChild(0);
		assertTrue(classDef.content.getChildCount() == 1);
		IdentifierDeclStatement declStmt = (IdentifierDeclStatement) classDef.content.getChild(0);
		assertTrue(declStmt.getChildCount() == 1);
	}
	
	@Test
	public void testConditionalExpr()
	{
		String input = "for (int k = m; k < l; k += ((c = text[k]) >= sBMHCharSetSize) ? patlen : skip[c]){}";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		
		System.out.println(contentItem.getStatements().size());
		System.out.println(contentItem.getStatements().get(0).getClass());
		System.out.println(contentItem.getStatements().get(1).getClass());
		
		// BlockStarterItem forItem = (BlockStarterItem) contentItem.getStatements().get(0);
		// Condition condition = forItem.getCondition();
		// System.out.println(forItem.getChild(0).getCodeStr());
		// System.out.println(condition.getExpression().getCodeStr());
	}
		
	@Test
	public void testPreElseSkipping()
	{
		String input = "#if foo\n bar(); #else\n foo(); foo(); #endif";
		CompoundStatement contentItem = (CompoundStatement) FineFuncContentTestUtil.parseAndWalk(input);
		System.out.println(contentItem.getStatements().size());
		assertTrue(contentItem.getStatements().size() == 1);
	}

}
