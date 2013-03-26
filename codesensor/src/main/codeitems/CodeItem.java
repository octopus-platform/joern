package main.codeitems;

import main.ParseTreeUtils;

import org.antlr.v4.runtime.ParserRuleContext;


public class CodeItem {

	public String nodeTypeName;
	public CodeLocation location;	
	
	protected String codeStr = null;
	protected ParserRuleContext rootRule;
	
	public void initializeFromContext(ParserRuleContext ctx)
	{
		setLocation(ctx);
		rootRule = ctx;
	}
	
	public void setLocation(ParserRuleContext ctx)
	{
		location = new CodeLocation(ctx);
	}
	
	public void setCodeStr(String aCodeStr)
	{
		codeStr = aCodeStr;
	}
	
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		codeStr = ParseTreeUtils.childTokenString(rootRule);
		return codeStr;
	}
	
	public void accept(CodeItemVisitor visitor){}
	
}
