package main.ShallowParser;

import java.io.IOException;

import main.CommonParser;
import main.TokenSubStream;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

public class ShallowParser extends CommonParser
{
	private ParserContext context = null;
	
	public void parseAndWalk(String filename) throws IOException
	{
		initializeContext(filename);
		ParseTree tree = parseTokenStream(context.stream);
        walkParseTree(context.stream, tree);
	}

	private void initializeContext(String filename) throws IOException
	{
		context = new ParserContext();
		context.filename = filename;
		context.stream = createTokenStreamFromFile(context.filename);
	}

	private static TokenSubStream createTokenStreamFromFile(String filename)
			throws IOException
	{
		ANTLRInputStream input = new ANTLRFileStream(filename);
    	CodeSensorLexer lexer = new CodeSensorLexer(input);
        TokenSubStream tokens = new TokenSubStream(lexer);
		return tokens;
	}
	
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
	
	private void walkParseTree(TokenSubStream tokens,
			ParseTree tree)
	{
		ShallowParseTreeListener listener = new ShallowParseTreeListener(context);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
	}
	
}
