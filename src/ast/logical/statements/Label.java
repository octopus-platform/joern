package ast.logical.statements;

import ast.ASTNode;
import ast.walking.ASTNodeVisitor;

public class Label extends Statement
{
	private ASTNode name = null;

	public void setNameChild(ASTNode name) {
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getNameChild() {
		return this.name;
	}
	
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
