package output.neo4j;

import java.util.Map;

import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserterIndex;
import org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider;
import org.neo4j.unsafe.batchinsert.BatchInserters;
import org.neo4j.unsafe.batchinsert.BatchRelationship;


public class Neo4JBatchInserter
{
	
	static BatchInserter inserter;
	static BatchInserterIndexProvider indexProvider;
	static BatchInserterIndex astNodeIndex;
	
	static String databaseDirectory = "neo4j-db";
	
	
	public static void setIndexDirectoryName(String dirName)
	{
		databaseDirectory = dirName;
	}

	public static void openDatabase()
	{
		inserter = BatchInserters.inserter(databaseDirectory);
		initializeIndex();
	}

	private static void initializeIndex()
	{
		indexProvider = new LuceneBatchInserterIndexProvider( inserter );		
		astNodeIndex = indexProvider.nodeIndex( "astNodeIndex", MapUtil.stringMap( "type", "exact" ) );		
	
		astNodeIndex.setCacheCapacity( "type", 100000 );
		astNodeIndex.setCacheCapacity( "functionName", 100000 );
	
	}
	
	public static long addNode(Map<String, Object> properties)
	{
		long newNode = inserter.createNode(properties);
		
		return newNode;	
	}

	public static void indexNode(long nodeId, Map<String, Object> properties)
	{
		if(properties != null){
			astNodeIndex.add(nodeId, properties);
		}
	}
	
	public static IndexHits<Long> retrieveExactFromIndex(String key, String value)
	{
		return astNodeIndex.get(key, value);
	}
	
	public static IndexHits<Long> queryIndex(String query)
	{
		
		return astNodeIndex.query(query);
	}
	
	public static Map<String, Object> getNodeProperties(long id)
	{
		return inserter.getNodeProperties(id);
	}
	
	public static Map<String, Object> getRelationshipProperties(long id)
	{
		return inserter.getRelationshipProperties(id);
	}
	
	public static Iterable<BatchRelationship> getRelationships(long id)
	{
		return inserter.getRelationships(id);
	}
	
	public static void addRelationship(long srcId, long dstId,
			RelationshipType rel, Map<String, Object> properties)
	{
		inserter.createRelationship(srcId, dstId, rel, properties);
	}
	
	public static void closeDatabase()
	{
		indexProvider.shutdown();
		inserter.shutdown();
	}
	
}
