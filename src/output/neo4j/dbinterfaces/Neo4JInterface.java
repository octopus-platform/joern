package output.neo4j.dbinterfaces;

import java.util.Map;

import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;


public class Neo4JInterface
{
	static Neo4JInterfaceImpl impl;
	
	static{
		impl = new Neo4JBatchInserter();
	}
	
	public static void setImplementation(Neo4JInterfaceImpl anImpl)
	{
		impl = anImpl;
	}
	
	public static void setIndexDirectoryName(String dirName)
	{
		impl.setIndexDirectoryName(dirName);
	}

	public static void openDatabase()
	{
		impl.openDatabase();
	}
	
	public static long addNode(Map<String, Object> properties)
	{
		return impl.addNode(properties);
	}

	public static void indexNode(long nodeId, Map<String, Object> properties)
	{
		impl.indexNode(nodeId, properties);
	}
	
	public static IndexHits<Long> retrieveExactFromIndex(String key, String value)
	{
		return impl.retrieveExactFromIndex(key, value);
	}
	
	public static IndexHits<Long> queryIndex(String query)
	{
		return impl.queryIndex(query);
	}
	
	public static Map<String, Object> getNodeProperties(long id)
	{
		return impl.getNodeProperties(id);
	}
	
	public static Map<String, Object> getRelationshipProperties(long id)
	{
		return impl.getRelationshipProperties(id);
	}
	
	public static Iterable<BatchRelationship> getRelationships(long id)
	{
		return impl.getRelationships(id);
	}
	
	public static void addRelationship(long srcId, long dstId,
			RelationshipType rel, Map<String, Object> properties)
	{
		impl.addRelationship(srcId, dstId, rel, properties);
	}
	
	public static void closeDatabase()
	{
		impl.closeDatabase();
	}
}
