package tools.udg;

import neo4j.batchInserter.ImportedNodeListener;
import neo4j.batchInserter.ImportedNodeWalker;

import org.apache.commons.cli.ParseException;

import tools.GraphDbWalker;
import tools.ddg.DDGCommandLineInterface;

public class UseDefGraphMain extends GraphDbWalker {
	
	static ImportedNodeWalker walker = new ImportedNodeWalker();
	private static ImportedNodeListener listener = new UseDefGraphListener();
	private static DDGCommandLineInterface cmd = new DDGCommandLineInterface();
	
	public static void main(String[] args)
	{
		parseCommandLine(args);
		setDatabaseDirectory(cmd.getDatabaseDir());
		
		initializeDatabase();
		
		walkFunctionsInDatabase();
		
		shutdownDatabase();
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
	
	private static void walkFunctionsInDatabase()
	{
		walker.setType("Function");
		walker.addListener(listener);
		walker.walk();
	}
	
}
