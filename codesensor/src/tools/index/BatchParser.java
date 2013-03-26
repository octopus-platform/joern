package tools.index;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import lucene.LuceneIndexCreator;
import main.ModuleParser.ModuleParser;
import main.processors.CSVPrinter;

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
		// parser.addObserver(new LuceneIndexCreator());
		parser.addObserver(new CSVPrinter());
		processBatch();
	}
	
	public void processBatch()
	{
		parser.begin();
		
		List<String> filenames = batchToProcess.getFilenames();

		Iterator<String> it = filenames.iterator();
		while(it.hasNext()){
			String filename = it.next();
			processSingleFile(filename);
		}
		
		parser.end();
		
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
