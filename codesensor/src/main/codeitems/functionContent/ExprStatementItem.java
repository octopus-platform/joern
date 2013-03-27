package main.codeitems.functionContent;

import main.codeitems.expressions.ExpressionItem;

public class ExprStatementItem extends StatementItem
{
	public ExpressionItem expr;

	public void accept(StatementVisitor visitor){ visitor.visit(this); }

	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		// codeStr = ParseTreeUtils.childTokenString(rootRule);
		codeStr = rootRule.getText();
		return codeStr;
	}
	
}
