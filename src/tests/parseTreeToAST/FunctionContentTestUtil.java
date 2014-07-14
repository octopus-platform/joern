package tests.parseTreeToAST;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parsing.ANTLRFunctionParserDriver;
import parsing.TokenSubStream;
import antlr.FunctionLexer;
import astnodes.ASTNode;

public class FunctionContentTestUtil
{

	public static ASTNode parseAndWalk(String input)
	{
		ANTLRFunctionParserDriver parser = new ANTLRFunctionParserDriver();
		TokenSubStream tokens = tokenStreamFromString(input);
		parser.parseAndWalkTokenStream(tokens);
		return parser.builderStack.peek().getItem();
	}

	static ParseTree parse(String input)
	{
		ANTLRFunctionParserDriver parser = new ANTLRFunctionParserDriver();
		return parser.parseString(input);
	}

	private static TokenSubStream tokenStreamFromString(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		FunctionLexer lex = new FunctionLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return tokens;
	}

}
