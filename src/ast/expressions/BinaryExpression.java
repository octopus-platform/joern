package ast.expressions;

import ast.ASTNode;

public class BinaryExpression extends Expression
{
	ASTNode leftExpression = null; // TODO make this an Expression again, once PHP mapping is finished
	ASTNode rightExpression = null; // TODO make this an Expression again, once PHP mapping is finished
	
	public ASTNode getLeft() // TODO return Expression
	{
		return this.leftExpression;
	}

	protected void setLeft(ASTNode leftExpression) // TODO take Expression
	{
		this.leftExpression = leftExpression;
		super.addChild(leftExpression);
	}
	
	public ASTNode getRight() // TODO return Expression
	{
		return this.rightExpression;
	}

	protected void setRight(ASTNode rightExpression) // TODO take Expression
	{
		this.rightExpression = rightExpression;
		super.addChild(rightExpression);
	}

	@Override
	public void addChild(ASTNode item)
	{
		// TODO cast this to an Expression again
		//Expression expression = (Expression) item;
		if (getLeft() == null)
			setLeft(item);
		else if (getRight() == null)
			setRight(item);
		else
			throw new RuntimeException(
					"Error: attempting to add third child to binary expression");
	}
}
