package main.codeitems;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import main.CodeLocation;

public class CodeItem {

	public String nodeTypeName;
	public CodeLocation location;
	public int level;
	public String codeStr;
	
	public void create(ParserRuleContext ctx)
	{
		setLocation(ctx);
		codeStr = childTokenString(ctx);
	}
	
	private void setLocation(ParserRuleContext ctx)
	{
		location = new CodeLocation(ctx);
	}
	
	protected String childTokenString(ParseTree ctx)
    {
    	int nChildren = ctx.getChildCount();
    	
    	if(nChildren == 0){
    		return ctx.getText();
    	}
    	        
    	String retval = "";
    	for(int i = 0; i < nChildren; i++){
    		ParseTree child = ctx.getChild(i);
    		retval += childTokenString(child);
    		retval += " ";
    	}
    	retval = retval.substring(0, retval.length()-1);
    	return retval;
    	
    }
	
}
