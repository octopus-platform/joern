package tools.index;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SourceFileWalker
{

	private SourceFileWalkerImpl sourceFileWalkerImpl = new SourceFileWalkerImpl(
			"*.{c,cpp,h,cc,hpp}");

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

	public void addListener(SourceFileListener listener)
	{
		sourceFileWalkerImpl.addListener(listener);
	}
}