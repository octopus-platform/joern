package tools.udg.environments;

import java.util.Collection;
import java.util.HashSet;

import tools.udg.UseOrDef;

public class MemberAccessEnvironment extends UseDefEnvironment {

	boolean emitted = false;
	
	// emit 'use' for left hand side
	// and def for complete node
	
//	@Override
//	public boolean shouldTraverse()
//	{
//		if(childType != null && childNum == 1  &&
//		   childType.equals("Identifier"))
//			return false;				
//		
//		return true;
//	}

	public Collection<String> upstreamSymbols()
	{
		if(emitted) return emptySymbolHash;
		
		// emit the entire symbol
		emitted = true;
		HashSet<String> retval = new HashSet<String>();
		retval.add(dbProvider.getNodeCode(nodeId));
		return retval; 
	}
	
}
