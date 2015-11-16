package ast.expressions;

import ast.ASTNode;

public class Variable extends Expression
{
	private ASTNode name = null;
	
	public void setNameChild(ASTNode name) {
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getNameChild() {
		return this.name;
	}
}
