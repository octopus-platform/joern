package languages.c.parsing;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;

import ast.logical.statements.CompoundStatement;
import parsing.FunctionParser;
import languages.c.antlr.ModuleParser;
import languages.c.antlr.ModuleParser.Compound_statementContext;
import languages.c.antlr.ModuleParser.Function_defContext;
import languages.c.parsing.Functions.ANTLRCFunctionParserDriver;

public class ModuleFunctionParserInterface
{
	// Extracts compound statement from input stream
	// as a string and passes that string to the
	// function parser. The resulting 'CompoundStatement'
	// (an AST node) is returned.

	public static CompoundStatement parseFunctionContents(
			Function_defContext ctx)
	{
		String text = getCompoundStmtAsString(ctx);

		ANTLRCFunctionParserDriver driver = new ANTLRCFunctionParserDriver();
		FunctionParser parser = new FunctionParser(driver);

		try
		{
			parser.parseAndWalkString(text);
		}
		catch (RuntimeException ex)
		{
			System.err.println("Error parsing function "
					+ ctx.function_name().getText() + ". skipping.");

			// ex.printStackTrace();
		}
		CompoundStatement result = parser.getResult();
		result.initializeFromContext(ctx.compound_statement());
		return result;
	}

	private static String getCompoundStmtAsString(
			ModuleParser.Function_defContext ctx)
	{
		Compound_statementContext compound_statement = ctx.compound_statement();

		CharStream inputStream = compound_statement.start.getInputStream();
		int startIndex = compound_statement.start.getStopIndex();
		int stopIndex = compound_statement.stop.getStopIndex();
		return inputStream.getText(new Interval(startIndex + 1, stopIndex - 1));
	}

}
