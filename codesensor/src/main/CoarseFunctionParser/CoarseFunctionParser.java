package main.CoarseFunctionParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.SymbolsLexer;
import antlr.SymbolsParser;

import main.CommonParser;
import main.TokenSubStream;

public class CoarseFunctionParser extends CommonParser {

	public CoarseFunctionParser()
	{
		super();
		listener = new CoarseParseTreeListener(this);
	}

	@Override
	public Lexer createLexer(ANTLRInputStream input)
	{
		return new SymbolsLexer(input);
	}
	
	@Override
	public ParseTree parseTokenStream(TokenSubStream tokens)
	{
		parser = new SymbolsParser(tokens);
        SymbolsParser thisParser = (SymbolsParser) parser;
		ParseTree tree = null;
       
        try {
        	setSLLMode(parser);
        	tree = thisParser.coarse_content();
        } catch (RuntimeException ex) {
        	if (isRecognitionException(ex))
        	{
        		tokens.reset();
        		setLLStarMode(parser);
        		tree = thisParser.coarse_content();
        		
        	}
        	return tree;
        }
		return tree;
	}

}
