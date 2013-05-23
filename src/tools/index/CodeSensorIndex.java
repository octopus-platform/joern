package tools.index;

import java.io.IOException;
import java.util.List;

import output.neo4j.Neo4JASTWalker;
import output.neo4j.Neo4JDatabaseCreator;
import parsing.Parser;

public class CodeSensorIndex {

	private static CommandLineInterface cmd = new CommandLineInterface();
	private static FilenameProvider filenameProvider = new FilenameProvider();

	private static void usage()
	{
		cmd.outputHelp();
	}
	
    public static void main(String[] args)
	{
    	
    	String[] userSpecifiedFilenames = parseCommandLine(args);
		
    	Neo4JDatabaseCreator creator = new Neo4JDatabaseCreator();
    	creator.setIndexDirectoryName(".joernIndex/");
    	creator.openDatabase();
    	
    	try{
    		
    		List<String> listOfFiles = filenameProvider.getFilesToProcess(userSpecifiedFilenames);
    		
    		Parser parser = new Parser();
    		Neo4JASTWalker neo4JASTWalker = new Neo4JASTWalker();
    			
    		parser.addObserver(neo4JASTWalker);
    		parser.run(listOfFiles);
    		
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
	    }finally{
	    	creator.closeDatabase();
	    }

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
