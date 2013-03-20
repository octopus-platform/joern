package main;

import java.io.IOException;
import java.util.Stack;

import main.codeitems.CodeItemBuilder;
import main.processors.Processor;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

abstract public class CommonParser
{

	public CodeSensorParser parser;
	public CommonCodeSensorListener listener;
	protected CommonParserContext context = null;
	
	abstract public ParseTree parseTokenStream(TokenSubStream tokens);

	public CommonParser()
	{
		super();
	}
	
	public ParseTree parseAndWalkString(String input)
	{
		ParseTree tree = parseString(input);
		walkTree(tree);
		return tree;
	}
	
	public ParseTree parseString(String input)
	{
		char[] charArray = input.toCharArray();
		ANTLRInputStream inputStream = new ANTLRInputStream(charArray, charArray.length);
		CodeSensorLexer lex = new CodeSensorLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		ParseTree tree = parseTokenStream(tokens);
		return tree;
	}
	
	protected void walkTree(ParseTree tree)
	{
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
	}
	
	public void parseAndWalkStream(TokenSubStream tokens)
	{
		listener.filename = "";
		listener.stream = tokens;
		ParseTree tree = parseTokenStream(tokens);
		walkTree(tree);
	}
	
	protected static TokenSubStream createTokenStreamFromFile(String filename)
	throws IOException
	{
		ANTLRInputStream input = new ANTLRFileStream(filename);
    	CodeSensorLexer lexer = new CodeSensorLexer(input);
        TokenSubStream tokens = new TokenSubStream(lexer);
		return tokens;
	}
	
	public void parseAndWalkFile(String filename) throws IOException
	{
		TokenSubStream stream = createTokenStreamFromFile(filename);
		initializeContextWithFile(filename, stream);
		
		ParseTree tree = parseTokenStream(stream);
        walkTree(tree);
	}

	protected void initializeContextWithFile(String filename, TokenSubStream stream) throws IOException
	{
		context = new CommonParserContext();
		context.filename = filename;
		context.stream = stream;
		listener.initializeContext(context);
	}
	
	/*
	private void initializeContextWithStream(TokenSubStream stream)
	{
		context = new CommonParserContext();
		context.filename = null;
		context.stream = stream;
		listener.initializeContext(context);
	}
	*/
	
	public void setProcessor(Processor processor)
	{
		listener.setProcessor(processor);
	}
	
	public void setStack(Stack<CodeItemBuilder> aStack)
	{
		listener.setStack(aStack);;
	}
	
	protected static boolean isRecognitionException(RuntimeException ex)
	{
		return ex.getClass() == RuntimeException.class &&
				ex.getCause() instanceof RecognitionException;
	}

	protected static void setLLStarMode(Parser parser)
	{
		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
		parser.setErrorHandler(new DefaultErrorStrategy());
		parser.getInterpreter().setPredictionMode(PredictionMode.LL);
	}

	protected static void setSLLMode(Parser parser)
	{
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
	    parser.removeErrorListeners();
	    parser.setErrorHandler(new BailErrorStrategy());
	}

}