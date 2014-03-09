package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.useDefGraph.UseOrDef;

public class EmitDefAndUseEnvironment extends UseDefEnvironment {

	Collection<String> defSymbols = new LinkedList<String>();
	Collection<String> useSymbols = new LinkedList<String>();
	
	public void addChildSymbols(LinkedList<String> childSymbols)
	{
		if(isDef())
			defSymbols.addAll(childSymbols);
		if(isUse())
			useSymbols.addAll(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{
		LinkedList<UseOrDef> retval = new LinkedList<UseOrDef>();
		
		if(isDef())
			retval.addAll(createDefsForAllSymbols(defSymbols));
	
		if(isUse())
			retval.addAll(createUsesForAllSymbols(useSymbols));
			
		return retval;
	}
	
	public LinkedList<String> upstreamSymbols()
	{
		return emptySymbolList;
	}
	
}
