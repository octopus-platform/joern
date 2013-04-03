package tests;

import static org.junit.Assert.*;

import main.CoarseFunctionParser.CoarseFunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.CallExpression;
import main.codeitems.expressions.CallItem;
import main.codeitems.functionContent.CompoundItem;
import main.codeitems.functionContent.ExprStatementItem;
import main.codeitems.functionContent.IdentifierDeclStatement;

import org.antlr.v4.runtime.ANTLRInputStream;

import org.junit.Test;

import tools.index.TokenSubStream;

import antlr.CoarseFunctionGrammarLexer;

public class CoarseFuncContentTest
{

	@Test
	public void emptyContent()
	{
		String input = "";
		CompoundItem item = (CompoundItem) parseAndWalk(input);
		assert(item.statements.size() == 0);
	}
	
	@Test
	public void testMostBasicCall()
	{
		String input = "foo();";
		CompoundItem contentItem = (CompoundItem) parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.statements.get(0);
		CallExpression call = (CallExpression) statementItem.expr;
		assertTrue(call.getTarget().getCodeStr().equals("foo"));
	}
	
	@Test
	public void testMostBasicDecl()
	{
		String input = "int x;";
		CompoundItem contentItem = (CompoundItem) parseAndWalk(input);
		IdentifierDeclStatement statementItem = (IdentifierDeclStatement) contentItem.statements.get(0);
		IdentifierDecl identifierDecl = statementItem.identifierDeclList.get(0);
		assertTrue(identifierDecl.name.getCodeStr().equals("x"));
	}
	
	
	static CodeItem parseAndWalk(String input)
	{
		CoarseFunctionParser parser = new CoarseFunctionParser();		
		TokenSubStream tokens = tokenStreamFromString(input);
		parser.parseAndWalkStream(tokens);
		return parser.itemStack.peek().getItem();
	}
		

	private static TokenSubStream tokenStreamFromString(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CoarseFunctionGrammarLexer lex = new CoarseFunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return tokens;
	}
	
}
