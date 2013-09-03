package output.neo4j.dbinterfaces;

import java.util.Map;

import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

public abstract class Neo4JInterfaceImpl {

	public abstract void setIndexDirectoryName(String dirName);
	public abstract void openDatabase();
	public abstract long addNode(Map<String, Object> properties);
	public abstract void indexNode(long nodeId, Map<String, Object> properties);
	public abstract IndexHits<Long> retrieveExactFromIndex(String key, String value);
	public abstract IndexHits<Long> queryIndex(String query);
	public abstract Map<String, Object> getNodeProperties(long id);
	public abstract Map<String, Object> getRelationshipProperties(long id);
	public abstract Iterable<BatchRelationship> getRelationships(long id);
	public abstract void addRelationship(long srcId, long dstId,
			RelationshipType rel, Map<String, Object> properties);
	public abstract void closeDatabase();
	
}
