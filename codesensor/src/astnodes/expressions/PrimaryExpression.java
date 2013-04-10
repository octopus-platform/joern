package astnodes.expressions;

import astnodes.ASTNodeVisitor;

public class PrimaryExpression extends PostfixExpression
{
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }	
}
