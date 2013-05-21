package tools.index;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import output.neo4j.Neo4JDatabaseCreatorMain;
import parsing.BatchOfFiles;
import parsing.Parser;



public class CodeSensorIndex {

	private static final int nCores = 1;
	private static CommandLineInterface cmd = new CommandLineInterface();
	private static FilenameProvider filenameProvider = new FilenameProvider();
	private static ExecutorService executor =  Executors.newFixedThreadPool(nCores);

	private static void usage()
	{
		cmd.outputHelp();
	}
	
    public static void main(String[] args)
	{
    	cmd.parseCommandLine(args);
		String[] userSpecifiedFilenames = cmd.getFilenames();
    	
		if(userSpecifiedFilenames.length == 0){
			usage();
			return;
		}
			
    	try{
    		
    		BatchOfFiles[] batches = filenameProvider.getBatchesToProcess(userSpecifiedFilenames, nCores);
    		
    		for(int i = 0; i < nCores; i++){
    			Parser batchParser = new Parser();
    			
    			Neo4JDatabaseCreatorMain indexCreator = new Neo4JDatabaseCreatorMain();
    			indexCreator.setIndexDirectoryName(".joernIndex/");
    			batchParser.addObserver(indexCreator);
    			batchParser.setBatch(batches[i]);
    			executor.execute(batchParser);
    		}
    		
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
	    }

    	executor.shutdown();
	}

}
