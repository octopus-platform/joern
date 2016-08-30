package ast.logical.statements;

import ast.ASTNode;

public class BlockStarterWithStmtAndCnd extends BlockStarter {

	@Override
	public void addChild(ASTNode node)
	{
		if (node instanceof Condition)
			setCondition((Condition) node);
		else if (node instanceof Statement)
			setStatement((Statement) node);
		else
			super.addChild(node);
	}

}
