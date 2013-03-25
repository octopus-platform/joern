package main;

import java.io.IOException;
import java.util.Stack;

import main.codeitems.CodeItemBuilder;
import main.processors.CSVPrinter;
import main.processors.Processor;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


abstract public class CommonParser
{

	public Parser parser;
	public ParseTreeListener listener;
	public CommonParserContext context = null;
	
	public Stack<CodeItemBuilder> itemStack = new Stack<CodeItemBuilder>();
	public Processor processor = new CSVPrinter();
	public TokenSubStream stream;
	public String filename;
	
	abstract public ParseTree parseTokenStream(TokenSubStream tokens);
	
	abstract public Lexer createLexer(ANTLRInputStream input);
	
	
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
		Lexer lex = createLexer(inputStream);
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
		filename = "";
		stream = tokens;
		ParseTree tree = parseTokenStream(tokens);
		walkTree(tree);
	}
	
	protected TokenSubStream createTokenStreamFromFile(String filename)
	throws IOException
	{
		ANTLRInputStream input = new ANTLRFileStream(filename);
    	Lexer lexer = createLexer(input);
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

	public void parseAndANTLRFileStream(ANTLRFileStream input, String aFilename) throws IOException
	{
		filename = aFilename;
		Lexer lexer = createLexer(input);
        TokenSubStream stream = new TokenSubStream(lexer);
		initializeContextWithFile(filename, stream);
		ParseTree tree = parseTokenStream(stream);
        walkTree(tree);
	}
	
	protected void initializeContextWithFile(String filename, TokenSubStream stream) throws IOException
	{
		context = new CommonParserContext();
		context.filename = filename;
		context.stream = stream;
		initializeContext(context);
	}
	
	protected boolean isRecognitionException(RuntimeException ex)
	{
		// return ex.getClass() == RuntimeException.class &&
		//		ex.getCause() instanceof RecognitionException;
		
		return ex.getClass() == ParseCancellationException.class &&
			   ex.getCause() instanceof RecognitionException;
			
	
	}

	protected void setLLStarMode(Parser parser)
	{
		parser.removeErrorListeners();
		// parser.addErrorListener(ConsoleErrorListener.INSTANCE);
		parser.setErrorHandler(new DefaultErrorStrategy());
		parser.getInterpreter().setPredictionMode(PredictionMode.LL);
	}

	protected void setSLLMode(Parser parser)
	{
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
	    parser.removeErrorListeners();
	    parser.setErrorHandler(new BailErrorStrategy());
	}

	public void initializeContext(CommonParserContext context)
	{
		filename = context.filename;
		stream = context.stream;
	}
	
	public void setStack(Stack<CodeItemBuilder> aStack)
	{
		itemStack = aStack;
	}
	
	public void setProcessor(Processor aProcessor)
	{
		processor = aProcessor;
	}

	public Processor getProcessor() 
	{
		return processor;
	}
	
	public void begin()
	{
		processor.begin();
	}

	public void end()
	{
		processor.end();
	}

}