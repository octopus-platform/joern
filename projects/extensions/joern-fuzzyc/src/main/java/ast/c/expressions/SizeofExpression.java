package ast.c.expressions;

import ast.expressions.Expression;
import ast.walking.ASTNodeVisitor;

public class SizeofExpression extends Expression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
