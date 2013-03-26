package main.ModuleParser;

import main.CommonParser;
import main.TokenSubStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class ModuleParser extends CommonParser
{	
	
	public ModuleParser()
	{
		super();
		listener = new ModuleParseTreeListener(this);
	}

	@Override
	public ParseTree parseTokenStream(TokenSubStream tokens)
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
