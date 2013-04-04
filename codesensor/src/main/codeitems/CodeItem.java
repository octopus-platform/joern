package main.codeitems;


import java.util.LinkedList;

import main.codeitems.expressions.Expression;

import org.antlr.v4.runtime.ParserRuleContext;

import tools.index.ParseTreeUtils;


public class CodeItem {

	protected String codeStr = null;		
	protected ParserRuleContext parseTreeNodeContext;
	private String nodeTypeName = "unnamed";
	private CodeLocation location = new CodeLocation();
	
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
	
	
	LinkedList<CodeItem> children = new LinkedList<CodeItem>();
	
	// Child classes must implement this
	public void addChildExpression(CodeItem expression)
	{
		children.add(expression);
	}
	public int getChildCount() { return children.size(); }
	public CodeItem getChild(int i){ return (Expression) children.get(i); }
	
	
}
