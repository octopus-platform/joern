package main;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


import antlr.CodeSensorParser;

public class ShallowParser {

	public void parse(String filename, TokenSubStream tokens)
	{
		ParseTree tree = parseTokenStream(tokens);
        ParseTreeListener listener = new ParseTreeListener(filename, tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        
	}
	
	private static ParseTree parseTokenStream(TokenSubStream tokens) {
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

	private static boolean isRecognitionException(RuntimeException ex) {
		return ex.getClass() == RuntimeException.class &&
				ex.getCause() instanceof RecognitionException;
	}

	private static void setLLStarMode(CodeSensorParser parser) {
		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
		parser.setErrorHandler(new DefaultErrorStrategy());
		parser.getInterpreter().setPredictionMode(PredictionMode.LL);
	}

	private static void setSLLMode(CodeSensorParser parser) {
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
	}
	
}
