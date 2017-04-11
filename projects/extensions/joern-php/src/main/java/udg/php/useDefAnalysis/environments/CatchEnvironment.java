package udg.php.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class CatchEnvironment extends UseDefEnvironment
{
	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		// the second child contains the exception variable's symbol
		int childNum = child.getChildNumber();
		if( 1 == childNum)
			this.symbols.addAll(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		// symbols should contain exactly one string, coming from the second child,
		// added previously by addChildSymbols()
		LinkedList<UseOrDef> retval = createDefsForAllSymbols(symbols);
		return retval;
	}
	
	// a CatchStatement uses exactly one variable whose name is contained in its second child;
	// no need to traverse any other children
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 1 == childNum ? true : false;
	}
}
