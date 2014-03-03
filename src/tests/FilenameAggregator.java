package tests;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import tools.index.OutputModule;

public class FilenameAggregator extends OutputModule {

	public List<String> filenames = new LinkedList<String>();
	
	@Override
	public void visitFile(Path filename)
	{
		filenames.add(filename.toString());
	}

	@Override public void preVisitDirectory(Path dir) {}
	@Override public void postVisitDirectory(Path dir) {}

	@Override
	public void initialize(String indexDirectory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}
}
