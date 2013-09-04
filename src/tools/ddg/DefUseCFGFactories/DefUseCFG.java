package tools.ddg.DefUseCFGFactories;

import java.util.LinkedList;

import misc.MultiHashMap;

/**
 * A CFG decorated with USE and DEFs suitable to
 * determine reaching definitions.
 * */

public class DefUseCFG {

	private LinkedList<Long> basicBlocks = new LinkedList<Long>();
	private MultiHashMap symbolsUsed = new MultiHashMap();
	private MultiHashMap symbolsDefined = new MultiHashMap();
	private MultiHashMap parentBlocks = new MultiHashMap();
	private MultiHashMap childBlocks = new MultiHashMap();
	
	public void addBasicBlock(long basicBlockId)
	{
		basicBlocks.add(basicBlockId);
	}
	
	public void addSymbolUsed(Long key, String symbol)
	{
		symbolsUsed.add(key, symbol);
	}
	
	public void addSymbolDefined(Long key, String symbol)
	{
		symbolsDefined.add(key, symbol);
	}
	
	public void addParentBlock(long thisBlockId, long parentId)
	{
		parentBlocks.add(thisBlockId, parentId);
	}
	
	public void addChildBlock(long thisBlockId, long childId)
	{
		childBlocks.add(thisBlockId, childId);
	}
	
	public LinkedList<Long> getBasicBlocks() {
		return basicBlocks;
	}
	
	public MultiHashMap getSymbolsUsed() {
		return symbolsUsed;
	}
		
	public MultiHashMap getSymbolsDefined() {
		return symbolsDefined;
	}
	
	public MultiHashMap getParentBlocks() {
		return parentBlocks;
	}
	
	public MultiHashMap getChildBlocks() {
		return childBlocks;
	}
	
}
