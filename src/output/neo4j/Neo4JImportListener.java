package output.neo4j;

import java.nio.file.Path;

import output.neo4j.fileImport.FileImporter;
import output.neo4j.functionImport.Neo4JASTWalker;
import output.neo4j.nodes.FileDatabaseNode;
import parsing.Parser;
import tools.index.DirectoryListener;

public class Neo4JImportListener extends DirectoryListener {

	Parser parser = new Parser();
	FileDatabaseNode currentFileNode;
	
	Neo4JASTWalker neo4JASTWalker = new Neo4JASTWalker();
	FileImporter dirImporter = new FileImporter();
	
	public Neo4JImportListener()
	{
		neo4JASTWalker.setImportListener(this);
		parser.addObserver(neo4JASTWalker);
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
	
}
