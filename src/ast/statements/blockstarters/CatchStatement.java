package ast.statements.blockstarters;

import ast.ASTNode;
import ast.logical.statements.BlockStarter;
import ast.walking.ASTNodeVisitor;

public class CatchStatement extends BlockStarter
{
	public void accept(ASTNodeVisitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public void addChild(ASTNode node)
	{
		super.addChild(node);
	}

}
