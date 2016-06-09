package ast.statements.jump;

import ast.logical.statements.BreakOrContinueStatement;
import ast.walking.ASTNodeVisitor;

public class BreakStatement extends BreakOrContinueStatement
{

	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
