package ast.expressions;

import ast.ASTNode;

public class Expression extends ASTNode
{
	private String operator = "";
	
	public void replaceFirstChild(ASTNode node)
	{
		children.removeFirst();
		children.addFirst(node);
	}

	protected void setOperator(String text)
	{
		operator = text;
	}

	public String getOperator()
	{
		return operator;
	}
	
}
