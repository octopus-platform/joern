package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class AssignmentExpr extends BinaryExpression
{
	// TODO: This can probably be removed
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
