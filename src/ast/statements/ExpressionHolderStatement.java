package ast.statements;

import ast.expressions.Expression;
import ast.logical.statements.Statement;

public class ExpressionHolderStatement extends Statement
{
	@Override
	public String getEscapedCodeStr()
	{

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
