package outputModules;

import java.util.Iterator;
import java.util.List;

import misc.MultiHashMap;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;
import databaseNodes.FunctionDatabaseNode;

public abstract class UDGImporter
{
	protected FunctionDatabaseNode currentFunction;

	public void setCurrentFunction(FunctionDatabaseNode function)
	{
		currentFunction = function;
	}

	public void addUDGToDatabase(UseDefGraph graph)
	{
		MultiHashMap<String, UseOrDefRecord> useDefDict = graph.getUseDefDict();

		Iterator<String> it = useDefDict.getKeySetIterator();

		while (it.hasNext())
		{
			String identifier = it.next();
			long symbolNodeId = createSymbolNode(identifier);
			addUseDefEdges(useDefDict, identifier, symbolNodeId);
		}

	}

	private void addUseDefEdges(
			MultiHashMap<String, UseOrDefRecord> useDefDict, String identifier,
			long symbolNodeId)
	{

		List<UseOrDefRecord> destinations = useDefDict.get(identifier);

		for (UseOrDefRecord item : destinations)
		{
			addUseOrDefRecordToDatabase(symbolNodeId, item);
		}
	}

	protected abstract void addUseOrDefRecordToDatabase(long symbolNodeId,
			UseOrDefRecord item);

	protected abstract long createSymbolNode(String identifier);

}
