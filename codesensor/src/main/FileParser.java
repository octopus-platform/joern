package main;

import java.io.IOException;

import main.ModuleParser.ModuleParser;

public class FileParser implements Runnable{

	private ModuleParser parser = new ModuleParser();
	private String filename;
	
	public FileParser(String aFilename)
	{
		filename = aFilename;
	}
	
	@Override
	public void run()
	{
		processSingleFile();
	}

    private void processSingleFile()
    {
    	try{
    		parser.parseAndWalkFile(filename);
    	}catch(IOException ex){
    		System.err.println("Error processing file: " + filename);
    	}
    }
	
}
