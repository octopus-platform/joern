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

	public Integer getDepthAsInteger()
	{
		if(this.depth == null)
			return 0;

		return this.depth.getValue();
	}

	public void decrementDepth()
	{
		if(this.depth == null)
			return;

		this.depth.decrement();
	}

}
