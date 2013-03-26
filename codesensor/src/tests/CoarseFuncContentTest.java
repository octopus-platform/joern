package tests;

import static org.junit.Assert.*;

import main.TokenSubStream;
import main.CoarseFunctionParser.CoarseFunctionParser;
import main.codeitems.CodeItem;
import main.codeitems.expressions.CallItem;
import main.codeitems.functionContent.CompoundItem;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

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
		CallItem statementItem = (CallItem) contentItem.statements.get(0);
		assertTrue(statementItem.callee.equals("foo"));
	}
	
	static CodeItem parseAndWalk(String input)
	{
		CoarseFunctionParser parser = new CoarseFunctionParser();		
		TokenSubStream tokens = tokenStreamFromString(input);
		parser.parseAndWalkStream(tokens);
		return parser.itemStack.peek().getItem();
	}
		
	static ParseTree parse(String input)
	{
		CoarseFunctionParser parser = new CoarseFunctionParser();
		return parser.parseString(input);
	}

	private static TokenSubStream tokenStreamFromString(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CoarseFunctionGrammarLexer lex = new CoarseFunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return tokens;
	}
	
}
