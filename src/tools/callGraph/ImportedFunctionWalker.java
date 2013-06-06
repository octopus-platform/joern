package tools.callGraph;

import java.util.LinkedList;
import java.util.List;


/**
 * Walks all functions present in the Neo4J database
 * by querying the index
 * */

public class ImportedFunctionWalker
{
	private List<CallGraphListener> listeners = new LinkedList<CallGraphListener>();
	
	public void addListener(CallGraphListener listener)
	{
		listeners.add(listener);
	}

	public void walk()
	{
		
	}
	
	private void notifyListenersOfFunction(Object func)
	{
		for(CallGraphListener listener : listeners){
			listener.visitFunction(func);
		}
	}
	
}
