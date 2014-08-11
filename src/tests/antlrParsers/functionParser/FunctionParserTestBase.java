package tests.antlrParsers.functionParser;

import parsing.FunctionParser;
import parsing.C.Functions.ANTLRCFunctionParserDriver;
import parsing.C.Functions.CFunctionParseTreeListener;

public class FunctionParserTestBase
{
	protected FunctionParser createFunctionParser()
	{
		ANTLRCFunctionParserDriver driver = new ANTLRCFunctionParserDriver();
		CFunctionParseTreeListener listener = new CFunctionParseTreeListener();
		driver.setListener(listener);
		listener.setDriver(driver);
		
		FunctionParser functionParser = new FunctionParser(driver);
		return functionParser;
	}

}
