package tools.udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import tools.udg.useDefGraph.UseOrDef;

public class MemberAccessEnvironment extends UseDefEnvironment {

	boolean emitted = false;
	
	String leftMostSymbol = "";
	
	public Collection<String> upstreamSymbols()
	{
		if(emitted) return emptySymbolList;
		
		// emit the entire symbol
		emitted = true;
		LinkedList<String> retval = new LinkedList<String>();
		
		// emit the left-most symbol
		retval.add(leftMostSymbol);	
		
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
