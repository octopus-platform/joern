package ast.expressions;

import ast.ASTNode;

public class ArrayIndexing extends Expression
{
	private ASTNode array = null; // TODO make this an Expression
	private ASTNode index = null; // TODO make this an Expression

	public ASTNode getArrayExpression() // TODO return an Expression
	{
		return this.array;
	}

	public void setArrayExpression(ASTNode array) // TODO take an Expression
	{
		this.array = array;
		super.addChild(array);
	}
	
	public ASTNode getIndexExpression() // TODO return an Expression
	{
		return this.index;
	}

	public void setIndexExpression(ASTNode index) // TODO take an Expression
	{
		this.index = index;
		super.addChild(index);
	}
}
