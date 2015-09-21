package tests.antlrParsers.functionParser;

import languages.c.parsing.Functions.ANTLRCFunctionParserDriver;
import parsing.FunctionParser;

public class FunctionParserTestBase
{
	protected FunctionParser createFunctionParser()
	{
		ANTLRCFunctionParserDriver driver = new ANTLRCFunctionParserDriver();

		FunctionParser functionParser = new FunctionParser(driver);
		return functionParser;
	}

}
