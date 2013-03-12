package main;

import antlr.CodeSensorLexer;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.*;

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
    	TokenSubStream tokens = createTokenStreamFromFile(filename);
        ShallowParser parser = new ShallowParser();
        parser.parse(filename, tokens);
    }
    
    private static TokenSubStream createTokenStreamFromFile(String filename)
			throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(filename);
    	CodeSensorLexer lexer = new CodeSensorLexer(input);
        TokenSubStream tokens = new TokenSubStream(lexer);
		return tokens;
	}
    
}
