package ast.statements.blockstarters;

import ast.logical.statements.BlockStarterWithStmtAndCnd;
import ast.walking.ASTNodeVisitor;

public class SwitchStatement extends BlockStarterWithStmtAndCnd
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}
}
