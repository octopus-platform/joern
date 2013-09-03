package tools.ddg;

import java.util.List;

import org.neo4j.graphdb.index.IndexHits;

import output.neo4j.BatchInserter.QueryUtils;

public class BatchInserterFactory extends CFGForDDGFactory{

	CFGForDDGCreation cfg;
	
	public CFGForDDGCreation create(Long funcId)
	{
		cfg = new CFGForDDGCreation();
		
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
			cfg.basicBlocks.add(block);
	}

	private void getUsesAndDefs()
	{
		for(Long basicBlock : cfg.basicBlocks){
			
			List<String> useSymbols = QueryUtils.getSymbolsUsedByBasicBlock(basicBlock);			
			for(String symbol : useSymbols)
				cfg.symbolsUsed.add(basicBlock, symbol);
					
			List<String> defSymbols = QueryUtils.getSymbolsDefinedByBasicBlock(basicBlock);
			for(String symbol : defSymbols)
				cfg.symbolsDefined.add(basicBlock, symbol);				
		}
	}

	private void getParentBlocks()
	{
		for(Long basicBlock : cfg.basicBlocks){
			List<Long> parents = QueryUtils.getParentBasicBlocks(basicBlock);
			for(Long parent : parents){
				cfg.parentBlocks.add(basicBlock, parent);
			}
		}
	}
	
	private void getChildBlocks()
	{
		for(Long basicBlock : cfg.basicBlocks){
			List<Long> parents = QueryUtils.getChildBasicBlocks(basicBlock);
			for(Long parent : parents){
				cfg.childBlocks.add(basicBlock, parent);
			}
		}
	}
	
}
