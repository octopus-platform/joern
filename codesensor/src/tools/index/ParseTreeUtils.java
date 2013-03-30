package tools.index;

import org.antlr.v4.runtime.tree.ParseTree;

public class ParseTreeUtils
{
	 public static String childTokenString(ParseTree ctx)
	 {
	    	// TODO: use a StringBuilder here.
	    	
		 	if(ctx == null)
		 		return "";
		 
	    	int nChildren = ctx.getChildCount();
	    	
	    	if(nChildren == 0){
	    		return ctx.getText();
	    	}
	    	
	    	String retval = "";
	    	for(int i = 0; i < nChildren; i++){
	    		ParseTree child = ctx.getChild(i);
	    		String childText = childTokenString(child);
	    		if(!childText.equals("")){
	    			retval += childText;
	    			retval += " ";
	    		}
	    	}
	    	retval = retval.substring(0, retval.length()-1);
	    	return retval;
	 }
}
