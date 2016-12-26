package tests.argumentTainter;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import neo4j.readWriteDB.Neo4JDBInterface;
import neo4j.traversals.readWriteDB.Traversals;

import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.IndexHits;

import tests.TestDBTestReadWriteDB;
import tools.argumentTainter.DefUseCFGPatcher;
import tools.argumentTainter.DefUseCFGPatcher.DefUseLink;
import ddg.DefUseCFG.DefUseCFG;
import ddg.DefUseCFG.DefUseCFGFactory;
import ddg.DefUseCFG.ReadWriteDbFactory;

public class TestArgumentTainter extends TestDBTestReadWriteDB
{
	private DefUseCFGFactory defUseGraphFactory = new ReadWriteDbFactory();

	@Test
	public void testDefUseCFGPatcher()
	{
	
		Long funcId = getFunctionIdByFunctionName("arg_tainter_basic_test");
		List<Node> statementsToPatch = getStatementsToPatch(funcId, "memset");
		
		DefUseCFGPatcher defUseCFGPatcher = new DefUseCFGPatcher();
		DefUseCFG defUseCFG = defUseGraphFactory.create(funcId);
		
		defUseCFGPatcher.setSourceToPatch("memset", 0);
		defUseCFGPatcher.patchDefUseCFG(defUseCFG, statementsToPatch);

		Collection<DefUseLink> defUseLinksToAdd = defUseCFGPatcher
				.getDefUseLinksToAdd();

		assertTrue(defUseLinksToAdd.size() == 4);
		
		for (DefUseLink a : defUseLinksToAdd)
		{
			assertTrue(a.symbol.contains("myVar"));
		}

	}

	@Test
	public void testDDGPatcher()
	{

	}

	private List<Node> getStatementsToPatch(Long funcId, String source)
	{
		List<Node> statementsToPatch = new LinkedList<Node>();
		List<Node> callNodes = Traversals.getCallsToForFunction(source, funcId);
		for (Node callNode : callNodes)
		{
			statementsToPatch.add(Traversals.getStatementForASTNode(callNode));
		}
		return statementsToPatch;
	}

	private Long getFunctionIdByFunctionName(String functionName)
	{
		IndexHits<Node> hits = Traversals.getFunctionsByName(functionName);
		Long funcId = hits.next().getId();
		return funcId;
	}
}
