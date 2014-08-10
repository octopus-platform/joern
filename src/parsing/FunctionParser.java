package parsing;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import parsing.cFunctions.CFunctionParseTreeListener;
import ast.statements.CompoundStatement;

public class FunctionParser
{
	ANTLRParserDriver parser;

	public FunctionParser()
	{
		CFunctionParseTreeListener listener = new CFunctionParseTreeListener();
		parser = new ANTLRFunctionParserDriver(listener);
		listener.setDriver(parser);
	}

	public void parseAndWalkString(String input)
	{
		parser.parseAndWalkString(input);
	}

	public ParseTree parseString(String input) throws ParserException
	{
		return parser.parseString(input);
	}
	
	public void parseAndWalkTokenStream(TokenSubStream tokens)
			throws ParserException
	{
		parser.parseAndWalkTokenStream(tokens);
	}
	
	public Parser getAntlrParser()
	{
		return parser.getAntlrParser();
	}
	
	public ANTLRParserDriver getParser()
	{
		return parser;
	}
	
	
	public CompoundStatement getResult()
	{
		// The result is what's left on the stack in the end,
		// an AST rooted at a CompoundStatement node
		return parser.getResult();
	}

}
