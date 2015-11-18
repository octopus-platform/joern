package ast.php.statements.jump;

import ast.ASTNode;
import ast.statements.jump.BreakStatement;

public class PHPBreakStatement extends BreakStatement
{
	private ASTNode depth = null;
	
	public void setDepth(ASTNode depth) {
		this.depth = depth;
		super.addChild(depth);
	}
	
	public ASTNode getDepth() {
		return this.depth;
	}
}
