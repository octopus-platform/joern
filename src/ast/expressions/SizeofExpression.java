package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class SizeofExpression extends Expression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
