package fileWalker;

import java.io.File;
import java.io.IOException;

public abstract class SourceFileWalker
{
	protected final String DEFAULT_FILENAME_FILTER = "*.{c,cpp,h,cc,hpp,java}";
	
	public abstract void setFilenameFilter(String filter);
	
	/**
	 * Add a listener object that will be informed of all visited
	 * source files and directories.
	 * */
	
	public abstract void addListener(SourceFileListener listener);
	
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
	
	protected abstract void walkExistingFileOrDirectory(String dirName) throws IOException;
	
	private boolean pathIsAccessible(String path)
	{
		File file = new File(path);
		if (!file.exists())
			return false;

		// TODO: add more checks, for example, do we have sufficient
		// permissions for access?

		return true;
	}
	
}