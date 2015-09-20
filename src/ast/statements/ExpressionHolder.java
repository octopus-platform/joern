package ast.statements;

import ast.expressions.Expression;

// By default, Expressions holding only a single
// child are replaced by their child during
// consolidation. ExpressionHolders are never removed.

public class ExpressionHolder extends Expression
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
