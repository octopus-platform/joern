package tools.udg.environments;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import tools.udg.UseOrDef;

public class MemberAccessEnvironment extends UseDefEnvironment {

	boolean emitted = false;
	
	String leftMostSymbol = "";
	
	public Collection<String> upstreamSymbols()
	{
		if(emitted) return emptySymbolHash;
		
		// emit the entire symbol
		emitted = true;
		HashSet<String> retval = new HashSet<String>();
		retval.add(dbProvider.getNodeCode(nodeId));
		return retval; 
	}

	public void addChildSymbols(Collection<String> childSymbols)
	{
		if(childNum == 0 && childSymbols.size() == 1){
			leftMostSymbol = childSymbols.iterator().next();
		}
	}
	
	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{	
		if(childNum != 0)
			return emptyUseOrDef;
		
		LinkedList<String> symbols = new LinkedList<String>();
		symbols.add(leftMostSymbol);
	
		return createUsesForAllSymbols(symbols);
	}
		
}
