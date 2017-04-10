package udg.php.useDefAnalysis.environments;

import java.util.Collection;
import java.util.LinkedList;

import udg.ASTProvider;
import udg.useDefAnalysis.environments.UseDefEnvironment;
import udg.useDefGraph.UseOrDef;

public class ArrayIndexingEnvironment extends UseDefEnvironment
{
	private Collection<String> useSymbols = new LinkedList<String>();
	
	private boolean emitUse = false;
	
	// pass the 'code' of the array upstream (i.e., the array's name)
	// by recursion, this is already contained in the symbols field
	@Override
	public LinkedList<String> upstreamSymbols()
	{	
		return symbols;
	}
	
	public void addChildSymbols( LinkedList<String> childSymbols, ASTProvider child)
	{
		// add the index element(s) to the useSymbols 
		if( isUse( child))
			useSymbols.addAll( childSymbols);
		
		// the name of the array is a symbol to be passed upstream
		else
			symbols.addAll(childSymbols);
	}

	public Collection<UseOrDef> useOrDefsFromSymbols(ASTProvider child)
	{
		LinkedList<UseOrDef> retval = new LinkedList<UseOrDef>();

		if( isUse( child))
			retval.addAll(createUsesForAllSymbols(useSymbols));

		// if we are analyzing a standalone array access, then the
		// array's name should also be emitted as USE
		if( this.emitUse)
			retval.addAll(createUsesForAllSymbols(upstreamSymbols()));
		
		return retval;
	}
	
	@Override
	public boolean isUse( ASTProvider child)
	{
		int childNum = child.getChildNumber();
		return 1 == childNum ? true : false;
	}
	
	public void setEmitUse( boolean emitUse) {
		this.emitUse = emitUse;
	}
}
