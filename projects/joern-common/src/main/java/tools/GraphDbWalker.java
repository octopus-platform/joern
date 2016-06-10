package tools;

import java.util.Map;

import neo4j.batchInserter.ConfigurationGenerator;
import neo4j.batchInserter.Neo4JBatchInserter;

public class GraphDbWalker
{

	private static String databaseDirectory = ".joernIndex";

	public static void setDatabaseDirectory(String aDatabaseDirectory)
	{
		databaseDirectory = aDatabaseDirectory;
	}

	protected static void initializeDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(databaseDirectory);
		Map<String, String> config = ConfigurationGenerator
				.generateConfiguration();
		Neo4JBatchInserter.setBatchInserterConfig(config);
		Neo4JBatchInserter.openDatabase();
	}

	protected static void shutdownDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}

}
