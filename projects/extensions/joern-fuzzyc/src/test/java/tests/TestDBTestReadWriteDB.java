package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import neo4j.readWriteDB.Neo4JDBInterface;

public class TestDBTestReadWriteDB
{

	@BeforeClass
	public static void loadTestDatabase()
	{
		System.out.println(System.getProperty("user.dir"));
		Neo4JDBInterface.setDatabaseDir(".testDB");
		Neo4JDBInterface.openDatabase();
	}

	@AfterClass
	public static void shutdownTestDatabase()
	{
		Neo4JDBInterface.closeDatabase();
	}

}
