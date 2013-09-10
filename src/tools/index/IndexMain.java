package tools.index;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import output.neo4j.Neo4JImportListener;


public class IndexMain {

	private static CommandLineInterface cmd = new CommandLineInterface();
	private static SourceFileWalker sourceFileWalker = new SourceFileWalker();
	private static Neo4JImportListener neo4jImportListener = new Neo4JImportListener();
	
    public static void main(String[] args)
	{
    	parseCommandLine(args);
    	String[] fileAndDirNames = getFileAndDirNamesFromCommandLine();
    	setupNeo4JListener();
    	
    	try{
    		sourceFileWalker.walk(fileAndDirNames);
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
	    }finally{
	    	shutdownNeo4JListener();
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
		cmd.outputHelp();
		System.exit(1);
	}
	
	private static String[] getFileAndDirNamesFromCommandLine()
	{
		return cmd.getFilenames();
	}

	private static void setupNeo4JListener()
    {
		neo4jImportListener.initialize(); 	
    	sourceFileWalker.addListener(neo4jImportListener);
    }
	
    private static void shutdownNeo4JListener()
    {
    	neo4jImportListener.shutdown();
	}

}
