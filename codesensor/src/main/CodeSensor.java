package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import main.CommandLine.CommandLineInterface;


public class CodeSensor {
	
	
	private static CommandLineInterface cmd = new CommandLineInterface();
	private static ExecutorService executor =  Executors.newFixedThreadPool(1);
	
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
			Runnable parsingTask = new FileParser(filename);
			executor.execute(parsingTask);
		}
		executor.shutdown();
	}
	    
}
