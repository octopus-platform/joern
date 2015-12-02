package ast.expressions;

import ast.ASTNode;

public class AssignmentExpression extends BinaryExpression
{
	public ASTNode getVariable() // TODO return an Expression
	{          
		return getLeft();
	}          

	public void setVariable(ASTNode variable) // TODO take an Expression
	{          
		setLeft(variable);
	}          

	public ASTNode getAssignExpression() // TODO return an Expression
	{
		return getRight();
	}

	public void setAssignExpression(ASTNode assignExpression) // TODO take an Expression
	{
		setRight(assignExpression);
	}
}
