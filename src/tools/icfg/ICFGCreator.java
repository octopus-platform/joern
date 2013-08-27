package tools.icfg;

import output.neo4j.Neo4JBatchInserter;

public class ICFGCreator {

	public static void main(String[] args)
	{
		initializeDatabase();
		
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
