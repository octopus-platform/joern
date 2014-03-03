package tools.udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import tools.udg.useDefGraph.UseOrDef;

public class EmitDefEnvironment extends UseDefEnvironment {

	Collection<String> defSymbols = new LinkedList<String>();
	
	public void addChildSymbols(Collection<String> childSymbols)
	{
		if(isDef()){
			// add a definition for all but the first symbol,
			// e.g. for x.y = 10, add a def only for x.y but
			// not for x.
			if(childSymbols.size() > 1) {
				
				Iterator<String> iterator = childSymbols.iterator();
				iterator.next();
				while(iterator.hasNext()){
					String next = iterator.next();
					defSymbols.add(next);
				}
				
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
