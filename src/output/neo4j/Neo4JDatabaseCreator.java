package output.neo4j;

public class Neo4JDatabaseCreator
{
	public void setIndexDirectoryName(String dirName)
	{
		Neo4JDatabase.setIndexDirectoryName(dirName);
	}

	public void openDatabase()
	{
		Neo4JDatabase.start();
	}

	public void closeDatabase()
	{
		Neo4JDatabase.shutdown();
	}

}
