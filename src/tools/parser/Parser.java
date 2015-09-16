package tools.parser;

import java.nio.file.Path;

import outputModules.common.DirectoryTreeExporter;
import parsing.ModuleParser;
import fileWalker.SourceFileListener;
import languages.c.parsing.Modules.ANTLRCModuleParserDriver;

public abstract class Parser extends SourceFileListener
{

	ANTLRCModuleParserDriver driver = new ANTLRCModuleParserDriver();
	ModuleParser parser = new ModuleParser(driver);

	protected ParserState state;
	protected ParserASTWalker astWalker;
	protected DirectoryTreeExporter dirTreeImporter;

	protected String outputDir;

	protected abstract void initializeDirectoryImporter();

	protected abstract void initializeWalker();

	protected abstract void initializeDatabase();

	protected abstract void shutdownDatabase();

	protected void initializeIndexerState()
	{
		state = new ParserState(this);
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
		dirTreeImporter.setOutputDir(outputDir);
		parser.addObserver(astWalker);
	}

}
