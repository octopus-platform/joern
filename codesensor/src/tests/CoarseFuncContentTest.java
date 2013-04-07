package tests;

import static org.junit.Assert.assertTrue;
import main.CoarseFunctionParser.CoarseFunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.declarations.IdentifierDecl;
import main.codeitems.expressions.CallExpression;
import main.codeitems.statements.CompoundItem;
import main.codeitems.statements.ExprStatementItem;
import main.codeitems.statements.IdentifierDeclStatement;

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
		assert(item.getStatements().size() == 0);
	}
	
	@Test
	public void testMostBasicCall()
	{
		String input = "foo();";
		CompoundItem contentItem = (CompoundItem) parseAndWalk(input);
		ExprStatementItem statementItem = (ExprStatementItem) contentItem.getStatements().get(0);
		CallExpression call = (CallExpression) statementItem.getExpression();
		assertTrue(call.getTarget().getCodeStr().equals("foo"));
	}
	
	@Test
	public void testMostBasicDecl()
	{
		String input = "int x;";
		CompoundItem contentItem = (CompoundItem) parseAndWalk(input);
		IdentifierDeclStatement statementItem = (IdentifierDeclStatement) contentItem.getStatements().get(0);
		IdentifierDecl identifierDecl = (IdentifierDecl) statementItem.getIdentifierDeclList().get(0);
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
