package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class SizeofExpr extends Expression
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
