package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class MemberAccess extends PostfixExpression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
