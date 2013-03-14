package main.codeitems;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

abstract public class CodeItemBuilder
{
	protected CodeItem item;
	
    public CodeItem getItem()
    {
    	complete();
    	return item;
    }
    
    public void complete()
    {
    }
    
    abstract public void createNew(ParserRuleContext ctx);
    
    
}
