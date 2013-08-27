package tools.icfg;

import output.neo4j.Neo4JBatchInserter;
import tools.ImportedNodeListener;
import tools.ImportedNodeWalker;

public class ICFGCreator {

	static ImportedNodeWalker walker = new ImportedNodeWalker();
	static ImportedNodeListener listener = new ICFGListener();
	
	public static void main(String[] args)
	{
		initializeDatabase();
		
		walker.setType("CallExpression");
		walker.addListener(listener);
		walker.walk();
		
		shutdownDatabase();
	}

	private static void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(".joernIndex/");
		Neo4JBatchInserter.openDatabase();
	}

	private static void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}
	
}
