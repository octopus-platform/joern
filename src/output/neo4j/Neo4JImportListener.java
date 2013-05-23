package output.neo4j;

import java.nio.file.Path;

import output.neo4j.functionImport.Neo4JASTWalker;
import parsing.Parser;
import tools.index.DirectoryListener;

public class Neo4JImportListener extends DirectoryListener {

	Parser parser = new Parser();
	Neo4JASTWalker neo4JASTWalker = new Neo4JASTWalker();
	
	public Neo4JImportListener()
	{
		parser.addObserver(neo4JASTWalker);
	}

	@Override
	public void preVisitDirectory(Path dir)
	{
		
	}
	
	@Override
	public void visitFile(Path pathToFile)
	{
		// handling of the file itself goes here
		parser.processSingleFile(pathToFile.toString());
	}

}
