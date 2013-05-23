package tools.index;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CodebaseWalker
{
	
	private DirectoryWalker walker = new DirectoryWalker("*.{c,cpp,h,cc,hpp}");
	
	public void walk(String[] userSpecifiedFilenames) throws IOException
	{
		walkUserSpecifiedFiles(userSpecifiedFilenames);
	}
	
	public void walkUserSpecifiedFiles(String [] userSpecifiedFilenames) throws IOException
	{
		String [] filenames = userSpecifiedFilenames;
		
		for(int i = 0; i < filenames.length ; i++){
			
			String filename = filenames[i];
			File file = new File(filename);
			
			if(!file.exists()){
				System.err.println("Warning: " + filename + ": no such file or directory");
				continue;
			}
			
			walkDirectory(filename);
		}
		
	}
	
	public void walkDirectory(String dirName) throws IOException
	{
		Path dir = Paths.get(dirName);
		Files.walkFileTree(dir, walker);
	}
	
	public void addListener(DirectoryListener listener)
	{
		walker.addListener(listener);
	}
}