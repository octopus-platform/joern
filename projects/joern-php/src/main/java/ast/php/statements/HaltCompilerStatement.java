package ast.php.statements;

import ast.expressions.IntegerExpression;
import ast.logical.statements.Statement;

public class HaltCompilerStatement extends Statement
{
	private IntegerExpression offset = null;

	public IntegerExpression getOffset()
	{
		return this.offset;
	}

	public void setOffset(IntegerExpression offset)
	{
		this.offset = offset;
		super.addChild(offset);
	}
}
