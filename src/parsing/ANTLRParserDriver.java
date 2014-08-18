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

import ast.ASTNode;
import ast.ASTNodeBuilder;
import ast.statements.CompoundStatement;
import ast.walking.ASTWalkerEvent;

abstract public class ANTLRParserDriver extends Observable
{
	// TODO: This class does two things:
	// * It is a driver for the ANTLRParser, i.e., the parser
	// that creates ParseTrees from Strings. It can also already
	// 'walk' the ParseTree to create ASTs.
	// * It is an AST provider in that it will notify watchers
	// when ASTs are ready.
	// We should split this into two classes.

	public Stack<ASTNodeBuilder> builderStack = new Stack<ASTNodeBuilder>();
	public TokenSubStream stream;
	public String filename;

	private Parser antlrParser;
	private ParseTreeListener listener;
	private CommonParserContext context = null;

	abstract public ParseTree parseTokenStreamImpl(TokenSubStream tokens);

	abstract public Lexer createLexer(ANTLRInputStream input);

	public ANTLRParserDriver()
	{
		super();
	}

	public void parseAndWalkFile(String filename) throws ParserException
	{
		TokenSubStream stream = createTokenStreamFromFile(filename);
		initializeContextWithFile(filename, stream);

		ParseTree tree = parseTokenStream(stream);
		walkTree(tree);
	}

	public void parseAndWalkTokenStream(TokenSubStream tokens)
			throws ParserException
	{
		filename = "";
		stream = tokens;
		ParseTree tree = parseTokenStream(tokens);
		walkTree(tree);
	}

	public ParseTree parseAndWalkString(String input) throws ParserException
	{
		ParseTree tree = parseString(input);
		walkTree(tree);
		return tree;
	}

	public ParseTree parseTokenStream(TokenSubStream tokens)
			throws ParserException
	{
		ParseTree returnTree = parseTokenStreamImpl(tokens);
		if (returnTree == null)
			throw new ParserException();
		return returnTree;
	}

	public ParseTree parseString(String input) throws ParserException
	{
		char[] charArray = input.toCharArray();
		ANTLRInputStream inputStream = new ANTLRInputStream(charArray,
				charArray.length);
		Lexer lex = createLexer(inputStream);
		TokenSubStream tokens = new TokenSubStream(lex);
		ParseTree tree = parseTokenStream(tokens);
		return tree;
	}

	protected TokenSubStream createTokenStreamFromFile(String filename)
			throws ParserException
	{

		ANTLRInputStream input;
		try
		{
			input = new ANTLRFileStream(filename);
		}
		catch (IOException e)
		{
			throw new ParserException();
		}

		Lexer lexer = createLexer(input);
		TokenSubStream tokens = new TokenSubStream(lexer);
		return tokens;

	}

	protected void walkTree(ParseTree tree)
	{
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(getListener(), tree);
	}

	protected void initializeContextWithFile(String filename,
			TokenSubStream stream)
	{
		setContext(new CommonParserContext());
		getContext().filename = filename;
		getContext().stream = stream;
		initializeContext(getContext());
	}

	protected boolean isRecognitionException(RuntimeException ex)
	{

		return ex.getClass() == ParseCancellationException.class
				&& ex.getCause() instanceof RecognitionException;
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
		builderStack = aStack;
	}

	// //////////////////

	public void begin()
	{
		notifyObserversOfBegin();
	}

	public void end()
	{
		notifyObserversOfEnd();
	}

	private void notifyObserversOfBegin()
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.BEGIN);
		setChanged();
		notifyObservers(event);
	}

	private void notifyObserversOfEnd()
	{
		ASTWalkerEvent event = new ASTWalkerEvent(ASTWalkerEvent.eventID.END);
		setChanged();
		notifyObservers(event);
	}

	public void notifyObserversOfUnitStart(ParserRuleContext ctx)
	{
		ASTWalkerEvent event = new ASTWalkerEvent(
				ASTWalkerEvent.eventID.START_OF_UNIT);
		event.ctx = ctx;
		event.filename = filename;
		setChanged();
		notifyObservers(event);
	}

	public void notifyObserversOfUnitEnd(ParserRuleContext ctx)
	{
		ASTWalkerEvent event = new ASTWalkerEvent(
				ASTWalkerEvent.eventID.END_OF_UNIT);
		event.ctx = ctx;
		event.filename = filename;
		setChanged();
		notifyObservers(event);
	}

	public void notifyObserversOfItem(ASTNode aItem)
	{
		ASTWalkerEvent event = new ASTWalkerEvent(
				ASTWalkerEvent.eventID.PROCESS_ITEM);
		event.item = aItem;
		event.itemStack = builderStack;
		setChanged();
		notifyObservers(event);
	}

	public CompoundStatement getResult()
	{
		return (CompoundStatement) builderStack.peek().getItem();
	}

	public Parser getAntlrParser()
	{
		return antlrParser;
	}

	public void setAntlrParser(Parser aParser)
	{
		antlrParser = aParser;
	}

	public ParseTreeListener getListener()
	{
		return listener;
	}

	public void setListener(ParseTreeListener listener)
	{
		this.listener = listener;
	}

	public CommonParserContext getContext()
	{
		return context;
	}

	public void setContext(CommonParserContext context)
	{
		this.context = context;
	}

}