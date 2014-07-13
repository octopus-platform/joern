package parsing;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.FunctionLexer;
import antlr.FunctionParser;

public class ANTLRFunctionParserDriver extends ANTLRParserDriver
{

	public ANTLRFunctionParserDriver()
	{
		super();
		setListener(new FunctionParseTreeListener(this));
	}

	@Override
	public Lexer createLexer(ANTLRInputStream input)
	{
		return new FunctionLexer(input);
	}

	@Override
	public ParseTree parseTokenStreamImpl(TokenSubStream tokens)
	{
		setAntlrParser(new FunctionParser(tokens));
		FunctionParser thisParser = (FunctionParser) getAntlrParser();
		ParseTree tree = null;

		try
		{
			setSLLMode(getAntlrParser());
			tree = thisParser.statements();
		}
		catch (RuntimeException ex)
		{
			if (isRecognitionException(ex))
			{
				tokens.reset();
				setLLStarMode(getAntlrParser());
				tree = thisParser.statements();
			}

		}
		return tree;
	}

}
