package tests.antlrParsers.moduleParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr.C.ModuleLexer;
import antlr.C.ModuleParser;

public class FunctionDefinitionTests
{

	protected ModuleParser createParser(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		ModuleLexer lex = new ModuleLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		ModuleParser parser = new ModuleParser(tokens);
		return parser;
	}

}
