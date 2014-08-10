package ast.statements;

import ast.walking.ASTNodeVisitor;

public class SwitchStatement extends BlockStarter
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
