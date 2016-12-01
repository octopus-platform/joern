package outputModules.parser;

import java.nio.file.Path;

import fileWalker.SourceFileListener;
import outputModules.common.DirectoryTreeImporter;

public abstract class Parser extends SourceFileListener
{

	protected ParserState state;
	protected ParserASTWalker astWalker;
	protected DirectoryTreeImporter dirTreeImporter;

	protected String outputDir;

	protected abstract void initializeDirectoryImporter();

	protected abstract void initializeWalker();

	protected abstract void initializeDatabase();

	protected abstract void shutdownDatabase();

	protected void initializeIndexerState()
	{
		state = new ParserState();
	}

	public void setOutputDir(String anOutputDir)
	{
		outputDir = anOutputDir;
	}

	@Override
	public void initialize()
	{
		initializeIndexerState();
		initializeDirectoryImporter();
		initializeWalker();
		initializeDatabase();
		connectComponents();
	}

	@Override
	public void preVisitDirectory(Path dir)
	{
		dirTreeImporter.enterDir(dir);
	}

	@Override
	public void postVisitDirectory(Path dir)
	{
		dirTreeImporter.exitDir(dir);
	}


	private void connectComponents()
	{
		astWalker.setIndexerState(state);
		dirTreeImporter.setState(state);
		dirTreeImporter.setOutputDir(outputDir);
	}

	@Override
	public void shutdown()
	{
		shutdownDatabase();
	}


}
