package tools.index;

import java.nio.file.Path;

import neo4j.importers.DirectoryTreeImporter;
import parsing.ModuleParser;

public abstract class Indexer extends SourceFileListener
{

	ModuleParser parser = new ModuleParser();

	protected IndexerState state;
	protected IndexerASTWalker astWalker;
	protected DirectoryTreeImporter dirTreeImporter;

	protected String outputDir;

	protected abstract void initializeIndexerState();

	protected abstract void initializeDirectoryImporter();

	protected abstract void initializeWalker();

	protected abstract void initializeDatabase();

	protected abstract void shutdownDatabase();

	// Configuration routines called before initialize

	public void setOutputDir(String anOutputDir)
	{
		outputDir = anOutputDir;
	}

	// ////////////////

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

	@Override
	public void visitFile(Path pathToFile)
	{
		dirTreeImporter.enterFile(pathToFile);
		parser.parseFile(pathToFile.toString());
	}

	@Override
	public void shutdown()
	{
		shutdownDatabase();
	}

	private void connectComponents()
	{
		astWalker.setIndexerState(state);
		dirTreeImporter.setState(state);
		parser.addObserver(astWalker);
	}

}
