package tests;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import tools.index.DirectoryListener;

public class FilenameAggregator extends DirectoryListener {

	public List<String> filenames = new LinkedList<String>();
	
	@Override
	public void visitFile(Path filename)
	{
		filenames.add(filename.toString());
	}

	@Override public void preVisitDirectory(Path dir) {}
	@Override public void postVisitDirectory(Path dir) {}
}
