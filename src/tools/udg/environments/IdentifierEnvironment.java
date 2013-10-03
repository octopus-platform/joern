package tools.udg.environments;

import java.util.ArrayList;
import java.util.Collection;

import output.neo4j.batchInserter.QueryUtils;


public class IdentifierEnvironment extends UseDefEnvironment {

	public Collection<String> upstreamSymbols()
	{
		// pass the 'code' of the identifier up stream
		String code = dbProvider.getNodeCode(nodeId);
		ArrayList<String> retval = new ArrayList<String>();
		retval.add(code);
		return retval;
	}
}
