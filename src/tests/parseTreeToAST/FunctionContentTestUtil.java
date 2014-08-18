package tests.parseTreeToAST;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parsing.FunctionParser;
import parsing.TokenSubStream;
import parsing.C.Functions.ANTLRCFunctionParserDriver;
import antlr.C.FunctionLexer;
import ast.ASTNode;

public class FunctionContentTestUtil
{

	public static ASTNode parseAndWalk(String input)
	{
		ANTLRCFunctionParserDriver driver = new ANTLRCFunctionParserDriver();
		FunctionParser parser = new FunctionParser(driver);
		
		TokenSubStream tokens = tokenStreamFromString(input);
		parser.parseAndWalkTokenStream(tokens);
		return parser.getParser().builderStack.peek().getItem();
	}

	static ParseTree parse(String input)
	{
		ANTLRCFunctionParserDriver driver = new ANTLRCFunctionParserDriver();
		FunctionParser parser = new FunctionParser(driver);
		
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
