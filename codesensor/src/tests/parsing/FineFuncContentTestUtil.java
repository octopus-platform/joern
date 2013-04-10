package tests.parsing;



import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parsing.FineFunctionParser;
import parsing.TokenSubStream;

import antlr.FineFunctionGrammarLexer;
import astnodes.ASTNode;

public class FineFuncContentTestUtil {

	
	static ASTNode parseAndWalk(String input)
	{
		FineFunctionParser parser = new FineFunctionParser();		
		TokenSubStream tokens = tokenStreamFromString(input);
		parser.parseAndWalkStream(tokens);
		return parser.itemStack.peek().getItem();
	}
	
		
	static ParseTree parse(String input)
	{
		FineFunctionParser parser = new FineFunctionParser();
		return parser.parseString(input);
	}

	private static TokenSubStream tokenStreamFromString(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		FineFunctionGrammarLexer lex = new FineFunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return tokens;
	}
	
}
