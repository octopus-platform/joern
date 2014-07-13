package astnodes.expressions;

import astnodes.statements.ExpressionHolder;
import astwalking.ASTNodeVisitor;

public class Argument extends ExpressionHolder
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
