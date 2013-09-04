package tools.ddg.DefUseCFGFactories;

import java.util.List;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.BatchInserter.QueryUtils;

public class BatchInserterFactory extends DefUseCFGFactory{

	DefUseCFG cfg;
	
	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();
		cfg.setFunctionId(funcId);
		
		getBasicBlocksOfFunction(funcId);		
		getUsesAndDefs();		
		getParentBlocks();
		getChildBlocks();
	
		return cfg;
	}

	private void getBasicBlocksOfFunction(Long funcId)
	{
		IndexHits<Long> blocks = QueryUtils.getBasicBlocksFromIndex(funcId);
		for(Long block : blocks)
			cfg.addBasicBlock(block);
	}

	private void getUsesAndDefs()
	{
		for(Long basicBlock : cfg.getBasicBlocks()){
			
			List<String> useSymbols = QueryUtils.getSymbolsUsedByBasicBlock(basicBlock);			
			for(String symbol : useSymbols)
				cfg.addSymbolUsed(basicBlock, symbol);
					
			List<String> defSymbols = QueryUtils.getSymbolsDefinedByBasicBlock(basicBlock);
			for(String symbol : defSymbols)
				cfg.addSymbolDefined(basicBlock, symbol);				
		}
	}

	private void getParentBlocks()
	{
		for(Long basicBlock : cfg.getBasicBlocks()){
			List<Long> parents = QueryUtils.getParentBasicBlocks(basicBlock);
			for(Long parent : parents)
				cfg.addParentBlock(basicBlock, parent);
		}
	}
	
	private void getChildBlocks()
	{
		for(Long basicBlock : cfg.getBasicBlocks()){
			List<Long> children = QueryUtils.getChildBasicBlocks(basicBlock);
			for(Long child : children)
				cfg.addChildBlock(basicBlock, child);
		}
	}
	
}
