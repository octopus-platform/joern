package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import main.ModuleParser.ModuleParser;

public class BatchParser implements Runnable
{
	ModuleParser parser = new ModuleParser();
	BatchOfFiles batchToProcess;
	
	BatchParser(BatchOfFiles batch)
	{
		batchToProcess = batch;
	}
	
	@Override
	public void run()
	{
		processBatch();
	}
	
	public void processBatch()
	{
		List<String> filenames = batchToProcess.getFilenames();

		Iterator<String> it = filenames.iterator();
		while(it.hasNext()){
			String filename = it.next();
			processSingleFile(filename);
		}
		
	}
	
    private void processSingleFile(String filename)
    {
    	try{
    		parser.parseAndWalkFile(filename);
    	}catch(IOException ex){
    		System.err.println("Error processing file: " + filename);
    	}
    }
    
}
