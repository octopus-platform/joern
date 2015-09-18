package ast.statements;

import ast.expressions.Expression;
import ast.logical.statements.Statement;

public class ExpressionHolderStatement extends Statement
{

	public String getEscapedCodeStr()
	{
		if (getCodeStr() != null)
			return getCodeStr();

		Expression expr = getExpression();
		if (expr == null)
			return "";

		setCodeStr(expr.getEscapedCodeStr());
		return getCodeStr();
	}

	public Expression getExpression()
	{
		if (children == null)
			return null;
		return (Expression) children.get(0);
	}

}
