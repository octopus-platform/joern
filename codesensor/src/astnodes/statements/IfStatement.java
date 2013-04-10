package astnodes.statements;

import astnodes.ASTNode;



public class IfStatement extends BlockStarter {
	
	public ElseStatement elseItem = null;

	public int getChildCount()
	{
		int childCount = super.getChildCount();
		
		if(elseItem != null) childCount++;
		return childCount;
	}
	
	public ASTNode getChild(int i)
	{
		if(i == 0)
			return condition;
		else if (i == 1)
			return statement;
		else if(i == 2)
			return elseItem;
		throw new RuntimeException("Invalid IfItem");
	}
}
