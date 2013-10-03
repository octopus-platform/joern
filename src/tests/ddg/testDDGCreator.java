package tests.ddg;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.batchInserter.QueryUtils;
import tests.TestDBTestsBatchInserter;
import tools.ddg.DDG;
import tools.ddg.DDGCreator;
import tools.ddg.DefUseRelation;

public class testDDGCreator extends TestDBTestsBatchInserter{

	@Test
	public void simplestTest()
	{
		IndexHits<Long> hits = QueryUtils.getFunctionsByName("ddg_simplest_test");
		long functionId = hits.next();
		DDGCreator ddgCreator = new DDGCreator();
		DDG ddg = ddgCreator.createForFunctionById(functionId);
	
		Set<DefUseRelation> reachesLinks = ddg.getDefUseEdges();
		
		assertTrue(reachesLinks.size() == 1);
		
		for(DefUseRelation x : ddg.getDefUseEdges()){
			assertTrue((QueryUtils.getNodeCode(x.src).startsWith("int x = ")));
			assertTrue((QueryUtils.getNodeCode(x.dst).startsWith("foo ( x )")));
		}
	
	}

}
