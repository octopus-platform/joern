package fileWalker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SourceFileWalker
{
	private final String DEFAULT_FILENAME_FILTER = "*.{c,cpp,h,cc,hpp,java}";
	
	private SourceFileWalkerImpl sourceFileWalkerImpl = new SourceFileWalkerImpl();

	public SourceFileWalker()
	{
		sourceFileWalkerImpl.setFilenameFilter(DEFAULT_FILENAME_FILTER);
	}
		
	public void setFilenameFilter(String filter)
	{
		sourceFileWalkerImpl.setFilenameFilter(filter);
	}
	
	/**
	 * Add a listener object that will be informed of all visited
	 * source files and directories.
	 * */
	
	public void addListener(SourceFileListener listener)
	{
		sourceFileWalkerImpl.addListener(listener);
	}
	
	/**
	 * Walk list of files and directory names and report them to
	 * listeners.
	 * @param fileAndDirNames: A list of file and/or directory names
	 * */
	
	public void walk(String[] fileAndDirNames) throws IOException
	{
		for (String filename : fileAndDirNames)
		{

			if (!pathIsAccessible(filename))
			{
				System.err.println("Warning: Skipping " + filename
						+ " because it is not accessible");
				continue;
			}
			walkExistingFileOrDirectory(filename);
		}
	}

	private boolean pathIsAccessible(String path)
	{
		File file = new File(path);
		if (!file.exists())
			return false;

		// TODO: add more checks, for example, do we have sufficient
		// permissions for access?

		return true;
	}

	private void walkExistingFileOrDirectory(String dirName) throws IOException
	{
		Path dir = Paths.get(dirName);
		Files.walkFileTree(dir, sourceFileWalkerImpl);
	}

}