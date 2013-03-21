package main.FunctionParser;

import CoarseFunctionParser.CoarseFunctionParser;
import main.CommonParser;
import main.FineFunctionParser.FineFunctionParser;

public class FunctionParser
{
	CommonParser parser;

	FunctionParser()
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
	
}
