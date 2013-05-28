package parsing;

import java.io.IOException;
import java.util.Observable;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.statements.CompoundStatement;
import astwalking.ASTWalkerEvent;


abstract public class CommonParser extends Observable
{

	public Stack<ASTNodeBuilder> itemStack = new Stack<ASTNodeBuilder>();
	public TokenSubStream stream;
	public String filename;
	
	private Parser parser;
	private ParseTreeListener listener;
	private CommonParserContext context = null;
	
	abstract public ParseTree parseTokenStreamImpl(TokenSubStream tokens);
	
	public ParseTree parseTokenStream(TokenSubStream tokens) throws ParserException
	{
		ParseTree returnTree = parseTokenStreamImpl(tokens);
		if(returnTree == null)
			throw new ParserException();
		return returnTree;
	}
	
	abstract public Lexer createLexer(ANTLRInputStream input);
	
	public CommonParser()
	{
		super();
	}
	
	public ParseTree parseAndWalkString(String input) throws ParserException
	{
		ParseTree tree = parseString(input);
		walkTree(tree);
		return tree;
	}
	
	public ParseTree parseString(String input) throws ParserException
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
        walker.walk(getListener(), tree);
	}
	
	public void parseAndWalkStream(TokenSubStream tokens) throws ParserException
	{
		filename = "";
		stream = tokens;
		ParseTree tree = parseTokenStream(tokens);
		walkTree(tree);
	}
	
	protected TokenSubStream createTokenStreamFromFile(String filename) throws ParserException
	{
		
		ANTLRInputStream input;
		try {
			input = new ANTLRFileStream(filename);
		} catch (IOException e) {
			throw new ParserException();
		}
    	
		Lexer lexer = createLexer(input);
        TokenSubStream tokens = new TokenSubStream(lexer);
		return tokens;
		
	}
	
	public void parseAndWalkFile(String filename) throws ParserException
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
	
	protected void initializeContextWithFile(String filename, TokenSubStream stream)
	{
		setContext(new CommonParserContext());
		getContext().filename = filename;
		getContext().stream = stream;
		initializeContext(getContext());
	}
	
	protected boolean isRecognitionException(RuntimeException ex)
	{
		
		return ex.getClass() == ParseCancellationException.class &&
			   ex.getCause() instanceof RecognitionException;
			
	
	}

	protected void setLLStarMode(Parser parser)
	{
		parser.removeErrorListeners();
		// parser.addErrorListener(ConsoleErrorListener.INSTANCE);
		parser.setErrorHandler(new DefaultErrorStrategy());
		// parser.getInterpreter().setPredictionMode(PredictionMode.LL);
	}

	protected void setSLLMode(Parser parser)
	{
		// parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
	    parser.removeErrorListeners();
	    parser.setErrorHandler(new BailErrorStrategy());
	}

	public void initializeContext(CommonParserContext context)
	{
		filename = context.filename;
		stream = context.stream;
	}
	
	public void setStack(Stack<ASTNodeBuilder> aStack)
	{
		itemStack = aStack;
	}
	
	
	public void begin()
	{
		notifyObserversOfBegin();
	}

	public void end()
	{
		notifyObserversOfEnd();
	}

	
	public void notifyObserversOfBegin()
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.BEGIN);
		setChanged();
		notifyObservers(event);
	}

	public void notifyObserversOfEnd()
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.END);
		setChanged();
		notifyObservers(event);
	}
	
	public void notifyObserversOfUnitStart(ParserRuleContext ctx)
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.START_OF_UNIT);
		event.ctx = ctx;
		event.filename = filename;
		setChanged();
		notifyObservers(event);
	}
	
	public void notifyObserversOfUnitEnd(ParserRuleContext ctx)
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.END_OF_UNIT);
		event.ctx = ctx;
		event.filename = filename;
		setChanged();
		notifyObservers(event);
	}
	
	public void notifyObserversOfItem(ASTNode aItem)
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.PROCESS_ITEM);
		event.item = aItem;
		event.itemStack = itemStack;
		setChanged();
		notifyObservers(event);
	}
	
	public CompoundStatement getResult()
	{
		return (CompoundStatement) itemStack.peek().getItem();
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public ParseTreeListener getListener() {
		return listener;
	}

	public void setListener(ParseTreeListener listener) {
		this.listener = listener;
	}

	public CommonParserContext getContext() {
		return context;
	}

	public void setContext(CommonParserContext context) {
		this.context = context;
	}

}