package tools.icfg;

import org.apache.commons.cli.ParseException;

import tools.GraphDbWalker;
import tools.ImportedNodeListener;
import tools.ImportedNodeWalker;

public class ICFGMain extends GraphDbWalker {

	static ImportedNodeWalker walker = new ImportedNodeWalker();
	static ImportedNodeListener listener = new ICFGListener();
	
	private static ICFGCommandLineInterface cmd = new ICFGCommandLineInterface();
	
	public static void main(String[] args)
	{
		parseCommandLine(args);
		setDatabaseDirectory(cmd.getDatabaseDir());
		
		initializeDatabase();
				
		walker.setType("CallExpression");
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
