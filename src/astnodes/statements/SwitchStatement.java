package astnodes.statements;

import astwalking.ASTNodeVisitor;

public class SwitchStatement extends BlockStarter
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
