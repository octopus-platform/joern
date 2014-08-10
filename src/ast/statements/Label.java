package ast.statements;

import ast.walking.ASTNodeVisitor;

public class Label extends Statement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
