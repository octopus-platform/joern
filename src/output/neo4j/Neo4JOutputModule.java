package output.neo4j;

import java.nio.file.Path;

import output.OutputModule;
import parsing.ModuleParser;
import output.neo4j.batchInserter.Neo4JBatchInserter;
import output.neo4j.importers.DirectoryTreeImporter;
import output.neo4j.nodes.FileDatabaseNode;


public class Neo4JOutputModule extends OutputModule
{

	ModuleParser parser = new ModuleParser();
	Neo4JASTWalker neo4JASTWalker = new Neo4JASTWalker();
	
	DirectoryTreeImporter dirTreeImporter = new DirectoryTreeImporter();
	FileDatabaseNode currentFileNode;
	
	private static final String indexDirectory = ".joernIndex/";
	
	@Override
	public void initialize()
	{
		initializeParser();
		initializeDatabase();
	}

	private void initializeParser()
	{
		neo4JASTWalker.setImportListener(this);
		parser.addObserver(neo4JASTWalker);
	}
	
	private void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(indexDirectory);
		Neo4JBatchInserter.openDatabase();
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
		currentFileNode = dirTreeImporter.enterFile(pathToFile);
		parser.parseFile(pathToFile.toString());
	}
	
	public FileDatabaseNode getCurrentFileNode()
	{
		return currentFileNode;
	}
	
	@Override
	public void shutdown()
	{
		Neo4JBatchInserter.closeDatabase();	
	}
	
}
