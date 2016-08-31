package udg.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class UseEnvironment extends UseDefEnvironment
{

	public boolean isUse(ASTProvider child)
	{
		return true;
	}

	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		LinkedList<UseOrDef> retval = new LinkedList<UseOrDef>();
		retval.addAll(createUsesForAllSymbols(symbols));
		return retval;
	}

}
