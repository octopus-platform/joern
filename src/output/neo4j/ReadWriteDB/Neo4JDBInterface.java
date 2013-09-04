package output.neo4j.ReadWriteDB;

import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;

public class Neo4JDBInterface {
	
	static GraphDatabaseService graphDb;
	static Index<Node> nodeIndex;
	
	static String databaseDir = "";
	
	static Transaction tx;
	
	public static void startTransaction()
	{
		tx = graphDb.beginTx();
	}
	
	public static void finishTransaction()
	{
		tx.success();
		tx.finish();
	}
	
	public static void setIndexDirectoryName(String aDir)
	{
		databaseDir = aDir;
	}
		
	public static void openDatabase()
	{
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(databaseDir);
		nodeIndex = graphDb.index().forNodes("nodeIndex");
	}
	
	public static IndexHits<Node> queryIndex(String query)
	{
		return nodeIndex.query(query);
	}
	
	public static void closeDatabase()
	{
		graphDb.shutdown();
	}

	public static Node getNodeById(Long basicBlockId)
	{
		return graphDb.getNodeById(basicBlockId);
	}

	public static void removeEdge(long id)
	{
		graphDb.getRelationshipById(id).delete();
	}

	public static void addRelationship(long src, long dst, RelationshipType relType, Map<String, Object> properties)
	{
		
		Node node = graphDb.getNodeById(src);
		Relationship rel = node.createRelationshipTo(graphDb.getNodeById(dst), relType);
		for(Entry<String, Object> entry : properties.entrySet()){
			rel.setProperty(entry.getKey(), entry.getValue());
		}
	}
	
}
