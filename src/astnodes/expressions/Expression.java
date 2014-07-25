package astnodes.expressions;

import astnodes.ASTNode;

public class Expression extends ASTNode
{
	public void replaceFirstChild(ASTNode node)
	{
		children.removeFirst();
		children.addFirst(node);
	}

}
