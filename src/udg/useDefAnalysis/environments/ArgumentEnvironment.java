package udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;

public class ArgumentEnvironment extends EmitDefAndUseEnvironment
{

	boolean isTainted = false;

	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		if (isDef(child)){
			// For tainted arguments, add "* symbol" instead of symbol
			// to defined symbols. Make an exception if symbol starts with '& '
			
			LinkedList<String> derefChildSymbols = new LinkedList<String>();
			for(String symbol : childSymbols){
				
				if(!symbol.startsWith("& ")){
					derefChildSymbols.add("* " + symbol);
					// !patch to see if we can detect macro-sources!
					derefChildSymbols.add(symbol);
				}else
					derefChildSymbols.add(symbol.substring(2));	
			}
			
			defSymbols.addAll(derefChildSymbols);
		}
		if (isUse(child))
			useSymbols.addAll(childSymbols);
	}
	
	public boolean isUse(ASTProvider child)
	{
		return true;
	}

	public boolean isDef(ASTProvider child)
	{
		return isTainted;
	}

	public void setIsTainted()
	{
		isTainted = true;
	}

}
