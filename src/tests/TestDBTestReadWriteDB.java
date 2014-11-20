package tests;

import neo4j.readWriteDB.Neo4JDBInterface;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestDBTestReadWriteDB
{

	@BeforeClass
	public static void loadTestDatabase()
	{
		Neo4JDBInterface.setDatabaseDir(".testDB");
		Neo4JDBInterface.openDatabase();	
	}

	@AfterClass
	public static void shutdownTestDatabase()
	{
		Neo4JDBInterface.closeDatabase();
	}

}
