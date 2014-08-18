package ast.statements;

import ast.walking.ASTNodeVisitor;

public class ContinueStatement extends JumpStatement
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
