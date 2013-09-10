package output.neo4j;

import java.nio.file.Path;

import output.neo4j.BatchInserter.Neo4JBatchInserter;
import output.neo4j.importers.FileImporter;
import output.neo4j.nodes.FileDatabaseNode;
import parsing.ModuleParser;
import tools.index.SourceFileListener;

public class Neo4JImportListener extends SourceFileListener {

	ModuleParser parser = new ModuleParser();
	FileDatabaseNode currentFileNode;
	Neo4JASTWalker neo4JASTWalker = new Neo4JASTWalker();
	FileImporter dirImporter = new FileImporter();
	
	private static final String indexDirectory = ".joernIndex/";
	
	public Neo4JImportListener()
	{
		neo4JASTWalker.setImportListener(this);
		parser.addObserver(neo4JASTWalker);
	}

	public void initialize()
	{
		Neo4JBatchInserter.setIndexDirectoryName(indexDirectory);
		Neo4JBatchInserter.openDatabase();
	}
	
	@Override
	public void preVisitDirectory(Path dir)
	{
		dirImporter.enterDir(dir);
	}
	
	@Override
	public void postVisitDirectory(Path dir)
	{
		dirImporter.exitDir(dir);
	}
	
	@Override
	public void visitFile(Path pathToFile)
	{
		currentFileNode = dirImporter.enterFile(pathToFile);
		parser.processSingleFile(pathToFile.toString());
	}

	public FileDatabaseNode getCurrentFileNode()
	{
		return currentFileNode;
	}

	public void shutdown()
	{
		Neo4JBatchInserter.closeDatabase();	
	}
	
}
