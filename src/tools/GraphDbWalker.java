package tools;

import output.neo4j.batchInserter.Neo4JBatchInserter;

public class GraphDbWalker {

	private static String indexDirectory = ".joernIndex/";
	
	protected static void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(indexDirectory);
		Neo4JBatchInserter.openDatabase();
	}

	protected static void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}
	
}
