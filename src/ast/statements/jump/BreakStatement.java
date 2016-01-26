package ast.statements.jump;

import ast.expressions.IntegerExpression;
import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class BreakStatement extends JumpStatement
{
	private IntegerExpression depth = null;

	public void setDepth(IntegerExpression depth) {
		this.depth = depth;
		super.addChild(depth);
	}

	public IntegerExpression getDepth() {
		return this.depth;
	}

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
