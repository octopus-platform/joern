package octopus.server.gremlinShell.fileWalker;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

class UnorderedFileWalkerImpl extends SimpleFileVisitor<Path>
{
	private FileNameMatcher matcher = new FileNameMatcher();
	private List<SourceFileListener> listeners = new LinkedList<SourceFileListener>();

	public void setFilenameFilter(String pattern)
	{
		matcher.setFilenameFilter(pattern);
	}

	public void addListener(SourceFileListener listener)
	{
		listeners.add(listener);
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir,
			BasicFileAttributes attrs)
	{
		notifyListenersOfDirEntry(dir);
		return FileVisitResult.CONTINUE;
	}

	private void notifyListenersOfDirEntry(Path dir)
	{
		for (SourceFileListener listener : listeners)
		{
			listener.preVisitDirectory(dir);
		}
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
	{
		notifyListenersOfDirExit(dir);
		return FileVisitResult.CONTINUE;
	}

	private void notifyListenersOfDirExit(Path dir)
	{
		for (SourceFileListener listener : listeners)
		{
			listener.postVisitDirectory(dir);
		}
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	{

		if (!matcher.fileMatches(file))
		{
			return FileVisitResult.CONTINUE;
		}

		notifyListenersOfFile(file);
		return FileVisitResult.CONTINUE;
	}

	private void notifyListenersOfFile(Path filename)
	{
		for (SourceFileListener listener : listeners)
		{
			listener.visitFile(filename);
		}
	}

}