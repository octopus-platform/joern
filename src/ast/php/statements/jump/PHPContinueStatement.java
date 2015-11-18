package ast.php.statements.jump;

import ast.ASTNode;
import ast.statements.jump.ContinueStatement;

public class PHPContinueStatement extends ContinueStatement
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
