package ast.statements.blockstarters;

import ast.logical.statements.BlockStarterWithStmtAndCnd;
import ast.walking.ASTNodeVisitor;

public class DoStatement extends BlockStarterWithStmtAndCnd
{
	@Override
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
