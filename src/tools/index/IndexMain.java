package tools.index;

import java.io.IOException;

import output.neo4j.Neo4JImportListener;
import output.neo4j.BatchInserter.Neo4JBatchInserter;

public class IndexMain {

	private static CommandLineInterface cmd = new CommandLineInterface();
	private static CodebaseWalker codebaseWalker = new CodebaseWalker();
	private static Neo4JImportListener listener = new Neo4JImportListener();
	
	private static void usage()
	{
		cmd.outputHelp();
	}
	
    public static void main(String[] args)
	{
    	String[] userSpecifiedFilenames = parseCommandLine(args);
		initializeDatabase();
    	
    	codebaseWalker.addListener(listener);
    	
    	try{
    		codebaseWalker.walk(userSpecifiedFilenames);
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
	    }finally{
	    	shutdownDatabase();
	    }
	}

	private static void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(".joernIndex/");
		Neo4JBatchInserter.openDatabase();
	}

	private static void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}
	
	private static String[] parseCommandLine(String[] args) {
		cmd.parseCommandLine(args);
		String[] userSpecifiedFilenames = cmd.getFilenames();
		if(userSpecifiedFilenames.length == 0){
			usage();
			System.exit(1);
		}
		return userSpecifiedFilenames;
	}

}
