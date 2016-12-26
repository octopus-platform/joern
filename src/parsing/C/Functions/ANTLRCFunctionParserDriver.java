package parsing.C.Functions;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import parsing.ANTLRParserDriver;
import parsing.TokenSubStream;
import antlr.C.FunctionLexer;
import antlr.C.FunctionParser;

public class ANTLRCFunctionParserDriver extends ANTLRParserDriver
{
	
	public ANTLRCFunctionParserDriver()
	{
		super();
		CFunctionParseTreeListener listener = new CFunctionParseTreeListener();
		setListener(listener);
		listener.setDriver(this);
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
