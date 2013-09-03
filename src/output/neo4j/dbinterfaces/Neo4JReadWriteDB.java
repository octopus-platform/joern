package output.neo4j.dbinterfaces;

import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

public class Neo4JReadWriteDB extends Neo4JInterfaceImpl {

	@Override
	public void setIndexDirectoryName(String dirName) {
		// TODO Autos-generated method stub
		
	}

	@Override
	public void openDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long addNode(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void indexNode(long nodeId, Map<String, Object> properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IndexHits<Long> retrieveExactFromIndex(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IndexHits<Long> queryIndex(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getNodeProperties(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getRelationshipProperties(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<BatchRelationship> getRelationships(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRelationship(long srcId, long dstId, RelationshipType rel,
			Map<String, Object> properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeDatabase() {
		// TODO Auto-generated method stub
		
	}
	
}
