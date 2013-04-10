package parsing;

import java.util.Iterator;
import java.util.List;
import java.util.Observer;


public class Parser implements Runnable
{
	ModuleParser parser = new ModuleParser();
	private BatchOfFiles batchOfFiles;
	
	@Override
	public void run()
	{
		processBatch(batchOfFiles);
	}
	
	public void addObserver(Observer anObserver)
	{
		parser.addObserver(anObserver);
	}
	
	public void setBatch(BatchOfFiles aBatchOfFiles)
	{
		batchOfFiles = aBatchOfFiles;
	}
	
	public void processBatch(BatchOfFiles batchToProcess)
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
