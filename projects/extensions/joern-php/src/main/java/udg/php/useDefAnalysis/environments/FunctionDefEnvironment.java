package udg.php.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class FunctionDefEnvironment extends UseDefEnvironment
{
	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		// the first and second children contain the parameters, respectively
		// the used variables (for a closure)
		int childNum = child.getChildNumber();
		if( 0 == childNum || 1 == childNum)
			this.symbols.addAll(childSymbols);
	}
	
	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		// simply created DEFs for all collected symbols, which correspond
		// to the parameters, respectively to the used variables (for a closure)
		LinkedList<UseOrDef> retval = createDefsForAllSymbols(this.symbols);
		return retval;
	}
	
	// a FunctionDef has it DEF'ed symbols only in the first and second children;
	// no need to traverse any other children
	@Override
	public boolean shouldTraverse(ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 0 == childNum || 1 == childNum ? true : false;
	}
}
