package main;

import java.util.LinkedList;
import java.util.List;

public class BatchOfFiles {

	private List<String> listOfFiles = new LinkedList<String>();
	
	public List<String> getFilenames()
	{
		return listOfFiles;
	}
	
	public void addFilename(String filename)
	{
		listOfFiles.add(filename);
	}

}
