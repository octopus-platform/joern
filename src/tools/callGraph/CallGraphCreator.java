package tools.callGraph;

import output.neo4j.Neo4JBatchInserter;


public class CallGraphCreator {

	private static ImportedFunctionWalker functionWalker = new ImportedFunctionWalker();
	private static CallGraphListener listener = new CallGraphListener();
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		initializeDatabase();
		
		functionWalker.addListener(listener);
		functionWalker.walk();
		
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
