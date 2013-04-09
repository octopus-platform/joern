package main.codeitems.statements;

import main.codeitems.CodeItem;
import main.codeitems.expressions.Expression;

// By default, Expressions holding only a single
// child are replaced by their child during
// consolidation. ExpressionHolders are never removed.

public class ExpressionHolder extends Expression
{	
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		codeStr = getExpression().getCodeStr();
		return codeStr;
	}
	
	public Expression getExpression()
	{
		return (Expression) children.get(0);
	}
	
}
