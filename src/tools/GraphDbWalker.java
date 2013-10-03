package tools;

import output.neo4j.batchInserter.Neo4JBatchInserter;

public class GraphDbWalker {

	private static String databaseDirectory = ".joernIndex";

	public static void setDatabaseDirectory(String aDatabaseDirectory)
	{
		databaseDirectory = aDatabaseDirectory;
	}
	
	protected static void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(databaseDirectory);
		Neo4JBatchInserter.openDatabase();
	}

	protected static void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}
	
}
