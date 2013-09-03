package output.neo4j.dbinterfaces;

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

public class Neo4JBatchInserter extends Neo4JInterfaceImpl {

	BatchInserter inserter;
	BatchInserterIndexProvider indexProvider;
	BatchInserterIndex nodeIndex;
	String databaseDirectory = "neo4j-db";
	
	@Override
	public void setIndexDirectoryName(String dirName)
	{
		databaseDirectory = dirName;
	}

	@Override
	public void openDatabase()
	{
		inserter = BatchInserters.inserter(databaseDirectory);
		initializeIndex();
	}

	private void initializeIndex()
	{
		indexProvider = new LuceneBatchInserterIndexProvider( inserter );		
		nodeIndex = indexProvider.nodeIndex( "nodeIndex", MapUtil.stringMap( "type", "exact" ) );		
	
		nodeIndex.setCacheCapacity( "type", 100000 );
		nodeIndex.setCacheCapacity( "functionName", 100000 );
	
	}
	
	@Override
	public long addNode(Map<String, Object> properties)
	{
		long newNode = inserter.createNode(properties);
		
		return newNode;	
	}

	@Override
	public void indexNode(long nodeId, Map<String, Object> properties)
	{
		if(properties != null){
			nodeIndex.add(nodeId, properties);
		}
	}
	
	@Override
	public IndexHits<Long> retrieveExactFromIndex(String key, String value)
	{
		return nodeIndex.get(key, value);
	}
	
	@Override
	public IndexHits<Long> queryIndex(String query)
	{
		
		return nodeIndex.query(query);
	}
	
	@Override
	public Map<String, Object> getNodeProperties(long id)
	{
		return inserter.getNodeProperties(id);
	}
	
	@Override
	public Map<String, Object> getRelationshipProperties(long id)
	{
		return inserter.getRelationshipProperties(id);
	}
	
	@Override
	public Iterable<BatchRelationship> getRelationships(long id)
	{
		return inserter.getRelationships(id);
	}
	
	@Override
	public void addRelationship(long srcId, long dstId,
			RelationshipType rel, Map<String, Object> properties)
	{
		inserter.createRelationship(srcId, dstId, rel, properties);
	}
	
	@Override
	public void closeDatabase()
	{
		indexProvider.shutdown();
		inserter.shutdown();
	}
	
}
