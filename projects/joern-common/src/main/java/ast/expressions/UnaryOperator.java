package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class UnaryOperator extends Expression
{

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
