package parsing;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ModuleLexer;
import antlr.ModuleParser;

public class ANTLRModuleParserDriver extends ANTLRParserDriver
{

	public ANTLRModuleParserDriver()
	{
		super();
		setListener(new ModuleParserTreeListener(this));
	}

	@Override
	public ParseTree parseTokenStreamImpl(TokenSubStream tokens)
	{
		ModuleParser parser = new ModuleParser(tokens);
		ParseTree tree = null;

		try
		{
			setSLLMode(parser);
			tree = parser.code();
		}
		catch (RuntimeException ex)
		{
			if (isRecognitionException(ex))
			{
				tokens.reset();
				setLLStarMode(parser);
				tree = parser.code();
			}
		}
		return tree;
	}

	@Override
	public Lexer createLexer(ANTLRInputStream input)
	{
		return new ModuleLexer(input);
	}

}
