package astnodes.expressions;

import astnodes.ASTNodeVisitor;

public class MemberAccess extends PostfixExpression
{
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }	
}
