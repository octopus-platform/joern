package fileWalker;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

public class FileNameMatcher
{
	private PathMatcher matcher;

	public void setFilenameFilter(String pattern)
	{
		// TODO Auto-generated method stub
		matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
	}

	public boolean fileMatches(Path file)
	{
		Path name = file.getFileName();
		if (name == null)
			return false;
		return matcher.matches(name);
	}

}
