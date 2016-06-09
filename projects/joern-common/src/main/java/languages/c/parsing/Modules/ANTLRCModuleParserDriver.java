package languages.c.parsing.Modules;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import languages.c.antlr.ModuleLexer;
import languages.c.antlr.ModuleParser;
import parsing.ANTLRParserDriver;
import parsing.TokenSubStream;

public class ANTLRCModuleParserDriver extends ANTLRParserDriver
{

	public ANTLRCModuleParserDriver()
	{
		super();
		setListener(new CModuleParserTreeListener(this));
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
		} catch (RuntimeException ex)
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
