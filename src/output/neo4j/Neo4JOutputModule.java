package output.neo4j;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import output.neo4j.batchInserter.ConfigurationGenerator;
import output.neo4j.batchInserter.Neo4JBatchInserter;
import output.neo4j.importers.DirectoryTreeImporter;
import output.neo4j.nodes.FileDatabaseNode;
import parsing.ModuleParser;
import tools.index.OutputModule;


public class Neo4JOutputModule extends OutputModule
{

	ModuleParser parser = new ModuleParser();
	Neo4JASTWalker neo4JASTWalker = new Neo4JASTWalker();
	
	DirectoryTreeImporter dirTreeImporter = new DirectoryTreeImporter();
	FileDatabaseNode currentFileNode;
	
	private String indexDirectory;
	
	@Override
	public void initialize(String aIndexDirectory)
	{
		indexDirectory = aIndexDirectory;
		
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
		Map<String, String> config = ConfigurationGenerator.generateConfiguration();
		Neo4JBatchInserter.setBatchInserterConfig(config);
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
