package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class AssignmentExpr extends BinaryExpression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
