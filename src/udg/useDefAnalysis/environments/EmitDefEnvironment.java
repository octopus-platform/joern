package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import udg.useDefGraph.UseOrDef;

public class EmitDefEnvironment extends UseDefEnvironment {

	Collection<String> defSymbols = new LinkedList<String>();
	
	public void addChildSymbols(LinkedList<String> childSymbols)
	{
		if(isDef()){
			// add definition only for the last symbol, e.g.,
			// for x.y.z = 10, add a def for x.y.z only.
			
			if(childSymbols.size() > 1) {
				
				defSymbols.add(childSymbols.getLast());
				
			}else
				defSymbols.addAll(childSymbols);
		}
		if(isUse())
			symbolsForUpstream.addAll(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromChildSymbols()
	{
		
		if(!isDef())
			return emptyUseOrDef;
	
		LinkedList<UseOrDef> retval = createDefsForAllSymbols(defSymbols);	
		return retval;
	}
	
}
