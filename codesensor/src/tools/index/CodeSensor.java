package tools.index;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CodeSensor {

	private static final int nCores = 1;
	private static CommandLineInterface cmd = new CommandLineInterface();
	private static FilenameProvider filenameProvider = new FilenameProvider();
	private static ExecutorService executor =  Executors.newFixedThreadPool(nCores);
	
    public static void main(String[] args)
	{
    	cmd.parseCommandLine(args);
		String[] userSpecifiedFilenames = cmd.getFilenames();
    	
    	try{
    		
    		BatchOfFiles[] batches = filenameProvider.getBatchesToProcess(userSpecifiedFilenames, nCores);
    		
    		for(int i = 0; i < nCores; i++){
    			BatchParser batchParser = new BatchParser(batches[i]);
    			executor.execute(batchParser);
    		}
    		
	    }catch(IOException err){
			System.err.println("I/O-Error: " + err.getMessage()); 
	    }

    	executor.shutdown();
	}
    
}
