package ast.statements;

import ast.walking.ASTNodeVisitor;

public class WhileStatement extends BlockStarter
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
