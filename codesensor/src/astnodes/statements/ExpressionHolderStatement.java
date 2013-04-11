package astnodes.statements;

import astnodes.expressions.Expression;

public class ExpressionHolderStatement extends Statement
{
	
	public String getCodeStr()
	{
		if(codeStr != null)
			return codeStr;
		
		Expression expr = getExpression();
		if(expr == null) return "";
		
		codeStr = expr.getCodeStr();
		return codeStr;
	}
	
	public Expression getExpression()
	{
		if(children == null)
			return null;
		return (Expression) children.get(0);
	}
	
}
