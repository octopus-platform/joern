package ast.expressions;

import ast.ASTNode;

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
	
	public void addChild(ASTNode node)
	{
		setNameChild(node);
		super.addChild(node);
	}
	
	public void setNameChild(ASTNode name) {
		this.name = name;
	}
	
	public ASTNode getNameChild() {
		return this.name;
	}

}
