package output.neo4j;

import java.util.Map;

import org.neo4j.graphdb.RelationshipType;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserterIndex;
import org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider;
import org.neo4j.unsafe.batchinsert.BatchInserters;
import org.neo4j.unsafe.batchinsert.LuceneBatchInserterIndexProvider;



public class Neo4JDatabase
{
	
	static BatchInserter inserter;
	static BatchInserterIndexProvider indexProvider;
	static BatchInserterIndex astNodeIndex;
	
	static String databaseDirectory = "neo4j-db";
	
	public static void setIndexDirectoryName(String dirName)
	{
		databaseDirectory = dirName;
	}

	public static void start()
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
	
	public static void addRelationship(long srcId, long dstId,
			RelationshipType rel, Map<String, Object> properties)
	{
		inserter.createRelationship(srcId, dstId, rel, properties);
	}
	
	public static void shutdown()
	{

		indexProvider.shutdown();
		inserter.shutdown();
	}
	
}
