package parsing;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.statements.CompoundStatement;

public class FunctionParser
{
	ANTLRParserDriver driver;
	
	public FunctionParser(ANTLRParserDriver aDriver)
	{
		driver = aDriver;
	}
	
	public void parseAndWalkString(String input)
	{
		driver.parseAndWalkString(input);
	}

	public ParseTree parseString(String input) throws ParserException
	{
		return driver.parseString(input);
	}
	
	public void parseAndWalkTokenStream(TokenSubStream tokens)
			throws ParserException
	{
		driver.parseAndWalkTokenStream(tokens);
	}
	
	public Parser getAntlrParser()
	{
		return driver.getAntlrParser();
	}
	
	public ANTLRParserDriver getParser()
	{
		return driver;
	}
	
	
	public CompoundStatement getResult()
	{
		// The result is what's left on the stack in the end,
		// an AST rooted at a CompoundStatement node
		return driver.getResult();
	}

}
