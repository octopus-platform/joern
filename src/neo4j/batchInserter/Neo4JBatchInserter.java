package neo4j.batchInserter;

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

import databaseNodes.NodeKeys;

public class Neo4JBatchInserter
{

	static BatchInserter inserter;
	static BatchInserterIndexProvider indexProvider;
	static BatchInserterIndex nodeIndex;

	static String databaseDirectory = "neo4j-db";
	static Map<String, String> batchInserterConfig;

	/*
	 * Configuration of the batch inserter: These functions must be called
	 * before openDatabase is called
	 */

	public static void setIndexDirectoryName(String dirName)
	{
		databaseDirectory = dirName;
	}

	public static void setBatchInserterConfig(Map<String, String> config)
	{
		batchInserterConfig = config;
	}

	/* ************************************** */

	public static void openDatabase()
	{
		if (batchInserterConfig == null)
			inserter = BatchInserters.inserter(databaseDirectory);
		else
			inserter = BatchInserters.inserter(databaseDirectory,
					batchInserterConfig);

		initializeIndex();
	}

	public static long addNode(Map<String, Object> properties)
	{
		long newNode = inserter.createNode(properties);
		return newNode;
	}

	public static void indexNode(long nodeId, Map<String, Object> properties)
	{
		if (properties != null)
		{
			nodeIndex.add(nodeId, properties);
		}
	}

	public static IndexHits<Long> retrieveExactFromIndex(String key,
			String value)
	{
		return nodeIndex.get(key, value);
	}

	public static IndexHits<Long> queryIndex(String query)
	{

		return nodeIndex.query(query);
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
		try
		{
			indexProvider.shutdown();
		}
		catch (RuntimeException ex)
		{
			System.err
					.println("Error while shutting down index provider. This may be harmless:");
			// System.err.println(ex.getMessage());
		}
		inserter.shutdown();
	}

	public static void setNodeProperty(long nodeId, String key, String val)
	{
		inserter.setNodeProperty(nodeId, key, val);
		// Need to call flush before calling updateOrAdd because otherwise
		// the node may not be visible yet.
		flushIndex();
		nodeIndex.updateOrAdd(nodeId, getNodeProperties(nodeId));
	}

	public static void flushIndex()
	{
		nodeIndex.flush();
	}

	private static void initializeIndex()
	{
		indexProvider = new LuceneBatchInserterIndexProvider(inserter);
		nodeIndex = indexProvider.nodeIndex("nodeIndex",
				MapUtil.stringMap("type", "exact"));

		// TODO: Does this have an effect at all?
		nodeIndex.setCacheCapacity(NodeKeys.TYPE, 100000);
		nodeIndex.setCacheCapacity(NodeKeys.NAME, 100000);
		nodeIndex.setCacheCapacity(NodeKeys.CODE, 100000);

	}

}
