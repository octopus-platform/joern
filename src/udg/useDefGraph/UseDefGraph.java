package udg.useDefGraph;

import java.util.List;

import astnodes.ASTNode;
import cfg.CFGNode;
import misc.MultiHashMap;

public class UseDefGraph {
	
	// A UseDefGraph is a table indexed
	// by identifiers. Each table-entry
	// is a list of the UseOrDefRecords
	// of the identifier.
	
	MultiHashMap useOrDefRecordTable = new MultiHashMap();
	
	public MultiHashMap getUseDefDict()
	{
		return useOrDefRecordTable;
	}
	
	public List<Object> getUsesAndDefsForSymbol(String symbol)
	{
		return useOrDefRecordTable.getListForKey(symbol);
	}
	
	public void addDefinition(String identifier, ASTNode astNode)
	{
		add(identifier, astNode, true);
	}

	public void addUse(String identifier, ASTNode astNode)
	{
		add(identifier, astNode, false);
	}
	
	private void add(String identifier, ASTNode astNode, boolean isDef)
	{
		UseOrDefRecord record = new UseOrDefRecord(astNode, isDef);		
		useOrDefRecordTable.add(identifier, record);
	}
		
}
