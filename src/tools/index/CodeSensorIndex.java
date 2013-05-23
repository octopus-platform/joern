package tools.index;

import java.io.IOException;
import java.util.List;

import output.neo4j.Neo4JDatabaseCreatorMain;
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
		
    	try{
    		
    		List<String> listOfFiles = filenameProvider.getListOfFiles(userSpecifiedFilenames);
    		
    		Parser parser = new Parser();
    		Neo4JDatabaseCreatorMain indexCreator = new Neo4JDatabaseCreatorMain();
    		indexCreator.setIndexDirectoryName(".joernIndex/");
    			
    		parser.addObserver(indexCreator);
    		parser.run(listOfFiles);
    		
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
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
