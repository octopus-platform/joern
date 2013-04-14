package astnodes.statements;

import java.util.List;

import astnodes.ASTNode;
import astwalking.ASTNodeVisitor;

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

	public void accept(ASTNodeVisitor visitor){ visitor.visit(this); }
}
