package tools.udg.environments;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import tools.udg.DBProvider;
import tools.udg.UseOrDef;

// This is both the base class of all UseDefEnvironments
// and the default implementation

public class UseDefEnvironment{
	
	protected String childType;
	protected int childNum;
	protected long nodeId;
	protected DBProvider dbProvider;
	
	Collection<String> symbolsForUpstream = new HashSet<String>();
	
	static final Collection<UseOrDef> emptyUseOrDef = new LinkedList<UseOrDef>();
	static final Collection<String> emptySymbolHash = new HashSet<String>();
	
	public boolean isUse() { return false; }
	public boolean isDef() { return false; }
	public boolean shouldTraverse() { return true; }

	
	public void setDBProvider(DBProvider dbProvider)
	{
		this.dbProvider = dbProvider;
	}
	
	public void setNodeId(long nodeId)
	{
		this.nodeId = nodeId;
	}
	
	public void setChild(String childType, int childNum)
	{
		this.childType = childType;
		this.childNum = childNum;
	}
	
	
	// default behaviour is simply to propgate all
	// symbols received
	
	public Collection<String> upstreamSymbols()
	{
		return symbolsForUpstream;
	}

	
	public void addChildSymbols(Collection<String> childSymbols)
	{
		symbolsForUpstream.addAll(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{	
		return emptyUseOrDef;
	}

	public LinkedList<UseOrDef> createDefsForAllSymbols(Collection<String> symbols)
	{
		return createDefOrUseForSymbols(symbols, true);
	}
	
	public LinkedList<UseOrDef> createUsesForAllSymbols(Collection<String> symbols)
	{
		return createDefOrUseForSymbols(symbols, false);
	}
	
	private LinkedList<UseOrDef> createDefOrUseForSymbols(Collection<String> symbols, boolean isDef)
	{
		LinkedList<UseOrDef> retval = new LinkedList<UseOrDef>();
		for(String s : symbols){
			UseOrDef useOrDef = new UseOrDef();
			useOrDef.isDef = isDef;
			useOrDef.symbol = s;
			useOrDef.nodeId = this.nodeId ;
			retval.add(useOrDef);
		}
		return retval;
	}
	public int getChildNum()
	{
		return childNum;
	}
	
};