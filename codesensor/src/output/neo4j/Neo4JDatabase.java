package output.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.EmbeddedGraphDatabase;


public class Neo4JDatabase
{
	GraphDatabaseService graphDb;
	String databaseDirectory = "neo4j-db";

	public void setIndexDirectoryName(String dirName)
	{
		databaseDirectory = dirName;
	}

	public void start()
	{
		graphDb = new EmbeddedGraphDatabase(databaseDirectory);
		registerShutdownHook(graphDb);
	}

	public void shutdown()
	{
		graphDb.shutdown();
	}

	private static void registerShutdownHook( final GraphDatabaseService graphDb)
	{
		// Registers a shutdown hook for the Neo4j instance so that it
		// shuts down nicely when the VM exits (even if you "Ctrl-C" the
		// running example before it's completed)
		Runtime.getRuntime().addShutdownHook( new Thread()
		{
			@Override
			public void run()
			{
				graphDb.shutdown();
			}
		} );
	}
	
}
