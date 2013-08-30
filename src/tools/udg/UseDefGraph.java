package tools.udg;

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
	
	public void addDefinition(String identifier, long basicBlockId)
	{
		add(identifier, basicBlockId, true);
	}

	public void addUse(String identifier, long basicBlockId)
	{
		add(identifier, basicBlockId, false);
	}
	
	private void add(String code, long basicBlockId, boolean isDef)
	{
		UseOrDefRecord item = new UseOrDefRecord(basicBlockId, isDef);		
		useOrDefRecordTable.add(code, item);
	}
		
}
