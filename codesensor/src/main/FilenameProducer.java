package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.antlr.v4.runtime.ANTLRFileStream;

public class FilenameProducer implements Runnable {

	protected ConcurrentLinkedQueue<FileToParse> queue;
	String [] userSpecifiedFiles;
	
	public FilenameProducer(ConcurrentLinkedQueue<FileToParse> aQueue, String[] aUserSpecifiedFiles)
	{
		queue = aQueue;
		userSpecifiedFiles = aUserSpecifiedFiles;
	}
	
	@Override
	public void run()
	{
		String [] filenames = userSpecifiedFiles;
		
		for(int i = 0; i < filenames.length ; i++){
			
			String filename = filenames[i];
			File file = new File(filename);
			
			if(!file.exists()){
				System.err.println("Warning: " + filename + ": no such file or directory");
				continue;
			}
			if(file.isDirectory()){
				addAllFilesInDirectory(filename);
			}else{
				addToQueue(filename);
			}
		}
	
		addToQueue(null);
	}

	private void addAllFilesInDirectory(String filename)
	{
		List<String> fs;
		try {
			fs = getFilesInDirectory(filename);
			addAllToQueue(fs);
		} catch (IOException e) {
			System.err.println("Warning: " + filename + ": error getting files from directory");
		}
	}

	private void addToQueue(String filename)
	{
		if(filename == null){
			queue.offer(new FileToParse());
			return;
		}
		FileToParse fileToParse = createFileToParse(filename);
		queue.offer(fileToParse);
	}

	private void addAllToQueue(List<String> fs)
	{
		Iterator<String> it = fs.iterator();
		while(it.hasNext()){
			String filename = it.next();
			addToQueue(filename);
		}
	}
	
	private FileToParse createFileToParse(String filename)
	{
		try {
			FileToParse fileToParse = new FileToParse();
			fileToParse.filename = filename;
			fileToParse.stream = new ANTLRFileStream(filename);
			return fileToParse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private List<String> getFilesInDirectory(String filename) throws IOException
	{
		DirectoryWalker walker = new DirectoryWalker("*.{c,cpp,h,cc,hpp}");
		Path dir = Paths.get(filename);
		Files.walkFileTree(dir, walker);
		return walker.filenames;
	}
	
}
