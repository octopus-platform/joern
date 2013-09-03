package tools;

import output.neo4j.Neo4JBatchInserter;

public class GraphDbWalker {

	protected static void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(".joernIndex/");
		Neo4JBatchInserter.openDatabase();
	}

	protected static void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}
	
}
