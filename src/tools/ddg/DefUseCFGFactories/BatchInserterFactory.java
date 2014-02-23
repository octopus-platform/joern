package tools.ddg.DefUseCFGFactories;

import java.util.List;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.batchInserter.QueryUtils;

public class BatchInserterFactory extends DefUseCFGFactory{

	DefUseCFG cfg;
	
	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();
		cfg.setFunctionId(funcId);
		
		getStatementsOfFunction(funcId);		
		getUsesAndDefs();		
		getParentBlocks();
		getChildBlocks();
	
		return cfg;
	}

	private void getStatementsOfFunction(Long funcId)
	{
		IndexHits<Long> blocks = QueryUtils.getStatementsFromIndex(funcId);
		for(Long block : blocks)
			cfg.addStatement(block);
	}

	private void getUsesAndDefs()
	{
		for(Long statement : cfg.getStatements()){
			
			List<String> useSymbols = QueryUtils.getSymbolsUsedByStatement(statement);			
			for(String symbol : useSymbols)
				cfg.addSymbolUsed(statement, symbol);
					
			List<String> defSymbols = QueryUtils.getSymbolsDefinedByStatement(statement);
			for(String symbol : defSymbols)
				cfg.addSymbolDefined(statement, symbol);				
		}
	}

	private void getParentBlocks()
	{
		for(Long statement : cfg.getStatements()){
			List<Long> parents = QueryUtils.getParentStatements(statement);
			for(Long parent : parents)
				cfg.addParentBlock(statement, parent);
		}
	}
	
	private void getChildBlocks()
	{
		for(Long statement : cfg.getStatements()){
			List<Long> children = QueryUtils.getChildStatements(statement);
			for(Long child : children)
				cfg.addChildBlock(statement, child);
		}
	}
	
}
