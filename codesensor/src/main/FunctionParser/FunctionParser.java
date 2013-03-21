package main.FunctionParser;

import CoarseFunctionParser.CoarseFunctionParser;
import main.CommonParser;
import main.TokenSubStream;
import main.FineFunctionParser.FineFunctionParser;

public class FunctionParser
{
	CommonParser parser;

	public FunctionParser()
	{
		parser = new CoarseFunctionParser();
	}

	public void enableFineParsing()
	{
		parser = new FineFunctionParser();
	}
	
	public void disableFineParsing()
	{
		parser = new CoarseFunctionParser();
	}
	
	public void parseAndWalkStream(TokenSubStream tokens)
	{
		parser.parseAndWalkStream(tokens);
	}
	
	public void parseAndWalkString(String input)
	{
		parser.parseAndWalkString(input);
	}
	
	
}
