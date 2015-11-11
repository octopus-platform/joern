package ast.expressions;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class Identifier extends Expression
{
	private ASTNode name = new ASTNode();
	
	public Identifier()
	{
	}

	public Identifier(Identifier name)
	{
		super(name);
	}

	public void setNameChild(ASTNode name) {
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getNameChild() {
		return this.name;
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
