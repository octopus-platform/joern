package tools.callGraph;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.Neo4JBatchInserter;


/**
 * Walks all functions present in the Neo4J database
 * by querying the index
 * */

public class ImportedNodeWalker
{
	private List<CallGraphListener> listeners = new LinkedList<CallGraphListener>();
	String type = "Function";
	
	public void addListener(CallGraphListener listener)
	{
		listeners.add(listener);
	}
	
	public void setType(String aType)
	{
		type = aType;
	}
	
	public void walk()
	{
		IndexHits<Long> functions = Neo4JBatchInserter.retrieveExactFromIndex("type", type);
		for(Long funcId : functions){
			notifyListenersOfFunction(funcId);
		}
	
	}
	
	private void notifyListenersOfFunction(Long funcId)
	{
		for(CallGraphListener listener : listeners){
			listener.visitFunction(funcId);
		}
	}
	
}
