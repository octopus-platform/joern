package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class UnaryOp extends Expression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
