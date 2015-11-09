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
		setName(node);
		super.addChild(node);
	}
	
	public void setName(ASTNode name) {
		this.name = name;
	}
	
	public ASTNode getName() {
		return this.name;
	}

}
