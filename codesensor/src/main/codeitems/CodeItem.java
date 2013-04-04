package main.codeitems;

import org.antlr.v4.runtime.ParserRuleContext;
import tools.index.ParseTreeUtils;


public class CodeItem {

	protected String codeStr = null;		
	protected ParserRuleContext parseTreeNodeContext;
	private String nodeTypeName = "unnamed";
	private CodeLocation location = new CodeLocation();
	
	// Overload the following three to
	// allow placement of CodeItem in a tree
	
	public void addChild(CodeItem expression){  }
	public int getChildCount() { return 0; }
	public CodeItem getChild(int i){ return null; }
	
	
	public void initializeFromContext(ParserRuleContext ctx)
	{
		parseTreeNodeContext = ctx;
	}
	
	public void setLocation(ParserRuleContext ctx)
	{
		if(ctx == null) return;
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
	
	  public String getLocationString()
	  {
		  setLocation(parseTreeNodeContext);
		  return location.toString();
	  }
	
	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }

	public String getNodeTypeName() {
		return nodeTypeName;
	}

	public void setNodeTypeName(String nodeTypeName) {
		this.nodeTypeName = nodeTypeName;
	}
	
}
