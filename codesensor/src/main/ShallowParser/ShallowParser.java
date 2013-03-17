package main.ShallowParser;

import java.io.IOException;
import java.util.Stack;

import main.CommonParser;
import main.TokenSubStream;
import main.codeitems.CodeItemBuilder;
import main.processors.Processor;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class ShallowParser extends CommonParser
{
	
	protected ShallowParserContext context = null;
	public ShallowParseTreeListener listener = new ShallowParseTreeListener();
	
	public void setStack(Stack<CodeItemBuilder> aStack)
	{
		listener.setStack(aStack);;
	}
	
	public void setProcessor(Processor aProcessor)
	{
		listener.setProcessor(aProcessor);
	}
	
	public void parseAndWalkFile(String filename) throws IOException
	{
		initializeContextWithFile(filename);
		ParseTree tree = parseTokenStream(context.stream);
        walkParseTree(context.stream, tree);
	}

	private void initializeContextWithFile(String filename) throws IOException
	{
		context = new ShallowParserContext();
		context.filename = filename;
		context.stream = createTokenStreamFromFile(context.filename);
		listener.initializeContext(context);
	}
	
	private static TokenSubStream createTokenStreamFromFile(String filename)
			throws IOException
	{
		ANTLRInputStream input = new ANTLRFileStream(filename);
    	CodeSensorLexer lexer = new CodeSensorLexer(input);
        TokenSubStream tokens = new TokenSubStream(lexer);
		return tokens;
	}
	
	
	public void parseAndWalkStream(TokenSubStream stream)
	{
		initializeContextWithStream(stream);
		ParseTree tree = parseTokenStream(context.stream);
        walkParseTree(context.stream, tree);
	}
	
	private void initializeContextWithStream(TokenSubStream stream)
	{
		context = new ShallowParserContext();
		context.filename = null;
		context.stream = stream;
		listener.initializeContext(context);
	}

	private ParseTree parseTokenStream(TokenSubStream tokens)
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
	
	private void walkParseTree(TokenSubStream tokens,
			ParseTree tree)
	{
		ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
	}
	
}
