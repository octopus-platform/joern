package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import main.CommandLine.CommandLineInterface;
import main.ModuleParser.ModuleParser;


public class CodeSensor {
    
	private static ModuleParser parser = new ModuleParser();
	private static CommandLineInterface cmd = new CommandLineInterface();
	
    public static void main(String[] args)
	{
    	cmd.parseCommandLine(args);
    	
    	try{
	    	List<String> filesToProcess = cmd.getFilesToProcess();
	    	processListOfFiles(filesToProcess);
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
	    }

	}

	private static void processListOfFiles(List<String> filesToProcess)
	{
		for(Iterator<String> i = filesToProcess.iterator(); i.hasNext();)
		{
			String filename = i.next();
			processSingleFile(filename);
		}
	}
	
    private static void processSingleFile(String filename)
    {
    	try{
    		System.out.println(filename);
    		parser.parseAndWalkFile(filename);
    	}catch(IOException ex){
    		System.err.println("Error processing file: " + filename);
    	}
    }
    
    
}
