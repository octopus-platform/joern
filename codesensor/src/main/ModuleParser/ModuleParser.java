package main.ModuleParser;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import tools.index.CommonParser;
import tools.index.TokenSubStream;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class ModuleParser extends CommonParser
{	
	
	public ModuleParser()
	{
		super();
		setListener(new ModuleParseTreeListener(this));
	}

	@Override
	public ParseTree parseTokenStreamImpl(TokenSubStream tokens)
	{
		CodeSensorParser parser = new CodeSensorParser(tokens);
        ParseTree tree = null;
        
        try {
    		setSLLMode(parser);
        	tree = parser.code();
        } catch (RuntimeException ex) {
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
		return new CodeSensorLexer(input);
	}
	
}
