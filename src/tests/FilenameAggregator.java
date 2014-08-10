package tests;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import fileWalker.SourceFileListener;

public class FilenameAggregator extends SourceFileListener
{

	public List<String> filenames = new LinkedList<String>();

	@Override
	public void visitFile(Path filename)
	{
		filenames.add(filename.toString());
	}

	@Override
	public void preVisitDirectory(Path dir)
	{
	}

	@Override
	public void postVisitDirectory(Path dir)
	{
	}

	@Override
	public void initialize()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void shutdown()
	{
		// TODO Auto-generated method stub

	}
}
