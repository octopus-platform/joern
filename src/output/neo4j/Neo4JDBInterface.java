package output.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;

public class Neo4JDBInterface {
	
	static GraphDatabaseService graphDb;
	static Index<Node> nodeIndex;
	
	static String databaseDir = "";
	
	public static void setIndexDirectoryName(String aDir)
	{
		databaseDir = aDir;
	}
		
	public static void openDatabase()
	{
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(databaseDir);
		nodeIndex = graphDb.index().forNodes("nodeIndex");
	}
	
	public static void closeDatabase()
	{
		graphDb.shutdown();
	}
	
}
