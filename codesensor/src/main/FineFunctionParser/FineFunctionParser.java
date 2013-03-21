package main.FineFunctionParser;

import main.CommonParser;
import main.TokenSubStream;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.CodeSensorParser;

public class FineFunctionParser extends CommonParser
{
	
	public FineFunctionParser()
	{
		super();
		listener = new FineFunctionParseTreeListener();
	}
	
	@Override
	public ParseTree parseTokenStream(TokenSubStream tokens)
	{
		parser = new CodeSensorParser(tokens);
        ParseTree tree = null;
        
        try {
    		setSLLMode(parser);
        	tree = parser.statements();
        } catch (RuntimeException ex) {
        	if (isRecognitionException(ex))
        	{
        		tokens.reset();
        		setLLStarMode(parser);
        		tree = parser.statements();
        	}
        
        }
		return tree;
	}
	
}
