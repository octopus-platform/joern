package ast.expressions;

import ast.ASTNode;

public class Expression extends ASTNode
{
	public void replaceFirstChild(ASTNode node)
	{
		children.removeFirst();
		children.addFirst(node);
	}

}
