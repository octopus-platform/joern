package parsing;



import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.FunctionLexer;
import antlr.FunctionParser;


public class FunctionParserDriver extends CommonParserDriver
{
	
	public FunctionParserDriver()
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
		setParser(new FunctionParser(tokens));
        FunctionParser thisParser = (FunctionParser) getParser();
		ParseTree tree = null;
        
        try {
    		setSLLMode(getParser());
        	tree = thisParser.statements();
        } catch (RuntimeException ex) {
        	if (isRecognitionException(ex))
        	{
        		tokens.reset();
        		setLLStarMode(getParser());
        		tree = thisParser.statements();
        	}
        
        }
		return tree;
	}

	
}
