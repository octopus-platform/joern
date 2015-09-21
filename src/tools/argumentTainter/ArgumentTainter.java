package tools.argumentTainter;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.neo4j.graphdb.Node;

import neo4j.readWriteDB.Neo4JDBInterface;
import neo4j.traversals.readWriteDB.Traversals;

// Determine functions to patch and hand over
// individual functions to FunctionPatcher

public class ArgumentTainter
{

	HashMap<Long, CallsForFunction> sourceCallsByFuncId;
	Collection<Long> functionsToPatch = new HashSet<Long>();
	FunctionPatcher functionPatcher = new FunctionPatcher();
	private String source;

	public void initialize(String databaseDir)
	{
		Neo4JDBInterface.setDatabaseDir(databaseDir);
		Neo4JDBInterface.openDatabase();
	}

	public void setSourceToPatch(String sourceToPatch)
	{
		source = sourceToPatch;
		functionPatcher.setSourceToPatch(sourceToPatch);
	}

	public void setArgToPatch(int taintedArg)
	{
		functionPatcher.setArgumentToPatch(taintedArg);
	}

	public void patch()
	{
		determineFunctionsToPatch(source);

		for (Long funcId : functionsToPatch)
			patchFunction(funcId);

	}

	private void determineFunctionsToPatch(String source)
	{

		List<Node> hits = Traversals.getCallsTo(source);

		for (Node callASTNode : hits)
		{
			Long functionId = Traversals.getFunctionIdFromASTNode(callASTNode);
			functionsToPatch.add(functionId);
		}

	}

	public void patchFunction(Long funcId)
	{
		functionPatcher.reset();
		functionPatcher.patch(funcId);
	}

	public void shutdown()
	{
		Neo4JDBInterface.closeDatabase();
	}

}
