package ast.statements.blockstarters;

import ast.logical.statements.BlockStarter;
import ast.walking.ASTNodeVisitor;

public class DoStatement extends BlockStarter
{
	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
