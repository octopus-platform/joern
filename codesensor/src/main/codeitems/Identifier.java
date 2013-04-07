package main.codeitems;

import org.antlr.v4.runtime.ParserRuleContext;

public class Identifier extends CodeItem
{
	public Identifier()
	{
		setNodeTypeName("IDENTIFIER");
	}
	
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		if(parseTreeNodeContext != null)
			codeStr = parseTreeNodeContext.getText();
		else
			codeStr = "";
		return codeStr;
	}

	public ParserRuleContext getParseTreeNodeContext()
	{
		return parseTreeNodeContext;
	}
	
}
