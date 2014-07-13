package tests;

import neo4j.batchInserter.Neo4JBatchInserter;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestDBTestsBatchInserter
{

	@BeforeClass
	public static void loadTestDatabase()
	{
		Neo4JBatchInserter.setIndexDirectoryName(".testDB");
		Neo4JBatchInserter.openDatabase();
	}

	@AfterClass
	public static void shutdownTestDatabase()
	{
		Neo4JBatchInserter.closeDatabase();
	}

}
