package udg.useDefAnalysis.environments;

import java.util.ArrayList;
import java.util.Collection;


public class IdentifierEnvironment extends UseDefEnvironment {

	public Collection<String> upstreamSymbols()
	{
		// pass the 'code' of the identifier up stream
		String code = astProvider.getEscapedCodeStr();
		ArrayList<String> retval = new ArrayList<String>();
		retval.add(code);
		return retval;
	}
}
