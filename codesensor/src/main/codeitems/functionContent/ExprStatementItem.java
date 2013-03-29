package main.codeitems.functionContent;

import main.codeitems.CodeItem;
import main.codeitems.CodeItemVisitor;
import main.codeitems.expressions.ExpressionItem;

public class ExprStatementItem extends CodeItem
{
	public ExpressionItem expr;

	public void accept(CodeItemVisitor visitor){ visitor.visit(this); }

	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		// codeStr = ParseTreeUtils.childTokenString(rootRule);
		codeStr = rootRule.getText();
		return codeStr;
	}
	
}
