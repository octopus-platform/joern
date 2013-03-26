package tools.index;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilenameProvider
{
	
	public List<String> getFilesToProcess(String [] userSpecifiedFilenames) throws IOException
	{
		String [] filenames = userSpecifiedFilenames;
		
		List<String> retList = new LinkedList<String>();
		
		for(int i = 0; i < filenames.length ; i++){
			
			String filename = filenames[i];
			File file = new File(filename);
			
			if(!file.exists()){
				System.err.println("Warning: " + filename + ": no such file or directory");
				continue;
			}
			
			if(file.isDirectory()){
				List<String> fs = getFilesInDirectory(filename);
				retList.addAll(fs);
			}else{
				retList.add(filename);
			}
		}
		return retList;
	}
	
	public BatchOfFiles [] getBatchesToProcess(String [] userSpecifiedFilenames, int nBatches) throws IOException
	{
		List<String> filesToProcess = getFilesToProcess(userSpecifiedFilenames);
		return partitionList(filesToProcess, nBatches);
	}
	
	private BatchOfFiles [] partitionList(List<String> filesToProcess, int nBatches)
	{
		// TODO: check if this causes performance problems.
		// It's not efficient but probably not worth optimizing
		// since the number of items in the list is small.
		BatchOfFiles [] batches = new BatchOfFiles[nBatches];
		for(int i = 0; i < nBatches; i++)
			batches[i] = new BatchOfFiles();
		
		Iterator<String> it = filesToProcess.iterator();
		int curBatch = 0;
		while(it.hasNext()){
			String filename = it.next();
			batches[curBatch].addFilename(filename);
			curBatch = (curBatch + 1) % nBatches;
		}
		return batches;
	}

	private List<String> getFilesInDirectory(String filename) throws IOException
	{
		DirectoryWalker walker = new DirectoryWalker("*.{c,cpp,h,cc,hpp}");
		Path dir = Paths.get(filename);
		Files.walkFileTree(dir, walker);
		return walker.filenames;
	}
}