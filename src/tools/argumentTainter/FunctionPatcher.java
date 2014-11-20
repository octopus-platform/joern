package tools.argumentTainter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import neo4j.readWriteDB.Neo4JDBInterface;
import neo4j.traversals.readWriteDB.Traversals;

import org.neo4j.graphdb.Node;

import ddg.DefUseCFG.DefUseCFG;
import ddg.DefUseCFG.DefUseCFGFactory;
import ddg.DefUseCFG.ReadWriteDbFactory;

public class FunctionPatcher
{

	private DefUseCFGFactory defUseGraphFactory = new ReadWriteDbFactory();
	private Collection<Node> statementsToPatch = new LinkedList<Node>();
	private DefUseCFG defUseCFG = null;

	private String sourceToPatch;
	private int argumentToPatch;

	public void setSourceToPatch(String source)
	{
		sourceToPatch = source;
	}

	public void setArgumentToPatch(int argToPatch)
	{
		argumentToPatch = argToPatch;
	}

	public void reset()
	{
		statementsToPatch.clear();
		defUseCFG = null;
	}

	public void patch(Long funcId)
	{
		Neo4JDBInterface.startTransaction();
		determineCallsToPatch(funcId);
		retrieveDefUseCFGFromDatabase(funcId);
		Neo4JDBInterface.finishTransaction();
		patchDefUseCFG();
		patchDDG(funcId);
	}

	private void determineCallsToPatch(Long funcId)
	{
		
		List<Node> callNodes = Traversals.getCallsToForFunction(sourceToPatch,
				funcId);
		for (Node callNode : callNodes)
		{
			statementsToPatch.add(Traversals.getStatementForASTNode(callNode));
		}
	}

	private void retrieveDefUseCFGFromDatabase(long funcId)
	{
		defUseCFG = defUseGraphFactory.create(funcId);
	}

	private void patchDefUseCFG()
	{
		DefUseCFGPatcher patcher = new DefUseCFGPatcher();
		patcher.setSourceToPatch(sourceToPatch, argumentToPatch);
		patcher.patchDefUseCFG(defUseCFG, statementsToPatch);
		patcher.writeChangesToDatabase();
	}

	private void patchDDG(Long funcId)
	{
		DDGPatcher patcher = new DDGPatcher();
		Neo4JDBInterface.startTransaction();
		patcher.patchDDG(defUseCFG, funcId);
		Neo4JDBInterface.finishTransaction();
		patcher.writeChangesToDatabase();
	}
}
