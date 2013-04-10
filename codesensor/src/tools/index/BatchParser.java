package tools.index;

import java.util.Iterator;
import java.util.List;

import output.CSVPrinter;


import parsing.ModuleParser;

import lucene.LuceneIndexCreatorMain;

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
		LuceneIndexCreatorMain indexCreator = new LuceneIndexCreatorMain();
		indexCreator.setIndexDirectoryName("/home/fabs/tmp/lucene/");
		parser.addObserver(indexCreator);
		// parser.addObserver(new CSVPrinter());
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
    	}catch(ParserException ex){
    		System.err.println("Error processing file: " + filename);
    	}
    }
    
}
