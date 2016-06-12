package ast.expressions;

import ast.statements.ExpressionHolder;
import ast.walking.ASTNodeVisitor;

public class Argument extends ExpressionHolder
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
