package ast.statements;

import ast.expressions.Expression;

public class ExpressionHolderStatement extends Statement
{

	public String getEscapedCodeStr()
	{
		if (codeStr != null)
			return codeStr;

		Expression expr = getExpression();
		if (expr == null)
			return "";

		codeStr = expr.getEscapedCodeStr();
		return codeStr;
	}

	public Expression getExpression()
	{
		if (children == null)
			return null;
		return (Expression) children.get(0);
	}

}
