package ast.php.statements.jump;

import ast.expressions.IntegerExpression;
import ast.statements.jump.BreakStatement;

public class PHPBreakStatement extends BreakStatement
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
