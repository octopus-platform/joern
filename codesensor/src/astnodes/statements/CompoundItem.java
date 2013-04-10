package astnodes.statements;

import java.util.LinkedList;
import java.util.List;

import astnodes.ASTNode;


public class CompoundItem extends Statement
{

	LinkedList<ASTNode> statements = new LinkedList<ASTNode>();
	
	public void addChild(ASTNode stmt){ addStatement(stmt); }
	public int getChildCount() { return statements.size(); }
	public ASTNode getChild(int i){ return statements.get(i); }
	
	
	public CompoundItem()
	{
		setNodeTypeName("STATEMENTS");	
	}
	
	public void addStatement(ASTNode stmt)
	{
		statements.add(stmt);
	}
	
	public List<ASTNode> getStatements()
	{
		return statements;
	}
	
}
