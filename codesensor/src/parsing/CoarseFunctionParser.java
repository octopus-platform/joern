package parsing;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.CoarseFunctionGrammarLexer;
import antlr.CoarseFunctionGrammarParser;


public class CoarseFunctionParser extends CommonParser {

	public CoarseFunctionParser()
	{
		super();
		setListener(new CoarseParseTreeListener(this));
	}

	@Override
	public Lexer createLexer(ANTLRInputStream input)
	{
		return new CoarseFunctionGrammarLexer(input);
	}
	
	@Override
	public ParseTree parseTokenStreamImpl(TokenSubStream tokens)
	{
		setParser(new CoarseFunctionGrammarParser(tokens));
        CoarseFunctionGrammarParser thisParser = (CoarseFunctionGrammarParser) getParser();
		ParseTree tree = null;
       
        try {
        	setSLLMode(getParser());
        	tree = thisParser.coarse_content();
        } catch (RuntimeException ex) {
        	if (isRecognitionException(ex))
        	{
        		tokens.reset();
        		setLLStarMode(getParser());
        		tree = thisParser.coarse_content();
        		
        	}
        	return tree;
        }
		return tree;
	}

}
