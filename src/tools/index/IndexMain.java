package tools.index;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import output.OutputModule;
import output.neo4j.Neo4JOutputModule;


public class IndexMain {

	private static CommandLineInterface cmd = new CommandLineInterface();
	private static SourceFileWalker sourceFileWalker = new SourceFileWalker();
	private static OutputModule outputModule = new Neo4JOutputModule();
	
    public static void main(String[] args)
	{
    	parseCommandLine(args);
    	String[] fileAndDirNames = getFileAndDirNamesFromCommandLine();
    	setupOutputModule();
    	
    	try{
    		sourceFileWalker.walk(fileAndDirNames);
	    }catch(IOException err){
			System.err.println("Error walking source files: " + err.getMessage()); 
	    }finally{
	    	shutdownOutputModule();
	    }
	}

	private static void parseCommandLine(String [] args)
	{
		try{
			cmd.parseCommandLine(args);
		} catch(RuntimeException | ParseException ex){
			printHelpAndTerminate(ex);
		}
	}

	private static void printHelpAndTerminate(Exception ex)
	{
		System.err.println(ex.getMessage());
		cmd.printHelp();
		System.exit(1);
	}
	
	private static String[] getFileAndDirNamesFromCommandLine()
	{
		return cmd.getFilenames();
	}

	private static void setupOutputModule()
    {
		String outputDir = cmd.getOutputDir();
		outputModule.initialize(outputDir); 	
    	sourceFileWalker.addListener(outputModule);
    }
	
    private static void shutdownOutputModule()
    {
    	outputModule.shutdown();
	}

}
