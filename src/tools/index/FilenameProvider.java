package tools.index;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	private List<String> getFilesInDirectory(String filename) throws IOException
	{
		DirectoryWalker walker = new DirectoryWalker("*.{c,cpp,h,cc,hpp}");
		Path dir = Paths.get(filename);
		Files.walkFileTree(dir, walker);
		return walker.filenames;
	}
}