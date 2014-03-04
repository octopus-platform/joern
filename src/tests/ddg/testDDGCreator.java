package tests.ddg;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.neo4j.graphdb.index.IndexHits;

import tests.TestDBTestsBatchInserter;
import tools.ddg.DDGCreator;
import tools.ddg.DataDependenceGraph.DDG;
import tools.ddg.DataDependenceGraph.DefUseRelation;
import traversals.batchInserter.Elementary;
import traversals.batchInserter.Function;

public class testDDGCreator extends TestDBTestsBatchInserter{

	@Test
	public void simplestTest()
	{
		IndexHits<Long> hits = Function.getFunctionsByName("ddg_simplest_test");
		long functionId = hits.next();
		DDGCreator ddgCreator = new DDGCreator();
		DDG ddg = ddgCreator.createForFunctionById(functionId);
	
		Set<DefUseRelation> reachesLinks = ddg.getDefUseEdges();
		
		assertTrue(reachesLinks.size() == 1);
		
		for(DefUseRelation x : ddg.getDefUseEdges()){
			assertTrue((Elementary.getNodeCode(x.src).startsWith("int x = ")));
			assertTrue((Elementary.getNodeCode(x.dst).startsWith("foo ( x )")));
		}
	
	}

}
