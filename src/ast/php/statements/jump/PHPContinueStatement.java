package ast.php.statements.jump;

import ast.expressions.IntegerExpression;
import ast.statements.jump.ContinueStatement;

public class PHPContinueStatement extends ContinueStatement
{
	private IntegerExpression depth = null;
	
	public void setDepth(IntegerExpression depth) {
		this.depth = depth;
		super.addChild(depth);
	}
	
	public IntegerExpression getDepth() {
		return this.depth;
	}
}
