package tools;

import output.neo4j.dbinterfaces.Neo4JInterface;

public class GraphDbWalker {

	protected static void initializeDatabase()
	{
		Neo4JInterface.setIndexDirectoryName(".joernIndex/");
		Neo4JInterface.openDatabase();
	}

	protected static void shutdownDatabase()
	{
		Neo4JInterface.closeDatabase();
	}
	
}
