package main.FunctionParser;

import main.CommonParser;
import main.TokenSubStream;
import main.processors.Processor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class FunctionParser extends CommonParser
{
	public CodeSensorParser parser;
	public FunctionParseTreeListener listener = new FunctionParseTreeListener();
	
	public ParseTree parseAndWalk(String input)
	{
		ParseTree tree = parse(input);
		walkTree(tree);
		return tree;
	}

	public ParseTree parse(String input)
	{
		char[] charArray = input.toCharArray();
		ANTLRInputStream inputStream = new ANTLRInputStream(charArray, charArray.length);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		ParseTree tree = parse(tokens);
		return tree;
	}
	
	
	
	public ParseTree parse(TokenSubStream tokens)
	{
		ParseTree tree = parseTokenStream(tokens);
		
        if(tree == null)
        	return null;
        	
        return tree;
	}

	private void walkTree(ParseTree tree)
	{
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
	}
	
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

	public void setProcessor(Processor processor)
	{
		listener.setProcessor(processor);
	}

	public void parseAndWalkStream(TokenSubStream tokens)
	{
		ParseTree tree = parseTokenStream(tokens);
		walkTree(tree);
	}
}
