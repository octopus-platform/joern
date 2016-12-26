package neo4j.batchInserter;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.index.IndexHits;

/**
 * Walks all nodes of a given type present in the Neo4J database by querying the
 * index.
 * */

public class ImportedNodeWalker
{
	private List<ImportedNodeListener> listeners = new LinkedList<ImportedNodeListener>();
	String type = "Function";

	public void addListener(ImportedNodeListener listener)
	{
		listeners.add(listener);
	}

	public void setType(String aType)
	{
		type = aType;
	}

	public void walk()
	{
		IndexHits<Long> nodes = Neo4JBatchInserter.retrieveExactFromIndex(
				"type", type);
		for (Long nodeId : nodes)
		{
			notifyListenersOfNode(nodeId);
		}

	}

	private void notifyListenersOfNode(Long nodeId)
	{
		for (ImportedNodeListener listener : listeners)
		{
			listener.visitNode(nodeId);
		}
	}

}
