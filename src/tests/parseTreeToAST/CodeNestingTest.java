package tests.parseTreeToAST;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import antlr.C.FunctionParser.StatementsContext;
import ast.declarations.ClassDefStatement;
import ast.declarations.IdentifierDecl;
import ast.expressions.Argument;
import ast.expressions.ArgumentList;
import ast.expressions.AssignmentExpr;
import ast.expressions.CallExpression;
import ast.statements.BlockStarter;
import ast.statements.CompoundStatement;
import ast.statements.ExpressionStatement;
import ast.statements.ForStatement;
import ast.statements.IdentifierDeclStatement;
import ast.statements.IfStatement;

public class CodeNestingTest
{

	@Test
	public void testLineNumbers()
	{
		String input = "if(foo)\nbar();\nfoo()\n";
		StatementsContext ctx = (StatementsContext) FunctionContentTestUtil
				.parse(input);
		assert (ctx.start.getLine() == 1);
		assert (ctx.stop.getLine() == 3);
	}

	@Test
	public void emptyContent()
	{
		String input = "";
		CompoundStatement item = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		assert (item.getStatements().size() == 0);
	}

	@Test
	public void compoundWithoutBlockStart()
	{
		String input = "bar(); {}";
		CompoundStatement item = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		assertTrue(item.getStatements().size() == 2);
	}

	@Test
	public void assignmentInCondition()
	{
		String input = "if(foo = bar){}";
		CompoundStatement item = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		BlockStarter starter = (BlockStarter) item.getStatements().get(0);
		AssignmentExpr condition = (AssignmentExpr) starter.getCondition()
				.getExpression();
		System.out.println(condition.getEscapedCodeStr());
		assertTrue(condition.getEscapedCodeStr().equals("foo = bar"));
	}

	@Test
	public void whileInElse()
	{
		String input = "if(foo){bar();}else{ while(foo1){ if(bar2){} } }";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IfStatement ifItem = (IfStatement) contentItem.getStatements().get(0);
	}

	@Test
	public void complexIfElseNesting()
	{
		String input = "if (A){ if (B){ } if (C){ } } else { }";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IfStatement ifItem = (IfStatement) contentItem.getStatements().get(0);
		assertTrue(ifItem.getElseNode() != null);
	}

	@Test
	public void testFor()
	{
		String input = "for(i = 0; i < 10; i++){}";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ForStatement forItem = (ForStatement) contentItem.getStatements()
				.get(0);

		String condExprString = forItem.getCondition().getExpression()
				.getEscapedCodeStr();
		System.out.println(condExprString);
		assertTrue(condExprString.equals("i < 10"));

	}

	@Test
	public void testDeclInFor()
	{
		String input = "for(int i = 0; i < 10; i++){}";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ForStatement forItem = (ForStatement) contentItem.getStatements()
				.get(0);

		System.out.println(forItem.getChildCount());

		String condExprString = forItem.getCondition().getExpression()
				.getEscapedCodeStr();
		assertTrue(condExprString.equals("i < 10"));

	}

	@Test
	public void testVarDeclName()
	{
		String input = "int x = 2*y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IdentifierDeclStatement declStatement = (IdentifierDeclStatement) contentItem
				.getStatements().get(0);
		IdentifierDecl decl = (IdentifierDecl) declStatement.getChild(0);
		assertTrue(decl.getName().getEscapedCodeStr().equals("x"));
	}

	@Test
	public void testVarDeclType()
	{
		String input = "int x = 2*y;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IdentifierDeclStatement declStatement = (IdentifierDeclStatement) contentItem
				.getStatements().get(0);
		IdentifierDecl decl = (IdentifierDecl) declStatement.getChild(0);
		System.out.println(decl.getType().getEscapedCodeStr());
		assertTrue(decl.getType().getEscapedCodeStr().equals("int"));
	}

	@Test
	public void testAssignment()
	{
		String input = "const char *m = \"Usage: untar [-tvx] [-f file] [file]\\n\";";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		IdentifierDeclStatement declStatement = (IdentifierDeclStatement) contentItem
				.getStatements().get(0);
		IdentifierDecl decl = (IdentifierDecl) declStatement.getChild(0);

		AssignmentExpr assign = (AssignmentExpr) decl.getChild(decl
				.getChildCount() - 1);
		assertTrue(assign.getLeft().getEscapedCodeStr().equals("m"));
		assertTrue(assign.getRight().getEscapedCodeStr()
				.equals("\"Usage: untar [-tvx] [-f file] [file]\\n\""));
	}

	@Test
	public void testDeclRightAfterStruct()
	{
		String input = "struct foo{ int x; } foo;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		assertTrue(contentItem.getChildCount() == 1);
		ClassDefStatement classDef = (ClassDefStatement) contentItem
				.getChild(0);
		assertTrue(classDef.getChildCount() == 1);
		IdentifierDecl decl = (IdentifierDecl) classDef.getChild(0);
		assertTrue(decl.getName().getEscapedCodeStr().equals("foo"));
	}

	@Test
	public void testCall()
	{
		String input = "foo(x);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement stmt = (ExpressionStatement) contentItem
				.getStatements().get(0);
		CallExpression expr = (CallExpression) stmt.getChild(0);
		assertTrue(expr.getTarget().getEscapedCodeStr().equals("foo"));
		ArgumentList argList = (ArgumentList) expr.getChild(1);
		Argument arg = (Argument) argList.getChild(0);
	}

	@Test
	public void testCallWithTwoArguments()
	{
		String input = "foo(x,y);";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		ExpressionStatement stmt = (ExpressionStatement) contentItem
				.getStatements().get(0);
		CallExpression expr = (CallExpression) stmt.getChild(0);
		assertTrue(expr.getTarget().getEscapedCodeStr().equals("foo"));
	}

	@Test
	public void testClassContent()
	{
		// TODO: implement content-parsing for classes defined inside functions
		String input = "struct foo{ int x; } foo;";
		CompoundStatement contentItem = (CompoundStatement) FunctionContentTestUtil
				.parseAndWalk(input);
		assertTrue(contentItem.getChildCount() == 1);
		ClassDefStatement classDef = (ClassDefStatement) contentItem
				.getChild(0);
		assertTrue(classDef.content.getChildCount() == 1);
		IdentifierDeclStatement declStmt = (IdentifierDeclStatement) classDef.content
				.getChild(0);
		assertTrue(declStmt.getChildCount() == 1);
	}

}
