package main;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.FunctionGrammarLexer;
import antlr.FunctionGrammarParser;

public class FunctionParser extends CommonParser
{
	public FunctionGrammarParser parser;
	
	public ParseTree parse(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		FunctionGrammarLexer lex = new FunctionGrammarLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		return parse(tokens);
	}
	
	public ParseTree parse(TokenSubStream tokens)
	{
		ParseTree tree = parseTokenStream(tokens);
		
        if(tree == null)
        	return null;
		        
        FunctionParseTreeListener listener = new FunctionParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        return tree;
	}
	
	public ParseTree parseTokenStream(TokenSubStream tokens)
	{
		parser = new FunctionGrammarParser(tokens);
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
