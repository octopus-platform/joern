package main.codeitems.functionContent;

import main.codeitems.CodeItem;

public class StatementItem extends CodeItem
{
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		codeStr = "";
		return codeStr;
	}

	public void accept(StatementVisitor visitor){ visitor.visit(this); }
}
