package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class AssignmentExpr extends BinaryExpression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
