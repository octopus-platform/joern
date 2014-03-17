package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefGraph.UseOrDef;

// This is both the base class of all UseDefEnvironments
// and the default implementation

public class UseDefEnvironment{
	
	protected String childType;
	protected int childNum;
	protected ASTProvider astProvider;
	
	LinkedList<String> symbolsForUpstream = new LinkedList<String>();
	
	static final LinkedList<UseOrDef> emptyUseOrDef = new LinkedList<UseOrDef>();
	static final LinkedList<String> emptySymbolList = new LinkedList<String>();
	
	public boolean isUse() { return false; }
	public boolean isDef() { return false; }
	public boolean shouldTraverse() { return true; }

	public void setASTProvider(ASTProvider anASTProvider)
	{
		this.astProvider = anASTProvider;
	}
	
	public void setChild(String childType, int childNum)
	{
		this.childType = childType;
		this.childNum = childNum;
	}
	
	
	// default behavior is simply to propagate all
	// symbols received
	
	public LinkedList<String> upstreamSymbols()
	{
		return symbolsForUpstream;
	}

	
	public void addChildSymbols(LinkedList<String> childSymbols)
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
			useOrDef.astProvider = this.astProvider ;
			retval.add(useOrDef);
		}
		return retval;
	}
	public int getChildNum()
	{
		return childNum;
	}
	
};