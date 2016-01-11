package languages.php.udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;

public class PropertyEnvironment extends UseDefEnvironment
{

	// simply return the list of symbols added earlier by addChildSymbols
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		return this.symbols;
	}
	
	// add the *object's name* of the property access expression to the child symbols
	public void addChildSymbols(LinkedList<String> childSymbols, ASTProvider child)
	{
		int childNum = child.getChildNumber();
		// Only add the left child but never the right child
		// e.g., in $foo->bar, we only add $foo but not $bar.
		if( 0 == childNum)
			this.symbols.addAll(childSymbols);
	}
}
