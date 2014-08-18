package ast.statements;

import ast.walking.ASTNodeVisitor;

public class Condition extends ExpressionHolder
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
