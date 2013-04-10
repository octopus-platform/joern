package astnodes.expressions;

import astnodes.ASTNodeVisitor;

public class UnaryExpression extends Expression
{
	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }	
}
