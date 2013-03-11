package main;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.*;


public class CodeSensor {
    
	
    public static void main(String[] args) throws IOException
	{
	    try{
	    	
	    	CommandLineInterface cmd = new CommandLineInterface();
	    	cmd.parseCommandLine(args);
	    	
	    	List<String> filesToProcess = cmd.getFilesToProcess();
	    	
	    	for(Iterator<String> i = filesToProcess.iterator(); i.hasNext();){
	    		String filename = i.next();
	    		processFile(filename);
	    	}
	    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
    private static void processFile(String filename) throws IOException
    {
    	ANTLRInputStream input = new ANTLRFileStream(filename);
    	CodeSensorLexer lexer = new CodeSensorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeSensorParser parser = new CodeSensorParser(tokens);
        ParseTree tree = null;
        
        
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL); // try with simpler/faster SLL(*)
        // we don't want error messages or recovery during first try
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
        try {
        	tree = parser.code();
        	// if we get here, there was no syntax error and SLL(*) was enough;
        	// there is no need to try full LL(*)
        } catch (RuntimeException ex) {
        	if (ex.getClass() == RuntimeException.class &&
        			ex.getCause() instanceof RecognitionException)
        	{
        		// The BailErrorStrategy wraps the RecognitionExceptions in
        		// RuntimeExceptions so we have to make sure we're detecting
        		// a true RecognitionException not some other kind
        		tokens.reset(); // rewind input stream
        		// back to standard listeners/handlers
        		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
        		parser.setErrorHandler(new DefaultErrorStrategy());
        		parser.getInterpreter().setPredictionMode(PredictionMode.LL);
        		tree = parser.code();
        	}
        }
        
        ParseTreeListener extractor = new ParseTreeListener(filename);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(extractor, tree);
    }
        
}
