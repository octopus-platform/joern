package ast.php.functionDef;

import ast.ASTNode;

public class ClosureVar extends ASTNode
{
	private ASTNode name = new ASTNode();
	
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
