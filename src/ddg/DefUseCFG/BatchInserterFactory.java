package ddg.DefUseCFG;

import java.util.List;

import neo4j.traversals.batchInserter.CFG;

import org.neo4j.graphdb.index.IndexHits;

public class BatchInserterFactory extends DefUseCFGFactory
{

	DefUseCFG cfg;

	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();

		getStatementsOfFunction(funcId);
		getUsesAndDefs();
		getParentBlocks();
		getChildBlocks();

		return cfg;
	}

	private void getStatementsOfFunction(Long funcId)
	{
		IndexHits<Long> blocks = CFG.getStatementsFromIndex(funcId);
		for (Long block : blocks)
			cfg.addStatement(block);
	}

	private void getUsesAndDefs()
	{
		for (Object obj : cfg.getStatements())
		{
			Long statement = (Long) obj;

			List<String> useSymbols = CFG.getSymbolsUsedByStatement(statement);
			for (String symbol : useSymbols)
				cfg.addSymbolUsed(statement, symbol);

			List<String> defSymbols = CFG
					.getSymbolsDefinedByStatement(statement);
			for (String symbol : defSymbols)
				cfg.addSymbolDefined(statement, symbol);
		}
	}

	private void getParentBlocks()
	{
		for (Object obj : cfg.getStatements())
		{
			Long statement = (Long) obj;

			List<Long> parents = CFG.getParentStatements(statement);
			for (Long parent : parents)
				cfg.addParentBlock(statement, parent);
		}
	}

	private void getChildBlocks()
	{
		for (Object obj : cfg.getStatements())
		{
			Long statement = (Long) obj;

			List<Long> children = CFG.getChildStatements(statement);
			for (Long child : children)
				cfg.addChildBlock(statement, child);
		}
	}

}
