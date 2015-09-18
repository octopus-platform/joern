package ast.expressions;

import ast.walking.ASTNodeVisitor;

public class Identifier extends Expression
{

	public Identifier()
	{
	}

	public Identifier(Identifier name)
	{
		super(name);
	}

	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

}
