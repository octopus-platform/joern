package udg.useDefAnalysis.environments;

import java.util.LinkedList;

import udg.ASTProvider;

public class UnaryOpEnvironment extends EmitUseEnvironment
{
	
	public void addChildSymbols(LinkedList<String> childSymbols,
			ASTProvider child)
	{
		
		String codeStr = astProvider.getEscapedCodeStr();
		
		if(codeStr != null && codeStr.startsWith("&")){
			for(String symbol : childSymbols){
				symbols.add("& " + symbol);
			}
			return;
		}
		
		if(codeStr == null|| !codeStr.startsWith("*")){
			symbols.addAll(childSymbols);
			return;
		}
			
		LinkedList<String> retval = new LinkedList<String>();
			
		// emit all symbols as '* symbol'
		
		LinkedList<String> derefedChildren = new LinkedList<String>();
		for(String c : childSymbols){
			derefedChildren.add("* " + c);
		}
		
		retval.addAll(derefedChildren);

		// emit entire code string
		retval.add(codeStr);
	
		useSymbols.addAll(childSymbols);
		symbols.addAll(retval);
		
	}
}
