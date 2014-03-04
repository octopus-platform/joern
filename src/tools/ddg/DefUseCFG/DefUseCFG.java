package tools.ddg.DefUseCFG;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import misc.MultiHashMap;

/**
 * A CFG decorated with USE and DEFs suitable to
 * determine reaching definitions.
 * This contains the same information as a UseDefGraph (UDG)
 * but in a format better suited for DDG creation.
 * */

public class DefUseCFG {

	private long functionId;
	private LinkedList<Long> statements = new LinkedList<Long>();
	private MultiHashMap symbolsUsed = new MultiHashMap();
	private MultiHashMap symbolsDefined = new MultiHashMap();
	private MultiHashMap parentBlocks = new MultiHashMap();
	private MultiHashMap childBlocks = new MultiHashMap();
	private Map<String, Long> symbolIds = new HashMap<String, Long>();
	
	private static final List<Object> EMPTY_LIST = new LinkedList<Object>();
	
	public void setFunctionId(long anId)
	{
		functionId = anId;
	}
	
	public long getFunctionId()
	{
		return functionId;
	}
	
	public void addStatement(long statementId)
	{
		statements.add(statementId);
	}
	
	public void addSymbolUsed(Long key, String symbol)
	{
		symbolsUsed.add(key, symbol);
	}
	
	public void addSymbolDefined(Long key, String symbol)
	{
		symbolsDefined.add(key, symbol);
	}
	
	public Collection<Object> getSymbolsDefinedBy(Long blockId)
	{
		List<Object> listForKey = symbolsDefined.getListForKey(blockId);
		if(listForKey == null) return EMPTY_LIST;
		return listForKey;
	}
	
	public void addParentBlock(long thisBlockId, long parentId)
	{
		parentBlocks.add(thisBlockId, parentId);
	}
	
	public void addChildBlock(long thisBlockId, long childId)
	{
		childBlocks.add(thisBlockId, childId);
	}
	
	public LinkedList<Long> getStatements() {
		return statements;
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

	public Long getIdForSymbol(String symbol)
	{
		return symbolIds.get(symbol);
	}

	public void setSetSymbolId(String symbolCode, Long symbolId)
	{
		symbolIds.put(symbolCode, symbolId);
	}
	
}
