package main.FineFunctionParser;

import main.CommonParser;
import main.TokenSubStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.FunctionGrammarLexer;
import antlr.FunctionGrammarParser;

public class FineFunctionParser extends CommonParser
{
	
	public FineFunctionParser()
	{
		super();
		listener = new FineFunctionParseTreeListener(this);
	}
	
	@Override
	public Lexer createLexer(ANTLRInputStream input)
	{
		return new FunctionGrammarLexer(input);
	}
	
	@Override
	public ParseTree parseTokenStream(TokenSubStream tokens)
	{
		parser = new FunctionGrammarParser(tokens);
        FunctionGrammarParser thisParser = (FunctionGrammarParser) parser;
		ParseTree tree = null;
        
        try {
    		setSLLMode(parser);
        	tree = thisParser.statements();
        } catch (RuntimeException ex) {
        	if (isRecognitionException(ex))
        	{
        		tokens.reset();
        		setLLStarMode(parser);
        		tree = thisParser.statements();
        	}
        
        }
		return tree;
	}

	
}
