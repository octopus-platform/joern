package ast.php.functionDef;

import ast.ASTNode;

public class ClosureVar extends ASTNode
{
	private ASTNode name = new ASTNode();
	
	public void setNameChild(ASTNode name) {
		this.name = name;
		super.addChild(name);
	}
	
	public ASTNode getNameChild() {
		return this.name;
	}
}
