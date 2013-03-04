package main;

import antlr.CodeSensorLexer;
import antlr.CodeSensorParser;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.*;
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
        ParseTree tree = parser.code();
        
        ParseTreeListener extractor = new ParseTreeListener(filename);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(extractor, tree);
    }
        
}
