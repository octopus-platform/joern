package tests.ddg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.neo4j.graphdb.index.IndexHits;

import cfg.CFG;
import ddg.CFGAndUDGToDefUseCFG;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;
import ddg.DefUseCFG.BatchInserterFactory;
import ddg.DefUseCFG.DatabaseDDGCreator;
import ddg.DefUseCFG.DefUseCFG;
import neo4j.traversals.batchInserter.Elementary;
import neo4j.traversals.batchInserter.Function;
import tests.TestDBTestsBatchInserter;
import tests.udg.CFGCreator;
import udg.CFGToUDGConverter;
import udg.useDefAnalysis.CASTDefUseAnalyzer;
import udg.useDefGraph.UseDefGraph;

public class testDDGCreator extends TestDBTestsBatchInserter
{

	@Test
	public void simplestTest()
	{
		IndexHits<Long> hits = Function.getFunctionsByName("ddg_simplest_test");
		long functionId = hits.next();
		DatabaseDDGCreator ddgCreator = new DatabaseDDGCreator();
		DDG ddg = ddgCreator.createForFunctionById(functionId);

		Set<DefUseRelation> reachesLinks = ddg.getDefUseEdges();

		assertTrue(reachesLinks.size() == 1);

		for (DefUseRelation x : ddg.getDefUseEdges())
		{
			assertTrue((Elementary.getNodeCode((Long) x.src)
					.startsWith("int x = ")));
			assertTrue((Elementary.getNodeCode((long) x.dst)
					.startsWith("foo ( x )")));
		}

	}

	@Test
	public void testConverter()
	{
		IndexHits<Long> hits = Function.getFunctionsByName("ddg_simplest_test");
		long funcId = hits.next();
		BatchInserterFactory cfgFactory = new BatchInserterFactory();
		DefUseCFG defUseCfgDb = cfgFactory.create(funcId);

		CFGCreator cfgCreator = new CFGCreator();
		CFGToUDGConverter converter = new CFGToUDGConverter();
		converter.setASTDefUseAnalyzer(new CASTDefUseAnalyzer());
		CFGAndUDGToDefUseCFG converter2 = new CFGAndUDGToDefUseCFG();

		CFG cfg = cfgCreator.getCFGForCode("f(){ int x = 0; foo(x);}");
		UseDefGraph udg = converter.convert(cfg);
		DefUseCFG defUseCfg = converter2.convert(cfg, udg);

		assertEquals(defUseCfg.getStatements().size(),
				defUseCfgDb.getStatements().size());
		assertEquals(defUseCfg.getParentBlocks().size(),
				defUseCfgDb.getParentBlocks().size());
		assertEquals(defUseCfg.getChildBlocks().size(),
				defUseCfgDb.getChildBlocks().size());

		assertEquals(defUseCfg.getSymbolsDefined().size(),
				defUseCfgDb.getSymbolsDefined().size());
		assertEquals(defUseCfg.getSymbolsUsed().size(),
				defUseCfgDb.getSymbolsUsed().size());

	}

}
