package tests.ddg;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.neo4j.graphdb.index.IndexHits;

import ddg.DDGCreator;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;
import tests.TestDBTestsBatchInserter;
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
			assertTrue((Elementary.getNodeCode( (Long) x.src).startsWith("int x = ")));
			assertTrue((Elementary.getNodeCode( (long) x.dst).startsWith("foo ( x )")));
		}
	
	}

}
