package parsing;

import astnodes.statements.CompoundStatement;

public class FunctionParser
{
	CommonParser parser;

	public FunctionParser()
	{
		parser = new FineFunctionParser();
	}

	public void parseAndWalkStream(TokenSubStream tokens)
	{
		parser.parseAndWalkStream(tokens);
	}
	
	public void parseAndWalkString(String input)
	{
		parser.parseAndWalkString(input);
	}

	public CompoundStatement getResult()
	{
		// The result is what's left on the stack in the end
		return parser.getResult();
	}
	
	
}
