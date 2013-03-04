package main;

import java.util.Iterator;

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
    	defaultOut(item);
    }
    
    @Override
    public void printItem(CodeItem item)
    {
    	switch(item.nodeTypeName){
    	case "FUNCTION_DEF":
    		outputFunctionDef(item);
    		break;
    	case "CLASS_DEF":
    		outputClassDef(item);
    		break;
    	case "DECL":
    		outputDecl(item);
    		break;
    	default:
    			defaultOut(item);
    			break;
    	}
    }

	private void outputFunctionDef(CodeItem aItem)
    {
    	FunctionDef item = (FunctionDef) aItem;
    	defaultOut(item);
    	defaultOut(item.returnType);
    	defaultOut(item.name);
    	if(item.parameterList != null){
    		defaultOut(item.parameterList);
    		Iterator<Parameter> i = item.parameterList.parameters.iterator();
    		for(; i.hasNext();){
    			Parameter p = i.next();
    			defaultOut(p);
    			defaultOut(p.type);
    			defaultOut(p.name);
    		}
    	}
    }

    private void outputClassDef(CodeItem aItem)
    {
    	ClassDef item = (ClassDef) aItem;
    	defaultOut(item);
    	if(item.name != null){
    		item.name.level = item.level + 1;
    		defaultOut(item.name);
    	}
    }

    private void outputDecl(CodeItem aItem)
	{
    	IdentifierDecl item = (IdentifierDecl) aItem;
    	
    	item.codeStr = item.type.completeType + " " + item.name.codeStr;
    	defaultOut(item);
	}
    
    
    private void defaultOut(CodeItem item)
    {
    	String output = item.nodeTypeName + SEPARATOR;
    	output += createLocationString(item) + SEPARATOR + item.level;
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
