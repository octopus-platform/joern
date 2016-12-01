package ast.statements.blockstarters;

import ast.logical.statements.BlockStarterWithStmtAndCnd;
import ast.walking.ASTNodeVisitor;

public abstract class IfStatementBase extends BlockStarterWithStmtAndCnd
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
