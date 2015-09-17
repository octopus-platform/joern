package ast.statements.jump;

import ast.logical.statements.JumpStatement;
import ast.walking.ASTNodeVisitor;

public class BreakStatement extends JumpStatement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
