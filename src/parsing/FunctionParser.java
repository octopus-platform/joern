package parsing;

import astnodes.statements.CompoundStatement;

public class FunctionParser
{
	ANTLRParserDriver parser;

	public FunctionParser()
	{
		parser = new ANTLRFunctionParserDriver();
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
