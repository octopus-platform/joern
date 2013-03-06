package main;

import java.util.Iterator;
import java.util.Stack;

import main.codeitems.ClassDef;
import main.codeitems.CodeItem;
import main.codeitems.FunctionDef;
import main.codeitems.IdentifierDecl;
import main.codeitems.Parameter;

import org.antlr.v4.runtime.ParserRuleContext;

class CSVPrinter extends Printer
{
    
    private static final String SEPARATOR = "\t";
    
    @Override
    public void startOfUnit(String nodeTypeName, ParserRuleContext ctx, String codeStr)
    {	
    	CodeItem item = new CodeItem();
    	item.nodeTypeName = nodeTypeName;
    	item.location = new CodeLocation(ctx);
    	item.codeStr = codeStr;	
    	defaultOut(item, 0);
    }
    
    @Override
    public void printItem(CodeItem item, Stack<CodeItem> itemStack)
    {
    	switch(item.nodeTypeName){
    	case "FUNCTION_DEF":
    		outputFunctionDef(item, itemStack);
    		break;
    	case "CLASS_DEF":
    		outputClassDef(item, itemStack);
    		break;
    	case "DECL":
    		outputDecl(item, itemStack);
    		break;
    	default:
    			defaultOut(item, itemStack.size());
    			break;
    	}
    }


	private void outputFunctionDef(CodeItem aItem, Stack<CodeItem> itemStack)
    {
    	int level = itemStack.size();
		FunctionDef item = (FunctionDef) aItem;
    	defaultOut(item, level);
    	defaultOut(item.returnType, level + 1);
    	defaultOut(item.name, level + 1);
    	if(item.parameterList != null){
    		defaultOut(item.parameterList, level + 1);
    		Iterator<Parameter> i = item.parameterList.parameters.iterator();
    		for(; i.hasNext();){
    			Parameter p = i.next();
    			defaultOut(p, level+2);
    			defaultOut(p.type, level+2);
    			defaultOut(p.name, level+2);
    		}
    	}
    }

    private void outputClassDef(CodeItem aItem, Stack<CodeItem> itemStack)
    {
    	int level = itemStack.size();
    	ClassDef item = (ClassDef) aItem;
    	
    	if(item.name != null){
    		item.codeStr = item.name.codeStr;
    		defaultOut(item, level);
    		defaultOut(item.name, level + 1);
    	}else{
    		defaultOut(item, level);
    	}
    }

    private void outputDecl(CodeItem aItem, Stack<CodeItem> itemStack)
	{
    	IdentifierDecl item = (IdentifierDecl) aItem;
    	int level = itemStack.size();
    	
    	item.codeStr = item.name.codeStr;
    	if(item.type.completeType != "")
    		item.codeStr = item.type.completeType + " " + item.name.codeStr;
    	defaultOut(item, level);
	}
    
    
    private void defaultOut(CodeItem item, int level)
    {
    	if(item == null) return;
    	
    	String output = item.nodeTypeName + SEPARATOR;
    	output += createLocationString(item) + SEPARATOR + level;
    	output += SEPARATOR + escapeCodeStr(item.codeStr);
    	System.out.println(output);
    }
    
    private String createLocationString(CodeItem item)
    {
    	CodeLocation loc = item.location;
    	String startLoc = loc.startLine + ":" + loc.startPos;
    	String indices = loc.startIndex + ":" + loc.stopIndex;
    	return startLoc + SEPARATOR + indices;
    }
    
    private String escapeCodeStr(String codeStr)
    {
    	String retval = codeStr;
    	retval = retval.replace("\n", "\\n");
    	retval = retval.replace("\t", "\\t");
    	return retval;
    }

	@Override
	public void endOfUnit(String nodeTypeName, ParserRuleContext ctx,
			String codeStr)
	{
		
	}
    
}
