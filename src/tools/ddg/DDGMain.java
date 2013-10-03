package tools.ddg;

import org.apache.commons.cli.ParseException;

import tools.GraphDbWalker;
import tools.ImportedNodeListener;
import tools.ImportedNodeWalker;

public class DDGMain extends GraphDbWalker {

	static ImportedNodeWalker walker = new ImportedNodeWalker();
	private static ImportedNodeListener listener = new DDGListener();
	private static DDGCommandLineInterface cmd = new DDGCommandLineInterface();
	
	public static void main(String[] args)
	{
		parseCommandLine(args);
		setDatabaseDirectory(cmd.getDatabaseDir());
		initializeDatabase();
		
		walker.setType("Function");
		walker.addListener(listener);
		walker.walk();		
		
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
	
}
