package ast.php.functionDef;

import ast.ASTNode;

public class ClosureVar extends ASTNode
{
	private ASTNode name = new ASTNode();
	
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
