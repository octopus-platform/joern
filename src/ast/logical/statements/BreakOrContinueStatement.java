package ast.logical.statements;

import ast.expressions.IntegerExpression;

public class BreakOrContinueStatement extends JumpStatement {

	private IntegerExpression depth = null;

	public void setDepth(IntegerExpression depth) {
		this.depth = depth;
		super.addChild(depth);
	}

	public IntegerExpression getDepth() {
		return this.depth;
	}

}
