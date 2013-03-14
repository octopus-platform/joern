package main;

import org.antlr.v4.runtime.tree.ParseTree;

public class ParseTreeUtils
{
	 public static String childTokenString(ParseTree ctx)
	 {
	    	// TODO: use a StringBuilder here.
	    	
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
