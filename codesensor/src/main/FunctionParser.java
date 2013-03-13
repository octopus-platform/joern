package main;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.CodeSensorLexer;
import antlr.FunctionGrammarParser;

public class FunctionParser extends CommonParser
{
	public void parse(String input)
	{
		ANTLRInputStream inputStream = new ANTLRInputStream(input);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		parse(tokens);
	}
	
	public void parse(TokenSubStream tokens)
	{
		ParseTree tree = parseTokenStream(tokens);
		
        if(tree == null)
        	return;
		        
        FunctionParseTreeListener listener = new FunctionParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
	}
	
	public ParseTree parseTokenStream(TokenSubStream tokens)
	{
		FunctionGrammarParser parser = new FunctionGrammarParser(tokens);
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
