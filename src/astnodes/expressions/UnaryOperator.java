package astnodes.expressions;

import astwalking.ASTNodeVisitor;

public class UnaryOperator extends Expression
{

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
