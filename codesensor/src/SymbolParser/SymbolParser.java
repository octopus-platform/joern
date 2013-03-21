package SymbolParser;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.CodeSensorParser;

import main.CommonParser;
import main.TokenSubStream;

public class SymbolParser extends CommonParser {

	@Override
	public ParseTree parseTokenStream(TokenSubStream tokens)
	{
		parser = new CodeSensorParser(tokens);
        ParseTree tree = null;
        
        try {
    		setSLLMode(parser);
        	tree = parser.symbols();
        } catch (RuntimeException ex) {
        	if (isRecognitionException(ex))
        	{
        		tokens.reset();
        		setLLStarMode(parser);
        		tree = parser.symbols();
        	}
        
        }
		return tree;
	}

}
