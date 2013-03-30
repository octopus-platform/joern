package main.codeitems;


import org.antlr.v4.runtime.ParserRuleContext;

import tools.index.ParseTreeUtils;


public class CodeItem {

	public String nodeTypeName = "unnamed";
	public CodeLocation location = new CodeLocation();
	
	protected String codeStr = null;
			
	protected ParserRuleContext parseTreeNodeContext;
	
	public void initializeFromContext(ParserRuleContext ctx)
	{
		setLocation(ctx);
		parseTreeNodeContext = ctx;
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
		
		codeStr = ParseTreeUtils.childTokenString(parseTreeNodeContext);
		return codeStr;
	}
	
	  public String getLocationString(CodeItem item)
	  {
		  return location.toString();
	  }
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }
		
}
