package ast.php.statements;

import ast.ASTNode;
import ast.logical.statements.Statement;

public class PHPHaltCompilerStatement extends Statement
{
	private ASTNode offset = null; // TODO make into PrimaryExpression (or maybe even more specific: IntegerExpression) once mapping is finished

	public ASTNode getOffset() // TODO return PrimaryExpression
	{
		return this.offset;
	}

	public void setOffset(ASTNode offset) // TODO take PrimaryExpression
	{
		this.offset = offset;
		super.addChild(offset);
	}
}
