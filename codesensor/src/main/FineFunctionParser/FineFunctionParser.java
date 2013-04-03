package main.FineFunctionParser;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import tools.index.CommonParser;
import tools.index.TokenSubStream;
import antlr.FineFunctionGrammarLexer;
import antlr.FineFunctionGrammarParser;

public class FineFunctionParser extends CommonParser
{
	
	public FineFunctionParser()
	{
		super();
		setListener(new FineFunctionParseTreeListener(this));
	}
	
	@Override
	public Lexer createLexer(ANTLRInputStream input)
	{
		return new FineFunctionGrammarLexer(input);
	}
	
	@Override
	public ParseTree parseTokenStreamImpl(TokenSubStream tokens)
	{
		setParser(new FineFunctionGrammarParser(tokens));
        FineFunctionGrammarParser thisParser = (FineFunctionGrammarParser) getParser();
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
