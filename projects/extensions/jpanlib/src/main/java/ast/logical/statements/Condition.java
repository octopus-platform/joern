package ast.logical.statements;

import ast.statements.ExpressionHolder;
import ast.walking.ASTNodeVisitor;

public class Condition extends ExpressionHolder
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
