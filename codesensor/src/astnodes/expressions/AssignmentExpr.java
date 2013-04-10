package astnodes.expressions;

import astnodes.ASTNodeVisitor;

public class AssignmentExpr extends BinaryExpression
{
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
}
