package astnodes.statements;

import java.util.List;

import astnodes.ASTNode;

public class CompoundStatement extends Statement
{

	public void addStatement(ASTNode stmt)
	{
		super.addChild(stmt);
	}
	
	public List<ASTNode> getStatements()
	{
		if(children == null)
			return emptyList;
		return children;
	}
}
