package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class SizeofExpr extends Expression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
