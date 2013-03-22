package main;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.antlr.v4.runtime.ANTLRFileStream;

import main.ModuleParser.ModuleParser;

public class FilenameConsumer implements Runnable {

	protected ConcurrentLinkedQueue<FileToParse> queue;
	private ModuleParser parser = new ModuleParser();
	
	public FilenameConsumer(ConcurrentLinkedQueue<FileToParse> aQueue)
	{
		queue = aQueue;
	}
	
	@Override
	public void run()
	{
		
		while(!(Thread.currentThread().isInterrupted())) {
            	
        	FileToParse fileToParse = queue.poll();
			
        	if(fileToParse == null) continue;            	     
        	
            if(fileToParse.isEndMarker()){
            	// put EOF-marker back into queue
            	// for other workers and exit.
            	queue.add(fileToParse);          	
            	return;
            }
            
            processSingleStream(fileToParse);
            
        }
	}

	private void processSingleStream(FileToParse fileToParse)
	{
		try{
			parser.parseAndANTLRFileStream(fileToParse.stream, fileToParse.filename);
	    }catch(IOException ex){
	    	System.err.println("Error processing file: " + fileToParse.filename);
	    }
	}
	
}
