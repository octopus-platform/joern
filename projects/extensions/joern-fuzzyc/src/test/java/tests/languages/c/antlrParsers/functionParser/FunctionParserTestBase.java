package tests.languages.c.antlrParsers.functionParser;

import parsing.FunctionParser;
import parsing.Functions.ANTLRCFunctionParserDriver;

public class FunctionParserTestBase
{
	protected FunctionParser createFunctionParser()
	{
		ANTLRCFunctionParserDriver driver = new ANTLRCFunctionParserDriver();

		FunctionParser functionParser = new FunctionParser(driver);
		return functionParser;
	}

}
